package model;

public abstract class Creature extends Entity {
    private double health;
    private int speed;

    public Creature(char symbol, EntityType entityType) {
        super(symbol, entityType);
    }

    public void makeMove() {

    }
}
