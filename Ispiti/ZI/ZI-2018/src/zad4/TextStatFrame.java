package zad4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import java.util.stream.Collectors;

public class TextStatFrame extends JFrame {

    private JTextArea textArea = new JTextArea();
    private JButton statsBtn = new JButton("Statistics");
    private JButton freqBtn = new JButton("Show frequencies");
    private JTextArea resultArea = new JTextArea();

    public TextStatFrame(String title) {
        setLayout(new BorderLayout());
        setTitle("Text Stat");

        resultArea.setEditable(false);

        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);

        JScrollPane textScroll = new JScrollPane(textArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        JScrollPane resultScroll = new JScrollPane(resultArea,
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        splitPane.setPreferredSize(new Dimension(400, 200));
        splitPane.setLeftComponent(textScroll);
        splitPane.setRightComponent(resultScroll);
        add(splitPane, BorderLayout.CENTER);


        JPanel btnPanel = new JPanel();
        btnPanel.setLayout(new FlowLayout());
        btnPanel.add(statsBtn);
        btnPanel.add(freqBtn);
        add(btnPanel, BorderLayout.SOUTH);


        statsBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                statsBtn.setEnabled(false);
                freqBtn.setEnabled(false);

                resultArea.setText("");

                String[] arrayWords = getWords(textArea.getText());
                resultArea.setText("No of words: " + arrayWords.length + "\n");

                List<String> filteredWords = getFilteredWords(arrayWords, 6);
                for (String word : filteredWords) {
                    resultArea.append("\n" + word);
                }

                statsBtn.setEnabled(true);
                freqBtn.setEnabled(true);
            }
        });

        freqBtn.addActionListener(e -> {
            statsBtn.setEnabled(false);
            freqBtn.setEnabled(false);

            SwingWorker worker = new SwingWorker() {
                @Override
                protected Void doInBackground() throws Exception {
                    resultArea.setText("");

                    String[] arrayText = getWords(textArea.getText());

                    for (Map.Entry<String, Integer> entry : getFrequencies(arrayText).entrySet()) {
                        resultArea.append(entry.getKey() + " " + entry.getValue() + "\n");
                    }

                    return null;
                }

                @Override
                protected void done() {
                    statsBtn.setEnabled(true);
                    freqBtn.setEnabled(true);
                }
            };

            worker.execute();


//            resultArea.setText("");
//
//            String[] arrayText = getWords(textArea.getText());
//
//            for (Map.Entry<String, Integer> entry : getFrequencies(arrayText).entrySet()) {
//                resultArea.append(entry.getKey() + " " + entry.getValue() + "\n");
//            }
//
//            statsBtn.setEnabled(true);
//            freqBtn.setEnabled(true);
        });
    }




    private List<String> getFilteredWords(String[] words, int noOfCharacters) {
        List<String> wordList = Arrays.asList(words);
        return wordList.stream().
                filter(w -> w.length() >= noOfCharacters).
                sorted(Comparator.comparing(String::length)).
                collect(Collectors.toList());
    }

    private String[] getWords(String text) {
        return text.split("[^a-zA-Z]+");
    }

    Map<String, Integer> getFrequencies(String[] words) {
        Map<String, Integer> frequencies = new TreeMap<>();
        for (String w : words) {
            w = w.toLowerCase();
            Integer n = frequencies.get(w);
            n = (n == null) ? 1 : ++n;
            frequencies.put(w, n);
        }
        return frequencies;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new TextStatFrame("Text Stat");
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
