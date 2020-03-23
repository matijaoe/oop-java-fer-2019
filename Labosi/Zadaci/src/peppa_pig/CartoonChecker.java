package peppa_pig;

import java.util.Arrays;

/**
 *
 * @author Matija
 */
class CartoonChecker {

    public static void processCharacter(String s) {
        if (Arrays.asList(Peppa.getAllCharacters()).contains(s)) {

            System.out.println(s + "JE u crtanom filmu Peppa Pig");

        } else {
            throw new InvalidPeppaPigCharacterException(s + " NIJE u crtanom filmu Peppa Pig");
        }
    }
}
