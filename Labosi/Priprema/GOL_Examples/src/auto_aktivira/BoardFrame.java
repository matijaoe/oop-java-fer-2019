package auto_aktivira;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Point;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;

/*
- dodati na dnu gumb koji sve dijagonalne ćelije aktivira (x=y)
- dodati na dnu gumb koji sve rubne ćelije aktivira (x=0 || y=0 || visina-1 || sirina-1)
- dodati na vrh JTextField u koji se upisuje broj sekundi izvođenja programa
- dodati na dnu dva JTextField-a , za x i y koordinatu, i gumb koji aktivira ćeliju sa
  tim određenim koordinatama, ukoliko su koordinate krivo unesene ispisati u pop-up prozoru pogrešku
 */

public class BoardFrame extends JFrame {
    private static final int BOARD_HEIGHT = 30;
    private static final int BOARD_WIDTH = 30;
    private JLabel secIterLabel;
    private JTextField secIterField, xCordField, yCordField;
    private JButton btnPlay, btnStop, btnTick, btnDiagAlive, btnBoarderAlive, btnCord;
    private JToggleButton buttons[][];
    private Board board;
    private SimulationWorker simulationWorker;

    public BoardFrame() {
        JPanel buttonPanel = new JPanel();

        board = new Board(BOARD_WIDTH, BOARD_HEIGHT);
        buttons = new JToggleButton[BOARD_WIDTH][BOARD_HEIGHT];

        secIterLabel = new JLabel("Broj sekundi izeđu iteracija");
        secIterField = new JTextField(5);
        buttonPanel.add(secIterLabel);
        buttonPanel.add(secIterField);

        btnPlay = new JButton("Pokreni");
        buttonPanel.add(btnPlay);
        btnPlay.addActionListener((e) -> {
            try {
                int sec = Integer.parseInt(secIterField.getText());
                if(sec < 1) {
                    JOptionPane.showMessageDialog(getContentPane(), "Neispravno unesen broj sekundi između iteracija");
                }
                else {
                    simulationWorker = new SimulationWorker(board, sec);
                    btnPlay.setEnabled(false);
                    btnStop.setEnabled(true);
                    btnTick.setEnabled(false);
                    simulationWorker.execute();
                }
            } catch (NumberFormatException exc) {
                JOptionPane.showMessageDialog(getContentPane(), "Neispravno unesen broj sekundi između iteracija");
            }
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

        JPanel bottomPanel = new JPanel();
        btnDiagAlive = new JButton("Oživi dijagonalu");
        btnDiagAlive.addActionListener((e) -> {
            board.diagAlive();
            for(int i = 0; i < BOARD_WIDTH; i++) {
                buttons[i][i].setSelected(true);
            }
        });

        btnBoarderAlive = new JButton("Oživi rubne");

        btnBoarderAlive.addActionListener((e) -> {
            board.borderAlive();
            for(int i = 0; i < BOARD_WIDTH; i++) {
                buttons[i][0].setSelected(true);
                buttons[i][BOARD_HEIGHT-1].setSelected(true);
                buttons[0][i].setSelected(true);
                buttons[BOARD_WIDTH-1][i].setSelected(true);
            }
        });

        xCordField = new JTextField(2);
        yCordField = new JTextField(2);
        btnCord = new JButton("Oživi polje");
        btnCord.addActionListener((e) -> {
            try {
                int y = Integer.parseInt(xCordField.getText());
                int x = Integer.parseInt(yCordField.getText());
                if(x < 1 || y < 1 || x > BOARD_WIDTH || y > BOARD_HEIGHT)
                    JOptionPane.showMessageDialog(getContentPane(), "Neispravno unesene koordinate");
                else {
                    board.setCell(x-1, y-1, true);
                    buttons[x-1][y-1].setSelected(true);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(getContentPane(), "Neispravno unesene koordinate");
            }
            xCordField.setText("");
            yCordField.setText("");
        });

        bottomPanel.add(btnDiagAlive);
        bottomPanel.add(btnBoarderAlive);
        bottomPanel.add(xCordField);
        bottomPanel.add(yCordField);
        bottomPanel.add(btnCord);
        add(bottomPanel, BorderLayout.SOUTH);

        initializeButonsAndBoard();
    }

    private void initializeButonsAndBoard() {
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