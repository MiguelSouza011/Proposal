# Proposal Management

API REST para gerenciamento de propostas, desenvolvida com Spring Boot, Spring Security, Spring Data JPA e MySQL. A aplicação possui autenticação por sessão e autorização baseada em papéis:

- **INFLUENCER**: pode criar propostas e consultar apenas as próprias propostas.
- **BRAND**: pode consultar todas as propostas.

## Tecnologias

- Java 25
- Spring Boot 4
- Spring Web
- Spring Security
- Spring Data JPA
- MySQL 9
- Gradle
- Docker Compose

## Pré-requisitos

- JDK 25
- Docker e Docker Compose

## Como executar

1. Inicie o banco de dados:

   ```bash
   docker compose up -d
   ```

2. Execute a aplicação:

   ```bash
   ./gradlew bootRun
   ```

   No Windows:

   ```powershell
   .\gradlew.bat bootRun
   ```

   A API ficará disponível em `http://localhost:8080`.

O Spring Boot reconhece o serviço definido no `compose.yml` e inicia a conexão com o MySQL na porta `3307`. O schema é recriado ao iniciar a aplicação, conforme a configuração atual de desenvolvimento.

## Usuários de demonstração

Os usuários abaixo são criados automaticamente quando o banco está vazio. A senha de todos eles é `password`.

| Usuário | Papel |
|---|---|
| `fitness_vibe` | INFLUENCER |
| `tech_guru` | INFLUENCER |
| `logistics` | BRAND |

## Endpoints

### Autenticação

`POST /api/auth/login` realiza o login e cria uma sessão autenticada. Envie as credenciais em JSON:

```json
{
  "username": "fitness_vibe",
  "password": "password"
}
```

O cliente deve guardar e enviar o cookie de sessão nas requisições seguintes.

### Consultar propostas

`GET /proposals`

- Influenciadores recebem somente suas próprias propostas.
- Marcas recebem todas as propostas.

### Criar proposta

`POST /proposals`

Disponível apenas para influenciadores:

```json
{
  "title": "Campanha de verão",
  "description": "Divulgação da nova coleção."
}
```

### Endpoints de teste de autorização

- `GET /influencer`: exclusivo para o papel `INFLUENCER`.
- `GET /brand`: exclusivo para o papel `BRAND`.
- `GET /`: retorna uma mensagem com o identificador do usuário autenticado.

## Testes

Execute os testes automatizados com:

```bash
./gradlew test
```

No Windows:

```powershell
.\gradlew.bat test
```

## Organização do projeto

O código está organizado por funcionalidades:

```text
src/main/java/io/miguelsouza/proposalmanagement
├── auth
│   ├── domain
│   └── infrastructure
└── proposal
    ├── application
    ├── domain
    └── infrastructure
```

- `auth`: autenticação, usuários, papéis e configuração do Spring Security.
- `proposal/application`: casos de uso da aplicação.
- `proposal/domain`: regras e modelos do domínio.
- `proposal/infrastructure`: controllers HTTP e persistência.

Foi um projeto desenvolvido durante os estudos do bootcamp DIO Itaú Java com IA.
