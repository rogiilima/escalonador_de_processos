# 🖥️ Escalonador de Processos iCEVOS

## 📚 Informações Acadêmicas

**Disciplina:** Algoritmos e Estrutura de Dados I  
**Professor:** Dimmy Magalhães  
**Instituição:** ICEV (Instituto de Ensino Superior)

## 👥 Integrantes da Equipe

| Nome | Matrícula |
|------|-----------|
| Igor Pereira Lima | [INSERIR MATRÍCULA] |
| João Matheus Ramos Araújo | [INSERIR MATRÍCULA] |
| Erick Rhuan Carvalho de Freitas Pereira | [INSERIR MATRÍCULA] |

## 🔗 Repositório

**Link do Projeto:** https://github.com/rogiilima/escalonador_de_processos.git

## 📋 Descrição do Projeto

O **iCEVOS** é um simulador de escalonador de processos desenvolvido como projeto prático da disciplina. O sistema implementa um escalonador com múltiplos níveis de prioridade e mecanismos de prevenção de inanição (starvation).

### 🎯 Funcionalidades Principais

- **📊 Escalonamento por Prioridade:** Três níveis de prioridade (Alta, Média, Baixa)
- **⚖️ Prevenção de Inanição:** Sistema anti-starvation que garante execução justa
- **💾 Gerenciamento de Recursos:** Simulação de bloqueio por recurso "DISCO"
- **🔄 Ciclos de CPU:** Simulação realista de execução de processos
- **📁 Entrada por Arquivo:** Carregamento de processos via arquivo TXT

### 🏗️ Estruturas de Dados Implementadas

- **Lista Encadeada Simples:** Para listas de prioridade (Alta, Média, Baixa)
- **Lista Circular:** Para gerenciamento de processos bloqueados
- **Nó Personalizado:** Estrutura específica para EstruturaProcesso

### 🧮 Algoritmo de Escalonamento

1. **Regra Anti-Inanição:** Após 5 processos de alta prioridade, executa obrigatoriamente um de média/baixa
2. **Ordem Padrão:** Alta → Média → Baixa prioridade
3. **Gerenciamento DISCO:** Processos são bloqueados na primeira solicitação do recurso
4. **Desbloqueio:** Um processo é desbloqueado por ciclo (FIFO)

## 🛠️ Tecnologias Utilizadas

- **Linguagem:** Java
- **Paradigma:** Programação Orientada a Objetos
- **Estruturas:** Implementação manual (sem bibliotecas prontas)
- **Entrada:** Arquivos de texto (.txt)

## 📦 Estrutura do Projeto

```
iCEVOS/
├── src/
│   ├── EstruturaProcesso.java
│   ├── Node.java
│   ├── ListasDeProcessos.java
│   ├── ListaCircular.java
│   ├── Scheduler.java
│   |── LeitorDocumentos.java
|   └──data/
│       └── processos.txt
├── README.md
└── relatorio_analise.pdf
```

## 🚀 Como Compilar e Executar

### 📋 Pré-requisitos

- **Java JDK 8+** instalado
- Terminal/Prompt de comando
- Arquivo de entrada com processos (.txt)

### 🔧 Compilação

```bash
# 1. Clone o repositório
git clone https://github.com/rogiilima/escalonador_de_processos.git
cd escalonador_de_processos/iCEVOS/src

# 2. Compile todos os arquivos Java
javac *.java

# 3. Ou compile individualmente (se necessário)
javac EstruturaProcesso.java
javac Node.java
javac ListasDeProcessos.java
javac ListaCircular.java
javac Scheduler.java
```

### ▶️ Execução

```bash
# Execute o programa principal
java Main [caminho_do_arquivo]

# Exemplo: (caso o arquivo de texto esteja nos mesmo diretório)
java Main processos.txt

```

### 📄 Formato do Arquivo de Entrada

