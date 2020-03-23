package zad2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    JTextField number = new JTextField();
    JTextField currentCall = new JTextField("0");
    JTextField lastCall = new JTextField("0.00");
    CallWorker call;

    public MainFrame() {
        currentCall.setPreferredSize(new Dimension(50, 50));
        lastCall.setPreferredSize(new Dimension(50, 50));
        add(number, BorderLayout.NORTH);
        add(currentCall, BorderLayout.WEST);
        add(lastCall, BorderLayout.EAST);
//TODO 1: Dodaj gumbe tipkovnice + gumb C i pridruži im događaje iz metoda
// getListener i getDeleteListener
        JPanel bottom = new JPanel();
        add(bottom, BorderLayout.SOUTH);
        JButton btnCall = new JButton("Call");
        JButton endCall = new JButton("End");
        endCall.setEnabled(false);
        bottom.add(btnCall);
        bottom.add(endCall);
        btnCall.addActionListener(e -> {
            btnCall.setEnabled(false);
            currentCall.setText("0");
            call = new CallWorker((i) -> currentCall.setText(Integer.toString(i)));
            call.execute();
            endCall.setEnabled(true);
        });
        endCall.addActionListener(e -> {
            endCall.setEnabled(false);
            call.endCall();
            Double time = null;
            try {
                time = call.get();
            } catch (Exception e1) {
            }
            currentCall.setText("0");
            lastCall.setText(Double.toString(time));
            btnCall.setEnabled(true);
        });
    }

    private ActionListener getListener() {
    //TODO 2: Klikom na gumb na tipkovnici broj pridružen gumbu
    //treba dopisati u tekstno polje za prikaz ukucanog broja telefon
    }

    private ActionListener getDeleteListener() {
        return (e) -> {
            String text = number.getText();
            if (text.length() > 0)
                number.setText(text.substring(0, text.length() - 1));
        };
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame frame = new MainFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
                frame.setTitle("Telefon");
                frame.setBounds(200, 200, 300, 300);
                frame.setVisible(true);
            }
        });
    }
}
