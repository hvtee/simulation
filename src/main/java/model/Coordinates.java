package model;

import java.util.Iterator;

public class Coordinates implements Iterable<Coordinates>, Comparable<Coordinates> {

    private int y;
    private int x;

    public Coordinates(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public Iterator<Coordinates> iterator() {
        return new CoordinatesIterator();
    }

    @Override
    public int compareTo(Coordinates other) {
        if (this.y != other.y) {
            return Integer.compare(this.y, other.y);
        }
        return Integer.compare(this.x, other.x);
    }


    private class CoordinatesIterator implements Iterator<Coordinates> {
        private int currentY = 0;
        private int currentX = 0;

        @Override
        public boolean hasNext() {
            return currentX <= x && currentY <= y;
        }

        @Override
        public Coordinates next() {
            Coordinates nextCoordinates = new Coordinates(currentY, currentX); // Меняем порядок x и y
            if (currentX < x) {
                currentX++;
            } else {
                currentX = 0;
                currentY++;
            }
            return nextCoordinates;
        }

        @Override
        public void remove() {
            // Empty implementation
        }
    }
}
