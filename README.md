# Segundo Trabalho - API REST (Grupo 6)

## 👥 Integrantes do Grupo
* **Gabriela Montes Gomes Coelho** - [gabrielamontescoelho](https://github.com/gabrielamontescoelho)
* **João Paulo Cordebello** - [jpcordebello](https://github.com/jpcordebello)
* **Lucas Branco Lira** - [lc-lira](https://github.com/lc-lira)
* **Nathália de Queiroz Antunes** - [nathaliaa-qa](https://github.com/nathaliaa-qa)
* **Pedro Lucas da Costa Teixeira** - [pedroteixeira5](https://github.com/pedroteixeira5)

---

## 📝 Sobre o Projeto
Projeto desenvolvido como parte da atividade em grupo para a disciplina de API. O objetivo é construir um sistema de gerenciamento de vendedores e lançamentos de vendas utilizando Spring Boot, Hibernate/JPA e PostgreSQL/H2.

## 🚀 Tecnologias Utilizadas
* Java 17
* Spring Boot (Web, Data JPA, Validation, DevTools)
* PostgreSQL (Produção)
* Banco H2 (Desenvolvimento)
* Swagger / OpenAPI (Documentação)
* Mockaroo (Geração de massa de dados)

## 🛠️ O que foi implementado
* **Modelo de Dados (ORM):** Criação das entidades `Vendedor`, `VendedorAutonomo`, `VendedorProfissional` (com estratégia de herança) e `LancamentoVendas`.
* **Carga Inicial:** População do banco de dados com 1.000 registros de vendedores via `import.sql` gerados no Mockaroo.
* **Validações:** Regras de negócio aplicadas com Bean Validation (validação de e-mail, nome obrigatório e salário mínimo).
* **Tratamento de Erros:** Criação de um `ControllerAdvice` para interceptar e customizar exceções comuns (como `NotFound` e erros de validação).
* **DTOs e Endpoints:** Implementação de Service, Controller e Repository focados em `LancamentoVendas`, retornando os dados formatados via DTO.

## 📁 Como rodar o projeto
1. Clone o repositório.
2. Certifique-se de que o perfil `developer` está ativo no `application.properties` para rodar o banco H2 em arquivo.
3. Execute a aplicação pela sua IDE ou terminal (`mvn spring-boot:run`).
4. Acesse a documentação do Swagger pelo navegador para testar os endpoints (listar por ID e inserir lançamento).