package controller;

import model.Coordinates;
import model.Creature;
import model.Entity;
import model.EntityType;
import view.Render;
import view.SimulationMap;

import java.util.HashMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class Actions {
    static void nextTurn() {
        TreeMap<Coordinates, Entity> map = SimulationMap.getMap();
        HashMap<Coordinates, Entity> mapCopy = new HashMap<>(map);

        for (Coordinates coordinate : mapCopy.keySet()) {
            if (map.get(coordinate).getEntityType() == EntityType.HERBIVORE ||
                    map.get(coordinate).getEntityType() == EntityType.PREDATOR) {
                ((Creature) map.get(coordinate)).makeMove(coordinate);
            }
        }
    }

    static void startSimulation(int width, int height) {
        SimulationMap map = new SimulationMap(width, height);
        int turnNumber = 0;

        Render.render(map);
        System.out.println();

        do {
            turnNumber++;
            System.out.println("Turn number: " + turnNumber);
            nextTurn();
            Render.render(map);
            System.out.println();

        } while (!pauseSimulation(turnNumber));
    }


    static boolean pauseSimulation(int turnNumber) {
        return turnNumber % 5 == 0;
    }
}

