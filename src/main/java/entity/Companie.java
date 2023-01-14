package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "company")
public class Companie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompanie;
    private String numeCompanie;
    private int punctaj;

    @OneToMany(
            mappedBy = "companie",
            cascade = CascadeType.PERSIST,
            orphanRemoval = true
    )
    private List<Bilete> listaBilete = new ArrayList<>();

    public Companie(Integer idCompanie, String numeCompanie, Integer punctaj) {
        super();
        this.idCompanie = idCompanie;
        this.numeCompanie = numeCompanie;
        this.punctaj = punctaj;
    }
    public Companie(String numeCompanie, int punctaj) {
        this.numeCompanie = numeCompanie;
        this.punctaj = punctaj;
    }

    public Companie(String numeCompanie) {
        this.numeCompanie = numeCompanie;
    }

    public int getPunctaj() {
        return punctaj;
    }

    public List<Bilete> getListaBilete() {
        return listaBilete;
    }

    public void setListaBilete(List<Bilete> listaBilete) {
        this.listaBilete = listaBilete;
    }

    public Companie(String numeCompanie, int punctaj, List<Bilete> listaBilete) {
        this.numeCompanie = numeCompanie;
        this.punctaj = punctaj;
        this.listaBilete = listaBilete;
    }

    public Companie() {
        super();
    }

    public void setPunctaj(int punctaj) {
        this.punctaj = punctaj;
    }

//    public List<Bilete> getListaBilete() {
//        return listaBilete;
//    }
//
//    public void setListaBilete(List<Bilete> listaBilete) {
//        this.listaBilete = listaBilete;
//    }

    public Integer getIdCompanie() {
        return idCompanie;
    }

    public void setIdCompanie(Integer idCompanie) {
        this.idCompanie = idCompanie;
    }

    public String getNumeCompanie() {
        return numeCompanie;
    }

    public void setNumeCompanie(String numeCompanie) {
        this.numeCompanie = numeCompanie;
    }
}
