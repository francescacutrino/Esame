package it.devlecce.SpringWebGestioneProdotti.controller;

import it.devlecce.SpringWebGestioneProdotti.avviso.ProdottoNonTrovato;
import it.devlecce.SpringWebGestioneProdotti.model.Prodotto;
import it.devlecce.SpringWebGestioneProdotti.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

@RestController
public class ProdottoRestController {
    private static Logger logger = LoggerFactory.getLogger(ProdottoRestController.class);

    private ProdottoRepository repository;

    ProdottoRestController(ProdottoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/prodotto")
    public List<Prodotto> leggiTuttiIProdotti() {
        logger.info("Prendo tutti i prodotti");
        return repository.findAll();
    }

    @GetMapping("/prodotto/{id}")
    public Prodotto trovaProdottoConID(@PathVariable Long id) {
        return repository.findById(id).orElseThrow(() -> new ProdottoNonTrovato(id));
    }

    @PostMapping("/prodotto")
    public Prodotto inserisciUnNuovoProdotto(@RequestBody Prodotto nuovoProdotto) {
        return repository.save(nuovoProdotto);
    }

    @PutMapping("/prodotto/{id}")
    public Prodotto aggiornaDatiProdotto(@PathVariable Long id, @RequestBody Prodotto prodotto) {
        return repository.findById(id).map(nuovoProdotto -> {
            nuovoProdotto.setNome(prodotto.getNome());
            nuovoProdotto.setDatascadenza(prodotto.getDatascadenza());
            nuovoProdotto.setDataacquisto(prodotto.getDataacquisto());
            nuovoProdotto.setPrezzo(prodotto.getPrezzo());
            nuovoProdotto.setQuantità(prodotto.getQuantità());
            return repository.save(nuovoProdotto);
        }).orElseGet(() -> {
            prodotto.setId(id);
            return repository.save(prodotto);
        });
    }

    @DeleteMapping("/prodotto/{id}")
    void eliminaProdotto(@PathVariable Long id) {
        repository.deleteById(id);
    }

   @GetMapping ("/prodotto/ricercatradate")
    public List <Prodotto> ricercaUtenteTraDate (
            @RequestParam(name="datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date datada,
            @RequestParam (name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date dataa
    ){
        return repository.findByDataacquistoBetween(datada, dataa);
    }

    @GetMapping ("/prodotto/datascadenza")
    public List <Prodotto> datascadenza (
            @RequestParam(name="datada") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date datada,
            @RequestParam (name = "dataa") @DateTimeFormat(pattern = "dd-MM-yyyy")
                    Date dataa
    ){
        return repository.findByDatascadenzaBetween(datada, dataa);
    }

    @GetMapping ("/prodotto/nome")
    public List <Prodotto> trovaProdottoNome (@RequestParam String nome) {
        return repository.findByNome(nome);
    }

    //Caricamento di file
    @PostMapping("/caricafile")
    public String caricaFile (@RequestParam("file") MultipartFile file) {
        String infoFile = file.getOriginalFilename() + "-" + file.getContentType();
        String conFormat = String.format("%s-%s", file.getOriginalFilename(), file.getContentType());
        logger.info(infoFile);
        logger.warn(conFormat);
        return conFormat;

    }
}