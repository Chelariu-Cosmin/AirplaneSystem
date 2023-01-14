package entity;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;

import java.util.Date;

import static jakarta.persistence.TemporalType.DATE;

@MappedSuperclass
public class Program {

    private String tara;
    private String oras;
    private String numeAeroport;
    @Temporal(DATE)
    private Date data;

    public Program(String tara, String oras, String numeAeroport, Date data) {
        this.tara = tara;
        this.oras = oras;
        this.numeAeroport = numeAeroport;
        this.data = data;
    }

    public Program() {
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public String getOras() {
        return oras;
    }

    public void setOras(String oras) {
        this.oras = oras;
    }

    public String getNumeAeroport() {
        return numeAeroport;
    }

    public void setNumeAeroport(String numeAeroport) {
        this.numeAeroport = numeAeroport;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }
}
