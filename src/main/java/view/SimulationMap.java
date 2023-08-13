package view;

import model.*;

import java.util.HashMap;
import java.util.Random;
import java.util.TreeMap;

public class SimulationMap {
    private final int width;
    private final int height;
    private static TreeMap<Coordinates, Entity> map;

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public static TreeMap<Coordinates, Entity> getMap() {
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

        int totalCells = width * height;
        int maxPredatorCells = totalCells * 5 / 100;    // 10% для хищников
        int maxHerbivoreCells = totalCells * 10 / 100;   // 20% для травоядных
        int maxGrassCells = totalCells * 20 / 100;       // 30% для травы
        int maxRockCells = totalCells * 5 / 100;        // 10% для скал
        int maxTreeCells = totalCells * 5 / 100;        // 10% для деревьев

        int predatorQuantity = 0;
        int herbivoreQuantity = 0;
        int grassQuantity = 0;
        int rockQuantity = 0;
        int treeQuantity = 0;
        int voidQuantity = 0;

        for (int y = 0; y < width; y++) {
            for (int x = 0; x < height; x++) {
                int randomNum = random.nextInt(7);

                if (predatorQuantity < maxPredatorCells && randomNum == 0) {
                    map.put(new Coordinates(y, x), new Predator());
                    predatorQuantity++;
                } else if (herbivoreQuantity < maxHerbivoreCells && randomNum == 1) {
                    map.put(new Coordinates(y, x), new Herbivore());
                    herbivoreQuantity++;
                } else if (grassQuantity < maxGrassCells && randomNum == 2) {
                    map.put(new Coordinates(y, x), new Grass());
                    grassQuantity++;
                } else if (rockQuantity < maxRockCells && randomNum == 3) {
                    map.put(new Coordinates(y, x), new Rock());
                    rockQuantity++;
                } else if (treeQuantity < maxTreeCells && randomNum == 4) {
                    map.put(new Coordinates(y, x), new Tree());
                    treeQuantity++;
                } else {
                    map.put(new Coordinates(y, x), null);
                    voidQuantity++;
                }
            }
        }
        System.out.println("Total Predators: " + predatorQuantity);
        System.out.println("Total Herbivores: " + herbivoreQuantity);
        System.out.println("Total Grass: " + grassQuantity);
        System.out.println("Total Rocks: " + rockQuantity);
        System.out.println("Total Trees: " + treeQuantity);
        System.out.println("Total void: " + voidQuantity);
    }

    public boolean isCellEmpty(Coordinates coordinates) {
        return map.get(coordinates) == null;
    }


}
