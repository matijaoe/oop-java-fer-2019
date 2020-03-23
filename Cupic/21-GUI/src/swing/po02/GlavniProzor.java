package swing.po02;

import javax.swing.*;
import java.awt.*;

public class GlavniProzor extends JFrame {

    public GlavniProzor() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(20, 50);
        setSize(300, 200);
        setTitle("Moj prvi prozor");
        initGUI();
    }

    public void initGUI() {
        //TODO
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
//            GlavniProzor prozor = new GlavniProzor();
//            prozor.setVisible(true);
            new GlavniProzor().setVisible(true);
        });
    }
}
