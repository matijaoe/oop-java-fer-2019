package password;

/**
 *
 * @author Matija
 */
class Utils {

    public static int checkPassword(String pw) {
        int strength = 0;
        int digitCounter = 0;
        int uppercaseCounter = 0;

        for (int i = 0; i < pw.length(); i++) {
            char c = pw.charAt(i);
            if (Character.isDigit(c)) {
                digitCounter++;
            } else if (Character.isUpperCase(c)) {
                uppercaseCounter++;
            }
        }

        strength = pw.length() + digitCounter * 3 + uppercaseCounter * 2;

        if ((pw.length() < 6 && strength < 10)) {
            throw new IllegalArgumentException("Lozinka je i prekratka i preslaba");
        } else if (pw.length() < 6) {
            throw new IllegalArgumentException("Lozinka je prekratka.");
        } else if (strength < 10) {
            throw new SecurityException("Lozinka nije dovoljno snazna.");
        }

        return strength;
    }

    public static void main(String[] args) {

        try {
            System.out.println(checkPassword("proba")); // IllegalArgumentException zbog oboje
            System.out.println(checkPassword("PR567")); // IllegalArgumentException zbog length
            System.out.println(checkPassword("lozinka")); // SecurityException
            System.out.println(checkPassword("moja45LozinkaJEk00l"));
            System.out.println(checkPassword("messiVoliCR7!!!!!!!!!!!!!"));

        } catch (IllegalArgumentException | SecurityException ex) {
            System.err.println(ex.getMessage());
        }
    }

}
