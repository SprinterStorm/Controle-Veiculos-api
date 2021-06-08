package com.michel.conroleveiculos.domain.service;

import com.michel.conroleveiculos.domain.exception.EntidadeEmUsoException;
import com.michel.conroleveiculos.domain.exception.UsuarioNaoEncontradoException;
import com.michel.conroleveiculos.domain.model.Usuario;
import com.michel.conroleveiculos.domain.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CadastroUsuarioService {

    private static final String MSG_USARIO_EM_USO =
            "Usuario de código %d não pode ser removido, pois está em uso";

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Transactional
    public Usuario salvar(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    @Transactional
    public void excluir(Long usuarioId) {
        try {
        usuarioRepository.deleteById(usuarioId);
        usuarioRepository.flush();

        } catch (EmptyResultDataAccessException e) {
            throw new UsuarioNaoEncontradoException(usuarioId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_USARIO_EM_USO, usuarioId));
        }
    }

    public Usuario buscarOuFalhar(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
                .orElseThrow( () -> new UsuarioNaoEncontradoException(usuarioId));
    }

}
