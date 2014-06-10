/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model.Actions;

import dominantspecies.model.Animal;
import java.util.ArrayList;


/**
 *
 * @author Tom
 * 
 * talk to me about this class as it may need to change depending on how you 
 * use it.
 */
public class EyeballSpaces {
    private final EyeballSpace[] queue;//represents the player in the queue
    private final int sizeLimit;
    private int first,last;//keep track of positions in the queue
    
    public EyeballSpaces(int sizeLimit){
        this.sizeLimit = sizeLimit;
        this.queue = new EyeballSpace[sizeLimit];
        for(int i = 0; i < sizeLimit; i++)//initialize to all null
            queue[i] =  null;
        first = 0;
        last = 0;
    }
    /////////use this when needed to be treated like a queue///////////
    public EyeballSpace removeNext(){
        EyeballSpace returnTo = queue[first];
        queue[first] = null;
        first++;
        return returnTo;
    }
    
     public EyeballSpace getNext(){
        return queue[first];
    }
     
     public boolean add(EyeballSpace player){
        if(last < sizeLimit && queue[last] == null){
            queue[last] = player;
            last++;
            return true;
        }
        return false;        
    }
     /////////////////////
     
    public EyeballSpace remove(int i){
        EyeballSpace returnTo = queue[i];
        queue[i] = null;
        return returnTo;
    }
   
    
    public EyeballSpace get(int i){
        return queue[i];
    }    
    
    public boolean add(EyeballSpace player, int i){
        if(i >=0 && i < sizeLimit && queue[i] == null){
            queue[i] = player;
            return true;
        }
        return false;
    }
    
    public int getSizeLimit(){
        return sizeLimit;
    }
    
    
    
}
