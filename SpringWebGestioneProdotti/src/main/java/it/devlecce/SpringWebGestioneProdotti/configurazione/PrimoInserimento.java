package it.devlecce.SpringWebGestioneProdotti.configurazione;

import it.devlecce.SpringWebGestioneProdotti.model.Prodotto;
import it.devlecce.SpringWebGestioneProdotti.repository.ProdottoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Configuration
public class PrimoInserimento {
    private static Logger logger = LoggerFactory.getLogger(PrimoInserimento.class);

    @Bean
    CommandLineRunner inserisciElementi(ProdottoRepository repository) {
        return args -> {

            SimpleDateFormat dataScadenza = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat dataAcquisto= new SimpleDateFormat("dd-MM-yyyy");

            Date  scadenza = dataScadenza.parse("06-04-2022");
            Date  acquisto = dataAcquisto.parse("21-09-2022");
            Prodotto p1 = new Prodotto("pane", 12, 3, scadenza, acquisto);
            logger.info("nome: " + p1.getNome() + " data di acquisto: " + p1.getDataAcquisto() + " data di scadenza: " + p1.getDataScadenza() + " prezzo: " + p1.getPrezzo() + " quantità: " + p1.getQuantità());
            repository.save(p1);

            scadenza = dataScadenza.parse("06-04-2022");
            acquisto = dataAcquisto.parse("11-10-2025");
            Prodotto p2 = new Prodotto("biscotti", 7, 9, scadenza,acquisto);
            logger.info("nome: " + p2.getNome() + " data di acquisto: " + p2.getDataAcquisto() + " data di scadenza: " + p2.getDataScadenza() + " prezzo: " + p2.getPrezzo() + " quantità: " + p2.getQuantità());
            repository.save(p2);

            List<Prodotto> prodotti = new ArrayList<>();
            prodotti.add(p1);
            prodotti.add(p2);

            repository.saveAll(prodotti);
        };
    }
}
