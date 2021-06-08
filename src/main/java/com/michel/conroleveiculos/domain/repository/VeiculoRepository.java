package com.michel.conroleveiculos.domain.repository;

import com.michel.conroleveiculos.domain.model.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VeiculoRepository extends CustomJpaRepository<Veiculo, Long> {

    @Query("FROM Veiculo v WHERE v.rodizioAtivo = true")
    List<Veiculo> listarVeiculosComRodizioAtivo();
}
