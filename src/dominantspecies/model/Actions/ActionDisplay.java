/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model.Actions;

import dominantspecies.model.ElementBag;
import dominantspecies.model.Game;
import dominantspecies.model.Player;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tom
 */
public class ActionDisplay {
    List<Action> actions;
    ElementBag elementBag;
    List<Player> players;
    
    public ActionDisplay(Game g){//might need to pass the game in here because i need to get the players and element bag
         elementBag = g.getElementBag();
         players = g.getPlayers();
         actions = new ArrayList<>();
         setupActions();
    }
    public final void setupActions(){
        int i = 0;
        actions.add(i++, new AdaptationAction());//Avi, i++ be 0 to insert the action then increment (you can do ++i to increment first) 
    }
}
