package br.com.serratec.segundotrabalhoapi.model;

import java.util.UUID;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("PROFISSIONAL")
public class VendedorProfissional extends Vendedor {
    private String cnpj;

    public VendedorProfissional() {
        super();
    }

    public VendedorProfissional(UUID id, String nome, String email, Double salario, String cnpj) {
        super(id, nome, email, salario);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }
}
