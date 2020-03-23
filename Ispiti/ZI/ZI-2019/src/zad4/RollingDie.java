package zad4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RollingDie extends JFrame {

    // 1
    private JLabel textLbl = new JLabel("Broj bacanja kocke:");
    private JTextField numberOfRollsTf = new JTextField(10);
    private JLabel[] dieValues = new JLabel[6];
    private JLabel[] occurrences = new JLabel[6];
    private JButton startBtn = new JButton("Start");
    private JPanel inputPnl = new JPanel();
    private JPanel centralPnl =
            new JPanel();
    private JPanel buttonPnl = new JPanel();


    // 2
    public RollingDie() {
        inputPnl.add(textLbl);
        inputPnl.add(numberOfRollsTf);

        centralPnl.setLayout(new GridLayout(6, 2));
        for (int i = 0; i < 6; i++) {
            centralPnl.add(dieValues[i] = new JLabel("[" + (i + 1) + "]"));
            centralPnl.add(occurrences[i] = new JLabel());

        }
        buttonPnl.add(startBtn);

        add(inputPnl, BorderLayout.NORTH);
        add(centralPnl, BorderLayout.CENTER);
        add(buttonPnl, BorderLayout.SOUTH);

        // 3
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int numberOfRolls = Integer.parseInt(numberOfRollsTf.getText());

                    // reset GUI
                    for (int i = 0; i < 6; i++) {
                        occurrences[i].setText("");
                    }
                    startBtn.setEnabled(false);

                    new SimulationTask(numberOfRolls).execute();
                } catch (Exception ex) {

                }
            }
        });

    }

    // 1
    private class SimulationTask extends SwingWorker<Double, Map<Integer, Integer>> {

        int numberOfRolls;
        Map<Integer, Integer> map = new HashMap<>();

        SimulationTask(int numberOfRolls) {
            this.numberOfRolls = numberOfRolls;
            for (int i = 0; i < 6; i++)
                map.put(i, 0);
        }

        // 4
        @Override
        protected Double doInBackground() throws Exception {
            Random random = new Random();
            for (int i = 0; i < numberOfRolls; i++) {
                Integer key = random.nextInt(6);
                map.put(key, map.get(key) + 1);

                publish(map);

            }

            return numberOfRolls / 6.;
        }

        @Override
        protected void process(List<Map<Integer, Integer>> distributions) {
            Map<Integer, Integer> d = distributions.get(distributions.size() - 1);

            for (Map.Entry<Integer, Integer> pair : d.entrySet()) {
                occurrences[pair.getKey()].setText(String.valueOf(pair.getValue()));
            }
        }

        @Override
        protected void done() {
            startBtn.setEnabled(true);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                RollingDie simulator = new RollingDie();
                simulator.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                simulator.pack();
                simulator.setVisible(true);
            }
        });
    }
}

