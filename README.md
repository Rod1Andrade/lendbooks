# LendBooks

Este é um monorepo que contem uma aplicação para controle de emprestimos de livros entre amigos.
A aplicação está no Heroku, para acessar <a href="https://lb-f.herokuapp.com/auth/signUp" target="_blank">click aqui</a>.

Lembrando, como se trata de um plano gratuito do HEROKU, quando acessar pela primeira vez pode ser que a aplicação esteja 
no modo sleep, porém depois da primeira requisição, tanto no frontend quanto no backend, a plataforma do Heroku se encarrega
de subir os dynos.

Status: **em desenvolvimento**

## Tecnologias

A ideia é utilizar uma arquitetura de microserviços, adotanto o clean architecture e o DDD para modelar a 
arquitetura e o domínio da aplicação.

### Backend

* Springboot
* Spring framework
* Spring security
* Spring JPA 
* Hibernate
* JDBC Template
* Java Mail sender
* Swagger

### Frontend

* Angular
* Typescript
* HTMLS, CSS
* SCSS
* Angular Material Design

# Módulos

## UserResgiter

Pendências
- [x] Responsividade 
- [x] Interação com a API

![image](https://user-images.githubusercontent.com/51142291/152538091-809fd703-7e18-4ee4-a5d3-b77fd412fd35.png)

# License

MIT
