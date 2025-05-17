```markdown
# 🏬 Loja de Produtos - Arquitetura de Microserviços

Este projeto é uma loja online construída com arquitetura **orientada a domínio** (DDD), seguindo os princípios da **Clean Architecture** e **Ports and Adapters (Hexagonal Architecture)**.

Cada microserviço é independente e se comunica via **Apache Kafka**, utilizando troca de mensagens assíncronas.

---

## 🧱 Arquitetura

### Camadas principais por serviço:

```

product-service/
└── src/
└── main/java/com/store/product/
├── entrypoints/         ← Entradas do sistema (REST, Kafka listeners, etc.)
│   └── rest/            ← Controllers HTTP
│   └── messaging/       ← Listeners Kafka (consumo de mensagens)
│
├── application/         ← Lógica de aplicação
│   ├── usecases/        ← Interfaces dos casos de uso
│   ├── services/        ← Implementações dos casos de uso
│   ├── commands/        ← DTOs de entrada para os casos de uso
│   └── ports/
│       ├── in/          ← Interfaces chamadas pela camada externa
│       └── out/         ← Interfaces que chamam adaptadores (DB, Kafka, etc.)
│
├── domain/              ← Entidades e regras de negócio puras
│   ├── model/
│   └── exceptions/
│
├── infrastructure/      ← Implementações concretas (adaptadores)
│   ├── persistence/     ← JPA, Repositórios, etc.
│   └── messaging/       ← Kafka Producers, Serializers
│
└── ProductServiceApplication.java

````

---

## 🧩 Microserviços

| Serviço           | Responsabilidade                                |
|------------------|--------------------------------------------------|
| `product-service`| Gestão de produtos da loja                       |
| `order-service`  | Processamento e rastreio de pedidos              |
| `inventory-service`| Controle de estoque e sincronização            |
| `payment-service`| Processamento de pagamentos                      |
| `notification-service`| Envio de e-mails e notificações Kafka        |

---

## 📦 Tecnologias Utilizadas

- **Java 17 + Spring Boot 3**
- **Apache Kafka** (mensageria assíncrona)
- **PostgreSQL** (persistência relacional)
- **Spring Data JPA**
- **Lombok**
- **MapStruct** (opcional para mapeamentos)
- **Docker + Docker Compose** (infraestrutura local)
- **Testcontainers** (testes de integração)
- **Jaeger + OpenTelemetry** (observabilidade)

---

## 📬 Comunicação Assíncrona

Todos os eventos entre os serviços são trocados via **Apache Kafka**, com tópicos como:

- `product-created`
- `order-created`
- `inventory-updated`
- `payment-processed`
- `notification-email`

Exemplo de fluxo:
1. `product-service` publica evento `product-created`
2. `inventory-service` consome e atualiza o estoque
3. `order-service` consome e cria um pedido com esse produto
4. `notification-service` envia notificação ao cliente

---

## ▶️ Como Executar Localmente

### Pré-requisitos:

- Docker e Docker Compose instalados
- Java 17
- Kafka + Zookeeper (já incluídos no `docker-compose.yml`)

### Subindo a infraestrutura:

```bash
docker-compose up -d
````

### Rodando um microserviço (ex: product-service):

```bash
cd product-service
./mvnw spring-boot:run
```

---

## 🧪 Testes

```bash
./mvnw test
```

Testes unitários e de integração com:

* JUnit 5
* Mockito
* Testcontainers (Kafka/Postgres)

---

## 📁 Padrões e Convenções

* Cada serviço segue **Clean Architecture**
* **Casos de uso** são explicitamente definidos
* Uso de **Ports (in/out)** para isolamento
* Nenhuma camada conhece outra diretamente, exceto via interfaces

---

## 📚 Futuro

* Integração com **Keycloak** para autenticação
* Suporte a **Event Sourcing** e **CQRS**
* Painel de administração em Angular/React

---

## 🛡️ Licença

MIT License.
