/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Tom
 */
public class ElementBag {
    private final int initNumElementPerType = 20;
    private final List<ElementTile> elementBag;
    private final Random r;
    
    public ElementBag(){
        elementBag = new ArrayList<>();
        r = new Random();
        for(int i = 0; i < initNumElementPerType; i++){
            for(ElementType type : ElementType.values()){
                elementBag.add(new ElementTile(type));
            }
        }
    }
    
    public ElementTile getElement(){
        int elementCount = elementBag.size();
        if(elementCount < 1){
            return null;
        }
        return elementBag.remove(r.nextInt(elementCount));
    }
    
    public ElementTile getElement(ElementType type){
        int elementCount = elementBag.size();
        for(int i = 0; i < elementCount; i++){
            if(elementBag.get(i).getElementType().equals(type))
                return elementBag.remove(i);
        }
        return null;
    }
    
    public void putBackElement(ElementTile tile){
        elementBag.add(tile);
    }
    
}
