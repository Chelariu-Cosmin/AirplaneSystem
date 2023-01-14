package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sosiri")
public class Sosiri extends Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idSosire;

    @OneToMany(
            mappedBy = "sosiri",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Calatorii> listaCalatorii = new ArrayList<>();

    public Sosiri(String tara, String oras, String numeAeroport, Date data, Integer idSosire) {
        super(tara, oras, numeAeroport, data);
        this.idSosire = idSosire;
    }

    public Sosiri() {
    }

    public Integer getIdSosire() {
        return idSosire;
    }

    public void setIdSosire(Integer idSosire) {
        this.idSosire = idSosire;
    }
}
