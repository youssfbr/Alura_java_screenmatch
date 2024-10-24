package com.github.youssfbr.screenmatch.modelos;

public class Titulo implements Comparable<Titulo> {
    private String nome;
    private Integer anoDeLancamento;
    private Boolean incluidoNoPlano;
    private Double somaDasAvaliacoes = 0.0;
    private Integer totaDeAvaliacoes = 0;
    private Integer duracaoEmMinutos;// = 0;

    public Titulo(String nome , Integer anoDeLancamento) {
        this.nome = nome;
        this.anoDeLancamento = anoDeLancamento;
    }

    public Titulo(TituloOmdb meuTituloOmdb) {

        nome = meuTituloOmdb.title();
        anoDeLancamento = Integer.valueOf(meuTituloOmdb.year().substring(0 , 4));

        if (!meuTituloOmdb.runtime().equals("N/A")) {
          duracaoEmMinutos = Integer.valueOf(meuTituloOmdb.runtime().substring(0 , 3).replace(" " , ""));
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(Integer anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public Boolean getIncluidoNoPlano() {
        return incluidoNoPlano;
    }

    public void setIncluidoNoPlano(Boolean incluidoNoPlano) {
        this.incluidoNoPlano = incluidoNoPlano;
    }

    public Integer getDuracaoEmMinutos() {
        return duracaoEmMinutos;
    }

    public void setDuracaoEmMinutos(Integer duracaoEmMinutos) {
        this.duracaoEmMinutos = duracaoEmMinutos;
    }

    public int getTotalDeAvaliacoes() {
        return totaDeAvaliacoes;
    }

    public void exibeFichaTecnica() {
        System.out.println("\n----------------------------------------------");
        System.out.println("\nNome do filme: " + nome);
        System.out.println("Ano de lançamento: " + anoDeLancamento);
    }

    public void avalia(double nota) {
        somaDasAvaliacoes += nota;
        totaDeAvaliacoes++;
    }

    public double pegaMedia() {
        return somaDasAvaliacoes / totaDeAvaliacoes;
    }

    @Override
    public int compareTo(Titulo outroTitulo) {
        return getNome().compareTo(outroTitulo.getNome());
    }

    @Override
    public String toString() {
        return "nome=" + nome +
                ", anoDeLancamento=" + anoDeLancamento +
                ", duracaoEmMinutos=" + duracaoEmMinutos + (duracaoEmMinutos != null ? " min" : "");
    }

}
