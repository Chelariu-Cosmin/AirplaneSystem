package entity;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDate;

@MappedSuperclass
public class Persoana {

    private String nume;
    private String cnp;
    private String adresa;
    private String localitate;
    private String tara;

    private LocalDate dataNastere;

    public Persoana() {

    }

    public Persoana(String nume, String cnp, String adresa, String localitate, String tara, LocalDate dataNastere) {
        this.nume = nume;
        this.cnp = cnp;
        this.adresa = adresa;
        this.localitate = localitate;
        this.tara = tara;
        this.dataNastere = dataNastere;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public String getTara() {
        return tara;
    }

    public void setTara(String tara) {
        this.tara = tara;
    }

    public LocalDate getDataNastere() {
        return dataNastere;
    }

    public void setDataNastere(LocalDate dataNastere) {
        this.dataNastere = dataNastere;
    }
}
