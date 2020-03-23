package hr.fer.oop.lab3.vjezba;

/**
 *
 * @author Matija
 */
public class FormationMain2 {

    public static void main(String[] args) {

        CustomFormation formation1 = new CustomFormation(2, 4, 0, 9);
        System.out.println(formation1);

        CustomFormation formation2 = new CustomFormation();
        System.out.println(formation2);

        CustomFormation formation3 = new CustomFormation(1, 3, 5, 2);
        System.out.println(formation3);

        CustomFormation formation4 = new CustomFormation(1, 8, 1, 1);
        System.out.println(formation4);

        CustomFormation formation5 = new CustomFormation(1, 4, 2, 4);
        System.out.println(formation5);

        CustomFormation formation6 = new CustomFormation(1, 3, 6, 1);
        System.out.println(formation6);
    }

}
