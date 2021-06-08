package com.michel.conroleveiculos.api.controller;

import com.michel.conroleveiculos.domain.model.Usuario;
import com.michel.conroleveiculos.domain.repository.UsuarioRepository;
import com.michel.conroleveiculos.domain.service.CadastroUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private CadastroUsuarioService cadastroUsuarioService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> listar(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{usuarioId}")
    public Usuario buscar (@PathVariable Long usuarioId){
        return cadastroUsuarioService.buscarOuFalhar(usuarioId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario adicionar (@RequestBody @Valid Usuario usuario){
        return cadastroUsuarioService.salvar(usuario);
    }

    @DeleteMapping("{usuarioId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long usuarioId) {
        cadastroUsuarioService.excluir(usuarioId);
    }
}
