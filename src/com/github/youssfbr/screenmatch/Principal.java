package com.github.youssfbr.screenmatch;

import com.github.youssfbr.screenmatch.calculos.CalculadoraDeTempo;
import com.github.youssfbr.screenmatch.calculos.FiltroRecomendacao;
import com.github.youssfbr.screenmatch.modelos.Episodio;
import com.github.youssfbr.screenmatch.modelos.Filme;
import com.github.youssfbr.screenmatch.modelos.Serie;

import java.util.ArrayList;

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

        System.out.println("\n----------------------------------------------\n");
        System.out.println(meuFilme.getNome());
        final FiltroRecomendacao filtro = new FiltroRecomendacao();
        filtro.filtra(meuFilme);

        System.out.println("\n----------------------------------------------\n");
        System.out.println(lost.getNome());
        final Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setSerie(lost);
        episodio.setTotalVisualizacoes(300);
        filtro.filtra(episodio);

        var filmeDoPaulo = new Filme();
        filmeDoPaulo.setNome("Dogville");
        filmeDoPaulo.setDuracaoEmMinutos(200);
        filmeDoPaulo.setAnoDeLancamento(2003);
        filmeDoPaulo.avalia(10);

        final ArrayList<Filme> listaDeFilmes = new ArrayList<>();
        listaDeFilmes.add(filmeDoPaulo);
        listaDeFilmes.add(meuFilme);
        listaDeFilmes.add(outroFilme);

        System.out.println("\n----------------------------------------------\n");
        final String s = listaDeFilmes.size() > 1 ? "s" : "";
        System.out.println("Tamanho da Lista: " + listaDeFilmes.size() + " filme" + s);
        System.out.println("Primeiro filme: " + listaDeFilmes.get(0).getNome());
        System.out.println("Primeiro filme: " + listaDeFilmes.getFirst().getNome());

        System.out.println("\n----------------------------------------------\n");
        System.out.println(listaDeFilmes);
    }
}
