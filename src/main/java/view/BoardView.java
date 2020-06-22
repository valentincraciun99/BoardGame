package view;

import model.Coordinates;
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
        //BIG square Coordinates
        ArrayList<Integer> x= new ArrayList<Integer>();
        ArrayList<Integer> y = new ArrayList<>();
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

            OvalComponent ovalComponent = new OvalComponent("ndasd" + i,new Coordinates(20,20,20,20));
            ovalComponent.setBounds(x.get(i), y.get(i), 50, 50);
            ovalComponent.setVisible(true);
            ovalComponent.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    var z = e.getSource();
                    if (z instanceof OvalComponent) {
                        System.out.println(((OvalComponent) z).name);
                        Graphics g = ((OvalComponent) z).getGraphics();
                        g.setColor(Color.BLUE);
                        ((OvalComponent) z).paintComponent(g);
                    }
                }
            });
            add(ovalComponent);

        }
        repaint();

    }
}
