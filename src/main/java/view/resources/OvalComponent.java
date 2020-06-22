package view.resources;

import model.Coordinates;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class OvalComponent extends JLabel {
    public String name;
    Coordinates coordinates;

    public OvalComponent(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.fillOval(0, 0, 50, 50);
    }



}
