/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model.Actions;

import dominantspecies.model.ElementTile;
import java.util.ArrayList;

/**
 *
 * @author Tom
 */
//this is the base class for phases like adaptation, regression, abundance, wasteland
//depletion and wanderlust

//we should also be able to use this for domination and migration where the TileArea is null
//and still runs as a queue (glaciation might work with this too?) 

//thinking about using this for speciation and competition however there would probably need to be some changes
//hold out on those for now...
class Action {
    EyeballSpaces eyeballSpaces;
   // TileArea tileArea;///so i forgot wanderlust doesnt have tiles in its area
                        //changing to regular list
    ArrayList<ElementTile> tileArea;
    
    public Action(EyeballSpaces spaces, ArrayList area){
        eyeballSpaces = spaces;
        tileArea = area;
    }
}
