/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies;

import dominantspecies.model.Game;
import dominantspecies.model.Player;
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
    
    public MainController(Game model){//, GameView view){
        this.model = model;
        this.view = view;//new GameView(this);
        //view.addMouseListener(this);
        //settlers version seems to pass the client around and call methods from it
        //however this kind of goes against the MVC concept of separation
    }
    
    //make methods that call to the model and get called by the view
public void placeActionPawn(){}
public void placeSpecies(){}
public void pickTile(){}//used for wanderlust and scoring domination
public void placeTile(){}// used for wanderlust and tundra
public void pickElement(){}// for placing on board or to adapt to or specieate
public void placeElement(){}// on board
public void removeSpecies(){}//from tile, used for competition and other shit
public void removeElement(){}//from board or animal
    
}
