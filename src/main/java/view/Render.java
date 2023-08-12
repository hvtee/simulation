package view;

import model.Coordinates;
import model.Entity;

public class Render {
    public static void render(SimulationMap map) {

        System.out.print("+");
        for (int i = 0; i < map.getWidth(); i++) {
            System.out.print("-");
        }
        System.out.println("+");

        for (Coordinates coordinate : map.getMap().keySet()) {
            Entity entity = map.getMap().get(coordinate);

            if (entity != null) {
                System.out.print(entity.getSymbol());
            } else System.out.print(' ');
//            System.out.print(" | y: " + coordinate.getY() + "; x: " + coordinate.getX() + " ");

            if (coordinate.getX() == map.getWidth() - 1) System.out.println(); //map.getWidth() always bigger than coordinate.getX()

            System.out.print("|");
        }

        // Вывод нижней рамки
        System.out.print("+");
        for (int i = 0; i < map.getWidth(); i++) {
            System.out.print("-");
        }
        System.out.println("+");
    }
}
