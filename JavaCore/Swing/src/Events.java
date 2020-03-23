import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Events implements ActionListener {

    private static JFrame frame;

    public static void main(String[] args) {

        frame = new JFrame("JTextField events");
        frame.setLayout(new FlowLayout());

        JTextField field1 = new JTextField(10);
        field1.addActionListener(new Events());
        frame.add(new JLabel("Field with no action command set"));
        frame.add(field1);

        JTextField field2 = new JTextField(10);
        field2.addActionListener(new Events());
        field2.setActionCommand("my action command");
        frame.add(new JLabel("Field with an action command set"));
        frame.add(field2);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(220, 150);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String cmd = evt.getActionCommand();
        JOptionPane.showMessageDialog(frame, "Command: " + cmd);
    }

}