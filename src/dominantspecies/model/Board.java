/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author DJ 4 Fathers
 */
public class Board extends JPanel {

     // public static boolean XYVertex=false;
    //  final static Tile EMPTY = new Tile(Tile.TerrainType.Invalid);
    final static int BSIZE = 7; //board size.
   // final static int HEXSIZE = 60;	//hex size in pixels
    //final static int BORDERS = 15;
    //final static int SCRSIZE = 525;//HEXSIZE * (BSIZE + 1) + BORDERS * 3; //screen size (vertical dimension).
    Tile[][] board;
    ElementTile[][] boardElements;   

    public Board() {
        board = new Tile[BSIZE][BSIZE - 1];
        boardElements = new ElementTile[2 * (BSIZE + 1)][BSIZE];
        initBoard();        
    }

    //sets up the grids and sets the tiles to invalid
    //setupBoard() will set the initial game tiles and element things
    public final void initBoard() {
        for (int i = 0; i < BSIZE; i++) {
            for (int j = 0; j < (BSIZE - 1); j++) {         
                board[i][j] = new Tile(Tile.TerrainType.Invalid);

                if (boardElements[2 * i + 1][j] == null) {
                    boardElements[2 * i + 1][j] = new ElementTile(ElementType.None);
                } else {
                    System.out.println("see there was a copy");
                }
                if (boardElements[2 * i + 2][j] == null) {
                    boardElements[2 * i + 2][j] = new ElementTile(ElementType.None);
                } else {
                    System.out.println("see there was a copy");
                }
                if (boardElements[2 * i + 3][j + i % 2] == null) {
                    boardElements[2 * i + 3][j + i % 2] = new ElementTile(ElementType.None);
                } else {
                    System.out.println("see there was a copy");
                }
                if (boardElements[2 * i + 2][j + 1] == null) {
                    boardElements[2 * i + 2][j + 1] = new ElementTile(ElementType.None);
                } else {
                    System.out.println("see there was a copy");
                }
                if (boardElements[2 * i + 1][j + 1] == null) {
                    boardElements[2 * i + 1][j + 1] = new ElementTile(ElementType.None);
                } else {
                    System.out.println("see there was a copy");
                }
                if (boardElements[2 * i][j + i % 2] == null) {
                    boardElements[2 * i][j + i % 2] = new ElementTile(ElementType.None);
                } else {
                    System.out.println("see there was a copy");
                }
            }
        }

        board[3][1].setTerrain(Tile.TerrainType.Wetlands);
        board[4][2].setTerrain(Tile.TerrainType.Savannah);
        board[4][3].setTerrain(Tile.TerrainType.Desert);
        board[3][3].setTerrain(Tile.TerrainType.Mountain);
        board[2][3].setTerrain(Tile.TerrainType.Forest);
        board[2][2].setTerrain(Tile.TerrainType.Jungle);

        board[3][2].setTerrain(Tile.TerrainType.Tundra);

        boardElements[7][3].setElementType(ElementType.Meat);
        boardElements[8][3].setElementType(ElementType.Sun);
        boardElements[9][4].setElementType(ElementType.Meat);
        boardElements[9][3].setElementType(ElementType.Grass);
        boardElements[10][3].setElementType(ElementType.Sun);
        boardElements[6][3].setElementType(ElementType.Seed);
boardElements[5][3].setElementType(ElementType.Grub);
boardElements[6][4].setElementType(ElementType.Seed);

boardElements[6][2].setElementType(ElementType.Water);
boardElements[7][2].setElementType(ElementType.Grub);

        boardElements[8][2].setElementType(ElementType.Water);
        boardElements[9][2].setElementType(ElementType.Grass);
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
