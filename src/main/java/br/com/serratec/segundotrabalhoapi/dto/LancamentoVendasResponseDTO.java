package br.com.serratec.segundotrabalhoapi.dto;

import java.time.LocalDate;

import br.com.serratec.segundotrabalhoapi.model.LancamentoVendas;

    public record LancamentoVendasResponseDTO(LocalDate data,Double valor, String nomeVendedor) {

    public LancamentoVendasResponseDTO(LancamentoVendas lancamentoVendas){
        this(
            lancamentoVendas.getData(),
            lancamentoVendas.getValor(),
            lancamentoVendas.getVendedor().getNome()
        );
    }
}
