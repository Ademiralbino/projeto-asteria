# Documento de requisitos – Projeto Asteria

## 1. Introdução

Este documento define os requisitos funcionais e não funcionais do Projeto Asteria, um sistema ERP para gestão de uma agência de modelos.

O objetivo é registrar apenas os requisitos necessários para orientar a modelagem do banco de dados, da arquitetura e da implementação do sistema.

## 2. Requisitos funcionais

### RF01 – Autenticação

O sistema deve permitir autenticação de usuários.

### RF02 – Cadastro de usuários

O sistema deve permitir cadastrar usuários com perfil de acesso.

### RF03 – Cadastro de modelos

O sistema deve permitir cadastrar modelos com informações pessoais, profissionais e físicas.

### RF04 – Foto do modelo

O sistema deve permitir armazenar uma foto 3x4 para identificação do modelo.

### RF05 – Ciclo de vida do modelo

O sistema deve controlar o status do modelo:

- Aspirante;
- Follow Up;
- New Face;
- Model Management;
- Top Model.

### RF06 – Cadastro de bookers

O sistema deve permitir cadastrar bookers.

### RF07 – Vinculação do booker

Cada modelo deverá possuir um booker responsável.

### RF08 – Cadastro de scouters

O sistema deve permitir cadastrar scouters.

### RF09 – Vinculação do scouter

O sistema deve permitir vincular um scouter ao modelo.

### RF10 – Cadastro de clientes

O sistema deve permitir cadastrar clientes.

### RF11 – Cadastro de categorias de produtos

O sistema deve permitir cadastrar categorias de produtos para controle de exclusividades.

### RF12 – Cadastro de exclusividades

O sistema deve permitir registrar exclusividades por modelo, categoria de produto e período de vigência.

### RF13 – Validação de exclusividade

O sistema deve impedir a seleção de modelos quando existir conflito de exclusividade durante a vigência do trabalho.

### RF14 – Cadastro de ficha de material

O sistema deve permitir cadastrar fichas de material.

### RF15 – Inclusão de modelos na ficha de material

O sistema deve permitir selecionar modelos para envio de material.

### RF16 – Geração de ficha de teste

O sistema deve gerar automaticamente uma ficha de teste a partir da ficha de material.

### RF17 – Aprovação para trabalho

O sistema deve permitir aprovar modelos na ficha de teste.

### RF18 – Geração de ficha de trabalho

O sistema deve gerar automaticamente uma ficha de trabalho a partir da ficha de teste.

### RF19 – Agenda do modelo

O sistema deve controlar eventos de agenda:

- casting;
- teste;
- trabalho;
- viagem;
- indisponibilidade.

### RF20 – Conflito de agenda

O sistema deve verificar conflitos de horário antes da confirmação de um trabalho.

### RF21 – Bloqueio por trabalho

Trabalhos confirmados deverão bloquear o período correspondente na agenda do modelo.

### RF22 – Conta corrente do modelo

Cada modelo deverá possuir uma conta corrente financeira.

### RF23 – Geração automática de lançamentos

Todo trabalho confirmado deverá gerar automaticamente lançamentos financeiros.

### RF24 – Cálculo de comissão

O sistema deverá calcular automaticamente a comissão da agência.

### RF25 – Cálculo de impostos

O sistema deverá calcular automaticamente os impostos informados pelo financeiro.

### RF26 – Comissão do scouter

O sistema deverá calcular automaticamente a comissão do scouter quando aplicável.

### RF27 – Extrato financeiro

O sistema deverá apresentar o extrato financeiro completo do modelo.

### RF28 – Dashboard

O sistema deverá apresentar indicadores operacionais e financeiros.

### RF29 – Relatório de trabalhos

O sistema deverá gerar relatório de trabalhos por período.

### RF30 – Relatório por cliente

O sistema deverá gerar relatório de faturamento por cliente.

### RF31 – Relatório por modelo

O sistema deverá gerar relatório de faturamento por modelo.

### RF32 – Modelos mais contratados

O sistema deverá gerar relatório de modelos mais contratados.

### RF33 – Auditoria

O sistema deverá registrar usuário, data e hora das alterações realizadas.

## 3. Requisitos não funcionais

### RNF01

O sistema deverá ser desenvolvido como aplicação web responsiva.

### RNF02

O backend deverá utilizar Java com Spring Boot.

### RNF03

O frontend deverá utilizar Angular.

### RNF04

O banco de dados deverá utilizar PostgreSQL.

### RNF05

O sistema deverá utilizar arquitetura em camadas.

### RNF06

O banco de dados deverá ser modelado até a 3FN.

### RNF07

O sistema deverá manter consistência transacional nas operações financeiras.

### RNF08

O sistema deverá registrar logs básicos de operações críticas.

## 4. Premissas

- O sistema não armazenará contratos digitalizados.
- O sistema não armazenará books ou composites.
- As permissões de acesso serão configuradas manualmente.
- O foco do projeto é demonstrar regras de negócio e integração entre módulos.