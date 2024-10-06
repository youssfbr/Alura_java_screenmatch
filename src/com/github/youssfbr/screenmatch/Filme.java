package com.github.youssfbr.screenmatch;

public class Filme {
    String nome;
    Integer anoDeLancamento;
    Boolean incluidoNoPlano;
    private Double somaDasAvaliacoes = 0.0;
    private Integer totaDeAvaliacoes = 0;
    Integer duracaoEmMinutos;

    int getTotalDeAvaliacoes() {
        return totaDeAvaliacoes;
    }

    void exibeFichaTecnica() {
        System.out.println("\nNome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totaDeAvaliacoes++;
    }

    double pegaMedia() {
        return somaDasAvaliacoes / totaDeAvaliacoes;
    }

}
