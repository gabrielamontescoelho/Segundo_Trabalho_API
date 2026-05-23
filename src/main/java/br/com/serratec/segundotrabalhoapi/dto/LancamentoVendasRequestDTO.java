package br.com.serratec.segundotrabalhoapi.dto;

import java.time.LocalDate;
import java.util.UUID;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record LancamentoVendasRequestDTO(

        @NotNull(message = "A data da venda é obrigatória")
        LocalDate data,

        @NotNull(message = "O valor da venda é obrigatório")
        @Positive(message = "O valor da venda deve ser maior que zero")
        Double valor,

        @NotNull(message = "O vendedor é obrigatório")
        UUID idVendedor
) {
}