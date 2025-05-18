```markdown
# Loja de Produtos - Microserviços com Clean Architecture e Kafka

Este projeto é uma solução baseada em microserviços para uma loja online, construída com **Java Spring Boot**, aplicando
a **Clean Architecture** com alguns principios da **Hexagonal Architecture** e comunicação assíncrona por meio do **Apache Kafka**.

---

## 🚀 Tecnologias Utilizadas

- Java 21 + Spring Boot 3.x  
- Apache Kafka  
- PostgreSQL + Spring Data JPA  
- Docker e Docker Compose  
- Lombok  
- JUnit 5 + Mockito + Testcontainers (testes)  

---

## 📁 Estrutura do Projeto

src/main/java/com/store/{service}/
├── entrypoints/           # Camada de entrada (REST Controllers, Kafka Listeners)
│   ├── rest/
│   └── messaging/
├── application/           # Casos de uso, comandos, serviços e ports
│   ├── usecases/
│   ├── services/
│   ├── commands/
│   └── ports/
│       ├── in/            # Interfaces para entrada (ex: UseCases)
│       └── out/           # Interfaces para saída (ex: repositórios, produtores Kafka)
├── domain/                # Entidades e regras de negócio puras
│   ├── model/
│   └── exceptions/
├── infrastructure/        # Implementações concretas (adaptadores)
│   ├── persistence/
│   └── messaging/
└── Application.java       # Classe principal do serviço

````

---

## ⚙️ Como Rodar Localmente

### Pré-requisitos

- Docker e Docker Compose instalados  
- Java 17+ instalado  

### Passos

1. Inicie os serviços dependentes (Kafka e PostgreSQL) usando Docker Compose:

```bash
docker-compose up -d
````

2. Execute o microserviço (exemplo: `product-service`):

```bash
cd product-service
./mvnw spring-boot:run
```

3. Acesse a API REST:

```
http://localhost:8080/api/products
```

---

## 📬 Comunicação Assíncrona com Kafka

* Eventos são publicados em tópicos Kafka (ex: `product-created`, `order-created`)
* Listeners consomem eventos para orquestração e integração
* Essa abordagem promove desacoplamento, escalabilidade e resiliência

---

## 🔄 Fluxo de Dados

1. A requisição chega ao Controller (entrypoint REST ou Kafka Listener).
2. Controller chama o UseCase (porta de entrada - **port in**).
3. UseCase executa a regra de negócio via Services.
4. Services usam as portas de saída (**port out**) para acessar repositórios, enviar mensagens, etc.
5. Adaptadores implementam essas interfaces para persistência (JPA), mensageria (Kafka Producer), etc.

---

## 📦 Microserviços do Sistema

* **product-service**: gestão de produtos
* **order-service**: gerenciamento de pedidos
* **inventory-service**: controle de estoque
* **payment-service**: processamento de pagamentos
* **notification-service**: envio de notificações

---

## 🧪 Testes

Para rodar os testes unitários e de integração:

```bash
./mvnw test
```

---

## 🔧 Boas Práticas Adotadas

* Seguir Clean Architecture para desacoplamento e facilidade de manutenção
* Utilizar DTOs e Commands para entrada e saída de dados
* Exceptions customizadas no domínio
* Tratamento global de erros na API
* Logs estruturados e rastreamento distribuído (OpenTelemetry / Jaeger)

---

