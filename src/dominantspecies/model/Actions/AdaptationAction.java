/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model.Actions;

import dominantspecies.model.ElementTile;
import dominantspecies.model.Game;

/**
 *
 * @author Tom
 */
public class AdaptationAction extends Action{
    Game game;
    
    public AdaptationAction(Game g){
        super(new EyeballSpaces(3), new TileArea<ElementTile>(4));
    }
}
