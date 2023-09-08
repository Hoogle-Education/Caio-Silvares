package com.caio.agenda.model;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @Builder
@ToString @EqualsAndHashCode
public class Endereco {
    private String CEP;
    private String logradouro;
    private String numero;
    private String cidade;
    private String estado;
}
