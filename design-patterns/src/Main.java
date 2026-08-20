import java.util.ArrayList;

public static void main(String[] args) {
    var planetas = new ArrayList<PlanetPrinter.Planet>();
    planetas.add(new PlanetPrinter.Planet("Saturno", 12122.02, 123678901.12, 21312341.12, "Gasoso"));
    planetas.add(new PlanetPrinter.Planet("Terra", 12122.02, 123678901.12, 21312341.12, "Rochoso"));
    var printer = new PlanetPrinter();
    printer.print(planetas, true,"LIGHT");
}