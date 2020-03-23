package ziv_carstvo;

/**
 *
 * @author Matija
 */
public class Slicica implements Comparable<Slicica> {

    private String[] nazivi = {
        "antilopa", "bumbar", "crv", "deva", "emu", "fazan", "gorila", "hrcak", "iguana", "jez"};

    private String naziv;
    private int rbr;

    public Slicica() {
        this.rbr = (int) (Math.random() * nazivi.length + 1);
        this.naziv = nazivi[this.rbr - 1];
    }

    public Slicica(int rbr) {
        this.rbr = rbr;
        this.naziv = nazivi[this.rbr - 1];
    }

    public String getNaziv() {
        return this.naziv;
    }

    public int getRbr() {
        return this.rbr;
    }

    @Override
    public int compareTo(Slicica other) {
        return Integer.compare(this.rbr, other.rbr);
    }

    @Override
    public String toString() {
        return this.rbr + " " + this.naziv;
    }

    @Override
    public int hashCode() {
        return new Integer(this.rbr).hashCode();
    }

    @Override
    public boolean equals(Object o) {
        return o == null ? false : o instanceof Slicica ? ((Slicica) o).getRbr() == this.rbr : false;
    }

}
