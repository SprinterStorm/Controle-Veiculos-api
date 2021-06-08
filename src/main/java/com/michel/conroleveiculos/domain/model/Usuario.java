package com.michel.conroleveiculos.domain.model;

import com.michel.conroleveiculos.Groups;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Usuario {

    @NotNull(groups = Groups.CadastroVeiculo.class)
    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String nome;

    @Email
    @Column(nullable = false)
    private String email;

    @CPF
    @Column(nullable = false)
    private String cpf;

    @NotNull
    @Column(nullable = false, columnDefinition = "datetime")
    private OffsetDateTime dataNascimento;

}
