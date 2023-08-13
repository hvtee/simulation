package model;

public abstract class Creature extends Entity {
    protected double health;
    protected int speed;
    protected int vision;

    public Creature(char symbol, EntityType entityType) {
        super(symbol, entityType);
    }

    public abstract void makeMove(Coordinates coordinate);
}
