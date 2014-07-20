/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominantspecies;

//import static dominantspecies.hexgame.SCRSIZE;
import dominantspecies.model.Board;
import dominantspecies.model.GameModel;
import dominantspecies.view.GameView;
import java.awt.Color;
import static java.awt.Component.LEFT_ALIGNMENT;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author DJ 4 Fathers
 */
public class DominantSpecies {
//int SCRSIZE;
    private MainController mainController;
    private static GameView board;
    private static GameModel gameModel;
    JPanel actionDisplay, PlayerPanelPlaceHolder;
    JFrame frame;
/**
     * @param args the command line arguments
     */
    final static int StartSize = 600;

    public static void main(String[] args) {
        new DominantSpecies();
    }

    public DominantSpecies() {
        gameModel = new GameModel(true);
        mainController = new MainController(gameModel);
        board = new GameView(gameModel, mainController);
        actionDisplay = new JPanel();
        createAndShowGUI();
    }

    private void createAndShowGUI() {        
        frame = new JFrame("Dominant Species");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));
        content.add(board);
        content.add(actionDisplay);
        content.setBackground(Color.green);
        frame.add(content);
        
//          board.setSize((int)(board.SCRSIZE/1.23), board.SCRSIZE);
//          board.setBounds(0, 0, (int)(board.SCRSIZE/1.23), (int)board.SCRSIZE);
        actionDisplay.setBackground(Color.red);
        board.setBackground(Color.blue);
      //frame.setTitle("place holder is " + actionDisplay.getWidth());
        frame.setSize((int) (StartSize * (36.0 / 22)), StartSize);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {
                board.resize();   
//                frame.setTitle("frame height "+frame.getHeight()+"panel height " + board.getHeight());
            }
            public void componentMoved(ComponentEvent e) {}
            public void componentShown(ComponentEvent e) {}
            public void componentHidden(ComponentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });

    }

//    public void setSizes(JPanel panel, double width, double height){
//        panel.setMinimumSize(new Dimension((int)(frame.getWidth()*(width/40)), (int)(frame.getHeight()*(height/25))));
//        panel.setPreferredSize(new Dimension((int)(frame.getWidth()*(width/40)), (int)(frame.getHeight()*(height/25))));
//        panel.setMaximumSize(new Dimension((int)(frame.getWidth()*(width/40)), (int)(frame.getHeight()*(height/25))));            
//    }
    
}