O arquivo de entrada deve seguir o formato CSV (separado por vírgulas):
```
#id,nome,prioridade,ciclos_necessarios,recurso_necessario
1,ProcessoA,1,5,CPU
2,ProcessoB,2,3,DISCO
3,ProcessoC,1,4,CPU
4,ProcessoD,3,6,DISCO
```

### 🔧 Como Criar o Arquivo de Processos

#### **Opção 1: Criar Manualmente**
Crie um arquivo de texto (.txt) com o formato CSV mostrado acima.

#### **Opção 2: Arquivo de Exemplo Automático**
Para gerar um arquivo de exemplo automaticamente:

```bash
# Execute o LeitorDocumentos isoladamente para criar um exemplo:
javac LeitorDocumentos.java
java LeitorDocumentos --exemplo processos.txt
#O programa indicará o diretório onde será gerado o arquivo
```

#### **Estrutura do Arquivo:**
- **Primeira linha (opcional):** Cabeçalho ou comentários iniciados com #
- **Linhas seguintes:** Dados dos processos no formato CSV
- **Campos obrigatórios:** id,nome,prioridade,ciclos_necessarios
- **Campo opcional:** recurso_necessario (pode ser vazio)

#### **Exemplo de Arquivo Completo:**
```.csv ou .txt
# Arquivo de processos para o iCEVOS
# Formato: id,nome,prioridade,ciclos_necessarios,recurso_necessario
1,ProcessoA,1,5,CPU
2,ProcessoB,2,3,DISCO
3,ProcessoC,1,4,CPU
4,ProcessoD,3,6,DISCO
5,ProcessoE,2,2,CPU
6,ProcessoF,1,7,DISCO
```

**Onde:**
- `id`: Identificador único do processo
- `nome`: Nome do processo
- `prioridade`: 1=Alta, 2=Média, 3=Baixa
- `ciclos_necessarios`: Quantidade de ciclos para conclusão
- `recurso_necessario`: CPU ou DISCO

## 📊 Exemplo de Saída

```
=== CICLO 1 ===
🔄 Executando: ProcessoA (ID: 1) - Ciclos restantes: 4
📋 Alta Prioridade: [ProcessoC]
📋 Média Prioridade: [ProcessoB]
📋 Baixa Prioridade: [ProcessoD]
🚫 Bloqueados: []

=== CICLO 2 ===
💾 ProcessoB solicitou DISCO - Bloqueado
🔓 Desbloqueando: ProcessoB
🔄 Executando: ProcessoC (ID: 3) - Ciclos restantes: 3
...
```

## 🎯 Recursos Implementados

### ✅ Funcionalidades Básicas
- [x] Estruturas de dados customizadas
- [x] Sistema de prioridades
- [x] Escalonamento round-robin por prioridade
- [x] Entrada via arquivo de texto

### ✅ Funcionalidades Avançadas
- [x] Prevenção de inanição (anti-starvation)
- [x] Gerenciamento de recurso DISCO
- [x] Sistema de bloqueio/desbloqueio
- [x] Saída detalhada no console

### ✅ Análise e Documentação
- [x] Análise de complexidade Big-O
- [x] Relatório técnico completo
- [x] Justificativas de design

## 📈 Análise de Complexidade

- **Inserção no fim:** O(1) - Com ponteiro tail
- **Remoção da cabeça:** O(1) - Acesso direto
- **Busca por prioridade:** O(1) - Listas separadas
- **Ciclo completo:** O(n) - Onde n é o número de processos ativos

## 🤝 Contribuição

Este projeto foi desenvolvido colaborativamente usando Git, com commits distribuídos entre todos os membros da equipe para demonstrar participação ativa no desenvolvimento.

## 📝 Relatório Técnico

Para análise detalhada da implementação, complexidade algorítmica e justificativas de design, consulte o arquivo `relatorio_analise.pdf` na raiz do repositório.

---

⭐ **Projeto desenvolvido como parte da avaliação P1 da disciplina Algoritmos e Estrutura de Dados I - ICEV**