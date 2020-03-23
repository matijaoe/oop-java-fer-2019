package lab.zad3;

public class Main {

    public static void main(String[] args) {

        Solution sol = new Solution();

        sol.addStudentPoints("Marko", 1, 2);
        sol.addStudentPoints("Marko", 10);
        sol.addStudentPoints("Ana", 4, 3, 1);
        sol.addStudentPoints("Ana", 1, 2, 1);
        sol.addStudentPoints("Margareta", 5, 4);


        System.out.println(sol.getStudentSize());
        System.out.println(sol.getTotalPoints());
        System.out.println(sol.getTotalPointsForStudent("Margareta"));
        System.out.println(sol.getTotalPointsForStudent("Marko"));
        System.out.println(sol.getTotalPointsForStudent("Ana"));

    }
}
