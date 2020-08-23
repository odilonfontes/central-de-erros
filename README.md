# error-center-api
API Rest para manter eventos de log de aplicações e serviços. Permitindo as aplicações e serviços gravar, consultar listagens e buscar determinado evento de log, mantidas em um banco de dados relacional.

Qualquer requisição será permitida apenas por token de acesso válido. As aplicações e serviços deverão solicitar um token de acesso enviando suas credendiais (ID do cliente e segredo). A definição do tipo de concessão **credenciais do cliente** foi a escolha ideal para este projeto, porque permite obter um token de acesso fora do contexto de um usuário.

Para testes foi definida a seguinte credencial:
  - ID: **codenation**
  - Segredo: **acelera@dev**
