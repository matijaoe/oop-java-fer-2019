package zad1;

public abstract class PoslovniPartner implements Comparable<PoslovniPartner> {

    private String oib;

    protected PoslovniPartner(String oib) {
        this.oib = oib;
    }


    public final String getOib() {
        return oib;
    }

    @Override
    public int hashCode() {
        return oib.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof PoslovniPartner)
            return ((PoslovniPartner) obj).oib.equals(this.oib);
        else
            return false;
    }

    @Override
    public int compareTo(PoslovniPartner o) {
        return oib.compareTo(o.oib);
    }
}
