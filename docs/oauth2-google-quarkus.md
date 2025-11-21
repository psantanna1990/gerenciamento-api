# Integração OAuth2 Google com Quarkus

## 1. Criação do Projeto Google Cloud
- Projeto criado no Google Cloud Console: "Demo Google Oauth".
- Credenciais OAuth2 geradas (Client ID e Client Secret).
- URIs de redirecionamento autorizados cadastrados:
  - http://localhost:8080/callback
  - http://localhost:8080/api-docs/oauth2-redirect.html
  - http://localhost:8080/hello

## 2. Configuração do Quarkus
- Dependência adicionada ao `pom.xml`:
  - `quarkus-oidc` para autenticação OIDC/OAuth2.
- Configurações no `application.properties`:
  ```properties
  quarkus.oidc.auth-server-url=https://accounts.google.com
  quarkus.oidc.client-id=${GOOGLE_CLIENT_ID}
  quarkus.oidc.credentials.secret=${GOOGLE_CLIENT_SECRET}
  quarkus.oidc.application-type=web-app
  quarkus.swagger-ui.oauth2-redirect-url=http://localhost:8080/api-docs/oauth2-redirect.html
  ```
- Variáveis de ambiente configuradas no `.env`:
  - GOOGLE_CLIENT_ID
  - GOOGLE_CLIENT_SECRET
  - GOOGLE_REDIRECT_URI

## 3. Proteção dos Endpoints
- Endpoints podem ser protegidos usando `@Authenticated` (qualquer usuário autenticado via Google) ou `@RolesAllowed` (controle por papéis/roles).
- Exemplo de proteção simples:
  ```java
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @Authenticated
  public String hello() {
      return "Hello from Quarkus REST";
  }
  ```
- Para restringir por roles:
  ```java
  @GET
  @Produces(MediaType.TEXT_PLAIN)
  @RolesAllowed("admin")
  public String adminHello() {
      return "Hello admin!";
  }
  ```
- Para controle por roles, é necessário que o token JWT do usuário contenha a claim de roles/grupos. No Quarkus, configure em `application.properties`:
  ```properties
  quarkus.oidc.roles.claim=groups
  ```
- O Google OAuth2 não envia roles por padrão. Para usar roles/grupos, você pode:
  - Utilizar Google Workspace (grupos).
  - Provisionar usuários localmente após login e associar roles na sua base de dados.
  - Implementar um `SecurityIdentityAugmentor` para adicionar roles customizadas após login.

## 4. Testes
- Testes realizados via navegador e Swagger UI.
- Problemas comuns resolvidos:
  - Erro 400: redirect_uri_mismatch (URI cadastrado no Google Cloud Console).
  - Erro 403: acesso negado (corrigido usando `@Authenticated`).

## 5. Observações
- O Quarkus OIDC não utiliza a propriedade `quarkus.oidc.redirect-uri`.
- Todos os URIs de redirecionamento usados devem estar cadastrados no Google Cloud Console.
- Para restringir acesso por roles, o token JWT precisa conter a claim configurada em `quarkus.oidc.roles.claim`.
- Caso o provedor OAuth2 não envie roles, implemente lógica de provisionamento local e augmentação de roles.

---

Documentação gerada por GitHub Copilot em 20/11/2025.