package br.pucpr.usuario;

import java.util.ArrayList;
import java.util.Objects;

public class UsuarioPrinter {
    public record Usuario(Long id, String nome, String email, String cpf) {
    }

    public void print(ArrayList<Usuario> lista, boolean maskCpf, boolean alignRight, String theme) {
        if (lista != null && !lista.isEmpty()) {
            var borderChar = "=";
            if (Objects.equals(theme, "DARK")) {
                borderChar = "#";
            } else if (Objects.equals(theme, "LIGHT")) {
                borderChar = "-";
            }

            // Borda superior e cabeçalho
            var sb = new StringBuilder();
            sb.repeat(borderChar, 74).append("\n");
            sb.append(String.format("| %-5s | %-20s | %-22s | %-14s |\n", "ID", "NOME", "EMAIL", "CPF"));
            sb.repeat(borderChar, 74).append("\n");
            for (var u : lista) {
                if (u != null) {
                    //Formatação do nome
                    var n = u.nome();
                    if (n == null || n.isEmpty()) {
                        n = "NÃO INFORMADO";
                    } else if (n.length() > 20) {
                        n = n.substring(0, 17) + "...";
                    }

                    // Formatação do email
                    var e = u.email();
                    if (e == null || !e.contains("@")) {
                        e = "INVALIDO";
                    }

                    // Formatação do CPF
                    var c = u.cpf();
                    if (c != null && c.length() == 11) {
                        if (maskCpf) {
                            c = "***." + c.substring(3, 6) + "." + c.substring(6, 9) + "-**";
                        } else {
                            c = c.substring(0, 3) + "." + c.substring(3, 6) + "." + c.substring(6, 9) + "-" + c.substring(9, 11);
                        }
                    } else {
                        c = "CPF INVALIDO";
                    }

                    var idStr = u.id() != null ? u.id().toString() : "0";
                    sb.append(String.format("| %-5s | %-20s | %-22s | %-14s |\n", idStr, n, e, c));
                }

                //Borda inferior
                sb.repeat(borderChar, 74).append("\n");

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
            System.out.println("ERRO: Lista de usuários vazia ou nula.");
        }
    }


}