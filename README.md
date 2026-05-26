# 📚 Sistema de Controle de Notas em Java

Este projeto foi desenvolvido como parte da **AF (Avaliação Final)** do curso de **Análise e Desenvolvimento de Sistemas (ADS) - 1º Semestre**.

O sistema tem como objetivo realizar o gerenciamento das notas de alunos, permitindo o cálculo automático das médias, validação de dados e exibição de estatísticas da turma.

---

# 🚀 Funcionalidades do Projeto

O programa permite:

✅ Definir os pesos das avaliações

✅ Validar se a soma dos pesos é igual a 100%

✅ Definir a nota mínima para aprovação

✅ Informar a quantidade de alunos da turma

✅ Registrar notas de AC1, AC2, AF e AG

✅ Validar notas entre 0 e 10

✅ Calcular média ponderada automaticamente

✅ Informar situação do aluno:

* Aprovado
* Recuperação
* Reprovado

✅ Exibir estatísticas finais da turma:

* Média geral
* Maior média
* Menor média
* Percentual de aprovados
* Percentual de reprovados

---

# 💻 Tecnologias Utilizadas

* Java
* Scanner
* Vetores
* Matrizes
* Estruturas condicionais
* Estruturas de repetição

---

# 📖 Conceitos Aplicados

Durante o desenvolvimento deste projeto foram utilizados diversos conceitos aprendidos no primeiro semestre de ADS:

## Estruturas Condicionais

* if
* else if
* else

## Estruturas de Repetição

* for
* do while

## Estruturas de Dados

* Vetores
* Matrizes

## Métodos

* Criação de funções
* Reutilização de código

## Validação de Dados

* Validação de notas
* Validação de pesos
* Validação da quantidade de alunos

## Operações Matemáticas

* Média ponderada
* Percentuais
* Comparação de valores

---

# 🧠 Como o Sistema Funciona

O programa inicia solicitando os pesos das avaliações:

* AC1
* AC2
* AF
* AG

Os pesos obrigatoriamente devem somar 100%.

Depois disso:

1. O usuário informa a nota mínima para aprovação
2. Informa a quantidade de alunos
3. Digita as notas de cada aluno
4. O sistema calcula automaticamente a média ponderada
5. Define a situação do aluno
6. Ao final, apresenta estatísticas gerais da turma

---

# 📊 Fórmula da Média

A média é calculada utilizando média ponderada:

media = (AC1 × pesoAC1 + AC2 × pesoAC2 + AF × pesoAF + AG × pesoAG) / 100

---

# 📂 Estrutura do Projeto

Main.java → Arquivo principal do sistema

Funções principais:

* main() → execução do programa
* lerNumero() → leitura de números decimais
* lerInteiro() → leitura de números inteiros

---

# 🎯 Objetivo Acadêmico

Este projeto foi desenvolvido com o objetivo de praticar:

* Lógica de programação
* Manipulação de vetores e matrizes
* Estruturas de repetição
* Estruturas condicionais
* Entrada e saída de dados
* Organização de código em Java

---

# 📌 Autor

Desenvolvido por:

 - [Fernando Cunha](https://linkedin.com/in/fernandocunhajunior)
 - [Guilherme Mattos](https://linkedin.com/in/guilhermerodriguesmattos)
 - [Laura Cosmos](https://linkedin.com/in/laura-cosmos-b9968032a)
 - [Livia Suniga](https://linkedin.com/in/líviasuniga)
 - [Pedro Henrique Proença](https://linkedin.com/in/phproenca)
 - [Pedro Luiz](https://linkedin.com/in/pedro-luiz-dev)

**Curso: Análise e Desenvolvimento de Sistemas (ADS)**

---

# 🏆 Considerações Finais

Esse projeto representa a aplicação prática dos conteúdos aprendidos durante o semestre, demonstrando conhecimentos fundamentais em programação Java e desenvolvimento lógico.