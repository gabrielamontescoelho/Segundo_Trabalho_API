package br.com.serratec.segundotrabalhoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.serratec.segundotrabalhoapi.dto.LancamentosVendasResponseDTO;
import br.com.serratec.segundotrabalhoapi.model.LancamentoVendas;
import br.com.serratec.segundotrabalhoapi.service.LancamentoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService service;

    @GetMapping("/{id}")
    public LancamentosVendasResponseDTO listarPorId(@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LancamentoVendas inserirLancamento(
            @Valid @RequestBody LancamentoVendas lancamento) {
        return service.inserirLancamento(lancamento);
    }
}