package view;

import model.*;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class SimulationMap {
    private final int width;
    private final int height;
    private final TreeMap<Coordinates, Entity> map;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public TreeMap<Coordinates, Entity> getMap() {
        return map;
    }

    public SimulationMap(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new TreeMap<>();
        fillMap();
    }

    public void fillMap() {
        Random random = new Random();
        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                int randomNum = random.nextInt(6);
                switch (randomNum) {
                    case 0:
                        map.put(new Coordinates(y, x), new Herbivore());
                        break;
                    case 1:
                        map.put(new Coordinates(y, x), new Predator());
                        break;
                    case 2:
                        map.put(new Coordinates(y, x), new Grass());
                        break;
                    case 3:
                        map.put(new Coordinates(y, x), new Rock());
                        break;
                    case 4:
                        map.put(new Coordinates(y, x), new Tree());
                        break;
                    case 5:
                        map.put(new Coordinates(y, x), null);
                        break;
                }
            }
        }
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return map.get(coordinates) == null;
    }


}
