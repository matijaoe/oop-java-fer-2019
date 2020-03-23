package hr.fer.oop.lab2.vjezba;

import java.util.Scanner;

public class MatixDiag {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;

        do {
            System.out.println("Unesite n: ");
            n = sc.nextInt();
        } while (n <= 0);

        int[][] array = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; ++j) {
                array[i][j] = sc.nextInt();
            }
        }
        System.out.println("Ukupni zbroj na glavnoj dijagonali je: " + zbroji(n, array) + ".");
        sc.close();
    }

    public static int zbroji(int n, int[][] array) {
        int zbroj = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (i == j) {
                    zbroj += array[i][j];
                }
            }
        }
        return zbroj;
    }

}
