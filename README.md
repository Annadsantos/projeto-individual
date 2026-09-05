# Projeto Individual - No I'm Not A Human

Este repositório contém o projeto completo da aplicação de triagem "NINAH", estruturado com o seu back-end (Spring Boot) e o front-end (HTML, CSS e JavaScript Vanilla) organizados em diretórios separados.

## Estrutura do Repositório

```
projeto-individual/
├── backend/
│   ├── src/
│   └── pom.xml
├── frontend/
│   ├── index.html
│   ├── validacao.js
│   └── script.js
└── README.md
```

## Pré-requisitos:
- Visual Studio Code (VS Code)
- Java Development Kit

Extensões do VS CODE
- Extension Pack for Java
- Spring Boot Extension Pack
- Live Server

## Como Executar o Back-end (Spring Boot)

1 - Abra o VS Code na pasta raiz do projeto (projeto-individual).
2 - Aguarde a extensão de Java reconhecer o projeto Maven dentro da pasta backend.
3 - Navegue até o arquivo principal do Spring Boot localizado em:
backend/src/main/java/.../NinahApplication.java
4 - Clique no botão Run que aparece logo acima da linha do método main.

## Como Executar o Front-end

1 - Abra o VS Code.
2 - Acesse o menu de extensões na barra lateral esquerda (Ctrl + Shift + X).
3 - Pesquise por Live Server (por Ritwick Dey) e clique em Install.
4 - No explorador de arquivos do VS Code, navegue até frontend/index.html.
5- Clique com o botão direito no arquivo index.html e escolha Open with Live Server (ou clique no botão Go Live no canto inferior direito do VS Code).

O navegador padrão abrirá automaticamente o endereço:
http://127.0.0.1:5500/frontend/index.html ou http://localhost:5500/frontend/index.html.

## Comunicação entre Cliente e API

O front-end interage diretamente com os endpoints REST expostos pela API Java através de requisições utilizando a fetch API do JavaScript:

### 1 - Carregamento de Países (GET /paises):
Ao carregar a página de triagem, a função carregarPaises() realiza uma requisição GET para http://localhost:8080/paises. Os dados retornados em formato JSON populam dinamicamente as opções do campo `<select>.`

### 2 - Envio da Triagem (POST /triagens):
Quando o formulário é enviado, o script valida os dados preenchidos pelo usuário e monta um objeto JSON no seguinte formato:

```
{
  "nome": "Nome do Paciente",
  "idade": 25,
  "dataNascimento": "2000-01-01",
  "senteDor": "sim",
  "sintomas": "sensibilidade_luz, perda_memoria",
  "pais": "Brasil"
}
```

Em seguida, envia uma requisição POST com o cabeçalho Content-Type: application/json para http://localhost:8080/triagens. Após o recebimento do status 201 Created retornado pela API, a aplicação redireciona o usuário para a tela de confirmação.