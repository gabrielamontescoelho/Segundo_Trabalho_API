package br.com.serratec.segundotrabalhoapi.model;

import java.util.UUID;

import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import jakarta.persistence.DiscriminatorType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_vendedor", discriminatorType = DiscriminatorType.STRING)
public abstract class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(max = 60, message = "O nome deve ter no máximo 60 caracteres")
    private String nome;

    @Email(message = "O e-mail deve ser válido")
    private String email;

    @Min(value = 1600, message = "O salário não pode ser inferior ao salário mínimo") 
    private Double salario;

    public Vendedor() {
    }

    public Vendedor(UUID id, String nome, String email, Double salario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.salario = salario;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

}
