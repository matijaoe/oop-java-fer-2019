package hr.fer.oop.task2;

import javax.swing.*;
import java.awt.*;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;

public class IBANFramew extends JFrame {

    private JTextField tfIBAN;
    private JTextField tfValidan;
    private JButton validButton;

    public IBANFramew() {

        setLayout(new GridLayout(3,2));

        add(new JLabel("IBAN:"));
        tfIBAN = new JTextField("HR", 21);
        add(tfIBAN);
        tfIBAN.setEditable(true);

        add(new JLabel("Validan:"));
        tfValidan = new JTextField(21);
        add(tfValidan);
        tfValidan.setEditable(false);

        add(new JLabel());
        validButton = new JButton("Validiraj");
        add(validButton);
        validButton.addActionListener(e -> {
            validButton.setEnabled(false);
            IBANWorker worker = new IBANWorker(tfIBAN.getText());
            worker.execute();

        });

    }



    private class IBANWorker extends SwingWorker<Boolean, Void> {

        String enteredIBAN;

        public IBANWorker(String enteredIBAN) {
            this.enteredIBAN = enteredIBAN;
        }

        @Override
        protected Boolean doInBackground() throws Exception {
            enteredIBAN = tfIBAN.getText();

            IBANCheckDigit checker = new IBANCheckDigit();
            boolean valid = false;
            try {
                valid = checker.isValid(enteredIBAN);
            } catch (Exception ex) {
                ex.getMessage();
            }
            if (valid) {
                tfValidan.setText("DA");
            } else {
                tfValidan.setText("NE");
            }


            return valid;
        }

        @Override
        protected void done() {
            validButton.setEnabled(true);
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new IBANFramew();
            frame.setLocation(200, 200);
            frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
