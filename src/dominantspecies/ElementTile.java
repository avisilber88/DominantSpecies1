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
    private ElementType food;
    public enum ElementType{
        Grass,
        Grub,
        Meat,
        Seed,
        Sun,
        Water,
        Invalid
    }
      public ElementTile(ElementTile.ElementType food, int x, int y, int w, int h) {
        super(x, y, w, h);
        this.food = food; 
        
    }
//      public 
}
