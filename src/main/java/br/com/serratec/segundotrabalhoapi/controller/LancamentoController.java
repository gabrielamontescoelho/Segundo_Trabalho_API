package br.com.serratec.segundotrabalhoapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import br.com.serratec.segundotrabalhoapi.dto.LancamentoVendasRequestDTO;
import br.com.serratec.segundotrabalhoapi.dto.LancamentoVendasResponseDTO;
import br.com.serratec.segundotrabalhoapi.service.LancamentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/lancamentos")
public class LancamentoController {

    @Autowired
    private LancamentoService service;

    @Operation(summary = "Buscar lançamento por ID", description = "A resposta retorna os dados do lançamento de venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    content = {@Content(schema = @Schema(implementation = LancamentoVendasResponseDTO.class), mediaType = "application/json")},
                    description = "Retorna o lançamento de venda"),
            @ApiResponse(responseCode = "404", description = "Lançamento não encontrado"),
            @ApiResponse(responseCode = "500", description = "Exceção interna da aplicação")
    })
    @GetMapping("/{id}")
    public LancamentoVendasResponseDTO listarPorId(@PathVariable Long id) {
        return service.listarPorId(id);
    }

    @Operation(summary = "Inserir um lançamento de venda", description = "Cadastra um lançamento de venda")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    content = {@Content(schema = @Schema(implementation = LancamentoVendasResponseDTO.class), mediaType = "application/json")},
                    description = "Cadastra lançamento"),
            @ApiResponse(responseCode = "400", description = "Erro de validação"),
            @ApiResponse(responseCode = "404", description = "Vendedor não encontrado"),
            @ApiResponse(responseCode = "500", description = "Exceção interna da aplicação")
    })
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public LancamentoVendasResponseDTO inserirLancamento(
            @Valid @RequestBody LancamentoVendasRequestDTO dto) {
        return service.inserirLancamento(dto);
    }
}