import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;

public class Reversi extends JPanel{
    public int [][] field = new int[6][6];
    public int fieldSize = 6;
    public JPanel panel = new JPanel();
    public int turn = 2;
    public int fontX = 10;
    public int fontY = 375;
    //public int

    public Reversi(){
        JFrame frame = new JFrame();
        frame.setTitle("My Game");
        frame.setLocationRelativeTo(null);
        frame.setLocation(450,150);
        panel.setPreferredSize(new Dimension(361,385));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.getContentPane().setBackground(new Color(133,165,226));

        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("");
        JMenuItem newgame = new JMenuItem("");
        JMenu gamesize = new JMenu("Game Size");
        JMenuItem x6 = new JMenuItem("6x6");
        JMenuItem x8 = new JMenuItem("8x8");
        JMenuItem x10 = new JMenuItem("10x10");
        JMenuItem x12 = new JMenuItem("12x12");
        menuBar.add(gamesize);
        gamesize.add(x6);
        gamesize.add(x8);
        gamesize.add(x10);
        gamesize.add(x12);

        newgame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                field = new int[fieldSize][fieldSize];
                turn = 2;
                panel.repaint();
            }
        });

        x6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fieldSize = 6;
                fontX = 10;
                fontY = 375;
                frame.setLocation(450,150);
                frame.setSize(367,437);
                frame.setPreferredSize(new Dimension(361,385));
                field = new int[6][6];
                turn = 2;
                panel.repaint();
            }
        });

        x8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fieldSize = 8;
                fontX = 10;
                fontY = 498;
                frame.setLocation(390, 80);
                frame.setPreferredSize(new Dimension(500, 505));
                frame.setSize(500, 557);
                field = new int[8][8];
                turn = 2;
                //start();
                //count();
                panel.repaint();
            }

        });

        x10.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fieldSize = 10;
                fontX = 10;
                fontY = 617;
                frame.setLocation(330, 30);
                frame.setSize(637, 677);
                frame.setPreferredSize(new Dimension(631, 625));
                field = new int[10][10];
                turn = 2;
                //start();
                //count();
                panel.repaint();
            }

        });

        x12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fieldSize = 12;
                fontX = 10;
                fontY = 835;
                frame.setLocation(270, -0);
                frame.setSize(741, 800);
                frame.setPreferredSize(new Dimension(741, 800));
                field = new int[12][12];
                turn = 2;
                //start();
                //count();
                panel.repaint();
            }

        });



        panel = new JPanel(){
            @Override
            public void paint(Graphics g) {
                super.paint(g);
                for(int i = 0; i < fieldSize; i++){
                    for(int j = 0; j < fieldSize; j++){
                        g.setColor(Color.ORANGE);
                        g.fillRect(j*60, i*60, 60,60 );
                        g.setColor(Color.black);
                        g.drawRect(j*60, i*60, 60,60);
                    }
                }
            }

            @Override
            public Dimension getPreferredSize(){
                if (fieldSize == 6){
                    return new Dimension(361,385);
                }else if(fieldSize == 8){
                    return new Dimension(500, 505);
                }else if(fieldSize == 10) {
                    return new Dimension(631,625);
                }
                else {
                    return new Dimension(741,800);
                }
            }
        };

        frame.add(panel);
        frame.setJMenuBar(menuBar);
        frame.pack();
        frame.setVisible(true);

    }
    public static void main(String[] args) {
        //start();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Reversi();
            }
        });
    }

}




