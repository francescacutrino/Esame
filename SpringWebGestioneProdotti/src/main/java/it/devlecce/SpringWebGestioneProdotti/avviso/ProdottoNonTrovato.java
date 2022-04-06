package it.devlecce.SpringWebGestioneProdotti.avviso;

public class ProdottoNonTrovato extends RuntimeException{
    public ProdottoNonTrovato(Long id) {
        super("Prodotto non trovato" + id);
    }
}
