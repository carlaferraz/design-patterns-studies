package br.pucpr.usuario;

import java.util.ArrayList;
import java.util.Objects;

public class PlanetPrinter {
    //"Nome", "Diâmetro", "Dist. sol (km)", "Dist. sol (ua)", e "Tipo".
    public record Planet(String nome, Double diametro, Double distSolKm, Double distSolUa, String tipo) {
    }

    public void print(ArrayList<Planet> lista, boolean alignRight, String theme) {
        if (lista != null && !lista.isEmpty()) {
            var borderChar = "=";
            if (Objects.equals(theme, "DARK")) {
                borderChar = "#";
            } else if (Objects.equals(theme, "LIGHT")) {
                borderChar = "-";
            }

            // Borda superior e cabeçalho
            var sb = new StringBuilder();
            sb.repeat(borderChar, 100).append("\n");
                sb.append(String.format("| %-5s | %-20s | %-22s | %-14s | %-14s |\n", "NOME", "DIAMETRO", "DISTSOLKM", "DISTSOLUA", "TIPO"));
            sb.repeat(borderChar, 100).append("\n");
            for (var planeta : lista) {
                if (planeta != null) {
                    //Formatação do nome
                    var nome = planeta.nome();
                    if (nome == null || nome.isEmpty()) {
                        nome = "NÃO INFORMADO";
                    } else if (nome.length() > 20) {
                        nome = nome.substring(0, 17) + "...";
                    }

                    var diametro = planeta.diametro();
                    String diametroStr;
                    if (diametro == null) {
                        diametroStr = "NÃO INFORMADO";
                    } else {
                        diametroStr = String.format("%.2f", diametro);
                    }

                    var distSolKm = planeta.distSolKm();
                      String distSolKmStr;
                      if (distSolKm == null) {
                          distSolKmStr = "NÃO INFORMADO";
                      } else {
                          distSolKmStr = String.format("%.2e", distSolKm);
                      }

                    var distSolUa = planeta.distSolUa();
                    String distSolUaStr;
                    if (distSolUa == null) {
                        distSolUaStr = "NÃO INFORMADO";
                    } else {
                        distSolUaStr = String.format("%.2e", distSolUa);
                    }

                    var tiposValidos = java.util.List.of("Rochoso", "Gasoso", "Anão", "Gelado");

                    var tipo = planeta.tipo();
                    if (tipo == null || !tiposValidos.contains(tipo)) {
                        tipo = "INVÁLIDO";
                    }


                    sb.append(String.format("| %-5s | %-20s | %-22s | %-14s | %-14s | \n", nome, diametroStr,
                            distSolKmStr,
                            distSolUaStr,
                            tipo   ));
                }

                //Borda inferior
                sb.repeat(borderChar, 100).append("\n");

                //Espaçamento
                if (alignRight) {
                    var lines = sb.toString().split("\n");
                    for (var line : lines) {
                        System.out.println("                    " + line);
                    }
                } else {
                    System.out.print(sb);
                }
            }
        } else {
            System.out.println("ERRO: Lista de planetas vazia ou nula.");
        }
    }

}
