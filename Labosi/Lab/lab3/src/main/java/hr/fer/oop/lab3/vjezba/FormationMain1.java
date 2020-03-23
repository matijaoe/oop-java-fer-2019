package hr.fer.oop.lab3.vjezba;

import hr.fer.oop.lab3.vjezba.CustomFormation;

import java.util.Scanner;

/**
 *
 * @author Matija
 */
public class FormationMain1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Golman: ");
        int Gks = sc.nextInt();
        System.out.println("Obrambeni: ");
        int Dfs = sc.nextInt();
        System.out.println("Vezni: ");
        int Mfs = sc.nextInt();
        System.out.println("Napadaci: ");
        int Fws = sc.nextInt();

        CustomFormation newFormation = new CustomFormation(Gks, Dfs, Mfs, Fws);

        System.out.println(newFormation);

        sc.close();
    }

}
