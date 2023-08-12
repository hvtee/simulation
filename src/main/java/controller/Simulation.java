package controller;

import model.Coordinates;
import model.Entity;
import view.Render;
import view.SimulationMap;

import java.util.Map;

public class Simulation {
    public static void main(String[] args) {
        SimulationMap map = new SimulationMap(5, 5);
        Render.render(map);
        System.out.println();
    }
}
