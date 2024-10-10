package com.github.youssfbr.screenmatch;

import com.github.youssfbr.screenmatch.modelos.Filme;

public class Principal {
    public static void main(String[] args) {

        final Filme meuFilme = new Filme();
        meuFilme.setNome("O poderoso chefão");
        meuFilme.setAnoDeLancamento(1970);
        meuFilme.setDuracaoEmMinutos(180);

        meuFilme.exibeFichaTecnica();

        meuFilme.avalia(8);
        meuFilme.avalia(5);
        meuFilme.avalia(10);

        System.out.println("\nTotal de avaliações: " + meuFilme.getTotalDeAvaliacoes());
        System.out.println(meuFilme.pegaMedia());

//        meuFilme.somaDasAvaliacoes = 10.0;
//        meuFilme.totaDeAvaliacoes = 1;
//        System.out.println(meuFilme.pegaMedia());
    }
}
