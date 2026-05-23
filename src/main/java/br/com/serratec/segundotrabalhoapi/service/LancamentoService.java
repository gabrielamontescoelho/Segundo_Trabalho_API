package br.com.serratec.segundotrabalhoapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.segundotrabalhoapi.dto.LancamentoVendasRequestDTO;
import br.com.serratec.segundotrabalhoapi.dto.LancamentoVendasResponseDTO;
import br.com.serratec.segundotrabalhoapi.exception.NotFoundException;
import br.com.serratec.segundotrabalhoapi.model.LancamentoVendas;
import br.com.serratec.segundotrabalhoapi.model.Vendedor;
import br.com.serratec.segundotrabalhoapi.repository.LancamentoRepository;
import br.com.serratec.segundotrabalhoapi.repository.VendedorRepository;

@Service
public class LancamentoService {

    @Autowired
    private LancamentoRepository lancamentoRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public LancamentoVendasResponseDTO inserirLancamento(LancamentoVendasRequestDTO dto) {

        Vendedor vendedor = vendedorRepository.findById(dto.idVendedor())
                .orElseThrow(() -> new NotFoundException("Vendedor com ID " + dto.idVendedor() + " não encontrado."));

        LancamentoVendas lancamento = new LancamentoVendas();
        lancamento.setData(dto.data());
        lancamento.setValor(dto.valor());
        lancamento.setVendedor(vendedor);

        LancamentoVendas lancamentoSalvo = lancamentoRepository.save(lancamento);

        return new LancamentoVendasResponseDTO(lancamentoSalvo);
    }

    public LancamentoVendasResponseDTO listarPorId(Long id) {

        LancamentoVendas lancamento = lancamentoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Lançamento com ID " + id + " não encontrado."));

        return new LancamentoVendasResponseDTO(lancamento);
    }
}