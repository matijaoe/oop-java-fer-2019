package hr.fer.oop.gol;

import javax.swing.*;

public class SimulationWorker extends SwingWorker<Void, Void> {

	private Board board;
	private JToggleButton btnAlive, btnDead;

	public SimulationWorker(Board board) {
		this.board = board;
	}

	public SimulationWorker(Board board, JToggleButton btnAlive, JToggleButton btnDead) {
		this.board = board;
		this.btnAlive = btnAlive;
		this.btnDead = btnDead;
	}

	@Override
	protected Void doInBackground() throws Exception {
		while(!isCancelled()){
			board.playOneIteration();

			if (btnAlive.isSelected()) {
				btnAlive.setText(String.valueOf(board.getCounterAlive()));
				btnDead.setText("Dead");
			} else if (btnDead.isSelected()) {
				btnDead.setText(String.valueOf(board.getCounterDead()));
				btnAlive.setText("Alive");
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				//ignore
			}
		}
		
		return null;
	}


}
