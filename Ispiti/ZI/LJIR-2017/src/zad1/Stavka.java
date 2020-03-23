package zad1;

public class Stavka {

    String naziv;
    double jedinicnaCijena;
    int kolicina;
    double pdv;

    public Stavka(String naziv, double jedinicnaCijena, int kolicina, double pdv) {
        this.naziv = naziv;
        this.jedinicnaCijena = jedinicnaCijena;
        this.kolicina = kolicina;
        this.pdv = pdv;
    }

    public String getNaziv() {
        return naziv;
    }

    public double getJedinicnaCijena() {
        return jedinicnaCijena;
    }

    public int getKolicina() {
        return kolicina;
    }

    public double getPdv() {
        return pdv;
    }
}
