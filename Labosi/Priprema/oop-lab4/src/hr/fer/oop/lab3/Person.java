package hr.fer.oop.lab3;

import hr.fer.oop.lab3.welcomepack.Constants;
import hr.fer.oop.lab4.exceptions.FootballPlayerEmotionException;

/**
 * Thiss class represents an individual person, with their name, representing
 * country and emotion level. This class is used as a base class for its
 * subclasses.
 *
 * @author Matija
 */
public abstract class Person {

    private String name = Constants.DEFAULT_PLAYER_NAME;
    //private String name = "No name";
    private String country = Constants.DEFAULT_COUNTRY;
    //private String country = "Noland";
    private int emotion = Constants.DEFAULT_EMOTION;
    //private int emotion = 20;

    /**
     * Base constructor for its subscalsses.
     */
    public Person() {
    }

    /**
     * Base constructor for its subclasses. Variables name, country and emotion
     * cannot be changed after calling this constructor. Variables can't be
     * null, otherwise they will be set to their default value stated in
     * {@code Constants}.
     *
     *
     * @param name
     * @param country
     * @param emotion
     */
    public Person(String name, String country, int emotion) {
        if (name == null) {
            System.err.println("Name can't be null!");
        } else {
            this.name = name;
        }
        if (country == null) {
            System.err.println("Country can't be null!");
        } else {
            this.country = country;
        }
        setEmotion(emotion);
    }

    /**
     * Return the name of the player, manager or a team..
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the country assigned to a player, manager or a team.
     *
     * @return country
     */
    public String getCountry() {
        return country;
    }

    /**
     * Return the person's emotion in range [1-100].
     *
     * @return emotion in range [1-100]
     */
    public int getEmotion() {
        return emotion;
    }

    /**
     * Sets the person's emotion. If the value is not in range [1-100], value is
     * set to default value stated in {@code Constants}.
     *
     * @param emotion - emotion in range [1-100]
     */
    public void setEmotion(int emotion) {
        boolean foundException = false;

        try {
            if (emotion >= Constants.MIN_EMOTION && emotion <= Constants.MAX_EMOTION) {
                this.emotion = emotion;
                System.out.println("Emotion sucessfully set to " + emotion + ".");
            } else {
                throw new FootballPlayerEmotionException("Emotion is out of range:",
                        Constants.MIN_EMOTION, Constants.MAX_EMOTION);
            }

        } catch (FootballPlayerEmotionException ex) {
            ex.printStackTrace();
            //System.err.println(ex.getMessage());
            this.emotion = 25;
            foundException = true;

        } finally {
            if (foundException) {
                System.out.println("Emotion set to 25.");
            }

        }

    }

    /**
     * Returns true if both {@code Person} objects are equal. Two are equal only
     * if they have both the same name and country they represent.
     *
     * @param obj an object
     * @return true if both are equal, otherwise false
     */
    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Person person = (Person) obj;

        boolean sameName;
        if (name != null && person.name != null) {
            sameName = name.equals(person.name);
        } else if (name == null && person.name == null) {
            sameName = true;
        } else {
            return false;
        }

        boolean sameCountry;
        if (country != null && person.country != null) {
            sameCountry = name.equals(person.country);
        } else if (country == null && person.country == null) {
            sameCountry = true;
        } else {
            return false;
        }

        return sameName && sameCountry;
    }

    /**
     *
     * @return result
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        return result;
    }

    public static void main(String[] args) {

        Person p = new Coach();
        p.setEmotion(50);
        p.setEmotion(269);
        p.setEmotion(95);
    }

}
