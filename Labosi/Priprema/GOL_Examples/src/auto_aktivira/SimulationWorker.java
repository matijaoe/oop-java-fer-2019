package auto_aktivira;

import javax.swing.*;

public class SimulationWorker extends SwingWorker<Void, Void> {

    private Board board;
    int time;

    public SimulationWorker(Board board) {
        this.board = board;
        this.time = 500;
    }

    public SimulationWorker(Board board, int time) {
        this.board = board;
        this.time = time;
    }


    @Override
    protected Void doInBackground() throws Exception {
        while(!isCancelled()){
            board.playOneIteration();
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                //ignore
            }
        }

        return null;
    }

}
