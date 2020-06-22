package controller;

import controller.enums.GameState;
import model.Coordinates;
import services.Seated;
import services.enums.Turn;
import view.BoardView;
import view.resources.OvalComponent;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class BoardController {
    BoardView boardView;
    Seated seated;
    GameState gameState = GameState.selectPiece;
    OvalComponent selectedPiece;

    public BoardController(BoardView boardView,Seated seated) {
        this.boardView = boardView;
        this.seated = seated;

        ArrayList<Integer> x= new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<>();
        ArrayList<Integer> cl = new ArrayList<>();
        ArrayList<Integer> cc =  new ArrayList<>();


        //matrix coordinates
        //BIG square Coordinates
        cl.add(1); cc.add(1);
        cl.add(1); cc.add(4);
        cl.add(1); cc.add(7);
        cl.add(4); cc.add(7);
        cl.add(7); cc.add(7);
        cl.add(7); cc.add(4);
        cl.add(7); cc.add(1);
        cl.add(4); cc.add(1);

        //MEDIUM square Coordinates
        cl.add(2); cc.add(2);
        cl.add(2); cc.add(4);
        cl.add(2); cc.add(6);
        cl.add(4); cc.add(6);
        cl.add(6); cc.add(6);
        cl.add(6); cc.add(4);
        cl.add(6); cc.add(2);
        cl.add(4); cc.add(2);

        //LITTLE square Coordinates
        cl.add(3); cc.add(3);
        cl.add(3); cc.add(4);
        cl.add(3); cc.add(5);
        cl.add(4); cc.add(5);
        cl.add(5); cc.add(5);
        cl.add(5); cc.add(4);
        cl.add(5); cc.add(3);
        cl.add(4); cc.add(3);



        //Design Coordinates
        //BIG square Coordinates
        x.add(60); y.add(50);
        x.add(380); y.add(50);
        x.add(685); y.add(50);
        x.add(685); y.add(325);
        x.add(685); y.add(600);
        x.add(380); y.add(600);
        x.add(60); y.add(600);
        x.add(60); y.add(325);

        //MEDIUM square Coordinates
        x.add(158); y.add(135);
        x.add(380); y.add(135);
        x.add(597); y.add(132);
        x.add(601); y.add(315);
        x.add(595); y.add(529);
        x.add(380); y.add(530);
        x.add(157); y.add(530);
        x.add(158); y.add(320);

        //LITTLE square Coordinates
        x.add(250); y.add(200);
        x.add(380); y.add(200);
        x.add(515); y.add(200);
        x.add(515); y.add(320);
        x.add(515); y.add(470);
        x.add(380); y.add(470);
        x.add(250); y.add(470);
        x.add(250); y.add(320);





        for (int i = 0; i < 24; i++) {

            OvalComponent ovalComponent = new OvalComponent("ndasd" + i,new Coordinates(cl.get(i),cc.get(i),20,20));
            ovalComponent.setBounds(x.get(i), y.get(i), 50, 50);
            ovalComponent.setVisible(true);
            ovalComponent.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    var component = e.getSource();
                    if (component instanceof OvalComponent) {
                        if(seated.putPiece(((OvalComponent) component).getCoordinates())==true)
                        {
                            Graphics g = ((OvalComponent) component).getGraphics();
                            if(seated.getCurrentUser()== Turn.firstUser)
                            {
                                g.setColor(Color.RED);
                            }
                            else
                            {
                                g.setColor(Color.BLUE);
                            }

                            ((OvalComponent) component).paintComponent(g);
                        }
                        else
                        {
                            if(gameState==GameState.selectPiece)
                            {
                                selectedPiece = ((OvalComponent) component);
                                gameState = GameState.movePiece;
                            }
                            else if(gameState == GameState.movePiece)
                            {
                                if(seated.movePiece(new Coordinates(selectedPiece.getCoordinates().getX(),selectedPiece.getCoordinates().getY(),0,0),
                                                new Coordinates(((OvalComponent) component).getCoordinates().getX(),((OvalComponent) component).getCoordinates().getY(),0,0))) {
                                    Graphics g1 =  selectedPiece.getGraphics();
                                    g1.setColor(Color.BLACK);
                                    selectedPiece.paintComponent(g1);

                                    Graphics g2= ((OvalComponent) component).getGraphics();
                                    if (seated.getCurrentUser() == Turn.firstUser)
                                        g2.setColor(Color.RED);
                                    else
                                        g2.setColor(Color.BLUE);

                                    ((OvalComponent) component).paintComponent(g2);


                                }
                                gameState = GameState.selectPiece;

                            }
                        }


                    }
                }
            });
            boardView.add(ovalComponent);

        }
      //  boardView.repaint();


    }


}
