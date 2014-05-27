/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies;

import java.awt.geom.Ellipse2D;


/**
 *
 * @author DJ 4 Fathers
 */
public class ElementTile extends Ellipse2D.Float{
    private ElementType elementType;
    
      public ElementTile(ElementType elementType, int x, int y, int w, int h) {
        super(x, y, w, h);
        this.elementType = elementType; 
        
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
          return this.elementType+".jpeg";
      }
//      public 
}
