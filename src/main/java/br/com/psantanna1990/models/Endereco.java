package br.com.psantanna1990.models;

import br.com.psantanna1990.enums.TipoEnderecoEnum;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Entity
public class Endereco extends PanacheEntity {

    @Column(length = 8, nullable = false)
    private String cep;
    @Column(length = 255, nullable = false)
    private String logradouro;
    @Column(length = 10, nullable = false)
    private String numero;
    @Column(length = 50)
    private String complemento;
    @Column(length = 50, nullable = false)
    private String bairro;
    @Column(length = 50, nullable = false)
    private String cidade;
    @Column(length = 2, nullable = false)
    private String estado;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private TipoEnderecoEnum tipo;

    public Endereco(String cep, String logradouro, String numero, String complemento,
            String bairro, String cidade,
            String estado, TipoEnderecoEnum tipo) {

        this.cep = cep;
        this.logradouro = logradouro;
        this.numero = numero;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.tipo = tipo;

    }

    public Endereco() {
        // construtor padrão exigido pelo Hibernate
    }

    public String getCep() {
        return cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public TipoEnderecoEnum getTipo() {
        return tipo;
    }
}
