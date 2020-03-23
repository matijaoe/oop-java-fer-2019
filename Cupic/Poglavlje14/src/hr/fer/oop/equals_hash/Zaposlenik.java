package hr.fer.oop.equals_hash;

import java.util.Objects;

public class Zaposlenik {

    private String sifra;
    private String ime;
    private String prezime;
    private double placa;

    public Zaposlenik(String sifra, String ime, String prezime) {
        super();
        if (sifra == null) {
            throw new IllegalArgumentException(
                    "Šifra zaposlenika ne smije biti null!"
            );
        }
        this.sifra = sifra;
        this.ime = ime;
        this.prezime = prezime;
    }

    public String getSifra() {
        return sifra;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public double getPlaca() {
        return placa;
    }

    public void setPlaca(double placa) {
        this.placa = placa;
    }

    @Override
    public String toString() {
        return String.format(
                "Zaposlenik: sifra=%s, prezime=%s, ime=%s, placa=%f",
                sifra, prezime, ime, placa);
    }

    /*@Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if(!(obj instanceof Zaposlenik)) return false;

        Zaposlenik drugi = (Zaposlenik) obj;
        if (this.sifra == null) {
            if (drugi.sifra == null) {
                return true;
            } else {
                return false;
            }
        } else if (drugi.sifra == null) {
            return false;
        }

        return this.sifra.equals(drugi.sifra);
    }*/

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Zaposlenik)) return false;
        Zaposlenik drugi = (Zaposlenik) obj;
        // Objects.equals vec sadrzi logiku za usporedbu refernci null
        return Objects.equals(this.sifra, drugi.sifra);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sifra);
    }


//    @Override
//    public int hashCode() {
//        return ((sifra == null) ? 0 : sifra.hashCode());
//    }
}