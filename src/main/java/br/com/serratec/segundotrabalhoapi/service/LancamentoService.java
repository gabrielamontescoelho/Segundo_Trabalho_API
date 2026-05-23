package br.com.serratec.segundotrabalhoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.segundotrabalhoapi.exception.NotFoundException;
import br.com.serratec.segundotrabalhoapi.model.LancamentoVendas;
import br.com.serratec.segundotrabalhoapi.repository.LancamentoRepository;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    // 1. Método para inserir um novo lançamento exigido pelo trabalho
    public LancamentoVendas inserirLancamento(LancamentoVendas lancamento) {
        return lancamentoRepository.save(lancamento);
    }

    // 2. Método para buscar pelo ID
    // NOTA: O trabalho pede para retornar o DTO aqui. Se o grupo já tiver criado
    // a classe "LancamentoVendasResponseDTO", você pode mudar o tipo de retorno!
    public LancamentoVendas listarPorId(Long id) {
        return lancamentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lançamento com ID " + id + " não encontrado."));
    }
}
