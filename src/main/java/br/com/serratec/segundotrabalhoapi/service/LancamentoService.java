package br.com.serratec.segundotrabalhoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.segundotrabalhoapi.dto.LancamentoVendasResponseDTO;
import br.com.serratec.segundotrabalhoapi.exception.NotFoundException; 
import br.com.serratec.segundotrabalhoapi.model.LancamentoVendas;
import br.com.serratec.segundotrabalhoapi.repository.LancamentoRepository;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    public LancamentoVendas inserirLancamento(LancamentoVendas lancamento) {
        return lancamentoRepository.save(lancamento);
    }

    public LancamentoVendasResponseDTO listarPorId(Long id) {
        
        LancamentoVendas lancamento = lancamentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lançamento com ID " + id + " não encontrado."));

        return new LancamentoVendasResponseDTO(lancamento);
    }
}