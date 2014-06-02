/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model.Actions;

import dominantspecies.model.Animal;
import java.util.LinkedList;


/**
 *
 * @author Tom
 */
public class EyeballSpaces {
    private final LinkedList<Animal> queue;//represents the player in the queue
    private final int sizeLimit;
    
    public EyeballSpaces(int sizeLimit){
        this.sizeLimit = sizeLimit;
        this.queue = new LinkedList();
    }
    
    public Animal getNext(){
        if(!queue.isEmpty())
            return queue.removeFirst();
        return null;
    }
    
    public boolean add(Animal player){
        if(queue.size() < sizeLimit){
            queue.addLast(player);
            return true;
        }
        return false;        
    }
    
    public int getSizeLimit(){
        return sizeLimit;
    }
    
    
    
}
