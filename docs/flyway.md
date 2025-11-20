# Flyway no Quarkus

## O que é Flyway?
Flyway é uma ferramenta de versionamento e migração de banco de dados. Ela permite que você controle e aplique mudanças no esquema do banco de dados de forma automática e segura.

## Como funciona?
- Você cria arquivos de migração SQL numerados sequencialmente (ex: `V1__init.sql`, `V2__add_table.sql`).
- Ao iniciar a aplicação, o Flyway verifica e aplica as migrações pendentes no banco de dados.
- O histórico de migrações aplicadas é registrado em uma tabela especial (`flyway_schema_history`).

## Configuração no Quarkus
1. Adicione a dependência no `pom.xml`:
   ```xml
   <dependency>
     <groupId>io.quarkus</groupId>
     <artifactId>quarkus-flyway</artifactId>
   </dependency>
   ```
2. Crie a pasta de migrações: `src/main/resources/db/migration/`
3. Adicione arquivos de migração SQL, por exemplo:
   - `V1__init.sql`
   - `V2__add_table.sql`
4. Configure no `application.properties`:
   ```properties
   quarkus.flyway.migrate-at-start=true
   quarkus.flyway.locations=db/migration
   ```

## Exemplo de arquivo de migração
```sql
-- V1__init.sql
CREATE TABLE exemplo (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);
```

## Comandos úteis
- As migrações são aplicadas automaticamente ao iniciar o Quarkus.
- Para ver o histórico, consulte a tabela `flyway_schema_history` no banco de dados.

## Vantagens
- Versionamento seguro do banco de dados
- Facilidade para trabalhar em equipe
- Automatização das mudanças de schema

## Documentação oficial
- [Flyway](https://flywaydb.org/)
- [Quarkus Flyway](https://quarkus.io/guides/flyway)
