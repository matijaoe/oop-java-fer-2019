package zad3;

public class HotDogKiosk {
    private int brojRacuna = 0;

    public void pripremi() {
        System.out.println("Robot pripremio hotdog");
    }

    public int prodajKupcu() {
        System.out.format("Hot dog prodan. \n");
        return noviRacun();
    }

    private int noviRacun() {
        brojRacuna++;
        return brojRacuna;
    }
}
