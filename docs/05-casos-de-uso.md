# Documento 05 – Casos de uso e fluxos principais

## 1. Objetivo

Este documento descreve os principais fluxos de utilização do Projeto Asteria, representando a interação dos usuários com os módulos essenciais do sistema.

## 2. Atores

- Administrador
- Diretor
- Booker
- Assistente de Booker
- Financeiro
- Development

## 3. Caso de uso: cadastrar modelo

### Atores

Development

### Fluxo principal

1. O usuário acessa o módulo de modelos.
2. Seleciona Novo Modelo.
3. Informa os dados cadastrais.
4. Define o status inicial do modelo.
5. Vincula o booker responsável.
6. Vincula o scouter (opcional).
7. Salva o cadastro.

### Resultado

O modelo é cadastrado e fica disponível para o processo operacional.

## 4. Caso de uso: criar processo operacional

### Atores

Booker

### Fluxo principal

1. O booker cria um novo processo operacional.
2. Seleciona o cliente.
3. Informa categoria do produto.
4. Informa tipo de trabalho.
5. Define datas e cachê.
6. O sistema cria o processo na etapa Material.

## 5. Caso de uso: incluir modelos

### Atores

Booker

### Fluxo principal

1. O booker pesquisa modelos.
2. Seleciona um modelo.
3. O sistema verifica:
   - conflito de agenda;
   - conflito de exclusividade.
4. Se não houver impedimento, o modelo é incluído.

### Exceção

Se houver exclusividade conflitante, o sistema bloqueia a inclusão.

## 6. Caso de uso: convocar para teste

### Atores

Booker

### Fluxo principal

1. O booker altera a etapa para Teste.
2. Seleciona os modelos convocados.
3. O sistema registra a participação.
4. O sistema cria evento de agenda do tipo Teste.

## 7. Caso de uso: aprovar modelo

### Atores

Booker

### Fluxo principal

1. O booker aprova o modelo.
2. O sistema altera a situação da participação para Aprovado.
3. O sistema altera a etapa do processo para Trabalho.

## 8. Caso de uso: confirmar trabalho

### Atores

Booker

### Fluxo principal

1. O booker informa:
   - local;
   - horário;
   - observações.
2. O sistema cria evento de agenda do tipo Trabalho.
3. O sistema bloqueia o período correspondente.
4. O sistema registra a confirmação.

## 9. Caso de uso: finalizar trabalho

### Atores

Financeiro

### Fluxo principal

1. O financeiro informa:
   - percentual de imposto;
   - data do lançamento.
2. O sistema calcula:
   - comissão da agência;
   - comissão do scouter;
   - impostos;
   - valor líquido.
3. O sistema gera os lançamentos financeiros.
4. O sistema atualiza o saldo da modelo.
5. O processo passa para a etapa Finalizado.

## 10. Caso de uso: consultar extrato

### Atores

Financeiro, Diretor

### Fluxo principal

1. O usuário acessa a conta corrente da modelo.
2. O sistema apresenta:
   - créditos;
   - débitos;
   - saldo;
   - histórico.

## 11. Caso de uso: registrar exclusividade

### Atores

Booker

### Fluxo principal

1. Seleciona a modelo.
2. Seleciona o cliente.
3. Seleciona a categoria do produto.
4. Informa o período de vigência.
5. Salva a exclusividade.

## 12. Fluxo operacional principal

Criar processo

↓

Selecionar modelos

↓

Validação de exclusividade

↓

Etapa Material

↓

Etapa Teste

↓

Aprovação

↓

Etapa Trabalho

↓

Bloqueio de agenda

↓

Cálculo financeiro

↓

Conta corrente

↓

Finalização

## 13. Fluxo financeiro

Trabalho confirmado

↓

Cachê bruto

↓

Comissão da agência

↓

Impostos

↓

Comissão do scouter

↓

Valor líquido

↓

Lançamentos financeiros

↓

Atualização do saldo

## 14. Encerramento

Os casos de uso descritos representam os processos essenciais do Projeto Asteria e servirão como referência para a implementação dos serviços do backend e das interfaces do frontend.