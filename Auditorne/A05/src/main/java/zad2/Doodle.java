package zad2;

import zad1.SimpleArrayList;
import java.util.Scanner;

/**
 *
 * @author Matija
 */
public class Doodle {

    private static final String EOI = "END";

    private SimpleArrayList names;
    private SimpleArrayList times;

    /**
     * Constructs a new instance of Doodle class.
     */
    public Doodle() {
        names = new SimpleArrayList();
        times = new SimpleArrayList();
    }

    /**
     * Creates and fills in the table with entered names nad times.
     *
     * @return table
     */
    public String toTable() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("|%-10s|%-10s|\n", " ---- ", "Time")); // 2 spaces, 4 dashes, 2 spaces

        int len = names.size();
        for (int i = 0; i < len; i++) {
            sb.append(String.format("|%-10s|%-10d|%n", names.get(i),
                    times.get(i)));
        }

        return sb.toString();
    }

    @Override
    public String toString() {
        return this.toTable();
    }

    /**
     * Prompts user to enter his name and desired time of the meeting.
     */
    public void askTime() {
        String line = null;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Tell me your name or tell me to END.");
            line = sc.nextLine();

            if (line.equals(EOI)) {
                break;
            }

            names.add(line);
            System.out.println(line + ", when can you meet?");
            line = sc.nextLine();
            times.add(Integer.parseInt(line));
        }

        sc.close();
    }

    public void removeLastEntry() {
        names.removeLastElement();
        times.removeLastElement();
    }

    /**
     *
     * @return names
     */
    public SimpleArrayList getNames() {
        return names;
    }

    /**
     *
     * @return times
     */
    public SimpleArrayList getTimes() {
        return times;
    }

}

/*
| ----     |Time      |
|Marry     |8         |
|Joel      |19        |
|Natasha   |14        |
|Marin     |19        |
|Manuela   |11        |
|Lenny     |12        |
|Kerry     |19        |
 */
