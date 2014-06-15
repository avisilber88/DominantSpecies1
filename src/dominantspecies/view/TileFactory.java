/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominantspecies.view;

import dominantspecies.hexgame;
import dominantspecies.model.ElementTile;
import dominantspecies.model.Tile;
import static dominantspecies.view.GameView.BORDERS;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.TexturePaint;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Tom
 */
public class TileFactory {

    private static int s = 0;	// length of one side
    private static int t = 0;	// short side of 30o triangle outside of each hex
    private static int r = 0;	// radius of inscribed circle (centre to middle of each side). r= h/2
    private static int h = 0;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.
    private static int sE = 0;
    private static int tE = 0;
    private static int rE = 0;
    private static int hE = 0;

    /**
     * This functions takes the Side length in pixels and uses that as the basic
     * dimension of the hex. It calculates all other needed constants from this
     * dimension.
     */
    /*	public static void setSide(int side) {
     s=side;
     t =  (int) (s / 2);			//t = s sin(30) = (int) CalculateH(s);
     r =  (int) (s * 0.8660254037844);	//r = s cos(30) = (int) CalculateR(s); 
     h=2*r;
     }
     public static void setHeight(int height) {
     h = height;			// h = basic dimension: height (distance between two adj centresr aka size)
     r = h/2;			// r = radius of inscribed circle
     s = (int) (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
     t = (int) (r / 1.73205);	// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)
     }
     */
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

    /**
     * *******************************************************
     * Name: hex() Parameters: (x0,y0) This point is normally the top left
     * corner of the rectangle enclosing the hexagon. However, if XYVertex is
     * true then (x0,y0) is the vertex of the top left corner of the hexagon.
     * Returns: a polygon containing the six points. Called from: drawHex(),
     * fillhex() Purpose: This function takes two points that describe a hexagon
     * and calculates all six of the points in the hexagon.
********************************************************
     */
    public static Polygon hex(int x0, int y0) {

        int y = y0 + GameView.BORDERS;
        int x = x0 + GameView.BORDERS; // + (XYVertex ? t : 0); //Fix added for XYVertex = true. 
        // NO! Done below in cx= section
        if (s == 0 || h == 0) {
            System.out.println("ERROR: size of hex has not been set");
            return new Polygon();
        }

        int[] cx, cy;

        cx = new int[]{x + t, x + s + t, x + s + t + t, x + s + t, x + t, x};	//this is for the whole hexagon to be below and to the right of this point
        cy = new int[]{y, y, y + r, y + r + r, y + r + r, y + r};

        return new Polygon(cx, cy, 6);
    }

    public static Ellipse2D.Double circle(int x0, int y0, int index) {

        int y = y0 + GameView.BORDERS;
        int x = x0 + GameView.BORDERS; // + (XYVertex ? t : 0); //Fix added for XYVertex = true. 
        // NO! Done below in cx= section
        if (hE == 0) {
            System.out.println("ERROR: size of ellipse has not been set");
            return new Ellipse2D.Double();
        }

	int[] cx,cy;
	cx = new int[] {x+t,x+s+t,x+s+t+t,x+s+t,x+t,x};
        cy = new int[] {y,y,y+r,y+r+r,y+r+r,y+r};
        return new Ellipse2D.Double(cx[index] - rE, cy[index] - rE, hE, hE);
    }

    public static void drawElement(int i, int j, int vertex, ElementTile tileToDraw, Graphics2D g2) {
        
        
        //
        int x = (i * (s + t));
        int y = (j * h + (i % 2) * h / 2);
        Ellipse2D.Double circle = circle(x, y, vertex);

        //too lazy to fix repeated code from draw tile
        try {
            BufferedImage img = ImageIO.read(new FileInputStream(tileToDraw.getImageName()));
            TexturePaint tex = new TexturePaint(img, circle.getBounds2D());
            g2.setPaint(tex);
            g2.fill(circle);
            

        } catch (IOException | IllegalArgumentException e) {
           // System.err.println(e);
            g2.setColor(tileToDraw.getColor());
            g2.fill(circle);
           // g2.setColor(Color.orange);
        }
        
       // g2.drawString(""+vertex, x+BORDERS, y+BORDERS+4);
    }

    /**
     * ******************************************************************
     * Name: drawHex() Parameters: (i,j) : the x,y coordinates of the inital
     * point of the hexagon g2: the Graphics2D object to draw on. Returns: void
     * Calls: hex() Purpose: This function draws a hexagon based on the initial
     * point (x,y). The hexagon is drawn in the colour specified in
     * hexgame.COLOURELL.
********************************************************************
     */
    public static void drawTile(int i, int j, Tile tileToDraw, Graphics2D g2) {
        int x = i * (s + t);
        int y = j * h + (i % 2) * h / 2;
        Polygon poly = hex(x, y);
        //draw with the tile spec
        try {
//            System.out.println("here: "+(board[i][j].getImageName()));z
//            URL blah = new FileInputStream(board[i][j].getImageName());
            BufferedImage img = ImageIO.read(new FileInputStream(tileToDraw.getImageName()));
            TexturePaint tex = new TexturePaint(img, poly.getBounds2D());
            g2.setPaint(tex);
            g2.fill(poly);
            g2.draw(poly);
//                        g2.drawImage(img, 0, 0, this);

        } catch (IOException | IllegalArgumentException e) {
           // System.err.println(e);
            g2.setColor(tileToDraw.getColor());
            g2.fill(poly);
           // g2.setColor(Color.orange);
        }
		//g2.setColor(hexgame.COLOURCELL);
        //g2.fillPolygon(hexmech.hex(x,y));
        //g2.fillPolygon(poly);
        //g2.setColor(hexgame.COLOURGRID);
        //g2.drawPolygon(poly);
    }

}
