import controller.BoardController;
import services.Seated;
import view.BoardView;
import view.resources.BackgroundPanel;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        BufferedImage backgroundImage = null;
        try {
            File file = new File(
                    Main.class.getClassLoader().getResource("tintar.jpg").getFile()
            );
            backgroundImage = ImageIO.read(file);
            new BoardController(new BoardView("Tintar",new BackgroundPanel(backgroundImage)),new Seated());
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error!");

            e.printStackTrace();
        }

    }
}