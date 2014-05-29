/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies;

import dominantspecies.model.Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Tom
 */
public class MainController {
    Game gameModel;
    //GameView gameView;
    
    public MainController(Game model){//, GameView view){
        gameModel = model;
        //gameView = view;
    }
    
    public class ModelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent ae) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            //this will handle the shit from the view
            //validate it in the model
            //then set in the model ie model.setsomeshit(someshit)
            //then gameView.update();
        }       
        
    }
    
}
