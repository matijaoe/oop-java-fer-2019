package hr.fer.oop.lab3;

/**
 *
 * @author Matija
 */
public interface ITrainer {

    /**
     * Coach organises a trainig session for players not in the starting eleven
     * (based on skill level). It upgrades player's skill by 10% of the coach's
     * skill, but only if they have lower skill level than the coach before the
     * training.
     *
     */
    public void performTeamTrainingSession();
}
