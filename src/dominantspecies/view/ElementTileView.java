/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.view;

import dominantspecies.model.*;
import java.awt.geom.Ellipse2D;


/**
 *
 * @author DJ 4 Fathers
 */
public class ElementTileView extends Ellipse2D.Float{
    private ElementType elementType;
    
      public ElementTileView(ElementType elementType, int x, int y, int w, int h) {
        super(x, y, w, h);
        this.elementType = elementType; 
        
    }
      public ElementTileView(ElementType elementType){
          this.elementType = elementType;
      }
      public ElementType getElementType(){
          return this.elementType;
      }
      public void setElementType(ElementType elementType){
          this.elementType=elementType;
      }
      public String getImageName(){
          //highley reccomend moving this to the view classes
          return "images/"+this.elementType+".jpeg";
      }
//      public 
}
