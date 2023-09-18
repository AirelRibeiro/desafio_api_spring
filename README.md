# Projeto Jogadores e Times de Airel

Este projeto consiste em uma aplicação desenvolvida usando Angular para o frontend e Spring Boot para o backend. A aplicação permite trabalhar com o cadastro de jogadores e divisão de times a partir dos jogadores cadastrados.

</br>

## Funcionalidades

Adicionar jogadores

Visualizar jogadores cadastrados

Excluir todos os jogadores

Gerar times com os jogadores cadastrados

</br>

<details>
  <summary><h2>Estrutura do Backend</h2></summary>

## API Rest Spring Boot

### Configuração necessáriias:

- Certifique-se de ter o JDK (Java Development Kit) instalado em sua máquina.

- Abra o projeto na sua IDE preferida (por exemplo, IntelliJ IDEA, Eclipse).

- Execute o aplicativo Spring Boot. Isso iniciará o servidor backend.

#### O backend estará disponível em http://localhost:8080.

#

<details>
  <summary><h2>Documentação dos Endpoints</h2></summary>

### 1. POST /jogador

#### Descrição

Adiciona um novo jogador com o nome fornecido.

#### Corpo da Requisição

```json
{
  "nome": "Nome Sobrenome"
}
```

#### Retorno Esperado

Status:200 OK

#### Corpo do retorno:

```json
{}
```

#### Lógica de Negócio

O endpoint POST /jogador recebe um objeto com o nome do jogador. Esse jogador é adicionado à lista de jogadores existente.

</br>

### 2. GET /jogador

#### Descrição

Retorna a lista de todos os jogadores.

#### Retorno Esperado

Status:200 OK

#### Corpo do retorno:

```json
[
  { "nome": "Nome Sobrenome" },
  { "nome": "Nome Sobrenome" },
  ...
]
```

#### Lógica de Negócio

O endpoint GET /jogador retorna todos os jogadores atualmente armazenados no sistema.

</br>

### 3. GET /times

#### Descrição

Organiza os jogadores em times com base na primeira letra do sobrenome.

#### Retorno Esperado

Status:200 OK
Um objeto onde as chaves são os nomes dos times e os valores são listas de jogadores.

#### Corpo do retorno:

```json
{
  "time": ["Nome Sobrenome", "Nome Sobrenome", "Nome Sobrenome"],
  "time": ["Nome Sobrenome", "Nome Sobrenome", "Nome Sobrenome"],
  ...
}
```

#### Lógica de Negócio

O endpoint GET /times organiza os jogadores em times, seguindo as regras requisitadas. Ele agrupa os jogadores com base na primeira letra do sobrenome e garante que cada time tenha apenas um jogador com o mesmo sobrenome em cada time.

</br>

### 4. DELETE /jogador/all

#### Descrição

Apaga todos os jogadores.

#### Retorno Esperado

Status:200 OK
Um objeto onde as chaves são os nomes dos times e os valores são listas de jogadores.

#### Corpo do retorno:

#### Corpo do retorno:

```json
{}
```

#### Lógica de Negócio

O endpoint DELETE /jogador/all remove todos os jogadores armazenados, limpando a lista de jogadores existente.

</details>

</br>
#

### Estrutura de diretórios:

```
src
├── main
│   ├── java
│   │   └── com
│   │       └── airel
│   │           └── jogadoresetimes
│   │               ├── controllers
│   │               │   ├── JogadorController.java
│   │               │   └── TimeController.java
│   │               ├── entities
│   │               │   ├── Jogador.java
│   │               │   └── Time.java
│   │               ├── JogadoresetimesApplication.java
│   │               ├── repositories
│   │               │   └── JogadorRepository.java
│   │               └── services
│   │                   ├── JogadorService.java
│   │                   └── TimeService.java
│   └── resources
│       ├── application.properties
│       ├── static
│       └── templates
└── test
    └── java
        └── com
            └── airel
                └── jogadoresetimes
                    └── AceitacaoTest.java
```

</details>

</br>

<details>
  <summary><h2>Estrutura do Frontend</h2></summary>

## Aplicação Web com framework Angular

  ### Configurações necessárias

- Certifique-se de ter o Node.js e o Angular CLI instalados em sua máquina.

- Navegue até a pasta frontend do projeto.

- Instale as dependências do projeto executando o seguinte comando:

```

npm install

```

Inicie o servidor de desenvolvimento com o seguinte comando:

```

ng serve

```

#### O frontend estará disponível em http://localhost:4200.

#

## Estrutura de diretórios:

```
src
├── app
│   ├── app.component.html
│   ├── app.component.scss
│   ├── app.component.spec.ts
│   ├── app.component.ts
│   ├── app.module.ts
│   ├── app-routing.module.ts
│   ├── header
│   │   ├── header.component.html
│   │   ├── header.component.scss
│   │   ├── header.component.spec.ts
│   │   └── header.component.ts
│   └── jogador
│   ├── jogador.component.html
│   ├── jogador.component.scss
│   ├── jogador.component.spec.ts
│   ├── jogador.component.ts
│   ├── jogador.service.ts
│   ├── jogador.ts
│   └── time.ts
├── assets
├── favicon.ico
├── index.html
├── main.ts
└── styles.scss

```

</details>

</br>


## Como rodar este projeto na sua máquina

É importante que você siga esta ordem, pois o frontend interage com o backend, de forma que você não poderá usufruir de suas funcionalidades de outra forma.

### Clone este repositório no diretório de sua escolha:

- Usando GitHub CLI

```
gh repo clone AirelRibeiro/desafio_api_spring
```

- Usando o Git

```
git clone git@github.com:AirelRibeiro/desafio_api_spring.git
```

### Para rodar o backend

- Vá para o diretório do back

```
cd jogadoresetimes_spring
```

- Execute o comando para rodar a API

```
 mvn spring-boot:run
```

#### Para acessar o backend use a url http://localhost:8080 (use uma interface gráfica, como Postman, ou o terminal, com o [`curl`](https://www.campuscode.com.br/conteudos/comandos-curl-para-testar-requisicoes-api))

### Para rodar o frontend

- Vá para o diretório do front

```
cd jogadoresetimes_angular
```

- Instale as dependências

```
 npm install
```

- Execute o comando para rodar a aplicação

```
 npm start
```

#### Para acessar o frontend use a url http://localhost:4200.

</br>

## Observações finais

Esta aplicação é minha primeira API Spring Boot e primeira aplicação Angular; trata-se de um desafio, mas també um projeto de aprendizado. Dessa forma, sinta-se a vontade para clonar e testar na sua máquina. Contribuições e sugestões sobre como melhorar são muito bem vindas.
