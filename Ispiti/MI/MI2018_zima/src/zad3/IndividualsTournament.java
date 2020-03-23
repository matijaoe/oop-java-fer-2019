package zad3;

/**
 *
 * @author Matija
 */
public class IndividualsTournament extends Tournament {

    public IndividualsTournament(String name, String when) {
        super(name, when);
    }

    @Override
    public boolean addCompetitor(Competitor newCompetitor) {
        if (newCompetitor instanceof Player) {
            return super.addCompetitor(newCompetitor);
        } else {
            return false;
        }
    }

}
