package br.com.serratec.segundotrabalhoapi.model;

import java.util.UUID;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("AUTONOMO")
public class VendedorAutonomo extends Vendedor {

    private Double comissao;

    public VendedorAutonomo() {
    }

    public VendedorAutonomo(UUID id, String nome, String email, Double salario, Double comissao) {
        super(id, nome, email, salario);
        this.comissao = comissao;
    }

    public Double getComissao() {
        return comissao;
    }

    public void setComissao(Double comissao) {
        this.comissao = comissao;
    }

}
