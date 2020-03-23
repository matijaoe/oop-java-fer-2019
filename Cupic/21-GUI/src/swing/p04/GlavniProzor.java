package swing.p04;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.Border;

public class GlavniProzor extends JFrame {
    private static final long serialVersionUID = 1L;

    public GlavniProzor() {
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setLocation(20, 50);
        setSize(300, 200);
        setTitle("Moj prvi prozor!");
        initGUI();
    }

    private void initGUI() {
    // kod za inicijalizaciju komponenti koje prozor prikazuje
    // ...
        Container cp = getContentPane();
        cp.setLayout(null);
        Poruka poruka = new Poruka();
        poruka.setBounds(0, 0, 100, 100);
        poruka.setBorder(new PuniObrub(1, Color.RED));
        cp.add(poruka);
    }

    private static class Poruka extends JComponent {
        private static final long serialVersionUID = 1L;
    }

    private static class PuniObrub implements Border {
        private int debljina;
        private Color boja;

        public PuniObrub(int debljina, Color boja) {
            super();
            this.debljina = debljina;
            this.boja = boja;
        }

        @Override
        public boolean isBorderOpaque() {
            return false;
        }

        @Override
        public Insets getBorderInsets(Component c) {
            return new Insets(debljina, debljina, debljina, debljina);
        }

        @Override
        public void paintBorder(Component c, Graphics g,
                                int x, int y, int width, int height) {
            g.setColor(boja);
            g.fillRect(0, 0, width, debljina);
            g.fillRect(0, height - debljina, width, debljina);
            g.fillRect(0, debljina, debljina, height - 2 * debljina);
            g.fillRect(width - debljina, debljina,
                    debljina, height - 2 * debljina);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new GlavniProzor().setVisible(true);
        });
    }
}
