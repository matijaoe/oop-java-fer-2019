package dead_alive_rgb;

import gameOfLife_load_save.Board;
import gameOfLife_load_save.SimulationWorker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

public class BoardFrame extends JFrame {

    private static final long serialVersionUID = 1L;
    private static final int BOARD_HEIGHT = 30;
    private static final int BOARD_WIDTH = 30;
    private JButton btnPlay, btnStop, btnTick;
    private JToggleButton buttons[][];
    private Board board;
    private SimulationWorker simulationWorker;
    private Color color;
    private JRadioButton alive;
    private JRadioButton dead;

    public BoardFrame() {
        this.color = new Color(255, 255, 255);
        JPanel buttonPanel = new JPanel();

        btnPlay = new JButton("Pokreni");
        buttonPanel.add(btnPlay);
        btnPlay.addActionListener((e) -> {
            simulationWorker = new SimulationWorker(board);
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
        });

        add(buttonPanel, BorderLayout.NORTH);


        alive = new JRadioButton("Alive");

        dead = new JRadioButton("Dead");

        ButtonGroup bgroup = new ButtonGroup();
        bgroup.add(dead);
        bgroup.add(alive);

        buttonPanel.add(dead);
        buttonPanel.add(alive);


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
                buttons[x][y].setBackground(this.color);
                Point point = new Point(x, y);
                toggleButton.addActionListener((e) -> {
                    if (((JToggleButton) e.getSource()).isSelected()) {
                        board.setCell((int) point.getX(), (int) point.getY(), true);
                    } else {
                        board.setCell((int) point.getX(), (int) point.getY(), false);
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


            //buttons[x][y].setSelected(cells[x][y]);

            SwingUtilities.invokeLater(() -> {
                for (int y = 0; y < BOARD_HEIGHT; y++) {
                    for (int x = 0; x < BOARD_WIDTH; x++) {
                        buttons[x][y].setSelected(cells[x][y]);
                        if (alive.isSelected()) {
                            if (cells[x][y]) {
                                Color color1 = buttons[x][y].getBackground();
                                if (color1.equals(Color.BLACK)) {
                                    buttons[x][y].setBackground(Color.WHITE);
                                } else {
                                    buttons[x][y].setBackground(new Color(color1.getRed() - 15, color1.getBlue() - 15, color1.getGreen() - 15));
                                }
                            }
                        } else if (dead.isSelected()) {
                            if (!cells[x][y]) {

                                Color color1 = buttons[x][y].getBackground();
                                if (color1.equals(Color.BLACK)) {
                                    buttons[x][y].setBackground(Color.WHITE);
                                } else {
                                    buttons[x][y].setBackground(new Color(color1.getRed() - 15, color1.getBlue() - 15, color1.getGreen() - 15));
                                }
                            }
                        }
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