/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominantspecies;

//import static dominantspecies.hexgame.SCRSIZE;
import dominantspecies.model.Board;
import dominantspecies.model.Game;
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
GameView board;
JPanel actionPlaceHolder, rightPlaceHolder, leftPlaceHolder;
JFrame frame;
String WinstonTested;
String testing2;
String testing3;
String testing4;
String testing5;
/**
     * @param args the command line arguments
     */
    final static int StartSize = 600;

    public static void main(String[] args) {
        // TODO code application logic here
        new DominantSpecies();//comment this out
        //uncomment below
       // Game model = new Game();
       // GameView view = new GameView(model);
       // MainController controller = new MainController(model);//, view);
    }

    public DominantSpecies() {
        createAndShowGUI();
    }

    private void createAndShowGUI() {
        board = new GameView(null);///this will be set up in the constructer so comment it out laters
        actionPlaceHolder = new JPanel();
        leftPlaceHolder = new JPanel();
        rightPlaceHolder = new JPanel();
        //JFrame.setDefaultLookAndFeelDecorated(true);
        frame = new JFrame("Dominant Species");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.X_AXIS));//frame.getContentPane();
//        board.setPreferredSize(null);
        content.add(leftPlaceHolder);
        content.add(board);

        content.add(actionPlaceHolder);
        content.add(rightPlaceHolder);
//        board.setMinimumSize(new Dimension((int) (StartSize * (25.0 / 40)), (int) ((StartSize * (25.0 / 40)))));
//        board.setPreferredSize(new Dimension((int) (StartSize * (25.0 / 40)), (int) ((StartSize * (25.0 / 40)))));
//        board.setMaximumSize(new Dimension((int) (StartSize * (25.0 / 40)), (int) ((StartSize * (25.0 / 40)))));

        board.realignBoard(board.getHeight());
//        board.setSize((int)(board.SCRSIZE/1.23), board.SCRSIZE);
//       board.setBounds(0, 0, (int)(board.SCRSIZE/1.23), (int)board.SCRSIZE);
        actionPlaceHolder.setBackground(Color.red);
        board.setBackground(Color.blue);
        //this.add(panel);  -- cannot be done in a static context
        //for hexes in the FLAT orientation, the height of a 10x10 grid is 1.1764 * the width. (from h / (s+t))
        frame.add(content);
        content.setBackground(Color.green);
        frame.setTitle("place holder is " + actionPlaceHolder.getWidth());
        frame.setSize((int) (StartSize * (36.0 / 22)), StartSize);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.addComponentListener(new ComponentListener() {
            public void componentResized(ComponentEvent e) {
                resizePanels();

//                frame.setTitle("frame height "+frame.getHeight()+"panel height " + board.getHeight());
            }

            public void componentMoved(ComponentEvent e) {

            }

            public void componentShown(ComponentEvent e) {

            }

            public void componentHidden(ComponentEvent e) {
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        }
        );

    }

    public void resizePanels() {
        frame.setSize(frame.getWidth(), (int) (frame.getWidth() * (22.0 / 36)));
        setSizes(leftPlaceHolder, 4.0, 22.0);
        setSizes(board, 22.0, 22.0);
        setSizes(actionPlaceHolder, 8.0, 22.0);
        setSizes(rightPlaceHolder, 4.0, 22.0);
        board.realignBoard(board.getHeight());

    }
    public void setSizes(JPanel panel, double width, double height){
        panel.setMinimumSize(new Dimension((int)(frame.getWidth()*(width/40)), (int)(frame.getHeight()*(height/25))));
        panel.setPreferredSize(new Dimension((int)(frame.getWidth()*(width/40)), (int)(frame.getHeight()*(height/25))));
        panel.setMaximumSize(new Dimension((int)(frame.getWidth()*(width/40)), (int)(frame.getHeight()*(height/25))));            
    }
    
}
