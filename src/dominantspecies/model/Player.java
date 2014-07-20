/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model;

import java.util.HashMap;

/**
 *
 * @author Tom
 */
public class Player {
  
   public static final int MAX_ACTIONS = 7;
   public static final int MAX_GENE_POOL = 55;
   public static final int MAX_ADAPTAIONS = 6;
   private HashMap<ElementType, Integer> adaptations;
   //avi, adaptations.values() gives you the values in there, use it to check if they are 
   //more then the max adaptions when adding new adaptations
   private Animal animal;
   private ElementType baseElement;//the animal cant lose more then the baseElementNum from regression and stuff
   private int baseElementNum = -1;//gets set up in adaptation setup
   private int actionPawns;
   private int genePool;
   private int score;
   
   public Player(Animal animal){//default?
       this(animal, 6);
       
   }
   
   public Player(Animal animal, int numberOfPlayers){
       this.animal = animal;       
       
     // int numberOfPlayers = -1;//TODO find this
      int modifier = (numberOfPlayers - 2);//it just is 2
      actionPawns = MAX_ACTIONS - modifier;
      genePool = MAX_GENE_POOL - (modifier * 5);//not sure why 5, but rules work out
      
      //setup adaptaitions      
       adaptations = new HashMap<>();
       setupAdaptations();
      
   }
   
   private void setupAdaptations(){
       this.baseElementNum = 2;       
       switch(animal){
           case Insect:
               baseElement = ElementType.Grass;break;
           case Arachnid:
               baseElement = ElementType.Grub;break;
           case Bird:
               baseElement =ElementType.Seed;break;
           case Reptile:
               baseElement =ElementType.Sun;break;
           case Mammal:
               baseElement =ElementType.Meat;break;
           case Amphibian:
               baseElement = ElementType.Water;
               baseElementNum = 3;
               break;
       }       
       adaptations.put(baseElement, baseElementNum);
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
