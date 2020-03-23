package zad2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Politician implements Comparable<Politician> {
    private String oib;
    private String firstname;
    private String surname;
    private String party;

    public Politician(String oib, String firstname, String surname, String party) {
        this.oib = oib;
        this.firstname = firstname;
        this.surname = surname;
        this.party = party;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Politician)) return false;
        Politician other = (Politician) o;
        return Objects.equals(this.oib, other.getOib());
    }

    @Override
    public int hashCode() {
        return oib.hashCode();
    }

    @Override
    public int compareTo(Politician o) {
        int r = this.getParty().compareTo(o.getParty());
        if (r != 0) {
            return r;
        }
        return this.oib.compareTo(o.getOib());
    }

    public String getOib() {
        return oib;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getParty() {
        return party;
    }

    @Override
    public String toString() {
        return "Politician{" + "oib=" + oib + ", firstname=" + firstname + ", surname=" + surname + ", party=" + party + '}';
    }


}

