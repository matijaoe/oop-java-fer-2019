package zad2;

/**
 * Napisati klasu GlassOfWater koja modelira čašu koja se može puniti vodom ili
 * kockama leda. Atributi klase (zapremina čaše [u mililitrima], koliko vode i
 * koliko kocki leda sadrži) trebaju biti enkapsulirani, a klasa mora imati
 * dvije javne metode – addWater(int waterAmount) i addIceCubes(int
 * numberOfIceCubes) kojima se čaša puni vodom zadanom u mililitrima ili ledom
 * zadanim brojem kocaka. Svaka kocka leda zauzima 50ml i kocke se mogu savršeno
 * složiti u čašu. Zapremina čaše zadaje se konstruktorom. Ako se u čašu utoči
 * previše vode ili doda previše leda, dolazi do prelijevanja. U slučaju
 * prelijevanja prvo izlazi višak vode, a onda otpada višak kocaka leda.
 * Enkapsulirati prelijevanje u zasebnu metodu koja se poziva iz javnih metoda
 * klase za dodavanje vode ili leda. Pri dodavanju leda ili vode ispisati na
 * ekran stanje čaše prije dodavanja, zatim količinu vode i leda koji se dodaju,
 * a naposljetku nakon provjere prelijevanja ispisati novo stanje. U slučaju
 * prelijevanja ispisati na ekran koliko se vode prelilo i koliko je kocki leda
 * otpalo.
 *
 * @author Matija
 */
public class GlassOfWater {

    private int glassSize, currentWaterAmount, currentIceCubeCount;

    public GlassOfWater(int glassSize) {
        this.glassSize = glassSize;
    }

    public void addWater(int waterAmount) {
        System.out.println("Glass contains " + currentWaterAmount
                + " milliliters of water and " + currentIceCubeCount
                + " ice cubes before addition.");

        System.out.println("Adding " + waterAmount
                + " milliliters of water.");

        currentWaterAmount += waterAmount;

        checkForOverflow();

        System.out.println("Glass contains " + currentWaterAmount
                + " milliliters of water and " + currentIceCubeCount
                + " ice cubes after addition.");
    }

    public void addIceCubes(int numberOfIceCubes) {
        System.out.println("Glass contains " + currentWaterAmount
                + " milliliters of water and " + currentIceCubeCount
                + " ice cubes before addition.");

        System.out.println("Adding " + numberOfIceCubes + " ice cubes.");

        currentIceCubeCount += numberOfIceCubes;

        checkForOverflow();

        System.out.println("Glass contains " + currentWaterAmount
                + " milliliters of water and " + currentIceCubeCount
                + " ice cubes after addition.");
    }

    public void checkForOverflow() {
        int currentIceCubeVolume = currentIceCubeCount * 50;

        //if true overflow will happen
        if (currentIceCubeVolume + currentWaterAmount > glassSize) {
            int overflowVolume
                    = (currentIceCubeVolume + currentWaterAmount) - glassSize;

            // if true only watter will be overflown
            if (overflowVolume <= currentWaterAmount) {
                currentWaterAmount -= overflowVolume;
                // smanjujemo kolicinu vode za onoliko koliiko se prelilo, jer 
                // sve sto se prelilo je bila voda, te je ili jois ostalo vode 
                // uz led u casi ili nije (ostao samo led)

                System.out.println(overflowVolume
                        + " millilters of water has overflown.");
            } else {
                // entire water overflows
                currentWaterAmount = 0;
                overflowVolume = currentIceCubeVolume - glassSize;

                //rounding up the number of cubes to ceiling
                int overflownIceCubes = (overflowVolume + 49) / 50;
                currentIceCubeCount -= overflownIceCubes;

                System.out.println("All water has overflown. "
                        + overflownIceCubes + " ice cubes have overflown.");
            }
        }
    }

    public static void main(String[] args) {

        GlassOfWater glass = new GlassOfWater(250);

        glass.addWater(200);
        glass.addIceCubes(3);
        glass.addIceCubes(4);
    }
}
