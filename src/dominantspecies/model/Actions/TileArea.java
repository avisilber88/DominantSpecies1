/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model.Actions;

import java.util.ArrayList;

/**
 *
 * @author Tom
 * @param <T>
 */

/*
avi, this is a class that stores generics, it can handle everything of the specified type
when instantiated. this is the area that will hold the tiles in the adaptation, regression, abundance
wasteland, depletion (ie the element tiles) also designed to handle wanderlust tiles,should be able to 
use this for initiative as well
 */
public class TileArea<T> {
    ArrayList<T> area; 
    final int size;
    
    public TileArea(int size){
        area = new ArrayList(size);
        this.size = size;
    }
    
    
    //quicker then just calling get tile, this both gets the tile and removes it
    //from the "area"
    //note: doesnt use the arrays remove method because I dont want the objects to shift
    //      this keeps relative locations
    public T removeTile(int i){
        if(i >= 0 && i < size){
            T mr_t = area.get(i);//couldnt help naming it mr t
            area.set(i, null);
            return mr_t;
        }
        return null;
    }
    //try to not use this if possible, i think i set this up with remove tile
    //but if you have to use this then fine?
    public T getTile(int i){
         if(i >= 0 && i < size)
            return area.get(i);
        return null;
    }
    
    public void setTile(int i, T newTile){
        if(i >= 0 && i < size)
            area.set(i, newTile);
    }
    
    
    public ArrayList<T> getTiles(){
        return area;
    }
    public void setTiles(ArrayList<T> tiles){
        if(tiles.size() == size)
            area = tiles;
        else
            System.err.println("trying to set tile arrays of different length");
    }
}
