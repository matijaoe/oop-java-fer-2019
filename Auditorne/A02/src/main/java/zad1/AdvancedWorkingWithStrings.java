/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package zad1;

/**
 *
 * @author Matija
 */
public class AdvancedWorkingWithStrings {

    static String text = "";

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for (String arg : args) {
            sb.append(arg).append(";");
        }
        text = sb.toString();

        if (!text.isEmpty()) {
            System.out.println(text + "\n");
            split();
            System.out.println();
            indexOfLetter();
            System.out.println();
            substring();
        }
    }

    // a)
    public static void split() {
        String[] splits = text.split(";");
        for (String eachSplit : splits) {
            System.out.println(eachSplit);
        }
    }

    // b)
    public static void indexOfLetter() {
        int firstIndexOfSemicolon = text.indexOf(";");
        int lastIndexOfSemicolon = text.lastIndexOf(";");

        System.out.println("First semicolon index is " + firstIndexOfSemicolon
                + " and the last one is " + lastIndexOfSemicolon);
    }

    // c)
    public static void substring() {
        int firstIndexOfSemicolon = text.indexOf(";");
        int lastIndexOfSemicolon = text.lastIndexOf(";");

        String substring = text.substring(firstIndexOfSemicolon + 1, lastIndexOfSemicolon);
        System.out.println(substring);
    }
}
