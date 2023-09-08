package com.caio.agenda.view;

import com.caio.agenda.model.Contato;

import java.util.List;
import java.util.Scanner;

public class ContatoMenu {

    private static Scanner scanner = new Scanner(System.in);

//    public static <T, R> void line(Function<T, R> function) {
//        System.out.println("----------------------------------");
//        function.apply();
//        System.out.println("----------------------------------");
//    }
//
//    public static <R> void line(Supplier<T, R> function) {
//        System.out.println("----------------------------------");
//        function.apply();
//        System.out.println("----------------------------------");
//    }
//
// filter, forEach, map

    public static void exibir(List<Contato> contatos) {
        contatos.forEach(System.out::println);
    }

    public static void exibirNumerado(List<Contato> contatos) {
        for (int i = 0; i < contatos.size(); i++) {
            System.out.println("#" + (i + 1) + " - " + contatos.get(i));
        }
    }

    public static Contato exibirNumeradoAndEscolher(List<Contato> contatos) {
        exibirNumerado(contatos);
        System.out.print("Escolha um Id para deletar: ");
        int id = scanner.nextInt() - 1;
        if(id < 0 || id >= contatos.size()) {
            System.out.println("Contato invalido escolhido");
            return null;
        }

        return contatos.get(id);
    }

    public static String palavraChave() {
        System.out.print("Digite uma palavra-chave para buscar: ");
        String palavraChave = scanner.nextLine();

        return palavraChave;
    }

    public static Contato novo() {
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o sobrenome: ");
        String sobrenome = scanner.nextLine();

        return new Contato(nome, sobrenome);
    }

    public static void mensagemTodosDeletados(){
        System.out.println("Todos os contatos removidos");
    }

    public static void mensagemInicioDeletarContato() {
        System.out.println("Busque por uma palavra chave e escolha um para ser deletado");
    }

    public static void mensagemContatoDeletado(Contato contato) {
        System.out.println("O contato: " + contato.getNomeCompleto() + " foi removido");
    }
}
