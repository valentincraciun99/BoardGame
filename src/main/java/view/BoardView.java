package view;

import view.resources.BackgroundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class BoardView extends JFrame {
    BufferedImage backgroundImage;

    public BoardView(String title, BufferedImage backgroundImage) throws HeadlessException {
        super(title);
        this.backgroundImage = backgroundImage;
        Initialization();
    }

    private void Initialization() {
        setContentPane(new BackgroundPanel(backgroundImage));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 740);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }
}
