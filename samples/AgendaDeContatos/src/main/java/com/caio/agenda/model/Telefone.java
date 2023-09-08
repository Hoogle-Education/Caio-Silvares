package com.caio.agenda.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString @EqualsAndHashCode
public class Telefone {
    private String DDD;
    private String numero;

    public Telefone(String numeroCompleto) {
        // "21 99999-8888" = ["21", "99999-8888"]
        String[] data = numeroCompleto.split(" ");
        this.DDD = data[0];
        this.numero = data[1];
    }

}
