package com.michel.conroleveiculos.domain.model;

import com.michel.conroleveiculos.Groups;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Veiculo {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(groups = Groups.CadastroVeiculo.class)
    @Column(nullable = false)
    private String marca;

    @NotBlank(groups = Groups.CadastroVeiculo.class)
    @Column(nullable = false)
    private String modelo;

    @NotBlank(groups = Groups.CadastroVeiculo.class)
    @Column(nullable = false)
    private String ano;

    @NotNull(groups = Groups.CadastroVeiculo.class)
    @Column(nullable = false)
    private Boolean rodizioAtivo;

    //Fazer o Valid pelo ID cascateando
    @Valid
    @ConvertGroup(to = Groups.CadastroVeiculo.class)
    @ManyToOne
    @JoinColumn(nullable = false)
    private Usuario usuario;

}
