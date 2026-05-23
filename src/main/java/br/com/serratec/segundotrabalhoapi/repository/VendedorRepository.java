package br.com.serratec.segundotrabalhoapi.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.segundotrabalhoapi.model.Vendedor;

public interface VendedorRepository extends JpaRepository<Vendedor, UUID> {

}