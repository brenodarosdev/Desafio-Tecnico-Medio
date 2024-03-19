
# Sistema de Controle de Delivery de Restaurante

Este é um sistema simplificado para o controle de delivery de um restaurante, construído para atender aos requisitos de uma vaga de Desenvolvedor Java Backend.

## Passo a Passo para Executar o Projeto Localmente

Siga os passos abaixo para clonar e executar o projeto em sua máquina:

1. Clone o repositório do projeto do GitHub:
   ```bash
   git clone https://github.com/brenodarosdev/Desafio-Tecnico-Medio.git
   ```

2. Acesse o diretório do projeto:
   ```bash
   cd Desafio-Tecnico-Medio
   ```

3. Configure o banco de dados MongoDB:
    - No site do MongoDB, crie e configure um cluster e a conexão com sua máquina. https://www.mongodb.com/pt-br
    - Configure a URI de conexão no arquivo `src/main/resources/application.yml`.

4. Execute a aplicação Spring Boot:
   - Rode o arquivo `src\main\java\com\restaurante\deliverysystem\DeliverysystemApplication.java`

5. Acesse a documentação da API gerada pelo Swagger em: `http://localhost:8080/public/swagger`

## Endpoints da API

### Cliente

- **Cria novo Cliente**
    - Método: POST
    - Endpoint: `/public/cliente`
    - Descrição: Cria um novo cliente no sistema.

- **Busca Cliente por ID**
    - Método: GET
    - Endpoint: `/public/cliente/{idCliente}`
    - Descrição: Busca um cliente específico com base em seu ID.

- **Altera Cliente**
    - Método: PATCH
    - Endpoint: `/public/cliente/editaCliente/{idCliente}`
    - Descrição: Permite a alteração dos dados de um cliente existente.

- **Deleta Cliente**
    - Método: DELETE
    - Endpoint: `/public/cliente/deletaCliente/{idCliente}`
    - Descrição: Remove um cliente do sistema com base em seu ID.

### Pedido

- **Cria novo Pedido**
    - Método: POST
    - Endpoint: `/public/pedido/novoPedido/{idCliente}`
    - Descrição: Cria um novo pedido para um cliente específico.

- **Busca Pedido por ID**
    - Método: GET
    - Endpoint: `/public/pedido/{idPedido}`
    - Descrição: Busca um pedido específico com base em seu ID.

- **Lista Pedidos por ID do Cliente**
    - Método: GET
    - Endpoint: `/public/pedido/pedidos/{idCliente}`
    - Descrição: Retorna uma lista de todos os pedidos de um cliente especificado.

- **Altera Pedido**
    - Método: PATCH
    - Endpoint: `/public/pedido/editaPedido/{idPedido}`
    - Descrição: Permite a alteração dos dados de um pedido existente.

- **Deleta Pedido**
    - Método: DELETE
    - Endpoint: `/public/pedido/deletaPedido/{idPedido}`
    - Descrição: Remove um pedido do sistema com base em seu ID.

### Entrega

- **Cria nova Entrega**
    - Método: POST
    - Endpoint: `/public/entrega/novaEntrega/{idPedido}`
    - Descrição: Cria uma nova entrega de um pedido específico.

- **Busca Entrega por ID**
    - Método: GET
    - Endpoint: `/public/entrega/{idEntrega}`
    - Descrição: Busca uma entrega específica com base em seu ID.

- **Altera Entrega**
    - Método: PATCH
    - Endpoint: `/public/entrega/editaEntrega/{idEntrega}`
    - Descrição: Permite a alteração dos dados de uma entrega existente.

- **Muda status para A_CAMINHO**
    - Método: PATCH
    - Endpoint: `/public/entrega/aCaminho/{idEntrega}`
    - Descrição: Muda o status de uma entrega específica para "a caminho".

- **Muda status para ENTREGUE**
  - Método: PATCH
  - Endpoint: `/public/entrega/entregue/{idEntrega}`
  - Descrição: Muda o status de uma entrega específica para "entregue".

- **Deleta Entrega**
    - Método: DELETE
    - Endpoint: `/public/entrega/deletaEntrega/{idEntrega}`
    - Descrição: Remove uma entrega do sistema com base em seu ID.
---
