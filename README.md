📦 Atualizador

Sistema desenvolvido em Java para gerenciamento e execução de processos de atualização de sistemas, incluindo controle de versões, execução de scripts e integração com banco de dados e APIs.

🚀 Visão Geral

O Atualizador é uma aplicação backend responsável por:

Verificar versões de sistemas
Executar processos de atualização automatizados
Consumir APIs externas
Executar scripts (possivelmente SQL ou arquivos)
Integrar com banco de dados (Oracle)
Gerenciar arquivos e processos internos

Esse tipo de projeto é comum em ambientes corporativos onde sistemas precisam ser atualizados de forma controlada e segura.

🛠️ Tecnologias Utilizadas
Java (JDK 11+)
Maven (Gerenciamento de dependências)
Oracle JDBC (ojdbc11) – conexão com banco de dados Oracle
Gson – manipulação de JSON
org.json – manipulação adicional de JSON
Unirest – consumo de APIs REST
JUnit – testes unitários
📁 Estrutura do Projeto

Atualizador/
│
├── config/
│   └── app.json              # Configurações da aplicação
│
├── src/main/java/
│   ├── Atual/Atualizador/
│   │   ├── FMain.java        # Classe principal (entry point)
│   │   ├── FApi.java         # Integração com APIs externas
│   │   ├── FProcessos.java   # Lógica de execução de processos
│   │   ├── FVersao.java      # Controle de versão
│   │
│   ├── banco/
│   │   ├── FBancoDadosExecucao.java  # Execução no banco
│   │   ├── FObjetosBancoDados.java   # Modelos/objetos do banco
│   │
│   ├── interfaces/
│   │   ├── IArquivos.java    # Interface para manipulação de arquivos
│   │   ├── IBancoDados.java  # Interface de banco
│   │
│   ├── types/
│   │   ├── FArquivos.java    # Implementação de arquivos
│   │   ├── FScripts.java     # Manipulação de scripts
│
├── src/test/java/
│   └── AppTest.java          # Testes unitários
│
├── pom.xml                   # Configuração Maven
└── README.md

⚙️ Funcionalidades
🔄 Atualização de Sistema
Verifica versões disponíveis
Executa rotinas de atualização automaticamente
🧠 Controle de Versão
Gerenciamento de versões via classe FVersao
Possível comparação entre versões locais e remotas
🔌 Integração com API
Consumo de endpoints externos usando Unirest
Tratamento de respostas JSON
🗄️ Banco de Dados
Integração com Oracle
Execução de comandos SQL
Abstração via interfaces (IBancoDados)
📄 Execução de Scripts
Execução de scripts estruturados
Possível uso para migrations ou updates
📁 Manipulação de Arquivos
Leitura/escrita de arquivos
Estrutura organizada via interfaces
▶️ Como Executar
Pré-requisitos
Java 11 ou superior
Maven instalado
Acesso a um banco Oracle (se necessário)
🔧 Build do Projeto
mvn clean install
▶️ Executar o JAR

Após o build:

java -jar target/Atualizador-0.0.1-SNAPSHOT.jar
⚙️ Configuração

O arquivo:

config/app.json

Provavelmente contém configurações como:

URL de API
Credenciais de banco
Parâmetros de execução

⚠️ Importante: Ajuste esse arquivo antes de rodar em produção.

🧪 Testes

Para rodar os testes:

mvn test
🧩 Arquitetura

O projeto segue uma arquitetura baseada em:

Separação por responsabilidades (API, banco, processos)
Uso de interfaces para desacoplamento
Organização modular por pacotes
📌 Possíveis Melhorias
Implementar logs estruturados (ex: Log4j ou SLF4J)
Adicionar tratamento de erros mais robusto
Criar interface web para controle das atualizações
Adicionar suporte a múltiplos bancos
Containerização com Docker
💼 Uso Profissional

Esse projeto pode ser usado como:

Sistema de atualização automática (updater)
Ferramenta de deploy interno
Executor de scripts controlado
Integração entre sistemas via API + banco
📄 Licença

Definir conforme necessidade do projeto (MIT, privado, etc.)
