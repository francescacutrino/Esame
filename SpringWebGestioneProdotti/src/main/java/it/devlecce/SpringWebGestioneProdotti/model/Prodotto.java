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
    private Date dataacquisto, datascadenza;

    private float ranking;
    public Prodotto() {
    }
    public Prodotto(String nome, float prezzo, float quantità, Date dataAcquisto, Date dataScadenza) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.quantità = quantità;
        this.dataacquisto = dataAcquisto;
        this.datascadenza = dataScadenza;
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

    public Date getDataacquisto() {
        return dataacquisto;
    }

    public void setDataacquisto(Date dataacquisto) {
        this.dataacquisto = dataacquisto;
    }

    public Date getDatascadenza() {
        return datascadenza;
    }

    public void setDatascadenza(Date datascadenza) {
        this.datascadenza = datascadenza;
    }
}
