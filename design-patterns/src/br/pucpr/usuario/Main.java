import java.util.ArrayList;

import br.pucpr.usuario.PlanetPrinter;

public static void main(String[] args) {
//    var usuarios = new ArrayList<UsuarioPrinter.Usuario>();
//    usuarios.add(new UsuarioPrinter.Usuario(101L, "Carlos Eduardo de Souza", "carlos.souza@email.com", "12345678901"));
//    usuarios.add(new UsuarioPrinter.Usuario(102L, "Ana Maria Silva", "ana.silva@email.com", "98765432100"));
//    usuarios.add(new UsuarioPrinter.Usuario(103L, "João Pedro de Alcântara Bragança", "joao.pedro@email.com", "45678912345"));
//    usuarios.add(new UsuarioPrinter.Usuario(104L, "Mariana Costa", "marianacosta.email.com", "11122233344"));
//    usuarios.add(new UsuarioPrinter.Usuario(105L, "Lucas Mendes", "lucas@email.com", "12345"));
//    usuarios.add(new UsuarioPrinter.Usuario(106L, "", "beatriz@email.com", "55566677788"));
//
//    var printer = new UsuarioPrinter();
//    printer.print(usuarios, true, true, "LIGHT");
    var planetas = new ArrayList<PlanetPrinter.Planet>();
    //String nome, Long diametro, Long distSolKm, Long distSolUa, String tipo
    planetas.add(new PlanetPrinter.Planet("Saturno", 12122.02, 123678901.12, 21312341.12, "Gasoso"));
    planetas.add(new PlanetPrinter.Planet("Terra", 12122.02, 123678901.12, 21312341.12, "Rochoso"));
    var printer = new PlanetPrinter();
    printer.print(planetas, true,"LIGHT");
}