# Documento 03 – Modelo de domínio do Projeto Asteria

## 1. Objetivo

Este documento define as entidades principais do sistema, seus relacionamentos e as regras básicas de negócio que estruturam o Projeto Asteria.

## 2. Entidades principais

### Modelo

Representa a modelo agenciada.

Principais atributos:

- nome;
- nome artístico;
- status;
- medidas;
- contatos;
- percentual de comissão;
- foto 3x4.

Relacionamentos:

- um booker;
- um scouter (opcional);
- várias exclusividades;
- vários eventos de agenda;
- vários lançamentos financeiros;
- vários trabalhos.

### Booker

Representa o profissional responsável pela carreira da modelo.

Relacionamentos:

- vários modelos;
- várias fichas de material.

### Scouter

Representa o profissional responsável pela indicação da modelo.

Relacionamentos:

- vários modelos.

### Cliente

Representa empresas, produtoras, fotógrafos e demais contratantes.

Relacionamentos:

- vários processos operacionais.

### Categoria de produto

Representa categorias utilizadas para controle de exclusividade.

Exemplos:

- perfumes;
- cosméticos;
- bancos;
- telefonia;
- vestuário.

Relacionamentos:

- várias exclusividades;
- vários processos operacionais.

### Exclusividade

Controla restrições comerciais da modelo.

Atributos:

- modelo;
- categoria de produto;
- cliente;
- data inicial;
- data final.

Relacionamentos:

- uma modelo;
- uma categoria de produto;
- um cliente.

### Processo operacional

Representa o fluxo completo do trabalho.

Substitui as entidades independentes:

- ficha de material;
- ficha de teste;
- ficha de trabalho.

Atributos principais:

- cliente;
- booker;
- categoria de produto;
- tipo de trabalho;
- cachê;
- datas;
- territorialidade;
- mídias;
- etapa atual.

Etapas:

- material;
- teste;
- trabalho;
- finalizado.

Relacionamentos:

- um cliente;
- um booker;
- uma categoria;
- vários modelos.

### Participação do modelo

Tabela associativa entre modelo e processo operacional.

Atributos:

- situação (material, teste, aprovado, trabalho);
- observações;
- aprovação.

Relacionamentos:

- um modelo;
- um processo operacional.

### Agenda

Representa os eventos da agenda da modelo.

Tipos:

- casting;
- teste;
- trabalho;
- viagem;
- indisponibilidade.

Relacionamentos:

- uma modelo.

### Lançamento financeiro

Representa créditos e débitos da conta corrente da modelo.

Tipos:

- crédito;
- comissão da agência;
- imposto;
- comissão do scouter;
- ajuste.

Relacionamentos:

- uma modelo;
- um processo operacional (opcional).

### Usuário

Representa os usuários do sistema.

Relacionamentos:

- registros de auditoria.

### Auditoria

Registra alterações realizadas no sistema.

Atributos:

- usuário;
- entidade;
- operação;
- data;
- descrição.

## 3. Relacionamentos principais

Booker 1:N Modelo

Scouter 1:N Modelo

Modelo 1:N Exclusividade

CategoriaProduto 1:N Exclusividade

Cliente 1:N ProcessoOperacional

Booker 1:N ProcessoOperacional

CategoriaProduto 1:N ProcessoOperacional

ProcessoOperacional N:N Modelo (via ParticipaçãoModelo)

Modelo 1:N Agenda

Modelo 1:N LançamentoFinanceiro

Usuário 1:N Auditoria

## 4. Regras de negócio

### RN01

Um modelo deve possuir apenas um booker responsável.

### RN02

O scouter é opcional.

### RN03

A exclusividade deve ser validada durante a inclusão da modelo no processo operacional.

### RN04

O processo operacional deve seguir obrigatoriamente as etapas:

Material → Teste → Trabalho → Finalizado.

### RN05

A confirmação da etapa Trabalho deve gerar automaticamente os lançamentos financeiros.

### RN06

Eventos do tipo Trabalho bloqueiam a agenda.

### RN07

A auditoria deve registrar alterações de cadastro e operações financeiras.

## 5. Decisão de modelagem

As fichas de material, teste e trabalho serão representadas por uma única entidade denominada ProcessoOperacional.

A mudança de etapa preservará todo o histórico da operação, evitará duplicação de informações e simplificará a implementação no banco de dados e no backend.