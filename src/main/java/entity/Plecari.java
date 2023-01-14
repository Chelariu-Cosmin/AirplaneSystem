package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "plecari")
public class Plecari extends Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlecare;

    @OneToMany(
            mappedBy = "plecari",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Calatorii> listaCalatorii = new ArrayList<>();

    public Plecari(String tara, String oras, String numeAeroport, Date data, Integer idPlecare) {
        super(tara, oras, numeAeroport, data);
        this.idPlecare = idPlecare;
    }

    public Plecari(Integer idPlecare) {
        this.idPlecare = idPlecare;
    }

    public Plecari() {
    }

    public Integer getIdPlecare() {
        return idPlecare;
    }

    public void setIdPlecare(Integer idPlecare) {
        this.idPlecare = idPlecare;
    }
}
