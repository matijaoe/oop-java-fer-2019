package count_log;



import javax.swing.*;
import java.awt.*;
import java.util.LinkedList;

public class BoardFrame extends JFrame {

    private Board board;
    private JToggleButton[][] buttons;
    private Start start;
    private JRadioButton countStates;
    private JRadioButton log;
    private JRadioButton cntAlive;
    private JRadioButton cntDead;
    private JFrame logFrame = new JFrame();
    private List<Point> dTa = new LinkedList<>();
    private List<Point> aTd = new LinkedList<>();

    public BoardFrame() {


        logFrame.setBounds(100, 100, 700, 150);
        logFrame.setLayout(new BorderLayout());

        ScrollPane logScrollPane = new ScrollPane();
        JTextArea logArea = new JTextArea();
        logArea.setEditable(false);
        logScrollPane.add(logArea);
        logFrame.add(logScrollPane);


        board = new Board(30, 30);
        buttons = new JToggleButton[board.getWidth()][board.getHeight()];
        board.addListener(l -> {

            for (int i = 0; i < board.getWidth(); i++) {
                for (int j = 0; j < board.getHeight(); j++) {
                    if (board.isCellAlive(i, j)) {
                        buttons[i][j].setSelected(true);
                        if (countStates.isSelected()) {
                            if (cntAlive.isSelected()) {
                                buttons[i][j].setText(Integer.toString(board.getCounterAlive(i, j)));
                            } else if (cntDead.isSelected()) {
                                buttons[i][j].setText(Integer.toString(board.getCounterDead(i, j)));
                            }
                        }
                    } else {
                        buttons[i][j].setSelected(false);
                    }
                }
            }
            if (log.isSelected()) {
                logFrame.setVisible(true);
            } else {
                logFrame.setVisible(false);
            }
            if (log.isSelected()) {
                dTa = board.deadToAlive();
                aTd = board.aliveToDead();

                for (Point cell : dTa) {
                    logArea.append("(" + cell.x + "," + cell.y + ") - 0 -> 1\n");
                }
                for (Point cell : aTd) {
                    logArea.append("(" + cell.x + "," + cell.y + ") - 1 -> 0\n");
                }
            }
        });

        setSize(600, 600);
        setTitle("Game of LYF3");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        JPanel playingField = new JPanel();
        playingField.setLayout(new GridLayout(board.getHeight(), board.getHeight(), 1, 1));

        for (int i = 0; i < board.getWidth(); i++) {
            for (int j = 0; j < board.getHeight(); j++) {
                int x = i;
                int y = j;
                JToggleButton btn = new JToggleButton();
                buttons[x][y] = btn;
                btn.addActionListener(e -> board.setCell(x, y, buttons[x][y].isSelected()));
                playingField.add(btn);
            }

        }

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnStart = new JButton("Pokreni");
        JButton btnStop = new JButton("Zaustavi");
        JButton btnIteration = new JButton("Jedna iteracija");

        btnStart.setEnabled(true);
        btnStop.setEnabled(false);
        btnIteration.setEnabled(true);

        btnStart.addActionListener(e -> {
            btnStop.setEnabled(true);
            btnIteration.setEnabled(false);
            btnStart.setEnabled(false);

            start = new Start();
            Thread t = new Thread(start);
            t.start();

        });

        btnStop.addActionListener(e -> {
            btnStop.setEnabled(false);
            btnIteration.setEnabled(true);
            btnStart.setEnabled(true);

            start.sigTerm();
        });

        JButton option = new JButton("Option");
        countStates = new JRadioButton("Count States");
        log = new JRadioButton("Log");
        JFrame optionFrame = new JFrame();
        optionFrame.setBounds(100, 100, 500, 100);
        optionFrame.setLayout(new GridLayout(0, 2));

        option.addActionListener(e -> {
            if (optionFrame.isVisible()) {
                optionFrame.setVisible(false);
            } else {
                optionFrame.setVisible(true);
            }
        });

        cntAlive = new JRadioButton("Alive");
        cntDead = new JRadioButton("Dead");
        ButtonGroup cntGroup = new ButtonGroup();
        cntGroup.add(cntAlive);
        cntGroup.add(cntDead);


        JPanel countPanel = new JPanel();
        countPanel.setBorder(BorderFactory.createTitledBorder("What to count"));
        countPanel.setLayout(new GridLayout(0, 1));
        countPanel.add(cntAlive);
        countPanel.add(cntDead);

        optionFrame.add(countStates);
        optionFrame.add(countPanel);
        optionFrame.add(log);


//        btnStop.addActionListener();

        btnIteration.addActionListener(e -> board.playOneIteration());

        buttonsPanel.add(btnStart);
        buttonsPanel.add(btnStop);
        buttonsPanel.add(btnIteration);
        buttonsPanel.add(option);

        cp.add(playingField, BorderLayout.CENTER);
        cp.add(buttonsPanel, BorderLayout.NORTH);
    }
}
