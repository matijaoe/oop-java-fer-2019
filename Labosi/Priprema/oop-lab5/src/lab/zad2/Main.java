package lab.zad2;


public class Main {

    public static void main(String[] args) {

        Solution sol = new Solution();
        sol.addEntry("Matija", "OOP", 5);
        sol.addEntry("Matija", "TZK", 5);
        sol.addEntry("Leo", "OOP", 2);
        sol.addEntry("Leo", "PIPI", 3);
        sol.addEntry("Leo", "FIZ", 4);
        sol.addEntry("Ana", "OOP", 5);
        sol.addEntry("Ana", "MAT", 4);
        sol.addEntry("Ana", "FIZ", 2);

        System.out.println(sol.getScore("Matija", "OOP"));
        System.out.println(sol.getScore("das", "OOP"));

        System.out.println(sol.getNaturallyOrderedScoresByCourse("OOP"));
        System.out.println(sol.getNaturallyOrderedScoresByCourse("msakd"));



    }
}
