package com.michel.conroleveiculos.api.controller;
import com.michel.conroleveiculos.Groups;
import com.michel.conroleveiculos.domain.model.Veiculo;
import com.michel.conroleveiculos.domain.repository.VeiculoRepository;
import com.michel.conroleveiculos.domain.service.CadastroVeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private CadastroVeiculoService cadastroVeiculoService;

    @GetMapping
    public List<Veiculo> listar(){
        return veiculoRepository.findAll();
    }

    @GetMapping(params = "rodizio-ativo=true")
    public List<Veiculo> listarComRodizioAtivo(){
        return veiculoRepository.listarVeiculosComRodizioAtivo();
    }

    @GetMapping("/{veiculoId}")
    public Veiculo buscar (@PathVariable Long veiculoId){
        return cadastroVeiculoService.buscarOuFalhar(veiculoId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo adicionar (@RequestBody @Valid Veiculo veiculo){
        return cadastroVeiculoService.salvar(veiculo);
    }

    @DeleteMapping("/{veiculoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover (@PathVariable Long  veiculoId) {
         cadastroVeiculoService.excluir(veiculoId);
    }

}

