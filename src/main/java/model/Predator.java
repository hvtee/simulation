package model;

public class Predator extends Creature{
    public Predator() {
        super('@', EntityType.PREDATOR);
        this.health=15;
        this.speed=1;
        this.vision=3;
    }

    @Override
    public void makeMove(Coordinates coordinate) {

    }
}
