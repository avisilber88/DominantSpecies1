/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies;

import dominantspecies.model.Game;
import dominantspecies.view.GameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Tom
 */
public class MainController{// implements MouseListener{
    Game model;
    GameView view;
    
    public MainController(Game model, GameView gameview){//, GameView view){
        this.model = model;
        this.view = view;
      //  view.addMouseListener(this);
        //settlers version seems to pass the client around and call methods from it
        //however this kind of goes against the MVC concept of separation
    }
    
    //make methods that call to the model

    
}
