# Documento 04 – Arquitetura e banco de dados

## 1. Objetivo

Definir a arquitetura do Projeto Asteria e a estrutura inicial do banco de dados PostgreSQL.

## 2. Arquitetura do sistema

O sistema utilizará arquitetura em camadas (Layered Architecture).

### Estrutura geral

Frontend (Angular)

↓

REST API (Spring Boot)

↓

Camada de Serviços

↓

Camada de Persistência

↓

PostgreSQL

## 3. Estrutura do backend

O backend será organizado por domínio.

com.asteria

├── config

├── controller

├── dto

├── entity

├── repository

├── service

├── validation

├── exception

└── util

Cada módulo do sistema utilizará essa mesma organização.

Exemplo:

modelo/

├── controller

├── dto

├── entity

├── repository

└── service

## 4. Estrutura do frontend

src/

├── core/

├── shared/

├── layout/

├── pages/

│   ├── dashboard/

│   ├── modelos/

│   ├── clientes/

│   ├── booking/

│   ├── agenda/

│   ├── financeiro/

│   └── relatorios/

└── services/

## 5. Banco de dados

O banco será normalizado até a 3FN.

## 6. Tabelas principais

### usuario

- id
- nome
- email
- senha
- perfil
- ativo

### booker

- id
- nome
- telefone
- email

### scouter

- id
- nome
- telefone
- email

### modelo

- id
- nome
- nome_artistico
- data_cadastro
- status
- booker_id
- scouter_id
- percentual_comissao
- altura
- medidas
- contatos
- foto

### cliente

- id
- razao_social
- nome_fantasia
- tipo
- cnpj
- endereco
- telefone
- email

### categoria_produto

- id
- nome
- descricao

### exclusividade

- id
- modelo_id
- cliente_id
- categoria_produto_id
- data_inicio
- data_fim

### processo_operacional

- id
- cliente_id
- booker_id
- categoria_produto_id
- etapa
- tipo_trabalho
- cache_bruto
- data_trabalho
- data_veiculacao_inicio
- data_veiculacao_fim
- territorialidade
- midias
- local_trabalho
- horario_inicio
- horario_fim

### participacao_modelo

- id
- processo_operacional_id
- modelo_id
- situacao
- observacoes

### agenda

- id
- modelo_id
- tipo_evento
- data_inicio
- data_fim
- descricao

### lancamento_financeiro

- id
- modelo_id
- processo_operacional_id
- tipo
- descricao
- valor
- data_lancamento
- saldo

### auditoria

- id
- usuario_id
- entidade
- operacao
- data_hora
- descricao

## 7. Relacionamentos

booker (1) —— (N) modelo

scouter (1) —— (N) modelo

modelo (1) —— (N) exclusividade

cliente (1) —— (N) exclusividade

categoria_produto (1) —— (N) exclusividade

cliente (1) —— (N) processo_operacional

booker (1) —— (N) processo_operacional

categoria_produto (1) —— (N) processo_operacional

processo_operacional (1) —— (N) participacao_modelo

modelo (1) —— (N) participacao_modelo

modelo (1) —— (N) agenda

modelo (1) —— (N) lancamento_financeiro

usuario (1) —— (N) auditoria

## 8. Padrões adotados

### Chaves primárias

Todas as tabelas utilizarão:

id BIGSERIAL PRIMARY KEY

### Chaves estrangeiras

Serão nomeadas com o padrão:

nome_tabela_id

### Datas

Será utilizado:

TIMESTAMP

para eventos e auditoria.

### Valores financeiros

Será utilizado:

NUMERIC(12,2)

## 9. Decisões de projeto

### D01

A agenda será uma entidade independente.

### D02

As exclusividades possuirão vigência obrigatória.

### D03

A participação da modelo será separada do processo operacional.

### D04

A conta corrente do modelo será composta exclusivamente pelos lançamentos financeiros.

### D05

A auditoria registrará apenas operações relevantes do sistema.

## 10. Considerações

Esta arquitetura prioriza simplicidade, organização por domínio e facilidade de manutenção, permitindo que o Projeto Asteria seja desenvolvido de forma incremental sem necessidade de alterações estruturais significativas no banco de dados.