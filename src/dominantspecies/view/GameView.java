/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominantspecies.view;

import dominantspecies.DominantSpecies;
import dominantspecies.MainController;
import dominantspecies.model.ElementTile;
import dominantspecies.model.ElementType;
import dominantspecies.model.Game;
import dominantspecies.model.TerrainType;
import dominantspecies.model.Tile;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author DJ 4 Fathers
 */
public class GameView extends JPanel {

    final static Color COLOURBACK = Color.WHITE;
    final static Color COLOURCELL = Color.ORANGE;
    final static Color COLOURGRID = Color.BLACK;
    final static Color COLOURONE = new Color(255, 255, 255, 200);
    final static Color COLOURONETXT = Color.BLUE;
    final static Color COLOURTWO = new Color(0, 0, 0, 200);
    final static Color COLOURTWOTXT = new Color(255, 100, 255);

    private static int s = 0;	// length of one side
    private static int t = 0;	// short side of 30o triangle outside of each hex
    private static int r = 0;	// radius of inscribed circle (centre to middle of each side). r= h/2
    private static int h = 0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.
    private static int sE = 0;	// length of one side
    private static int tE = 0;	// short side of 30o triangle outside of each hex
    private static int rE = 0;	// radius of inscribed circle (centre to middle of each side). r= h/2
    private static int hE = 0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.

    // public static boolean XYVertex=false;
    //  final static Tile EMPTY = new Tile(Tile.TerrainType.Invalid);
//  final static int BSIZE = 7; //board size.
    final static int HEXSIZE = 60;	//hex size in pixels
    final static int BORDERS = 15;
   // final static int SCRSIZE = 525;//HEXSIZE * (BSIZE + 1) + BORDERS * 3; //screen size (vertical dimension).
    Game game;
    Tile[][] board;// = new TileView[BSIZE][BSIZE - 1];
    ElementTile[][] boardElements;// = new ElementTileView[2 * (BSIZE + 1)][BSIZE];

