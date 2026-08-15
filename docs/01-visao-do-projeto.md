# Documento de visão – Projeto Asteria

## 1. Visão geral

O Projeto Asteria é um sistema ERP web para gestão de uma agência de modelos. O objetivo do sistema é centralizar os processos operacionais, financeiros e administrativos da agência, permitindo o gerenciamento do ciclo de vida dos modelos, das operações do booking, da agenda, das exclusividades e da conta corrente financeira dos modelos.

O sistema será desenvolvido como projeto acadêmico para composição de portfólio profissional, utilizando Java, Spring Boot, Angular e PostgreSQL.

## 2. Objetivo do sistema

Desenvolver um ERP simples, funcional e orientado às regras de negócio de uma agência de modelos, priorizando organização, automação de processos e consistência das informações.

## 3. Problema

Atualmente os processos de uma agência de modelos envolvem diversas etapas operacionais, como envio de material, testes, aprovação para trabalhos, controle de agenda, gestão financeira dos modelos e controle de exclusividades.

O Projeto Asteria busca integrar esses processos em um único sistema, reduzindo controles manuais e automatizando regras de negócio importantes.

## 4. Escopo

O sistema contemplará os seguintes módulos:

- Dashboard
- Cadastros
- Development
- Booking
- Internacional
- Material
- Agenda
- Operações
- Financeiro
- Relatórios
- Administração

Não serão armazenados no sistema:

- books fotográficos;
- composites;
- contratos digitalizados;
- documentos diversos.

## 5. Atores do sistema

Os principais usuários serão:

- Administrador
- Diretor
- Financeiro
- Booker
- Assistente de Booker
- Development

O controle de permissões será realizado manualmente.

## 6. Principais funcionalidades

### Modelos

- cadastro completo;
- controle do ciclo de vida;
- vínculo com booker;
- vínculo com scouter;
- controle de exclusividades;
- agenda;
- conta corrente financeira.

### Booking

- ficha de material;
- ficha de teste;
- ficha de trabalho;
- conversão automática entre as fichas.

### Agenda

- castings;
- testes;
- trabalhos;
- viagens;
- indisponibilidades;
- verificação de conflitos de horário.

### Financeiro

- cálculo automático de comissões;
- cálculo de impostos;
- geração automática de lançamentos;
- extrato financeiro do modelo.

## 7. Regras de negócio principais

### Exclusividade

O sistema impedirá a seleção de modelos para trabalhos com conflito de exclusividade durante o período de vigência.

### Fluxo operacional

As operações seguirão obrigatoriamente o fluxo:

Ficha de Material → Ficha de Teste → Ficha de Trabalho.

### Financeiro

Todo trabalho aprovado gerará automaticamente os lançamentos financeiros da conta corrente do modelo.

## 8. Restrições técnicas

- aplicação web responsiva;
- arquitetura em camadas;
- banco de dados PostgreSQL;
- backend em Java/Spring Boot;
- frontend em Angular;
- modelagem normalizada até a 3FN.

## 9. Objetivo acadêmico

O projeto tem como finalidade demonstrar competências em:

- engenharia de software;
- modelagem de domínio;
- banco de dados relacional;
- arquitetura de sistemas;
- desenvolvimento full stack;
- implementação de regras de negócio.