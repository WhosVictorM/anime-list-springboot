package com.whosvictorm.animesAPI.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "animes")
public class Anime {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String nome;
    private String descricao;

    public Anime() {
    }

    public Anime(Long id, String nome, String descricao) {
        Id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anime anime = (Anime) o;
        return Objects.equals(nome, anime.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
