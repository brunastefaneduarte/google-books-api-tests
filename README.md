# Google API Test

Este é um projeto Spring Boot que utiliza a API do Google Books para buscar informações sobre livros, como títulos, autores, preços, imagens de capa e muito mais. O projeto inclui também testes unitários usando o framework **JUnit 5** e **Reactor Test** para validar os dados retornados da API.

## Estrutura do Projeto

- **GoogleBooksService:** Serviço que utiliza `WebClient` do Spring WebFlux para fazer requisições assíncronas à API do Google Books.
- **GoogleBooksServiceTest:** Classe de testes que valida as respostas da API utilizando **StepVerifier** do **Reactor Test**.

## Dependências

Este projeto utiliza o **Gradle** como ferramenta de build. As dependências principais são:

- **Spring Boot WebFlux**: Para criar uma aplicação reativa com Spring.
- **Reactor Test**: Para testar fluxos reativos.
- **JUnit 5**: Framework de testes para executar e validar testes unitários.
- **Spring Boot Starter Test**: Inclui dependências para realizar testes com Spring.

### Dependências no `build.gradle`

```gradle
dependencies {
    testImplementation 'io.projectreactor:reactor-test:3.5.5'
    implementation 'org.springframework.boot:spring-boot-starter-webflux'
    implementation 'org.springframework.boot:spring-boot-starter-json'
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testImplementation 'org.junit.jupiter:junit-jupiter-api:5.8.2'
    testImplementation 'org.junit.jupiter:junit-jupiter-engine:5.8.2'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}


## Como Executar

### Requisitos

Antes de executar o projeto, certifique-se de que o **Java 11** ou superior e o **Gradle** estão instalados na sua máquina.

### Passos

1. Clone este repositório para sua máquina local:
   ```bash
   git clone https://github.com/brunastefaneduarte/google-api-test.git

Navegue até o diretório do projeto:

```bash
cd google-api-test

./gradlew bootRun

./gradlew test