    public static void setTileSize(int height) {
        h = height;			// h = basic dimension: height (distance between two adj centresr aka size)
        r = h / 2;			// r = radius of inscribed circle
        s = (int) (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
        t = (int) (r / 1.73205);	// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)
    }

    public static void setElementSize(int height) {
        hE = height;
        rE = hE / 2;//h / 2;
        sE = (int) (h / 1.73025);
        tE = sE;//(int) (r / 1.73025);
    }

    public GameView(Game model, MainController controller) {
        TileFactory.setTileSize(HEXSIZE);//TileSize(HEXSIZE);//this is simple way to change tile size
        TileFactory.setElementSize(HEXSIZE / 5);

        this.game = model;
        this.board = this.game.getBoard().getBoard();
        this.boardElements = this.game.getBoard().getBoardElements();

        //set up board here
    }

    /*
     public void realignBoard(int height) {

     int hexSizeNew = (height - BORDERS * 3) / (BSIZE - 1);
     setTileSize(hexSizeNew);
     setElementSize(hexSizeNew / 5);
     ElementTileView[][] boardElementsResizeCheck = new ElementTileView[2 * (BSIZE + 1)][BSIZE];
     for (int i = 0; i < BSIZE; i++) {
     for (int j = 0; j < (BSIZE - 1); j++) {
     int x0 = i * (s + t);
     int y0 = j * h + (i % 2) * h / 2;
     int x = x0 + BORDERS; // + (XYVertex ? t : 0); //Fix added for XYVertex = true. 
     // NO! Done below in cx= section
     int y = y0 + BORDERS;

     if (s == 0 || h == 0) {
     System.out.println("ERROR: size of hex has not been set");
     //return new Polygon();
     }

     int[] cx, cy;

     //I think that this XYvertex stuff is taken care of in the int x line above. Why is it here twice?
     /*TOM says fuck the xyvertex since its always false
     if (XYVertex) 
     cx = new int[] {x,x+s,x+s+t,x+s,x,x-t};  //this is for the top left vertex being at x,y. Which means that some of the hex is cutoff.
     else
     ///*
     cx = new int[]{x + t, x + s + t, x + s + t + t, x + s + t, x + t, x};	//this is for the whole hexagon to be below and to the right of this point

     cy = new int[]{y, y, y + r, y + r + r, y + r + r, y + r};

     board[i][j] = new TileView(board[i][j].getTerrain(), cx, cy);

     if (boardElementsResizeCheck[2 * i + 1][j] == null) {
     boardElementsResizeCheck[2 * i + 1][j] = new ElementTileView(ElementType.None, cx[0] - rE, cy[0] - rE, hE, hE);
     boardElements[2 * i + 1][j] = new ElementTileView(boardElements[2 * i + 1][j].getElementType(), cx[0] - rE, cy[0] - rE, hE, hE);
     } else {
     //                    System.out.println("see there was a copy");
     }
     if (boardElementsResizeCheck[2 * i + 2][j] == null) {
     boardElementsResizeCheck[2 * i + 2][j] = new ElementTileView(ElementType.None, cx[1] - rE, cy[1] - rE, hE, hE);
     boardElements[2 * i + 2][j] = new ElementTileView(boardElements[2 * i + 2][j].getElementType(), cx[1] - rE, cy[1] - rE, hE, hE);
     } else {
     //                    System.out.println("see there was a copy");
     }
     if (boardElementsResizeCheck[2 * i + 3][j + i % 2] == null) {
     boardElementsResizeCheck[2 * i + 3][j + i % 2] = new ElementTileView(ElementType.None, cx[2] - rE, cy[2] - rE, hE, hE);
     boardElements[2 * i + 3][j + i % 2] = new ElementTileView(boardElements[2 * i + 3][j + i % 2].getElementType(), cx[2] - rE, cy[2] - rE, hE, hE);
     } else {
     //                    System.out.println("see there was a copy");
     }
     if (boardElementsResizeCheck[2 * i + 2][j + 1] == null) {
     boardElementsResizeCheck[2 * i + 2][j + 1] = new ElementTileView(ElementType.None, cx[3] - rE, cy[3] - rE, hE, hE);
     boardElements[2 * i + 2][j + 1] = new ElementTileView(boardElements[2 * i + 2][j + 1].getElementType(), cx[3] - rE, cy[3] - rE, hE, hE);
     } else {
     //                    System.out.println("see there was a copy");
     }
     if (boardElementsResizeCheck[2 * i + 1][j + 1] == null) {
     boardElementsResizeCheck[2 * i + 1][j + 1] = new ElementTileView(ElementType.None, cx[4] - rE, cy[4] - rE, hE, hE);
     boardElements[2 * i + 1][j + 1] = new ElementTileView(boardElements[2 * i + 1][j + 1].getElementType(), cx[4] - rE, cy[4] - rE, hE, hE);
     } else {
     //                    System.out.println("see there was a copy");
     }
     if (boardElementsResizeCheck[2 * i][j + i % 2] == null) {
     boardElementsResizeCheck[2 * i][j + i % 2] = new ElementTileView(ElementType.None, cx[5] - rE, cy[5] - rE, hE, hE);
     boardElements[2 * i][j + i % 2] = new ElementTileView(boardElements[2 * i][j + i % 2].getElementType(), cx[5] - rE, cy[5] - rE, hE, hE);
     } else {
     //                    System.out.println("see there was a copy");
     }

     }
     }
     }*/
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        super.paintComponent(g2);
        System.err.println("board.length = "+board.length+"\nboardelements.length = "+boardElements.length);
        //draw grid
        int vertex;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
               // System.err.println("["+i+"]["+j+"] = " +  board[i][j].getTerrain());
                if (board[i][j].getTerrain() != TerrainType.Invalid) {
                    g2.setColor(COLOURONE);
                    TileFactory.drawTile(i, j, board[i][j], g2); //this fills an element with an image                    
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
               // System.err.println("["+i+"]["+j+"] = " +  board[i][j].getTerrain());
                if (board[i][j].getTerrain() != TerrainType.Invalid) {
                    //vertex=0;
                    TileFactory.drawElement(i, j, 5, boardElements[i][j], g2); //this fills an element with an image
                    TileFactory.drawElement(i, j, 0, boardElements[i+1][j], g2); //this fills an element with an image
                    TileFactory.drawElement(i, j, 1, boardElements[i+2][j], g2); //this fills an element with an image
                    TileFactory.drawElement(i, j, 2, boardElements[i+3][j], g2); //this fills an element with an image
                    TileFactory.drawElement(i, j, 3, boardElements[i+2][j + 1], g2); //this fills an element with an image
                    TileFactory.drawElement(i, j, 4, boardElements[i+1][j + 1], g2); //this fills an element with an image
                    
                  //  TileFactory.drawElement(2 * i + 1, j, vertex++, boardElements[2 * i + 1][j], g2); //this fills an element with an image
                  //  TileFactory.drawElement(2 * i + 2, j, vertex++, boardElements[2 * i + 2][j], g2);
                  //  TileFactory.drawElement(2 * i + 3, j + i % 2, vertex++,  boardElements[2 * i + 3][j+i%2], g2);
                  //  TileFactory.drawElement(2 * i + 2, j + 1, vertex++,boardElements[2 * i + 2][j+1], g2);
                  //  TileFactory.drawElement(2 * i + 1, j + 1,vertex++, boardElements[2 * i + 1][j+1], g2);
                  //  TileFactory.drawElement(2 * i, j + i % 2, vertex++,boardElements[2 * i][j+i%2], g2);
                     
                }
            }
        }
       /* for (int i = 0; i < boardElements.length; i++) {
            for (int j = 0; j < boardElements[i].length; j++) {
               // if (board[i/2][j/3].getTerrain() != TerrainType.Invalid) {
                    TileFactory.drawElement(i, j, boardElements[i][j], g2); //this fills an element with an image
                    
               // }
            }
        }*/

    }

