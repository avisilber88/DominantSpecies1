/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dominantspecies.model;

import dominantspecies.model.Actions.ActionDisplay;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Tom
 */
public class Game {

    private Board board;
    private ActionDisplay actionDisplay;
    private ElementBag elementBag;
    private List<Player> players;

    public Game(boolean defaultSetup) {
        players = new ArrayList<>();
        elementBag = new ElementBag();
        board = new Board(defaultSetup);
        if (defaultSetup) {
            DefaultSetup();
        }
        //after everything is set up, then set up the actionDisplay
        //this way it knows how many players are playing
        actionDisplay = new ActionDisplay(this);

    }


    public final void DefaultSetup() {
        players.add(new Player(Animal.Amphibian));
        players.add(new Player(Animal.Insect));
        players.add(new Player(Animal.Arachnid));
        players.add(new Player(Animal.Mammal));
        players.add(new Player(Animal.Bird));
        players.add(new Player(Animal.Reptile));

    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public ElementBag getElementBag() {
        return elementBag;
    }

    public void setElementBag(ElementBag elementBag) {
        this.elementBag = elementBag;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
