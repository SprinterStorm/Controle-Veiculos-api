package com.michel.conroleveiculos.domain.service;

import com.michel.conroleveiculos.domain.exception.EntidadeEmUsoException;
import com.michel.conroleveiculos.domain.exception.UsuarioNaoEncontradoException;
import com.michel.conroleveiculos.domain.exception.VeiculoNaoEncontradoException;
import com.michel.conroleveiculos.domain.model.Usuario;
import com.michel.conroleveiculos.domain.model.Veiculo;
import com.michel.conroleveiculos.domain.repository.UsuarioRepository;
import com.michel.conroleveiculos.domain.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroVeiculoService {

    private static final String MSG_VEICULOS_EM_USO =
            "Veiculo de código %d não pode ser removido, pois está em uso";

    @Autowired
    private VeiculoRepository veiculosRepository;

    @Transactional
    public Veiculo salvar(Veiculo veiculo){
        return veiculosRepository.save(veiculo);
    }

    @Transactional
    public void excluir(Long veiculoId) {
        try {
            veiculosRepository.deleteById(veiculoId);
            veiculosRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new VeiculoNaoEncontradoException(veiculoId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_VEICULOS_EM_USO, veiculoId));
        }
    }

    public Veiculo buscarOuFalhar(Long veiculoId) {
        return veiculosRepository.findById(veiculoId)
                .orElseThrow(() -> new VeiculoNaoEncontradoException(veiculoId));
    }
}
