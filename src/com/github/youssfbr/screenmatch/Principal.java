package com.github.youssfbr.screenmatch;

import com.github.youssfbr.screenmatch.calculos.CalculadoraDeTempo;
import com.github.youssfbr.screenmatch.modelos.Filme;
import com.github.youssfbr.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {

        final Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);
        System.out.println("\nDuração do filme: " + meuFilme.getDuracaoEmMinutos());

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("\nTotal de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

//        meuFilme.somaDasAvaliacoes = 10.0;
//        meuFilme.totaDeAvaliacoes = 1;
//        System.out.println(meuFilme.pegaMedia());

        final Serie lost = new Serie();
        lost.setNome("Lost");
        lost.setAnoDeLancamento(2000);
        lost.exibeFichaTecnica();
        lost.setTemporadas(10);
        lost.setEpisodiosPorTemporada(10);
        lost.setMinutosPorEpisodio(50);
        System.out.println("Duração da série: " + lost.getDuracaoEmMinutos());

        final Filme outroFilme = new Filme();
        outroFilme.setNome("Avatar");
        outroFilme.setAnoDeLancamento(2023);
        outroFilme.setDuracaoEmMinutos(200);

        final CalculadoraDeTempo calculadora = new CalculadoraDeTempo();
        calculadora.inclui(meuFilme);
        calculadora.inclui(outroFilme);
        calculadora.inclui(lost);

        System.out.println("\n----------------------------------------------\n");
        System.out.println("Tempo total da soma dos títulos das séries e filmes\n");
        System.out.println("Filme: " + meuFilme.getNome() + " , " + meuFilme.getDuracaoEmMinutos() + " minutos");
        System.out.println("Filme: " + outroFilme.getNome() + " , " + outroFilme.getDuracaoEmMinutos() + " minutos");
        System.out.println("Serie: " + lost.getNome() + " , " + lost.getDuracaoEmMinutos() + " minutos");

        System.out.println("\nTempo total: " + calculadora.getTempoTotal()+ " minutos");
    }
}
