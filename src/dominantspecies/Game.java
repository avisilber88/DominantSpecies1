/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
public class Game {
    private Board board;
  //  private ActionDisplay actionDisplay;
   private ElementBag elementBag;
    private List<Player> players = new ArrayList<Player>();
    
     public Game(boolean defaultSetup){//assume 6 players
      players.add(new Player(Animal.Amphibian));
      players.add(new Player(Animal.Insect));
      players.add(new Player(Animal.Arachnid));
      players.add(new Player(Animal.Mammal));
      players.add(new Player(Animal.Bird));
      players.add(new Player(Animal.Reptile));
      
      board = new Board();
      elementBag = new ElementBag();
     // actionDisplay = new ActionDisplay();
     // if (defaultSetup)
       // DefaultSetup();
    
  }
    
}
