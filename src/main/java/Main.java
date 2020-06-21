import controller.BoardController;
import view.BoardView;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        BufferedImage myImage = null;
        try {
            myImage = ImageIO.read(new File("C:\\Users\\Valentin\\Desktop\\tintar.jpg"));
            new BoardController(new BoardView("Tintar",myImage));
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Error!");
            e.printStackTrace();
        }

    }
}