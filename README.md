# API RESTful - Usuários

Uma API RESTful fundacional construída com Spring Boot para demonstrar a aplicação de boas práticas de mercado, Clean Code e arquitetura em camadas (Vertical Slicing).
Este repositório foi desenvolvido para consolidar os fundamentos da construção de APIs corporativas, evitando overengineering e focando em um design limpo e escalável.

**Tecnologias Utilizadas:**

* Java 21
* Spring Boot 3.x
* PostgreSQL
* Lombok (Exclusivamente para injeção de dependências via construtor e redução de boilerplate)

**Decisões Arquiteturais Destacadas:**

* **Isolamento de Dados (DTO Pattern):** Uso de `Records` no Java para separar completamente a Entidade do banco de dados (JPA) dos dados expostos na web, utilizando Mappers customizados.
* **Exclusão Lógica (Soft Delete):** Implementação de exclusão de registros via inativação de flag (`ativo = false`), preservando a integridade referencial e o histórico do banco de dados.
* **Validação de Entrada:** Uso do Jakarta Validation para garantir a integridade dos payloads recebidos.
* **Transações Seguras:** Gerenciamento de commits e rollbacks automáticos na camada de serviço com `@Transactional`.

## Como Executar

**1. Clone o repositório:**
```bash
git clone https://github.com/welxyz/crud-mvc-java.git
```

**2. Configure o banco de dados:**
Abra `application.properties` e insira as credenciais do seu PostgreSQL local:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update
```

## Endpoints

A API expõe o recurso `/usuarios` com os seguintes métodos:

| Verbo | Endpoint | Descrição | Status HTTP | 
| :--- | :--- | :--- | :--- | 
| **POST** | `/usuarios` | Cadastra um novo usuário | `201 Created` | 
| **GET** | `/usuarios` | Lista todos os usuários cadastrados | `200 OK` | 
| **GET** | `/usuarios/{id}` | Busca um usuário específico pelo ID | `200 OK` | 
| **PUT** | `/usuarios/{id}` | Atualiza os dados de um usuário | `200 OK` | 
| **DELETE** | `/usuarios/{id}` | Realiza o soft delete de um usuário | `204 No Content` | 
