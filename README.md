# Minha API de Tarefas (Projeto Task-Manager)

Este projeto foi desenvolvido para a Atividade Processual II da disciplina **Serviços Web API RESTful**. O objetivo é criar uma API para gerenciar tarefas (CRUD completo) utilizando **Spring Boot**.

# O que eu usei para construir?
Para fazer o projeto funcionar, eu usei essas ferramentas:

- **Java 17 e Spring Boot 3** (A base)
- **Spring Web** (Para criar os endpoints da API)
- **Spring Data JPA e H2 Database** (Para salvar os dados)
- **Lombok** (Para economizar código Java)
- **Visual Studio Code** (IDE que usei para o desenvolvimento)
- **Postman** (Para testar se tudo funcionava)

## O que a API faz? (Endpoints)
A API responde nos seguintes endereços (Base: /tasks):

| Método | Endpoint | Descrição | Status Sucesso |
|---|---|---|---|
| **POST** | `/tasks` | **Cria** uma nova tarefa. | `200 OK` |
| **GET** | `/tasks` | **Lista** todas as tarefas salvas. | `200 OK` |
| **PUT** | `/tasks/{id}` | **Atualiza** uma tarefa existente. | `200 OK` |
| **DELETE** | `/tasks/{id}` | **Exclui** uma tarefa pelo ID. | `204 No Content` |

## Provas de Teste (Minha Jornada no Postman)

Aqui estão os prints que tirei para provar que os métodos estão funcionando, incluindo a descoberta e correção de erros.

### 1. Criando a Primeira Tarefa (POST)
Primeiro, testei o POST para adicionar a tarefa "Estudar Postman".
![POST Criar](evidencias/01%20POST%20-%20Criar%20Tarefas.png)

### 2. Listando a Tarefa Criada (GET)
Usei o GET para confirmar que a tarefa (ID 1) foi salva corretamente.
![GET Listar](evidencias/02%20GET%20-%20Listar%20Tarefas.png)

### 3. O Erro de Digitação (O `null`!)
Continuei testando e criando novas tarefas, mas notei que algumas estavam com o título `null`.
![GET Erro Null](evidencias/02.1%20GET%20-%20Lista%20com%20Erro%20Null.png)

**O que eu aprendi:** Eu descobri que estava digitando "tilte" no JSON em vez de "title". O Spring não deu erro, mas salvou o campo como nulo.

### 4. Corrigindo o Erro (PUT)
Usei o PUT para consertar o registro de ID 2, que estava com o título nulo.
![PUT Atualizar](evidencias/03%20PUT%20-%20Sucesso%20Atualiza%C3%A7%C3%A3o.png)

### 5. Exclusão da Tarefa (DELETE)
Teste de exclusão da tarefa ID 3. A API retornou o status **204 No Content**, confirmando a remoção.
![DELETE Sucesso](evidencias/04%20DELETE%20-%20Delete%20Sucesso%20.png)

### 6. Verificando a Lista depois do Delete (GET)
Fiz um novo GET para provar que o ID 3 tinha sumido da lista.
![GET Pós-Delete](evidencias/05%20GET%20atualizada.png)

### 7. Prova Final (Lista Limpa)
Depois de apagar/corrigir todos os erros, este é o print final da lista, mostrando apenas os dados corretos.
![Teste Final](evidencias/Teste%20Final%20-%20Sucesso.png)

### Autor(a)

Desenvolvido por **Gabriela Ribeiro Almeida**