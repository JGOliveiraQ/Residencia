# StockManager

Backend REST para controle de estoque de distribuidoras de materiais de construção.

## Tecnologias

Java 21, Spring Boot 3.4, Spring Web, Spring Data JPA/Hibernate, Spring Security, JWT, H2, Flyway, JUnit 5 e Springdoc OpenAPI.

## Execução

Pré-requisitos: JDK 21 e Maven 3.9 ou superior.

1. Copie `.env.example` para `.env` e configure principalmente `JWT_SECRET` e as variáveis `INITIAL_ADMIN_*`.
2. Execute `mvn clean test`.
3. Execute `mvn spring-boot:run`.

O perfil `dev` usa H2 persistido em `./data/stockmanager`. O console fica em `/h2-console` apenas no perfil de desenvolvimento. Swagger fica em `/swagger-ui/index.html`.

## Endpoints principais

- `POST /api/auth/login` e `GET /api/auth/me`
- CRUD de categorias em `/api/categories`
- CRUD de produtos em `/api/products`
- CRUD de fornecedores em `/api/suppliers`
- Usuários administrativos em `/api/users`
- Entradas, saídas e ajustes em `/api/stock-movements`
- Indicadores em `/api/dashboard/summary`
- CSV de estoque em `/api/reports/stock` e `/api/reports/low-stock`

Todas as rotas, exceto login, Swagger e console de desenvolvimento, exigem JWT Bearer. Operações administrativas são restritas ao perfil ADMIN; entradas e saídas podem ser realizadas por usuários autenticados. O estoque só é alterado por movimentações transacionais.

## Estrutura

O código está organizado em `config`, `security`, `controller`, `service`, `repository`, `entity`, `dto`, `enums` e `exception`. A migração inicial está em `src/main/resources/db/migration`.
