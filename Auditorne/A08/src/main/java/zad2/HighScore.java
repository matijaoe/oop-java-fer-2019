package zad2;


import java.util.*;


public class HighScore {
    private List<HSElement> hscore;

    public HighScore() {
        hscore = new LinkedList<>();
    }

    // Efikasnija verzija metode (ne zahtjeva sučelje Comparable)
    // Lista se automatski sortira, od najveceg do najmanjeg
    public void add(HSElement element) {
        int i;
        for (i = 0; i < hscore.size(); i++) {
            if (element.getScore() > hscore.get(i).getScore()) {
                break;
            }
        }
        hscore.add(i, element);
    }

    public void add(int Score, String Name) {
        this.add(new HSElement(Score, Name));
    }

    public void print() {
        for (HSElement element : hscore) {
            System.out.println(element.getName() + ": " + element.getScore());
        }
    }

    // Rješenje pomoću skupa
    public void printBestHashSet() {
        Set<String> printed = new HashSet<>();

        // Iteriraj po elementima redom (bolji rezultati su prije u listi)
        // Ispiši prvi rezultat za svakog igrača, a igrače za koje je rezultat
        // već ispisan pohrani u skupu
        for (HSElement element : hscore) {
            String name = element.getName();
            int score = element.getScore();

            if (!printed.contains(name)) {
                System.out.println(name + ": " + score);
                printed.add(name);
            }
        }
    }

    // Rješenje pomoću Mape
    public void printBestMap() {
        Map<String, Integer> bestScores = new HashMap<>();

        // Izračunaj najbolji score za svakog igrača i spremi u mapu
        for (HSElement element : hscore) {
            String name = element.getName();
            int score = element.getScore();

            if (!bestScores.containsKey(name) || bestScores.get(name) < score) {
                bestScores.put(name, score);
            }
        }

        // Ispiši najbolji score za svakog igrača
        for (String name : bestScores.keySet()) {
            System.out.println(name + ": " + bestScores.get(name));
        }
    }
}