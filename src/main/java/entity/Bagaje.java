package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "bagaje")
public class Bagaje {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBagaj;
    private double greutate;
    private double volum;
    private String tipBagaj;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;

    @ManyToOne(fetch = FetchType.LAZY)
    private Bilete bilet;

    public Bagaje(Integer idBagaj, double greutate, double volum, String tipBagaj) {
        this.idBagaj = idBagaj;
        this.greutate = greutate;
        this.volum = volum;
        this.tipBagaj = tipBagaj;
    }

    public Bagaje(double greutate, double volum, String tipBagaj, Client client, Bilete bilet) {
        this.greutate = greutate;
        this.volum = volum;
        this.tipBagaj = tipBagaj;
        this.client = client;
        this.bilet = bilet;
    }

    public Bagaje() {
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Bilete getBilet() {
        return bilet;
    }

    public void setBilet(Bilete bilet) {
        this.bilet = bilet;
    }

    public Integer getIdBagaj() {
        return idBagaj;
    }

    public void setIdBagaj(Integer idBagaj) {
        this.idBagaj = idBagaj;
    }

    public double getGreutate() {
        return greutate;
    }

    public void setGreutate(double greutate) {
        this.greutate = greutate;
    }

    public double getVolum() {
        return volum;
    }

    public void setVolum(double volum) {
        this.volum = volum;
    }

    public String getTipBagaj() {
        return tipBagaj;
    }

    public void setTipBagaj(String tipBagaj) {
        this.tipBagaj = tipBagaj;
    }
}
