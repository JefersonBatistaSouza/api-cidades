package com.jeferson.apicidades.pais;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pais")
public class Pais {
    @Id
    private Long id;
    @Column(name = "nome")
    private String nome;
    @Column(name = "nome_pt")
    private String nome_pt;
    @Column(name = "sigla")
    private String sigla;
    @Column(name = "bacen")
    private Integer bacen;

    public Pais() {
    }

    public Pais(String nome){
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome_pt() {
        return nome_pt;
    }

    public void setNome_pt(String nome_pt) {
        this.nome_pt = nome_pt;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }

    public Integer getBacen() {
        return bacen;
    }

    public void setBacen(Integer bacen) {
        this.bacen = bacen;
    }

    @Override
    public String toString() {
        return "Pais{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", nome_pt='" + nome_pt + '\'' +
                ", sigla='" + sigla + '\'' +
                ", bacen=" + bacen +
                '}';
    }
}
