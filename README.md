## API RESTful - Usuários

Uma API REST  construída com Spring Boot demonstrando fundamentos com arquitetura em camadas.
Este repositório é uma demonstração mínima (Controller → Service → Repository, com DTOs e Mapper).

**Tecnologias Utilizadas:**

Java 21 · Spring Boot 4.1.1 · PostgreSQL · Gradle ·
Lombok (utilizado para reduzir boilerplate)

**Decisões Arquiteturais Destacadas:**

* **Isolamento de Dados (DTO Pattern):** Uso de `Records` no Java para separar completamente a Entidade do banco de dados (JPA) dos dados expostos na web, utilizando Mappers customizados.
* **Exclusão Lógica (Soft Delete):** Implementação de exclusão de registros via inativação de flag (`ativo = false`), preservando a integridade referencial e o histórico do banco de dados.
* **Validação de Entrada:** Uso do Jakarta Validation para garantir a integridade dos payloads recebidos.
* **Transações Seguras:** Gerenciamento de commits e rollbacks automáticos na camada de serviço com `@Transactional`.

## Como Executar

**Pré-requisitos:** JDK 21 e PostgreSQL rodando em `localhost:5432`.

**1. Clone o repositório**
```bash
git clone https://github.com/xyz/api-rest-spring-postgres.git
cd api-rest-spring-postgres
```

**2. Crie o banco de dados**
```bash
psql -U postgres -c "CREATE DATABASE api_rest_spring_db;"
```

A aplicação usa `postgres`/`postgres` por padrão. Se o seu PostgreSQL usa outras credenciais, ajuste `src/main/resources/application.properties`.

**3. Execute**
```bash
./gradlew bootRun        # Linux/macOS
gradlew.bat bootRun      # Windows
```

A API sobe em `http://localhost:8090`.

## Endpoints

A api expõe o recurso `/usuarios` com os seguintes métodos:

| Verbo | Endpoint | Descrição                           | Status HTTP | 
| :--- | :--- |:------------------------------------| :--- | 
| **POST** | `/usuarios` | Cadastra um novo usuário            | `201 Created` | 
| **GET** | `/usuarios` | Lista todos os usuários ativos      | `200 OK` | 
| **GET** | `/usuarios/{id}` | Busca um usuário específico pelo ID | `200 OK` | 
| **PUT** | `/usuarios/{id}` | Atualiza os dados de um usuário     | `200 OK` | 
| **DELETE** | `/usuarios/{id}` | Realiza o soft delete de um usuário | `204 No Content` | 
