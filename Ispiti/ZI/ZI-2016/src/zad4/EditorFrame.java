package zad4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditorFrame extends JFrame {

    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JButton calcButton;

    public EditorFrame() {

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(480, 400));
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        add(scrollPane, BorderLayout.CENTER);

        calcButton = new JButton("Izračunaj statistiku");
        add(calcButton, BorderLayout.SOUTH);
        calcButton.addActionListener(new MyActionListener(textArea));



    }

    private class MyActionListener implements ActionListener {

        JTextArea textArea;

        public MyActionListener(JTextArea textArea) {
            this.textArea = textArea;
        }

        public int wordCount(String text) {
            if (text.equals("")) return 0;
            return text.split("\\s+").length;
        }

        public int characterCount(String text, boolean withSpaces) {
            int count = 0;
            if (withSpaces) {
                count = text.length();
            } else {
                String withoutSpaces = text.replaceAll("\\s+", "");
                count = withoutSpaces.length();
            }
            return count;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            String output = null;
            JOptionPane.showMessageDialog(null,
                    "Broj riječi: " + wordCount(textArea.getText()) +
                    "\nBroj znakova (bez razmaka): " + characterCount(textArea.getText(), false) +
                    "\nBroj znakova (s razmakom): " + characterCount(textArea.getText(), true),
                    "Statistika", JOptionPane.PLAIN_MESSAGE);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new EditorFrame();
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.setTitle("Simple Text Editor");
            frame.setLocation(200, 200);
            frame.pack();
            frame.setVisible(true);

        });
    }
}
