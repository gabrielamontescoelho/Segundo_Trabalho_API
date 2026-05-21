package br.com.serratec.segundotrabalhoapi.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_lancamento_vendas")
public class LancamentoVendas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // ID numérico sequencial para as vendas [cite: 26]
    
    private LocalDate data; // Data da venda [cite: 27]
    private Double valor; // Valor da venda [cite: 28]

    // Relacionamento ORM: Muitos lançamentos pertencem a UM vendedor [cite: 29, 30]
    @ManyToOne
    @JoinColumn(name = "id_vendedor") // Cria a coluna de chave estrangeira no banco de dados
    private Vendedor vendedor; 

    // Construtor padrão obrigatório do JPA
    public LancamentoVendas() {
    }

    // Construtor completo
    public LancamentoVendas(Long id, LocalDate data, Double valor, Vendedor vendedor) {
        this.id = id;
        this.data = data;
        this.valor = valor;
        this.vendedor = vendedor;
    }

    // --- GETTERS E SETTERS --- [cite: 22]
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public Double getValor() { return valor; }
    public void setValor(Double valor) { this.valor = valor; }

    public Vendedor getVendedor() { return vendedor; }
    public void setVendedor(Vendedor vendedor) { this.vendedor = vendedor; }
}