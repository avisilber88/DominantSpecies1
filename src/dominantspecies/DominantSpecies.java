/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies;

//import static dominantspecies.hexgame.SCRSIZE;
import java.awt.Container;
import javax.swing.JFrame;

/**
 *
 * @author DJ 4 Fathers
 */
public class DominantSpecies {
//int SCRSIZE;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        new DominantSpecies();
    }
    public DominantSpecies(){
        createAndShowGUI();
    }
    private void createAndShowGUI() {
       Board board = new Board();

        //JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Dominant Species");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = frame.getContentPane();
        content.add(board);
        //this.add(panel);  -- cannot be done in a static context
        //for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
        frame.setSize((int) (board.SCRSIZE / 1.23), board.SCRSIZE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