/*
    public void drawElement(int i, int j, Graphics2D g2) {
//if (boardElements[i][j].getElementType()!=ElementType.)
        g2.draw(boardElements[i][j]);
        try {
            System.out.println();
            BufferedImage img = ImageIO.read(new FileInputStream(boardElements[i][j].getImageName()));

            TexturePaint tex = new TexturePaint(img, boardElements[i][j].getBounds2D());
            g2.setPaint(tex);
            g2.fill(boardElements[i][j]);
//                        g2.drawImage(img, 0, 0, this);

        } catch (IOException e) {

        } catch (IllegalArgumentException e) {
//         System.out.println("hi");
            g2.setColor(boardElements[i][j].getColor());
            g2.fill(boardElements[i][j]);
            g2.setColor(Color.orange);
        }

    }
//C:\Users\Avi\Documents\NetBeansProjects\DominantSpecies1\src\dominantspecies\view\GameView.java

    public void drawTile(int i, int j, Graphics2D g2) {
        try {
//            System.out.println("here: "+(board[i][j].getImageName()));z
//            URL blah = new FileInputStream(board[i][j].getImageName());
            BufferedImage img = ImageIO.read(new FileInputStream(board[i][j].getImageName()));
            TexturePaint tex = new TexturePaint(img, board[i][j].getBounds2D());
            g2.setPaint(tex);
            g2.fill(board[i][j]);
//                        g2.drawImage(img, 0, 0, this);

        } catch (IOException e) {

        } catch (IllegalArgumentException e) {
            g2.setColor(board[i][j].getColor());
            g2.fill(board[i][j]);
            g2.setColor(Color.orange);
        }

    }
*/
}
