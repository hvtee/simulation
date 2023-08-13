package model;

public class Herbivore extends Creature {
    public Herbivore() {
        super('#', EntityType.HERBIVORE);
        this.health = 10;
        this.speed = 2;
        this.vision = 2;
    }

    //write algorithm that will seek for grass and move towards it
    //if there is no grass in the vision radius, it will move randomly
    //if there is grass in the vision radius, it will move towards it
    //if there is grass in the adjacent field, it will eat it
    @Override
    public void makeMove(Coordinates coordinates) {
        //write algorithm that will seek for grass and move towards it



    }
}
