import planet.Planet;
import planet.PlanetPrinter;


import java.util.ArrayList;

public static void main(String[] args) {
    var planetas = new ArrayList<Planet>();
    planetas.add(new Planet("Saturno", 12122.02, 123678901.12, 21312341.12, "Gasoso"));
    planetas.add(new Planet("Terra", 12122.02, 123678901.12, 21312341.12, "Rochoso"));
    var printer = new PlanetPrinter();
    printer.print(planetas, true,"LIGHT");
}