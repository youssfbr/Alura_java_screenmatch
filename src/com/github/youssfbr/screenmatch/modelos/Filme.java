package com.github.youssfbr.screenmatch.modelos;

import com.github.youssfbr.screenmatch.calculos.Classificavel;

public class Filme extends Titulo implements Classificavel {
    private String diretor;

    public Filme(String nome , Integer anoDeLancamento) {
        super(nome , anoDeLancamento);
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    @Override
    public int getClassificacao() {
        return (int) pegaMedia() / 2;
    }

    @Override
    public String toString() {
        return getNome() + " (" + getAnoDeLancamento() + ")";
    }
}
