import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PlanetPrinter {
    //"Nome", "Diâmetro", "Dist. sol (km)", "Dist. sol (ua)", e "Tipo".
    public record Planet(String nome, Double diametro, Double distSolKm, Double distSolUa, String tipo) {
    }

    private String formatNome(String nome) {
        if (nome == null || nome.isEmpty()) return "NÃO INFORMADO";
        if (nome.length() > 20) return nome.substring(0, 17) + "...";
        return nome;
    }

    private String formatDistancias(Double valor, String formato) {
        if (valor == null) return "NÃO INFORMADO";
        return String.format(formato, valor);
    }

    private void printOutput(StringBuilder sb, boolean alignRight) {
        if (!alignRight) {
            System.out.print(sb);
            return;
        }
        for (var line : sb.toString().split("\n")) {
            System.out.println("                    " + line);
        }
    }



    private static final List<String> TIPOS_VALIDOS = List.of("Rochoso", "Gasoso", "Anão", "Gelado");

    private String formatTipo(String tipo) {
        if (tipo == null || !TIPOS_VALIDOS.contains(tipo)) return "INVÁLIDO";
        return tipo;
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
                if (planeta == null) continue;

                var nome = formatNome(planeta.nome());
                var diametro  = formatDistancias(planeta.diametro(), "%.2f");
                var distSolKm = formatDistancias(planeta.distSolKm(), "%.2e");
                var distSolUa = formatDistancias(planeta.distSolUa(), "%.2e");
                var tipo = formatTipo(planeta.tipo());


                sb.append(String.format("| %-5s | %-20s | %-22s | %-14s | %-14s \n",
                        nome, diametro, distSolKm, distSolUa, tipo
                ));


                //Borda inferior
                sb.repeat(borderChar, 100).append("\n");
                printOutput(sb, alignRight);
            }
        } else {
            System.out.println("ERRO: Lista de planetas vazia ou nula.");
        }
    }

}