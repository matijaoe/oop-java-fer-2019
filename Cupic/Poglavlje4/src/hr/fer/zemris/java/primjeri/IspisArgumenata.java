package hr.fer.zemris.java.primjeri;
//str 75

public class IspisArgumenata {

    public static void main(String[] args) {
        int brojArgumenata = args.length;

        for (int i = 0; i < brojArgumenata; i++) {
            System.out.println("Argument " + (i + 1) + ": " + args[i]);
        }
    }
}
