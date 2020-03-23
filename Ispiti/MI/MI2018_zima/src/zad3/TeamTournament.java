package zad3;

/**
 *
 * @author Matija
 */
public class TeamTournament extends Tournament {

    public TeamTournament(String name, String when) {
        super(name, when);
    }

    @Override
    public boolean addCompetitor(Competitor newCompetitor) {
        if (newCompetitor instanceof Team) {
            return super.addCompetitor(newCompetitor);
        } else {
            return false;
        }
    }

}
