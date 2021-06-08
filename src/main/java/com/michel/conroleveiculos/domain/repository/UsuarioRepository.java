package com.michel.conroleveiculos.domain.repository;


import com.michel.conroleveiculos.domain.model.Usuario;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {
}
