package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "calatorii")
public class Calatorii {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCalatorie;
    private int durataZbor;

    @ManyToOne(fetch = FetchType.LAZY)
    private Sosiri sosiri;

    @ManyToOne(fetch = FetchType.LAZY)
    private Plecari plecari;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    private Companie companie;


    public Calatorii(Integer idCalatorie, int durataZbor) {
        this.idCalatorie = idCalatorie;
        this.durataZbor = durataZbor;
    }

    public Calatorii(int durataZbor, Client client, Companie companie) {
        this.durataZbor = durataZbor;
        this.client = client;
        this.companie = companie;
    }

    public Calatorii() {
    }

    public Calatorii(int durataZbor, Sosiri sosiri, Plecari plecari, Client client, Companie companie) {
        this.durataZbor = durataZbor;
        this.sosiri = sosiri;
        this.plecari = plecari;
        this.client = client;
        this.companie = companie;
    }

    public Sosiri getSosiri() {
        return sosiri;
    }

    public void setSosiri(Sosiri sosiri) {
        this.sosiri = sosiri;
    }

    public Plecari getPlecari() {
        return plecari;
    }

    public void setPlecari(Plecari plecari) {
        this.plecari = plecari;
    }

    public Integer getIdCalatorie() {
        return idCalatorie;
    }

    public void setIdCalatorie(Integer idCalatorie) {
        this.idCalatorie = idCalatorie;
    }

    public int getDurataZbor() {
        return durataZbor;
    }

    public void setDurataZbor(int durataZbor) {
        this.durataZbor = durataZbor;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Companie getCompanie() {
        return companie;
    }

    public void setCompanie(Companie companie) {
        this.companie = companie;
    }
}
