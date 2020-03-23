package hr.fer.zemris.java.primjeri;

/**
 * @author Marko Cupic
 * @version 1.0
 */
public class RadSaStringovima {

    /**
     * Metoda koja se poziva prilikom pokretanja programa. Argumenti su
     * objasnjeni u nastavku.
     *
     * @param args Argumenti iz komandne linije.
     */
    public static void main(String[] args) {
        ispis1();
        ispis2();
        ispis3();
        ispis4();
    }

    /**
     * Demonstracija zbrajanja stringova.<br>
     * Zbrajanje uporabom operatora + kroz vise naredbi. Vrlo neefikasno!
     */
    private static void ispis1() {
        String tekst = null;

        tekst = "The quick " + "brown ";
        tekst += "fox jumps over ";
        tekst += 3;
        tekst += " lazy dogs.";

        System.out.println(tekst);
    }

    /**
     * Demonstracija zbrajanja stringova.<br>
     * Zbrajanje operatorom + u jednoj naredbi. Efikasnije.
     */
    private static void ispis2() {
        String tekst = null;

        int broj = 3;

        tekst = "The quick brown fox jumps over "
                + broj + " lazy dogs.";

        System.out.println(tekst);
    }

    /**
     * Demonstracija zbrajanja stringova.<br>
     * Zbrajanje uporabom StringBuffer objekta. Jednako efikasno kao i primjer
     * 2? Inicijalno se stvara spremnik velicine 16 koji se tri puta realocira
     * kako bi se prosirio. Napomena: prije Java 5.0 koristio se StringBuffer
     * koji je bitno sporiji (ali je višedretveno siguran).
     */
    private static void ispis3() {
        String tekst = null;

        StringBuilder sb = new StringBuilder();

        sb.append("The quick ").append("brown ");
        sb.append("fox jumps over ").append(3);
        sb.append(" lazy dogs.");

        tekst = sb.toString();

        System.out.println(tekst);
    }

    /**
     * Demonstracija zbrajanja stringova.<br>
     * Zbrajanje uporabom StringBuffer objekta. Najefikasnije ako unaprijed
     * znamo potrebnu velicinu spremnika. U primjeru se alocira spremnik
     * velicine 50 znakova. Napomena: prije Java 5.0 koristio se StringBuffer
     * koji je bitno sporiji (ali je višedretveno siguran).
     */
    private static void ispis4() {
        String tekst = null;

        StringBuilder sb = new StringBuilder(50);

        sb.append("The quick ").append("brown ");
        sb.append("fox jumps over ").append(3);
        sb.append(" lazy dogs.");

        tekst = sb.toString();

        System.out.println(tekst);
    }
}
