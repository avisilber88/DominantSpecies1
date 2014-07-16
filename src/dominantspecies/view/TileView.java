///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package dominantspecies.view;
//
//import dominantspecies.model.*;
//import java.awt.Color;
//import java.awt.Graphics2D;
//import java.awt.Polygon;
//
///**
// *
// * @author DJ 4 Fathers, Toms Over Baghdad
// */
//public class TileView extends Polygon {
//    
//    public static enum TerrainType {
//
//        Tundra,
//        Forest,
//        Jungle,
//        Mountain,
//        Desert,
//        Sea,
//        Wetlands,
//        Savannah,
//        Invalid
//    }
//    
//    private TerrainType terrain;
//    
//    public TileView(TerrainType terrain, int[] cx, int[] cy) {
//        super(cx,cy,6);
//        this.terrain = terrain; 
//    }
//    public void drawTile(Graphics2D g2){
//        //TODO have tile draw itself
//    }
//    public int[] Species = new int[6];
// 
//    
//    public TerrainType getTerrain(){
//        return this.terrain;
//    }
//    
//    public void setTerrain(TerrainType terrain){
//        this.terrain=terrain;
//    }
//    public int[] ScoreValues(){
//        switch(this.terrain) {
//            case Sea:
//              return new int[] { 9, 5, 3, 2 };
//            case Wetlands:
//              return new int[] { 8, 4, 2, 1 };
//            case Savannah:
//              return new int[] { 7, 4, 2 };
//            case Jungle:
//              return new int[] { 6, 3, 2 };
//            case Forest:
//              return new int[] { 5, 3, 2 };
//            case Desert:
//              return new int[] { 4, 2 };
//            case Mountain:
//              return new int[] { 3, 2 };
//            case Tundra:
//              return new int[] { 1 };
//          }
//          return new int[] {};
//    }
//    
//    public int getSpeciateCount(){
//        switch(this.terrain) {
//            case Sea:
//            case Wetlands:
//              return 4;
//            case Savannah:
//            case Jungle:
//            case Forest:
//              return 3;
//            case Desert:
//            case Mountain:
//              return 2;
//            case Tundra:
//              return 1;
//          }
//          return 0;
//    }
//    
//    public Color getColor(){
//        switch (this.terrain){
//            case Sea:
//                return Color.BLUE;
//            case Wetlands:
//                return Color.cyan;
//            case Savannah:
//                return Color.LIGHT_GRAY;
//            case Jungle:
//                return Color.green;
//            case Forest:
//                return Color.black;
//            case Desert:
//                return Color.yellow;
//            case Mountain:
//                return Color.GRAY;
//            case Tundra:
//                return Color.white;
//        }
//        return null;
//    }
//    
//    public String getImageName(){    
//        //highley reccomend moving this to the view classes
//        System.out.println("images/"+this.getTerrain()+".jpeg");
//        return "src/dominantspecies/view/images/"+this.getTerrain()+".jpeg";
//    }
//         
//
//}
