package hr.fer.zemris.java.tecaj_1;

/**
 *
 * @author Matija
 */
public class Krug extends GeometrijskiLik {

    private int cx, cy, r;

    public Krug(String ime, int cx, int cy, int r) {
        super(ime);
        this.cx = cx;
        this.cy = cy;
        this.r = r;
    }

    public int getCx() {
        return cx;
    }

    public int getCy() {
        return cy;
    }

    public int getR() {
        return r;
    }

    @Override
    public double getOpseg() {
        return 2 * r * Math.PI;
    }

    @Override
    public double getPovrsina() {
        return r * r * Math.PI;
    }

    @Override
    public boolean sadrziTocku(int x, int y) {
        int dx = x - cx;
        int dy = y - cy;

        return dx * dx + dy * dy <= r * r;
    }
}
