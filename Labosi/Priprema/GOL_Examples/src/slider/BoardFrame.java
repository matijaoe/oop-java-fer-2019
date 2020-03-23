package slider;



import javax.swing.*;
import java.awt.*;

// MENI SVE ZABLOKIRA

//dobila sam 9/10 jer mi je asistent rekao da dodam pomocnu varijablu pokazValue

public class BoardFrame extends JFrame {
    private static final int MIN = 50;
    private static final int MAX = 500;
    private static final int INIT_VALUE = 300;
    private static final int BOARD_HEIGHT = 30;
    private static final int BOARD_WIDTH = 30;
    private JButton btnPlay, btnStop, btnTick;
    private JToggleButton buttons[][];
    private Board board;
    private SimulationWorker simulationWorker;
    private JSlider pokaz;   //varijable koje sam dodala
    private JLabel pokazVrijeme;
    public int pokazValue;

    public BoardFrame() {
        JPanel buttonPanel = new JPanel();


        btnPlay = new JButton("Pokreni");
        buttonPanel.add(btnPlay);
        btnPlay.addActionListener((e) -> {                                      //u principu prekopiran kod iz simulationa
            simulationWorker = new SimulationWorker(board);
            btnStop.setEnabled(true);
            while (true) {
                board.playOneIteration();
                try {
                    Thread.sleep(pokazValue);
                } catch (InterruptedException f) {
                    btnPlay.setEnabled(true);
                    btnTick.setEnabled(true);
                    btnStop.setEnabled(true);
                    f.printStackTrace();
                    break;
                }
                simulationWorker.execute();
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

        JSlider pokaz = new JSlider(SwingConstants.HORIZONTAL, MIN, MAX, INIT_VALUE);   //konstruktor za jslider
        buttonPanel.add(pokaz);

        JLabel pokazVrijeme = new JLabel();

        pokaz.addChangeListener((e) -> {                     //aktiviranje jslidera
            pokazValue = pokaz.getValue();
            pokazVrijeme.setText(String.valueOf(pokazValue) + "ms");
        });


        pokazVrijeme.setPreferredSize(new Dimension (40, 20));      //konstruktor za text u kojem piše na koje vrijeme je namještena pauza
        pokazVrijeme.setText(String.valueOf(pokaz.getValue()));

        buttonPanel.add(pokazVrijeme);


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

    public int getPokaz() {  //ovo je bilo nepotrebno al sam imala problema sa pokaz.getValue() pa sam kombala
        return (int)pokaz.getValue();
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