package zad1;

public class Driver {
    private String firstname;
    private String surname;
    private String address;
    private long oib;

    public Driver(String firstname, String surname, String address, long oib) {
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.oib = oib;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getAddress() {
        return address;
    }

    public long getOib() {
        return oib;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "firstname='" + firstname + '\'' +
                ", surname='" + surname + '\'' +
                ", address='" + address + '\'' +
                ", oib=" + oib +
                '}';
    }

    // //.
}