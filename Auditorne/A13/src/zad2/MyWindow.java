package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MyWindow extends JFrame {
    private ButtonGroup vertical;
    private ButtonGroup horizontal;
    private JTextField text = new JTextField("");

    public MyWindow() {
        text.setEditable(false);
        text.setFont(new Font("Courier", Font.BOLD, 200));
        text.setHorizontalAlignment(JTextField.CENTER);
        add(text, BorderLayout.CENTER);

        JPanel north = new JPanel();
        JPanel south = new JPanel();
        JPanel east = new JPanel();
        JPanel west = new JPanel();

        east.setLayout(new BoxLayout(east, BoxLayout.Y_AXIS));
        west.setLayout(new BoxLayout(west, BoxLayout.Y_AXIS));

        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(east, BorderLayout.EAST);
        add(west, BorderLayout.WEST);

        vertical = new ButtonGroup();
        horizontal = new ButtonGroup();

        for (int i = 0; i < 10; i++) {
            String value = Integer.toString(i + 1);
            JToggleButton btnUp = new JToggleButton(value);
            JToggleButton btnDn = new JToggleButton(value);
            JToggleButton btnLf = new JToggleButton(value);
            JToggleButton btnRt = new JToggleButton(value);
            btnUp.setActionCommand(value);
            btnDn.setActionCommand(value);
            btnLf.setActionCommand(value);
            btnRt.setActionCommand(value);
            btnDn.setModel(btnUp.getModel());
            btnRt.setModel(btnLf.getModel());

            btnUp.addActionListener(getAction());
            btnRt.addActionListener(getAction());

            north.add(btnUp);
            south.add(btnDn);
            east.add(btnRt);
            west.add(btnLf);

            vertical.add(btnRt);
            horizontal.add(btnUp);
        }
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private ActionListener getAction() {
        return e -> {
            ButtonModel vert = vertical.getSelection();
            ButtonModel hor = horizontal.getSelection();

            if (vert != null && hor != null) {
                int a = Integer.parseInt(vert.getActionCommand());
                int b = Integer.parseInt(hor.getActionCommand());
                text.setText(Integer.toString(a * b));
            } else
                text.setText("");
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MyWindow());
    }
}
