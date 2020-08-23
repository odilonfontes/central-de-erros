# error-center-api
API Rest para que as aplicações e serviços possam gravar eventos de log em um banco de dados relacional. Além disso, será possível consultar listagens de eventos de log e buscar um evento de log específico.

Qualquer requisição será permitida apenas por token de acesso válido. As aplicações e serviços deverão solicitar um token de acesso enviando suas credendiais (ID do cliente e segredo). A definição do tipo de concessão **credenciais do cliente** foi a escolha ideal para este projeto, porque permite obter um token de acesso fora do contexto de um usuário.

Para testes, foi definida a seguinte credencial:
  - ID: **codenation**
  - Segredo: **acelera@dev**
