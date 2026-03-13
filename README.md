# 🍽️ Restaurant API

Uma API RESTful desenvolvida em Java com Spring Boot para gerenciar o cardápio de um restaurante. Este projeto foi construído para aplicar conceitos sólidos de back-end, arquitetura em camadas e integração com banco de dados.

## 🚀 Tecnologias Utilizadas

* **Java 21** (ou a versão que você usou)
* **Spring Boot 3** (Web, Data JPA, Validation)
* **PostgreSQL** (Banco de dados relacional)
* **Docker & Docker Compose** (Containerização do banco de dados)
* **Maven** (Gerenciamento de dependências)
* **Postman / Insomnia** (Testes de API)

## ⚙️ Arquitetura e Conceitos Aplicados
* Arquitetura em camadas (Controller, Service, Repository, Model).
* Padrão REST para rotas HTTP.
* Validação de dados de entrada com *Bean Validation* (ex: impedindo pratos sem nome ou com preços negativos).
* Tratamento de exceções (retornando `404 Not Found` para buscas de IDs inexistentes ao invés de `500 Internal Server Error`).

## 🛠️ Como rodar o projeto localmente

1. Clone este repositório:
   ```bash
   git clone [https://github.com/SKDEV9/restaurant-api.git](https://github.com/SKDEV9/restaurant-api.git)
