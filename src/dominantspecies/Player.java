/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies;

import java.util.HashMap;

/**
 *
 * @author Tom
 */
public class Player {
  
   public static final int MAX_ADAPTAIONS = 6;
   private HashMap<ElementType, Integer> adaptations = new HashMap<ElementType, Integer>();
   //avi, adaptations.values() gives you the values in their, use it to check if they are 
   //more then the max adaptions
   private Animal animal;
   private int actionPawns;
   private int genePool;
   private int score;
   
   public Player(Animal animal){//default?
       this(animal, 6);
       
   }
   
   public Player(Animal animal, int numberOfPlayers){
       this.animal = animal;
     // int numberOfPlayers = -1;//TODO find this
      int modifier = (numberOfPlayers - 2);
      actionPawns = 7 - modifier;
      genePool = 55 - (modifier * 5);
      
      //setup adaptaitions
      
   }
   
   
   
   
   
   
   
   
    public Animal getAnimal() {
        return animal;
    }

    public int getActionPawns() {
        return actionPawns;
    }

    public void setActionPawns(int actionPawns) {
        this.actionPawns = actionPawns;
    }

    public int getGenePool() {
        return genePool;
    }

    public void setGenePool(int genePool) {
        this.genePool = genePool;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
  
   
   
}
