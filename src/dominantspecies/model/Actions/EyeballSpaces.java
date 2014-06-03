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
 */
public class EyeballSpaces {
    private final ArrayList<EyeballSpace> queue;//represents the player in the queue
    private final int sizeLimit;
    private int last = 0;
    
    public EyeballSpaces(int sizeLimit){
        this.sizeLimit = sizeLimit;
        this.queue = new ArrayList(sizeLimit);
        for(int i = 0; i < sizeLimit; i++)//initialize to all null
            queue.add(i, null);
    }
    
    public EyeballSpace getNext(){
        if(!queue.isEmpty())
            return queue.remove(0);
        last--;
        return null;
    }
    
    public EyeballSpace get(int i){
        return queue.get(i);
    }
    
    public boolean add(EyeballSpace player){
        if(last < sizeLimit){
            queue.add(last, player);
            last++;
            return true;
        }
        return false;        
    }
    
    public boolean add(EyeballSpace player, int i){
        if(i >=0 && i < sizeLimit){
            if(queue.get(i) == null){
                queue.add(i, player);
                return true;
            }
        }
        return false;
    }
    
    public int getSizeLimit(){
        return sizeLimit;
    }
    
    
    
}
