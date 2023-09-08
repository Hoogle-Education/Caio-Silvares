package com.caio.agenda.service;

import com.caio.agenda.view.ContatoMenu;
import com.caio.agenda.model.Contato;

import java.util.ArrayList;
import java.util.List;

public class ContatoService {

    private List<Contato> contatos = new ArrayList<>();

    public void listarTodosContatos() {
        ContatoMenu.exibir(contatos);
    }

    public void buscarContato() {
        String palavraChave = ContatoMenu.palavraChave();
        var contatosEncontrados = buscaPorPalavraChave(palavraChave);
        ContatoMenu.exibir(contatosEncontrados);
    }

    public void cadastrarContato() {
        Contato paraCadastrar = ContatoMenu.novo();
        contatos.add(paraCadastrar);
    }

    public void removerContato() {
        ContatoMenu.mensagemInicioDeletarContato();
        String palavraChave = ContatoMenu.palavraChave();
        var contatosEncontrados = buscaPorPalavraChave(palavraChave);
        var contatoEscolhido = ContatoMenu.exibirNumeradoAndEscolher(contatosEncontrados);

        if (contatoEscolhido != null && contatos.remove(contatoEscolhido)) {
            ContatoMenu.mensagemContatoDeletado(contatoEscolhido);
        }
    }

    public void removerTodos() {
        contatos.clear();
        ContatoMenu.mensagemTodosDeletados();
    }

    private List<Contato> buscaPorPalavraChave(String palavraChave) {
        return contatos.stream()
            .filter(contato -> {
                boolean temNomeIgual = contato.getNome().toUpperCase().contains(palavraChave.toUpperCase());
                boolean temSobrenomeIgual = contato.getSobrenome().toUpperCase().contains(palavraChave.toUpperCase());
                return temNomeIgual || temSobrenomeIgual;
            }).toList();
    }

}
