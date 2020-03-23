package fer.oop.zadaci;

/**
 *
 * @author Matija
 */
public class Zad3 {

    public static void main(String[] args) {

        System.out.println(toBinaryString(4));

    }

    public static String toBinaryString(int number) {
        String binary = Integer.toBinaryString(number);
        char[] binNums = new char[binary.length()];
        String binaryFinal = "";

        //punimo listu charactersa
        for (int i = 0; i < binary.length(); i++) {
            binNums[i] = binary.charAt(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < binNums.length; i++) {
            if (i < binNums.length - 1) {
                sb.append(binNums[i]).append(" ");
            } else {
                sb.append(binNums[i]);
            }
        }
        binaryFinal = sb.toString();

        return binaryFinal;

    }
}
