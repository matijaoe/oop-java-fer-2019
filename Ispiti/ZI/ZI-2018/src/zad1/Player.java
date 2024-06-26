package zad1;


public class Player {

    private String name;
    private String surname;
    private String team;
    private int number;
    private int goals;
    private int assists;

    public Player(String name, String surname, int number, int goals, int assists, String team) {
        super();
        this.name = name;
        this.surname = surname;
        this.number = number;
        this.goals = goals;
        this.assists = assists;
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public int getAssists() {
        return assists;
    }

    public void setAssists(int assists) {
        this.assists = assists;
    }



}
