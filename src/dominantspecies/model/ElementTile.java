/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model;

import java.awt.Color;
import java.awt.geom.Ellipse2D;


/**
 *
 * @author DJ 4 Fathers
 */
public class ElementTile {
    private ElementType elementType;
    
     public ElementTile(){
          this.elementType = ElementType.None;
      }
      public ElementTile(ElementType elementType){
          this.elementType = elementType;
      }
      public ElementType getElementType(){
          return this.elementType;
      }
      public void setElementType(ElementType elementType){
          this.elementType=elementType;
      }
      public String getImageName(){
          //might reccomend moving this to the view classes
          return "images/"+this.elementType+".jpeg";
      }

    public Color getColor() {
        switch(this.elementType){
            case None:
                return Color.WHITE;
            case Seed:
                return Color.YELLOW;
            case Water:
                return Color.BLUE;
            case Sun:
                return Color.ORANGE;
            case Grass:
                return Color.GREEN;
            case Grub:
                return Color.PINK;
            case Meat:
                return Color.RED;
        }
        return null;
    }
}
