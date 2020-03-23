import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
                    MyFrame frame = new MyFrame();
                    //frame.pack();
                    frame.setVisible(true);
                }

        );
    }

    public MyFrame() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);

        setLayout(new SpringLayout());

        // row 0
        add(new JLabel("Ime:", SwingConstants.RIGHT));

        JTextField tfFirstName = new JTextField();
        tfFirstName.setColumns(10);
        add(tfFirstName);

        // row 1
        add(new JLabel("Prezime:", SwingConstants.RIGHT));

        JTextField tfLastName = new JTextField();
        tfLastName.setColumns(10);
        add(tfLastName);


    }


}
