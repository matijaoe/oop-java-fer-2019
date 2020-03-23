package hr.fer.oop.gol;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.*;

public class BoardFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int BOARD_HEIGHT = 30;
	private static final int BOARD_WIDTH = 30;
	private JButton btnPlay, btnStop, btnTick;
	private JToggleButton buttons[][];
	private Board board;
	private SimulationWorker simulationWorker;
	private JRadioButton btnAlive, btnDead;
	
	public BoardFrame() {
		JPanel buttonPanel = new JPanel();
		
		btnPlay = new JButton("Pokreni");
		buttonPanel.add(btnPlay);
		btnPlay.addActionListener((e) -> {
			simulationWorker = new SimulationWorker(board, btnAlive, btnDead);
			btnPlay.setEnabled(false);
			btnStop.setEnabled(true);
			btnTick.setEnabled(false);
			simulationWorker.execute();
		});
		
		btnStop = new JButton("Zaustavi");
		btnStop.setEnabled(false);
		buttonPanel.add(btnStop);
		btnStop.addActionListener((e) -> {
			simulationWorker.cancel(true);
			btnPlay.setEnabled(true);
			btnStop.setEnabled(false);
			btnTick.setEnabled(true);
		});
		
		btnTick = new JButton("Jedna iteracija");
		buttonPanel.add(btnTick);
		btnTick.addActionListener((e) -> {
			board.playOneIteration();
			if (btnAlive.isSelected()) {
				btnAlive.setText(String.valueOf(board.getCounterAlive()));
				btnDead.setText("Dead");
			} else if (btnDead.isSelected()) {
				btnDead.setText(String.valueOf(board.getCounterDead()));
				btnAlive.setText("Alive");
			}

		});

		ButtonGroup btnGroup = new ButtonGroup();
		btnAlive = new JRadioButton("Alive");
		buttonPanel.add(btnAlive);
		btnGroup.add(btnAlive);
		btnAlive.addActionListener(e -> {
			board.setCounterAlive(0);
		});

		btnDead = new JRadioButton("Dead");
		buttonPanel.add(btnDead);
		btnGroup.add(btnDead);
		btnDead.addActionListener(e -> {
			board.setCounterDead(0);
		});
		
		add(buttonPanel, BorderLayout.NORTH);
		
		initializeButonsAndBoard();
	}

	private void initializeButonsAndBoard() {
		board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
		buttons = new JToggleButton[BOARD_WIDTH][BOARD_HEIGHT];
		JPanel boardPanel = new JPanel();
		add(boardPanel, BorderLayout.CENTER);
		boardPanel.setLayout(new GridLayout(BOARD_WIDTH, BOARD_HEIGHT, 1, 1));
		
		for (int y = 0; y < BOARD_HEIGHT; y++) {
			for (int x = 0; x < BOARD_WIDTH; x++) {
				JToggleButton toggleButton = new JToggleButton();
				toggleButton.setPreferredSize(new Dimension(20, 20));
				buttons[x][y] = toggleButton;
				Point point = new Point(x, y);
				toggleButton.addActionListener((e) -> {
					if(((JToggleButton)e.getSource()).isSelected()) {
						board.setCell((int)point.getX(), (int)point.getY(), true);
					} else {
						board.setCell((int)point.getX(), (int)point.getY(), false);
					}
				});
				boardPanel.add(toggleButton);
			}
		}
		
		board.addListener((b) -> {
			boolean cells[][] = new boolean[BOARD_WIDTH][BOARD_HEIGHT];
			for (int y = 0; y < BOARD_HEIGHT; y++) {
				for (int x = 0; x < BOARD_WIDTH; x++) {
					cells[x][y] = b.isCellAlive(x, y);
				}
			}
			
			SwingUtilities.invokeLater(() -> {
				for (int y = 0; y < BOARD_HEIGHT; y++) {
					for (int x = 0; x < BOARD_WIDTH; x++) {
						buttons[x][y].setSelected(cells[x][y]);
					}
				}
			});
		});
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			BoardFrame frame = new BoardFrame();
			frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
		});
	}

}
