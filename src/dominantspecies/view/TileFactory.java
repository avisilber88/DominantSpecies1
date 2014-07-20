/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominantspecies.view;

import dominantspecies.hexgame;
import dominantspecies.model.ElementTile;
import dominantspecies.model.Tile;
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

    public static int HEXSIZE = 60;	//hex size in pixels
    public static int BORDERS = 15;
    private final static double element_to_hex_ratio = .2; //is going to be divided by 5, multiply by .2 instead ... look at set element size
    //its generally better to multiply then divide
    private static int h = HEXSIZE;	// height. Distance between centres of two adjacent hexes. Distance between two opposite sides in a hex.
    private static int r = h / 2;	// radius of inscribed circle (centre to middle of each side). r= h/2                                                         
    private static int s = (int) (h / 1.73205);	// length of one side
    private static int t = (int) (r / 1.73205);	// short side of 30o triangle outside of each hex
    private static int hE = (int) (HEXSIZE * element_to_hex_ratio);
    private static int rE = rE = hE / 2;

    private static void setTileSize() {//int height) {
        h = HEXSIZE;			// h = basic dimension: height (distance between two adj centresr aka size)
        r = h / 2;			// r = radius of inscribed circle
        s = (int) (h / 1.73205);	// s = (h/2)/cos(30)= (h/2) / (sqrt(3)/2) = h / sqrt(3)
        t = (int) (r / 1.73205);	// t = (h/2) tan30 = (h/2) 1/sqrt(3) = h / (2 sqrt(3)) = r / sqrt(3)
    }

    private static void setElementSize() {//int height) {
        hE = (int) (HEXSIZE * element_to_hex_ratio);
        rE = hE / 2;
    }

    public static void setSize(int hexsize) {
        HEXSIZE = hexsize;
        setTileSize();
        setElementSize();
    }

    private static Polygon hex(int x0, int y0) {
        int y = y0 + BORDERS;
        int x = x0 + BORDERS;

        if (s == 0 || h == 0) {
            System.out.println("ERROR: size of hex has not been set");
            return new Polygon();
        }

        int[] cx, cy;

        cx = new int[]{x + t, x + s + t, x + s + t + t, x + s + t, x + t, x};	//this is for the whole hexagon to be below and to the right of this point
        cy = new int[]{y, y, y + r, y + r + r, y + r + r, y + r};

        return new Polygon(cx, cy, 6);
    }

    private static Ellipse2D.Double circle(int x0, int y0, int index) {
        int y = y0 + BORDERS;
        int x = x0 + BORDERS;

        if (hE == 0) {
            System.out.println("ERROR: size of ellipse has not been set");
            return new Ellipse2D.Double();
        }

        int[] cx, cy;
        cx = new int[]{x + t, x + s + t, x + s + t + t, x + s + t, x + t, x};
        cy = new int[]{y, y, y + r, y + r + r, y + r + r, y + r};
        return new Ellipse2D.Double(cx[index] - rE, cy[index] - rE, hE, hE);
    }
        

    //the number in drawelement is the vertext of the hex at ( i , j )
    //  0   1
    //5        2
    //  4   3
    public static void drawElement(int i, int j, int vertex, ElementTile tileToDraw, Graphics2D g2) {
        int x = (i * (s + t));
        int y = (j * h + (i % 2) * h / 2);
        Ellipse2D.Double circle = circle(x, y, vertex);

        //too lazy to fix repeated code from draw tile
        try {
            // BufferedImage img = ImageIO.read(new FileInputStream(tileToDraw.getImageName()));
            BufferedImage img = ImageIO.read(GameView.class.getResource(tileToDraw.getImageName()));

            TexturePaint tex = new TexturePaint(img, circle.getBounds2D());
            g2.setPaint(tex);
            g2.fill(circle);

        } catch (IOException | IllegalArgumentException e) {

            //TODO give the blank tiles a image name, it shouldnt have to go through the exception
            // System.err.println(e);
            g2.setColor(tileToDraw.getColor());
            g2.fill(circle);
            // g2.setColor(Color.orange);
        }

        // g2.drawString(""+vertex, x+BORDERS, y+BORDERS+4);
    }

    public static void drawTile(int i, int j, Tile tileToDraw, Graphics2D g2) {
        int x = i * (s + t);
        int y = j * h + (i % 2) * h / 2;
        Polygon poly = hex(x, y);
        //draw with the tile spec
        try {
//            System.out.println("here: "+(board[i][j].getImageName()));z
//            URL blah = new FileInputStream(board[i][j].getImageName());
            // BufferedImage img = ImageIO.read(new FileInputStream(tileToDraw.getImageName()));
            BufferedImage img = ImageIO.read(GameView.class.getResource(tileToDraw.getImageName()));
            TexturePaint tex = new TexturePaint(img, poly.getBounds2D());
            g2.setPaint(tex);
            g2.fill(poly);
            g2.draw(poly);
//                        g2.drawImage(img, 0, 0, this);

        } catch (IOException | IllegalArgumentException e) {
            //TODO give the blank tiles an image name, it shouldnt have to go through the exception
            //System.err.println(e);
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
