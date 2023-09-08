package com.caio.agenda.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Contato { // dificil de extender, entender e mudar

    @NonNull private String nome;
    @NonNull private String sobrenome;
    private List<Telefone> telefones = new ArrayList<>();
    private List<Endereco> enderecos = new ArrayList<>();

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }

    public void addTelefone(Telefone telefone) {
        telefones.add(telefone);
    }

    public boolean removeTelefone(Telefone telefone) {
        return telefones.remove(telefone);
    }

    public void addEndereco(Endereco endereco) {
        enderecos.add(endereco);
    }

    public boolean removeEndereco(Endereco endereco) {
        return enderecos.remove(endereco);
    }
}
