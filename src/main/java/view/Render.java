package view;

import model.Coordinates;
import model.Entity;

public class Render {
    public static void render(SimulationMap map) {


        for (Coordinates coordinate : SimulationMap.getMap().keySet()) {
            Entity entity = SimulationMap.getMap().get(coordinate);

            if (entity != null) {
                System.out.print(entity.getSymbol());
            } else System.out.print(' ');
//            System.out.print(" | y: " + coordinate.getY() + "; x: " + coordinate.getX() + " ");

            if (coordinate.getX() == map.getWidth() - 1)
                System.out.println(); //map.getWidth() always bigger than coordinate.getX()
        }
    }
}
