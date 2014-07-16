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
   
    final Game game;
    final Tile[][] board;// = new TileView[BSIZE][BSIZE - 1];
    final ElementTile[][] boardElements;// = new ElementTileView[2 * (BSIZE + 1)][BSIZE];
    final MainController mainController;


    public GameView(Game model, MainController controller) {
        this.game = model;
        this.board = this.game.getBoard().getBoard();
        this.boardElements = this.game.getBoard().getBoardElements();
        this.mainController = controller;
    }
   
//  coordinate system for reference
//  this is top right (includes the tile that is "invalid"    
//            (1,0)----(2,0)          (5,0)----(6,0)
//            /           \           /
//        (0,0)           (3,0)----(4,0)
//            \           /           \
//            (1,1)----(2,1)          (5,1)----(6,1)
//            /           \           /
//        (0,1)           (3,1)----(4,1)
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setFont(new Font("TimesRoman", Font.PLAIN, 20));
        super.paintComponent(g2);
        System.err.println("board.length = "+board.length+"\nboardelements.length = "+boardElements.length);
        //draw grid
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
                    TileFactory.drawElement(i, j, 5, boardElements[i][j], g2); //this fills an element with an image
                    TileFactory.drawElement(i, j, 0, boardElements[i+1][j], g2); //this fills an element with an image
                    TileFactory.drawElement(i, j, 1, boardElements[i+2][j], g2); //this fills an element with an image
                    TileFactory.drawElement(i, j, 2, boardElements[i+3][j], g2); //this fills an element with an image
                    TileFactory.drawElement(i, j, 3, boardElements[i+2][j + 1], g2); //this fills an element with an image
                    TileFactory.drawElement(i, j, 4, boardElements[i+1][j + 1], g2); //this fills an element with an image
                    
                }
            }
        }        
    }

    //have the listener methods here
    //for example if the tile is clicked on then call the controllers tile method
    /*public void someTileGotPressed(){
       mainControllor.TilePressed(probably pass in the tile); 
    }*/
    /*public void someElementGotPressed(){
       mainControllor.elemtntPressed(probably pass in the element); 
    }*/
    
    
}
