package com.janadeve.janadeveportalbackend.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "posts", schema = "public")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    @Column(length = 167772)
    private String texto;
    private LocalDate datapubicacao;
    private boolean ativo;

    public Post() {
    }

    public Post(Long id, String titulo, String descricao, String texto, LocalDate datapubicacao, boolean ativo) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.texto = texto;
        this.datapubicacao = datapubicacao;
        this.ativo = ativo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public LocalDate getDatapubicacao() {
        return datapubicacao;
    }

    public void setDatapubicacao(LocalDate datapubicacao) {
        this.datapubicacao = datapubicacao;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
}
