package hr.fer.zemris.java.tecaj_1;

/**
 *
 * @author Matija
 */
public abstract class GeometrijskiLik implements SadrziocTocaka {

    private String ime;

    public GeometrijskiLik(String ime) {
        this.ime = ime;
    }

    public String getIme() {
        return ime;
    }

    public double getOpseg() {
        return 0;
    }

    public double getPovrsina() {
        return 0;
    }

//    public boolean sadrziTocku(int x, int y) {
//        return false;
//    }
//    public void crtaj(Slika slika) {
//        for (int y = 0, h = slika.getVisina(); y < h; y++) {
//            for (int x = 0, w = slika.getVisina(); x < h; x++) {
//                if (this.sadrziTocku(x, y)) {
//                    slika.upaliElement(x, y);
//                }
//            }
//        }
//    }
}
