package it.devlecce.SpringWebGestioneProdotti.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;
@Entity
public class Prodotto {
    @Id
    @GeneratedValue
    private Long id;
    private String nome;
    private float prezzo, quantità;
    private Date dataAcquisto, dataScadenza;

    private float ranking;
    public Prodotto() {
    }
    public Prodotto(String nome, float prezzo, float quantità, Date dataAcquisto, Date dataScadenza) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantità = quantità;
        this.dataAcquisto = dataAcquisto;
        this.dataScadenza = dataScadenza;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPrezzo() { return prezzo; }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public float getQuantità() { return quantità; }

    public void setQuantità(float quantità) {
        this.quantità = quantità;
    }

    public Date getDataAcquisto() {
        return dataAcquisto;
    }

    public void setDataAcquisto(Date dataAcquisto) {
        this.dataAcquisto = dataAcquisto;
    }

    public Date getDataScadenza() {
        return dataScadenza;
    }

    public void setDataScadenza(Date dataScadenza) {
        this.dataScadenza = dataScadenza;
    }
}
