# Exemplo: Provisionamento de Usuário e Atribuição de Roles após Login Google OAuth2

Este exemplo mostra como criar um usuário local na sua aplicação Quarkus após login via Google OAuth2 e atribuir roles/grupos personalizados.

## 1. Dependências
Certifique-se de ter as dependências:
- quarkus-oidc
- quarkus-security
- quarkus-hibernate-orm-panache (para persistência)

## 2. Modelo de Usuário
```java
package br.com.psantanna1990.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import java.util.Set;

@Entity
public class Usuario extends PanacheEntity {
    public String email;
    public String nome;
    public Set<String> roles;
}
```

## 3. Serviço de Usuário
```java
package br.com.psantanna1990.services;

import br.com.psantanna1990.models.Usuario;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsuarioService {
    public Usuario findOrCreate(String email, String nome) {
        Usuario usuario = Usuario.find("email", email).firstResult();
        if (usuario == null) {
            usuario = new Usuario();
            usuario.email = email;
            usuario.nome = nome;
            usuario.roles = Set.of("user"); // role padrão
            usuario.persist();
        }
        return usuario;
    }
}
```

## 4. Filtro Customizado para Roles
```java
package br.com.psantanna1990.security;

import io.quarkus.security.identity.SecurityIdentity;
import io.quarkus.security.identity.SecurityIdentityAugmentor;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import br.com.psantanna1990.services.UsuarioService;

@ApplicationScoped
public class CustomRoleAugmentor implements SecurityIdentityAugmentor {
    @Inject
    UsuarioService usuarioService;

    @Override
    public SecurityIdentity augment(SecurityIdentity identity) {
        String email = identity.getPrincipal().getName();
        String nome = identity.getAttribute("full_name");
        var usuario = usuarioService.findOrCreate(email, nome);
        return SecurityIdentity.builder(identity)
            .addRoles(usuario.roles)
            .build();
    }
}
```

## 5. Uso nos Endpoints
```java
@RolesAllowed("admin")
public String adminEndpoint() { ... }

@RolesAllowed("user")
public String userEndpoint() { ... }
```

## 6. Observações
- O usuário é criado/atualizado no banco após login via Google.
- As roles são atribuídas conforme sua lógica de negócio.
- O filtro customizado garante que as roles do usuário local sejam usadas para autorização.

---

Adapte os nomes dos pacotes e entidades conforme sua estrutura. Para produção, implemente lógica para atribuição dinâmica de roles e persistência segura.
