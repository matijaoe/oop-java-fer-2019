package vjezba.spremnik;

public class Spremnik implements AutoCloseable {

    private String ime;

    public Spremnik(String ime) {
        if (ime.length() == 0) {
            throw new IllegalArgumentException();
        }
        this.ime = ime;
        System.out.print("Stvoren " + ime + ";");
    }

    @Override
    public void close() {
        System.out.print("Zatvoren " + ime + ";");
    }

    public void write(int i) {
        if (i < 0) {
            throw new RuntimeException();
        }
        if (i == 0) {
            throw new ArithmeticException();
        }
    }
}
