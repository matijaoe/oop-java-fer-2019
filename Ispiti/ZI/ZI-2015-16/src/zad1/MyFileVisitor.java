package zad1;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyFileVisitor extends SimpleFileVisitor<Path> {

    private List<String> ekstenzije;
    private Set<Datoteka> desetNajvecih;
    private long sum;

    public MyFileVisitor(List<String> ekstenzije) {
        this.ekstenzije = ekstenzije;
        this.desetNajvecih = new TreeSet<>();
        sum = 0;
    }

    public Set<Datoteka> getDesetNajvecih() {

        return this.desetNajvecih;

    }

    public long getSum() {
        return sum;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        for (String ekstenzija : ekstenzije) {
            if (file.toString().endsWith(ekstenzija)) {
                long itemSize = file.toFile().length();
                sum += itemSize;
                if (this.desetNajvecih.size() >= 10) {
                    Datoteka najmanji = ((TreeSet<Datoteka>) this.desetNajvecih).last();
                    if (najmanji.getVelicina() < itemSize) {
                        desetNajvecih.remove(najmanji);

                        desetNajvecih.add(new Datoteka(file, itemSize));
                    }
                } else {
                    desetNajvecih.add(new Datoteka(file, itemSize));
                }
                break;
            }
        }
        return FileVisitResult.CONTINUE;
    }
}
