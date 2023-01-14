package entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "clienti")
public class Client extends Persoana {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idClient;

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Bilete> listaBilete = new ArrayList<>();

    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Calatorii> listaCalatorii = new ArrayList<>();


    @OneToMany(
            mappedBy = "client",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Bagaje> listaBagaje = new ArrayList<>();

    public Client() {
        super();
    }


    public Client(String nume, String cnp, String adresa, String localitate, String tara, LocalDate dataNastere, List<Bilete> listaBilete, List<Calatorii> listaCalatorii, List<Bagaje> listaBagaje) {
        super(nume, cnp, adresa, localitate, tara, dataNastere);
        this.listaBilete = listaBilete;
        this.listaCalatorii = listaCalatorii;
        this.listaBagaje = listaBagaje;
    }

    public Client(String nume, String cnp, String adresa, String localitate, String tara, LocalDate dataNastere, int idClient, List<Bilete> listaBilete, List<Calatorii> listaCalatorii, List<Bagaje> listaBagaje) {
        super(nume, cnp, adresa, localitate, tara, dataNastere);
        this.idClient = idClient;
        this.listaBilete = listaBilete;
        this.listaCalatorii = listaCalatorii;
        this.listaBagaje = listaBagaje;
    }

    public Client(String nume, String cnp, String adresa, String localitate, String tara, LocalDate dataNastere) {
        super(nume, cnp, adresa, localitate, tara, dataNastere);
        this.idClient = idClient;
    }

    public List<Bilete> getListaBilete() {
        return listaBilete;
    }

    public void setListaBilete(List<Bilete> listaBilete) {
        this.listaBilete = listaBilete;
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (getIdClient() != client.getIdClient()) return false;
        return getListaBilete() != null ? getListaBilete().equals(client.getListaBilete()) : client.getListaBilete() == null;
    }

    @Override
    public int hashCode() {
        int result = getIdClient();
        result = 31 * result + (getListaBilete() != null ? getListaBilete().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idClient=" + idClient +
                ", listaBilete=" + listaBilete +
                '}';
    }
}
