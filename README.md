# Projeto Asteria

Sistema ERP para gestão de agências de modelos desenvolvido como projeto acadêmico de portfólio.

O Projeto Asteria tem como objetivo centralizar os processos operacionais, financeiros e administrativos de uma agência de modelos, aplicando conceitos de engenharia de software, arquitetura em camadas e modelagem de banco de dados.

## Objetivo

Desenvolver um ERP web utilizando Java, Spring Boot, Angular e PostgreSQL, com foco em:

* organização dos processos;
* automação de regras de negócio;
* controle financeiro dos modelos;
* gestão operacional do booking;
* arquitetura de software.

## Tecnologias

### Backend

* Java 21
* Spring Boot 3
* Spring Data JPA
* Spring Security
* Maven
* Lombok

### Banco de dados

* PostgreSQL

### Frontend (próxima etapa)

* Angular
* TypeScript
* Angular Material

## Arquitetura

O projeto utiliza arquitetura em camadas (Layered Architecture).

Frontend (Angular)

↓

REST API (Spring Boot)

↓

Service

↓

Repository

↓

PostgreSQL

## Estrutura do projeto

src/main/java/com/ademiralbino/projetoasteria

├── config

├── controller

├── dto

├── entity

├── enums

├── exception

├── repository

├── service

├── validation

└── util

## Funcionalidades previstas

* cadastro de modelos;
* gestão de bookers;
* gestão de scouters;
* controle de exclusividades;
* agenda operacional;
* processo operacional (material, teste e trabalho);
* conta corrente do modelo;
* cálculo automático de comissões;
* cálculo de impostos;
* relatórios gerenciais.

## Funcionalidades implementadas

### Sprint 1 – Fundação do backend

* configuração do Spring Boot;
* configuração do PostgreSQL;
* arquitetura inicial do projeto;
* entidade BaseEntity com UUID;
* enum StatusModelo;
* entidade Booker;
* entidade Scouter;
* entidade Modelo;
* repositórios JPA iniciais.

## Documentação

A documentação do projeto encontra-se na pasta docs.

* Documento de Visão
* Requisitos
* Modelo de Domínio
* Arquitetura e Banco de Dados
* Casos de Uso

## Próximas etapas

* implementação dos serviços;
* criação dos endpoints REST;
* validações de negócio;
* controle de agenda;
* exclusividades;
* módulo financeiro;
* desenvolvimento do frontend Angular.

## Status do projeto

Em desenvolvimento.

Fase atual:

Sprint 1 – Estrutura inicial do backend.

## Autor

Ademir Albino

Projeto desenvolvido como portfólio acadêmico para Análise e Desenvolvimento de Sistemas.
