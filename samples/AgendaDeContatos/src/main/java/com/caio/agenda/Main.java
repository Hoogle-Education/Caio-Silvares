package com.caio.agenda;

import com.caio.agenda.service.ContatoService;
import com.caio.agenda.view.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        MenuPrincipal.bemVindo();

        ContatoService service = new ContatoService();

        MenuPrincipal.exibir();

        service.cadastrarContato();
        service.cadastrarContato();
        service.cadastrarContato();
        service.cadastrarContato();

        service.removerContato();
        service.listarTodosContatos();

//        service.listarTodosContatos();
//        service.buscarContato();
//        System.out.println("-----------");
//        service.removerTodos();
//        System.out.println("-----------");
//        System.out.println("-----------");
    }
}