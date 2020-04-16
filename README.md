# API de cadastro de eventos com Spring Boot

Para exceutar o projeto sera necessário preencher o [application.properties](src/main/resources/application.properties) com os seguintes dados:
```properties
## Configurações do pool de conexão
spring.datasource.hikari.connectionTimeout=20000
spring.datasource.hikari.maximumPoolSize=5

## Configuração da base de dados PostgreSQL
spring.datasource.url=jdbc:postgresql://seuhost:porta/suabasededados
spring.datasource.username=seuusuario
spring.datasource.password=suasenha

## JWT
jwt.secret=suachave

## Apagas a tabelas e faz as migrations. Ideal para testes, mas mantenha comentado em produção.
#spring.jpa.hibernate.ddl-auto=create
```

Esta API foi desenovolvida para ser consumida com um [front-end](https://github.com/LuanSSouza/angular-cadastro-eventos) desenvolvido em [Angular v9](https://angular.io/). Porém pode ser consumida com algum API Client, como o [Postman](https://www.postman.com/).

# Bibliotecas
- [Spring Boot v2.2.6](https://spring.io/projects/spring-boot)
- [Java JWT v0.9.1](https://github.com/jwtk/jjwt)
