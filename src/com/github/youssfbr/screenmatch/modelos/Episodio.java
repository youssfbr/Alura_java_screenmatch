package com.github.youssfbr.screenmatch.modelos;

import com.github.youssfbr.screenmatch.calculos.Classificavel;

public class Episodio implements Classificavel {
    private Integer numero;
    private String nome;
    private Serie serie;
    private int totalVisualizacoes;

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public int getTotalVisualizacoes() {
        return totalVisualizacoes;
    }

    public void setTotalVisualizacoes(int totalVisualizacoes) {
        this.totalVisualizacoes = totalVisualizacoes;
    }

    @Override
    public int getClassificacao() {
        return (totalVisualizacoes > 100) ? 4 : 2 ;
    }
}
