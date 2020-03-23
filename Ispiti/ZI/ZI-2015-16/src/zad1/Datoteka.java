package zad1;

import java.nio.file.Path;

public class Datoteka implements Comparable<Datoteka> {
    private Path naziv;
    private long velicina;

    public Datoteka(Path naziv, long velicina) {
        this.naziv = naziv;
        this.velicina = velicina;
    }

    public Path getNaziv() {
        return this.naziv;
    }

    public long getVelicina() {
        return this.velicina;
    }

    @Override
    public int compareTo(Datoteka o) {
        if (this.velicina > o.getVelicina())
            return -1;
        else
            return 1;
    }
}