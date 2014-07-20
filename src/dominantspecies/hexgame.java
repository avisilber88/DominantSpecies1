///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dominantspecies;
//
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Font;
//import java.awt.Graphics;
//import java.awt.Graphics2D;
//import java.awt.Point;
//import java.awt.RenderingHints;
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.SwingUtilities;
//
///**
// *
// * @author DJ 4 Fathers
// */
//public class hexgame {
//
//    private hexgame() {
//        initGame();
//        createAndShowGUI();
//    }
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                new hexgame();
//            }
//        });
//    }
//
//    //constants and global variables
//    final static Color COLOURBACK = Color.WHITE;
//    final static Color COLOURCELL = Color.ORANGE;
//    final static Color COLOURGRID = Color.BLACK;
//    final static Color COLOURONE = new Color(255, 255, 255, 200);
//    final static Color COLOURONETXT = Color.BLUE;
//    final static Color COLOURTWO = new Color(0, 0, 0, 200);
//    final static Color COLOURTWOTXT = new Color(255, 100, 255);
//    final static int EMPTY = 0;
//    final static int BSIZE = 7; //board size.
//    final static int HEXSIZE = 160;	//hex size in pixels
//    final static int BORDERS = 15;
//    final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS * 3; //screen size (vertical dimension).
//
//    int[][] board = new int[BSIZE][BSIZE - 1];
//
//    void initGame() {
//
//        hexmech.setXYasVertex(false); //RECOMMENDED: leave this as FALSE.
//
//        hexmech.setHeight(HEXSIZE); //Either setHeight or setSize must be run to initialize the hex
//        hexmech.setBorders(BORDERS);
//
//        for (int i = 0; i < BSIZE; i++) {
//            for (int j = 0; j < (BSIZE - 1); j++) {
//                board[i][j] = EMPTY;
//            }
//        }
//
//        //set up board here
//        board[3][3] = (int) 'A';
//        board[4][3] = (int) 'Q';
//        board[4][4] = -(int) 'B';
//    }
//
//    private void createAndShowGUI() {
//        DrawingPanel panel = new DrawingPanel();
//
//        //JFrame.setDefaultLookAndFeelDecorated(true);
//        JFrame frame = new JFrame("Hex Testing 4");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        Container content = frame.getContentPane();
//        content.add(panel);
//        //this.add(panel);  -- cannot be done in a static context
//        //for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
//        frame.setSize((int) (SCRSIZE / 1.23), SCRSIZE);
//        frame.setResizable(false);
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
//    }
//
//    class DrawingPanel extends JPanel {
//        //mouse variables here
//        //Point mPt = new Point(0,0);
//
//        public DrawingPanel() {
//            setBackground(COLOURBACK);
//
//            MyMouseListener ml = new MyMouseListener();
//            addMouseListener(ml);
//        }
//
//        public boolean checkIt(int x, int y) {
////                    if (x==0)&&(y==0)||{
////            if (x==0)&&(y==0){
//            if ((x == 0) && (y == 0)) {
//                return false;
//            } else if ((x == 6) && (y == 0)) {
//                return false;
//            } else if ((x == 0) && (y == 5)) {
//                return false;
//            } else if ((x == 1) && (y == 5)) {
//                return false;
//            } else if ((x == 3) && (y == 5)) {
//                return false;
//            } else if ((x == 5) && (y == 5)) {
//                return false;
//            } else if ((x == 6) && (y == 5)) {
//                return false;
//            } else {
//                return true;
//            }
//        }
//
//        public void paintComponent(Graphics g) {
//            Graphics2D g2 = (Graphics2D) g;
//            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
//            g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
//            super.paintComponent(g2);
//            //draw grid
//            for (int i = 0; i < BSIZE; i++) {
//                for (int j = 0; j < BSIZE - 1; j++) {
//
////                                    int [][] = 
//                    if (checkIt(i, j)) {
//                        hexmech.drawHex(i, j, g2);
//                    }
//                }
//            }
//            //fill in hexes
//            for (int i = 0; i < BSIZE; i++) {
//                for (int j = 0; j < (BSIZE - 1); j++) {
//                    //if (board[i][j] < 0) hexmech.fillHex(i,j,COLOURONE,-board[i][j],g2);
//                    //if (board[i][j] > 0) hexmech.fillHex(i,j,COLOURTWO, board[i][j],g2);
//                    hexmech.fillHex(i, j, board[i][j], g2);
//                }
//            }
//
//            //g.setColor(Color.RED);
//            //g.drawLine(mPt.x,mPt.y, mPt.x,mPt.y);
//        }
//
//        class MyMouseListener extends MouseAdapter {	//inner class inside DrawingPanel 
//
//            public void mouseClicked(MouseEvent e) {
//                int x = e.getX();
//                int y = e.getY();
//                //mPt.x = x;
//                //mPt.y = y;
//                Point p = new Point(hexmech.pxtoHex(e.getX(), e.getY()));
//                if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= (BSIZE - 1)) {
//                    return;
//                }
//
//				//DEBUG: colour in the hex which is supposedly the one clicked on
//                //clear the whole screen first.
//				/* for (int i=0;i<BSIZE;i++) {
//                 for (int j=0;j<BSIZE;j++) {
//                 board[i][j]=EMPTY;
//                 }
//                 } */
//                //What do you want to do when a hexagon is clicked?
//                board[p.x][p.y] = (int) 'X';
//                repaint();
//            }
//        } //end of MyMouseListener class 
//    } // end of DrawingPanel class
//    }
