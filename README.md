# Projeto Codebusters: Poupi

## Protótipo Figma:
https://www.figma.com/file/2Orm4Y8YZYGCY9n4zXUBuj/Untitled?type=design&node-id=1%3A6195&mode=design&t=28hRb6llOfOZlENO-1

## Diagrama de Classes
![Class Diagram](documents/POUPI.png)

## Requisitos Funcionais:
- O sistema deve permitir realizar o cadastro do Pai e/ou responsável pelo filho como um usuário:
  - **Atributos:**
    - Nome
    - Senha
    - Nickname
    - Imagem de perfil
    - email
    - Emprego
    - Dependentes "filho(s)"
    - CPF

- O sistema deve permitir ao pai realizar o cadastro do seu filho(s) como um usuário:
  - **Atributos:**
    - Nome
    - Senha
    - Nickname
    - Imagem de perfil
    - Data de aniversário
    - Parentesco
    - Adulto responsável

- O sistema deve permitir ao filho o cadastro de metas que deseja alcançar:
  - **Atributos:**
    - Valor da Meta
    - Valor já alcançado
    - Descrição da meta

- O sistema deve permitir a gestão da carteira do filho e do pai:
  -  **Atributos:**
    - Valor da carteira
    - Lista de transações (extrato)

- O sistema deve permitir a realização de transações do pai para o filho:
  -  **Atributos:**
    - Data da transação
    - Tipo do lançamento (Entrada ou saída)
    - Valor do lançamento
    - Descrição do lançamento
    - Carteira de quem irá receber

- O sistema deve permitir ao pai realizar o cadastro de tarefas que devem ser cumpridas pelo filho:
  - **Atributos:**
    - Descrição
    - Valor da Tarefa
    - Status da tarefa (Completa, Pendente, Não completa, Paga)


- O sistema deve permitir ao filho acompanhar o andamento do cumprimento da sua meta
- O sistema deve permitir ao pai pagar recompensas para o seu filho com base nas tarefas cumpridas
- O sistema deve permitir ao pai enviar dinheiro ao seu filho
- O sistema deve permitir ao filho receber dinheiro do pai
- O sistema deve permitir ao filho alocar o dinheiro de sua conta nas metas que deseja alcançar

- O usuário deverá conseguir fazer o login com seu usuário.
  - Adulto : Email e senha
  - Criança: Nickname

- O usuário poderá fazer logout
- O usuário responsável pode alterar e visualizar seu perfil.
  - Foto
  - Nome
  - Email
  - Senha

- O usuário responsável poderá acessar a conta do dependente.
- O usuário dependente poderá visualizar o extrato da sua conta.

## Requisitos não funcionais:
- Desenvolver o backend do projeto utilizando Java e SpringBoot
- Utilizar o banco de dados Postgre para realizar a persistência dos dados
- Desenvolver o frontend utilizando Flutter
- Escopo DevOps:
  - Banco de dados utilizando RDS com backups automatizados.
  - Pipelines desenvolvidas no GitHub Actions, com deploy automático de versões para a produção.
  - Se necessário implementação de pipeline para rodar testes de aplicação e deploy para ambiente de homologação.
  - Administração de dominios e acessos.
  - Fornecer acesso seguro ao banco de dados na nuvem.
  - Dar suporte e monitorar atividade dos repositórios dos projetos.

