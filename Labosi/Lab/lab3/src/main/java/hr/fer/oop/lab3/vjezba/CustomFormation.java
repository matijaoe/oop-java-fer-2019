package hr.fer.oop.lab3.vjezba;

import hr.fer.oop.lab3.welcomepack.Constants;

/**
 * Creates a custom formation.
 *
 * @author Matija
 */
public class CustomFormation {

    private int gkCount;
    private int dfCount;
    private int mfCount;
    private int fwCount;

    public static boolean isValid = true;

    public CustomFormation() {
        this.gkCount = FormationConstants.DEFAULT_GK_COUNT;
        this.dfCount = FormationConstants.DEFAULT_DF_COUNT;
        this.mfCount = FormationConstants.DEFAULT_MF_COUNT;
        this.fwCount = FormationConstants.DEFAULT_FW_COUNT;
        isValid = true;
    }

    public CustomFormation(int gkCount, int dfCount, int mfCount, int fwCount) {

        isValid = true;

        if ((gkCount + dfCount + mfCount + fwCount) != Constants.STARTING_ELEVEN_SIZE) {
            System.err.println("Broj igraca mora biti 11!");
            isValid = false;
        }

        if (gkCount != FormationConstants.DEFAULT_GK_COUNT) {
            System.err.println("Moze biti samo jedan golman!");
            isValid = false;
        } else {
            this.gkCount = gkCount;
        }

        if (dfCount < FormationConstants.MIN_POSITION
                || dfCount > FormationConstants.MAX_POSITION) {
            System.err.println("Nedozvoljen broj branica.");
            isValid = false;
        } else {
            this.dfCount = dfCount;

        }

        if (mfCount < FormationConstants.MIN_POSITION
                || mfCount > FormationConstants.MAX_POSITION) {
            System.err.println("Nedozvoljen broj veznjaka.");
            isValid = false;
        } else {
            this.mfCount = mfCount;
        }

        if (fwCount < FormationConstants.MIN_POSITION
                || fwCount > FormationConstants.MAX_POSITION) {
            System.err.println("Nedozvoljen broj napadaca.");
            isValid = false;
        } else {
            this.fwCount = fwCount;
        }
    }

    @Override
    public String toString() {
        String formation = null;

        if (!isValid) {
            formation = "\n### Nedozvoljena formacija ###\n";
        } else {
            formation = "\nFormation: " + dfCount + "-" + mfCount + "-" + fwCount + "\n"
                    + FormationConstants.FORMATION_STRINGS[fwCount - 1] + "\n"
                    + FormationConstants.FORMATION_STRINGS[mfCount - 1] + "\n"
                    + FormationConstants.FORMATION_STRINGS[dfCount - 1] + "\n"
                    + FormationConstants.FORMATION_STRINGS[gkCount - 1] + "\n";

        }
        return formation;
    }
}
