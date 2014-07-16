/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies;

import dominantspecies.model.Actions.EyeballSpace;
import dominantspecies.model.ElementTile;
import dominantspecies.model.Game;
import dominantspecies.model.Player;
import dominantspecies.model.Tile;
import dominantspecies.view.GameView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Tom
 */
public class MainController{
    Game model;
    
    public MainController(Game model){
        this.model = model;
    }
    
    //methods that get called from the view
    //figure out if it's valid then call the appropriate other method
    //NOTE:: ill probably give the model a state of which move it will accept
    //      avi if you want you can do it by making an enum for the state of the model.
    //      The state is basically which method the model will want to recieve 
    //      (look under this set of methods for "methods that call the model"
    //NOTE::NOTE:: this is not the end all be all, there will be other methods
    //              that will be needed
    public void tileClicked(Tile tile){}    
    public void elementClicked(ElementTile elementTile){}    
    public void eyeballspaceClicked(EyeballSpace eyeballSpace){}
    
    //methods that will call the model
public void placeActionPawn(){}
public void placeSpecies(){}
public void pickTile(){}//used for wanderlust and scoring domination
public void placeTile(){}// used for wanderlust and tundra
public void pickElement(){}// for placing on board or to adapt to or specieate
public void placeElement(){}// on board
public void removeSpecies(){}//from tile, used for competition and other shit
public void removeElement(){}//from board or animal
    
}
