/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model;


/**
 *
 * @author DJ 4 Fathers
 */
public class Board {

     // public static boolean XYVertex=false;
    //  final static Tile EMPTY = new Tile(Tile.TerrainType.Invalid);
    final static int BSIZE = 7; //board size.
   // final static int HEXSIZE = 60;	//hex size in pixels
    //final static int BORDERS = 15;
    //final static int SCRSIZE = 525;//HEXSIZE * (BSIZE + 1) + BORDERS * 3; //screen size (vertical dimension).
    final Tile[][] board;
    final ElementTile[][] boardElements;   

    public Board(boolean isDefaultSetup) {
        board = new Tile[BSIZE][BSIZE - 1];
        boardElements = new ElementTile[2 * (BSIZE + 1)][BSIZE];
        initBoard(); 
        if(isDefaultSetup)
            defaultSettings();
    }

    //sets up the grids and sets the tiles to invalid
    //setupBoard() will set the initial game tiles and element things
    public final void initBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {        
                board[i][j] = new Tile(TerrainType.None);
                if(!hexExist(i, j))
                    board[i][j].setTerrain(TerrainType.Invalid);
            }
        } 
        for (int i = 0; i < boardElements.length; i++) {
            for (int j = 0; j < boardElements[i].length; j++) { 
                boardElements[i][j] = new ElementTile(ElementType.None);
            }
        }
        
    }
    
    private void defaultSettings(){
        board[3][1].setTerrain(TerrainType.Wetlands);
        board[4][2].setTerrain(TerrainType.Savannah);
        board[4][3].setTerrain(TerrainType.Desert);
        board[3][3].setTerrain(TerrainType.Mountain);
        board[2][3].setTerrain(TerrainType.Forest);
        board[2][2].setTerrain(TerrainType.Jungle);
        board[3][2].setTerrain(TerrainType.Tundra);
/*
        //NEED TO RE FORMAT THE SET UP
        //TALK TO ME IF YOU NEED HELP WITH THE NEW COORDS
        
            (1,0)----(2,0)          (5,0)----(6,0)
            /           \           /
        (0,0)           (3,0)----(4,0)
            \           /           \
            (1,1)----(2,1)          (5,1)----(6,1)
            /           \           /
        (0,1)           (3,1)----(4,1)
        
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
    */   
    }
    
    public boolean hexExist(int x, int y) {
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

    public Tile[][] getBoard() {
        return board;
    }


    public ElementTile[][] getBoardElements() {
        return boardElements;
    }

    
}
