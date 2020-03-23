package zad3;


public class Main {

    public static void main(String[] args) {

        Grades grades = new Grades();
        grades.add("Nikola", 4);
        grades.add("Petar", 3);
        grades.add("Jovica", 3);
        grades.add("Barbara", 2);
        grades.add("Lovro", 1);
        grades.print();
        System.out.println();


        Grades2 grades2 = new Grades2();
        grades2.add("Nikola", 4);
        grades2.add("Petar", 3);
        grades2.add("Jovica", 3);
        grades2.add("Barbara", 2);
        grades2.add("Lovro", 1);
        grades2.add("Nikola", 5);
        grades2.add("Nikola", 5);
        grades2.add("Jovica", 3);
        grades2.add("Karlo", 1);
        grades2.add("Barbara", 3);
        grades2.print();
        System.out.println();


        Grades3 grades3 = new Grades3();
        grades3.add("Mauro", "Geografija", 4);
        grades3.add("Mauro", "Hrvatski", 2);
        grades3.add("Mauro", "Matematika", 4);
        grades3.add("Mauro", "Povijest", 5);
        grades3.add("Mauro", "Kemija", 4);
        grades3.add("Lea", "Geografija", 4);
        grades3.add("Lea", "Hrvatski", 5);
        grades3.add("Lea", "Matematika", 5);
        grades3.add("Lea", "Kemija", 4);
        grades3.add("Lea", "TZK", 3);
        grades3.add("Teja", "Povijest", 3);
        grades3.add("Teja", "Hrvatski", 2);
        grades3.add("Dominik", "Matematika", 3);
        grades3.add("Dominik", "Povijest", 4);
        grades3.print();
        System.out.println();
        grades3.printForCourse("Matematika");

    }

}
