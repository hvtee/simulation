package model;

import java.util.Objects;

public abstract class Entity {
    protected final char symbol;
    protected final EntityType entityType;
    protected Coordinates coordinates;

    protected Entity(char symbol, EntityType entityType) {
        this.symbol = symbol;
        this.entityType = entityType;
    }

    public char getSymbol() {
        return symbol;
    }

    public EntityType getEntityType() {
        return entityType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return symbol == entity.symbol && entityType == entity.entityType && Objects.equals(coordinates, entity.coordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(symbol, entityType, coordinates);
    }
}

public enum EntityType {
    GRASS, TREE, ROCK,
    HERBIVORE, PREDATOR;
}
