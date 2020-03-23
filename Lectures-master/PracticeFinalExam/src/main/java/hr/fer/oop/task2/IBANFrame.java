package hr.fer.oop.task2;

import javax.swing.*;
import java.awt.*;
import org.apache.commons.validator.routines.checkdigit.IBANCheckDigit;

public class IBANFrame extends JFrame {

    private JTextField tfIBAN;
    private JTextField tfValidan;
    private JButton validButton;

    public IBANFrame() {

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
            IBANWorker worker = new IBANWorker(tfIBAN.getText());
            validButton.setEnabled(false);
            worker.execute();
        });


    }



    private class IBANWorker extends SwingWorker<Void, Void> {

        String enteredIBAN;

        public IBANWorker(String enteredIBAN) {
            this.enteredIBAN = enteredIBAN;
        }

        @Override
        protected Void doInBackground() throws Exception {
            enteredIBAN = tfIBAN.getText();

        IBANCheckDigit checker = new IBANCheckDigit();
        if (checker.isValid(enteredIBAN)) {
            validButton.setText("DA");
        } else {
            validButton.setText("NE");
        }

            return null;
        }
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            IBANFrame validator = new IBANFrame();
        });
    }
}
