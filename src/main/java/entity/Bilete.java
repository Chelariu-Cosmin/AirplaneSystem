package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "bilete")
public class Bilete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBilet;

    @ManyToOne(fetch = FetchType.LAZY)
    private Client client;
    private Double pret;
    private String tipPlata;

    @ManyToOne(fetch = FetchType.LAZY)
    private Companie companie;
    @OneToMany(
            mappedBy = "bilet",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true
    )
    private List<Bagaje> listaBagaje = new ArrayList<>();

    public Bilete(Client client, Double pret, String tipPlata, Companie companie) {
        this.client = client;
        this.pret = pret;
        this.tipPlata = tipPlata;
        this.companie = companie;
    }

    public Bilete(Double pret, String tipPlata) {
        this.pret = pret;
        this.tipPlata = tipPlata;
    }

    public Bilete(Double pret, String tipPlata, Companie companie) {
        this.pret = pret;
        this.tipPlata = tipPlata;
        this.companie = companie;
    }

    public Bilete(Integer idBilet, Double pret, String tipPlata, Companie companie) {
        this.idBilet = idBilet;
        this.pret = pret;
        this.tipPlata = tipPlata;
        this.companie = companie;
    }

    public Bilete() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Companie getCompanie() {
        return companie;
    }

    public void setCompanie(Companie companie) {
        this.companie = companie;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<Bagaje> getListaBagaje() {
        return listaBagaje;
    }

    public void setListaBagaje(List<Bagaje> listaBagaje) {
        this.listaBagaje = listaBagaje;
    }

    public Integer getIdBilet() {
        return idBilet;
    }

    public void setIdBilet(Integer idBilet) {
        this.idBilet = idBilet;
    }

    public Double getPret() {
        return pret;
    }

    public void setPret(Double pret) {
        this.pret = pret;
    }

    public String getTipPlata() {
        return tipPlata;
    }

    public void setTipPlata(String tipPlata) {
        this.tipPlata = tipPlata;
    }

    @Override
    public String toString() {
        return "Bilete{" +
                "idBilet=" + idBilet +
                ", client=" + client +
                ", pret=" + pret +
                ", tipPlata='" + tipPlata + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bilete bilete = (Bilete) o;

        if (getIdBilet() != bilete.getIdBilet()) return false;
        if (!Objects.equals(client, bilete.client)) return false;
        if (getPret() != null ? !getPret().equals(bilete.getPret()) : bilete.getPret() != null) return false;
        return getTipPlata() != null ? getTipPlata().equals(bilete.getTipPlata()) : bilete.getTipPlata() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdBilet();
        result = 31 * result + (client != null ? client.hashCode() : 0);
        result = 31 * result + (getPret() != null ? getPret().hashCode() : 0);
        result = 31 * result + (getTipPlata() != null ? getTipPlata().hashCode() : 0);
        return result;
    }
}
