package controller;

import view.BoardView;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BoardController {
    BoardView boardView;

    public BoardController(BoardView boardView) {
        this.boardView = boardView;

    }

    void drawCircleByCenter (int x, int y, int radius){
        //g.setColor(Color.LIGHT_GRAY);
        Graphics g = this.boardView.getGraphics();
        g.setColor(Color.BLUE);
        Graphics2D g2d = (Graphics2D)g;
        // Assume x, y, and diameter are instance variables.
        Ellipse2D.Double circle = new Ellipse2D.Double(x, y, radius, radius);
        g2d.fill(circle);
    }
}
