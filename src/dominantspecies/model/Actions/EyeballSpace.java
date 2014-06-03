/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dominantspecies.model.Actions;

import dominantspecies.model.Animal;
import dominantspecies.model.ElementType;
import dominantspecies.model.Tile;

/**
 *
 * @author Tom
 */
public class EyeballSpace {
    private Animal animal;
    private int migrationCount = -1;
    private Tile.TerrainType[] speciationTerrains = null;
    private ElementType element = null;

    
    EyeballSpace(Animal animal){
        this.animal = animal;
    }
    //for speciation
    EyeballSpace(Animal animal, ElementType element){
        this.animal = animal;
        this.element = element;
    }
    //for migration
    EyeballSpace(Animal animal, int migrationCount){
        this.animal = animal;
        this.migrationCount = migrationCount;
    }
    //for competition
    EyeballSpace(Animal animal, Tile.TerrainType[] terrains){
        this.animal = animal;
        this.speciationTerrains = terrains;
    }
    
    
    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public int getMigrationCount() {
        return migrationCount;
    }

    public void setMigrationCount(int migrationCount) {
        this.migrationCount = migrationCount;
    }

    public Tile.TerrainType[] getSpeciationTerrains() {
        return speciationTerrains;
    }

    public void setSpeciationTerrains(Tile.TerrainType[] speciationTerrains) {
        this.speciationTerrains = speciationTerrains;
    }

    public ElementType getElement() {
        return element;
    }

    public void setElement(ElementType element) {
        this.element = element;
    }
    
}
