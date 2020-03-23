package lab.zad2;

import java.util.Collection;

interface StudentDatabase {
    /**
     * Biljezi ocjenu za studenta iz odredjenog predmeta. Student moze imati samo jednu ocjenu iz tocno odredjenog predmeta. Ocjena se moze naknadno mijenjati pri cemu se stara ocjena obrise.
     *
     * @param student
     * @param course
     * @param score
     */
    void addEntry(String student, String course, int score);

    /**
     * Dohvat ocjene za studenta iz odredjenog predmeta. Vraca null ako ne postoji zapis.
     *
     * @param student
     * @param course
     * @return
     */
    Integer getScore(String student, String course);


    /**
     * Vraca kolekciju ocjena sortiranu prema prirodnom poretku i filtriranu prema odredjenom predmetu. Ako nema zapisa vraca praznu kolekciju.
     *
     * @param course
     * @return
     */
    Collection<Integer> getNaturallyOrderedScoresByCourse(String course);

}
