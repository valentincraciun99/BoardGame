package view;

import model.Coordinates;
import services.Seated;
import services.enums.Turn;
import view.resources.BackgroundPanel;
import view.resources.OvalComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BoardView extends JFrame {
    BackgroundPanel backgroundPanel;


    public BoardView(String title, BackgroundPanel backgroundPanel) throws HeadlessException {
        super(title);
        this.backgroundPanel = backgroundPanel;
        Initialization();
    }

    private void Initialization() {
        setContentPane(backgroundPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 740);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

        /*JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new OvalComponent());
        panel.setBounds(100,100,300,230);
        panel.setVisible(true);

        add(panel);*/

    }
}
