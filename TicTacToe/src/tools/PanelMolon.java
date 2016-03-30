package tools;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class PanelMolon extends JPanel {

    private Image img;
    private String ruta;

    public PanelMolon(String ruta) {
        super();
        this.ruta = ruta;
        try {
            img = ImageIO.read(new File(this.ruta));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(img, 0, 0, null);           
    }

}
