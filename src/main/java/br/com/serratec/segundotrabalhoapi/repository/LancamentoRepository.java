package br.com.serratec.segundotrabalhoapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.segundotrabalhoapi.model.LancamentoVendas;

@Repository
public interface LancamentoRepository extends JpaRepository<LancamentoVendas, Long> {
}
