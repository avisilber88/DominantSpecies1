/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominantspecies;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JPanel;

/**
 *
 * @author DJ 4 Fathers
 */
public class Board extends JPanel {

    final static Color COLOURBACK = Color.WHITE;
    final static Color COLOURCELL = Color.ORANGE;
    final static Color COLOURGRID = Color.BLACK;
    final static Color COLOURONE = new Color(255, 255, 255, 200);
    final static Color COLOURONETXT = Color.BLUE;
    final static Color COLOURTWO = new Color(0, 0, 0, 200);
    final static Color COLOURTWOTXT = new Color(255, 100, 255);
    
    private static int s=0;	// length of one side
    private static int t=0;	// short side of 30o triangle outside of each hex
    private static int r=0;	// radius of inscribed circle (centre to middle of each side). r= h/2
    private static int h=0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.
 private static int sE=0;	// length of one side
    private static int tE=0;	// short side of 30o triangle outside of each hex
    private static int rE=0;	// radius of inscribed circle (centre to middle of each side). r= h/2
    private static int hE=0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.

    // public static boolean XYVertex=false;
  //  final static Tile EMPTY = new Tile(Tile.TerrainType.Invalid);
    final static int BSIZE = 7; //board size.
    final static int HEXSIZE = 60;	//hex size in pixels
    final static int BORDERS = 15;
    final static int SCRSIZE = HEXSIZE * (BSIZE + 1) + BORDERS * 3; //screen size (vertical dimension).
    Tile[][] board = new Tile[BSIZE][BSIZE - 1];
    ElementTile[][][] boardElements = new ElementTile[BSIZE][BSIZE - 1][2];
    public static void setTileSize(int height) {
		h = height;			// h = basic dimension: height (distance between two adj centresr aka size)
		r = h/2;			// r = radius of inscribed circle
		s = (int) (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
		t = (int) (r / 1.73205);	// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)
    }
    
    public static void setElementSize (int height){
        hE = height;
        rE = h/2;
        sE = (int) (h / 1.73025);
        tE = (int) (r / 1.73025);
    }
    
    public Board() {
        setTileSize(HEXSIZE);//this is simple way to change tile size
        setElementSize(HEXSIZE/10);
        initBoard();

        //set up board here
    }
    //sets up the grids and sets the tiles to invalid
    //setupBoard() will set the initial game tiles and element things
    public void initBoard(){
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < (BSIZE - 1); j++) {   
                int x0 = i * (s+t);
		int y0 = j * h + (i%2) * h/2;                
		int x = x0 + BORDERS; // + (XYVertex ? t : 0); //Fix added for XYVertex = true. 
				      // NO! Done below in cx= section
                int y = y0 + BORDERS;
                
		if (s == 0  || h == 0) {
			System.out.println("ERROR: size of hex has not been set");
			//return new Polygon();
		}

		int[] cx,cy;

//I think that this XYvertex stuff is taken care of in the int x line above. Why is it here twice?
		/*TOM says fuck the xyvertex since its always false
                if (XYVertex) 
			cx = new int[] {x,x+s,x+s+t,x+s,x,x-t};  //this is for the top left vertex being at x,y. Which means that some of the hex is cutoff.
		else
                */
		cx = new int[] {x+t,x+s+t,x+s+t+t,x+s+t,x+t,x};	//this is for the whole hexagon to be below and to the right of this point

		cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r}; 
                board[i][j] = new Tile(Tile.TerrainType.Invalid, cx, cy);
            }
        }
        
    }
    
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        super.paintComponent(g2);
        //draw grid
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < BSIZE - 1; j++) {
                if (checkHexExist(i, j)) {
                    System.out.println("TENGO! => [ "+i+" , "+j+" ]" );
                    
                    g2.setColor(COLOURCELL);
                    g2.fillPolygon(board[i][j]);
                    g2.setColor(COLOURGRID);
                    g2.drawPolygon(board[i][j]);
                }else{
                    System.out.println("NO TENGO => [ "+i+" , "+j+" ]" );
                }
            }
        }

    }

    public boolean checkHexExist(int x, int y) {
        if ((x == 0) && (y == 0)) {
            return false;
        } else if ((x == 6) && (y == 0)) {
            return false;
        } else if ((x == 0) && (y == 5)) {
            return false;
        } else if ((x == 1) && (y == 5)) {
            return false;
        } else if ((x == 3) && (y == 5)) {
            return false;
        } else if ((x == 5) && (y == 5)) {
            return false;
        } else if ((x == 6) && (y == 5)) {
            return false;
        } else {
            return true;
        }
    }
}