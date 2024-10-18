package com.github.youssfbr.screenmatch.principal;

import com.github.youssfbr.screenmatch.modelos.Filme;
import com.github.youssfbr.screenmatch.modelos.Serie;
import com.github.youssfbr.screenmatch.modelos.Titulo;

import java.util.ArrayList;

public class PrincipalComListas {
    public static void main(String[] args) {

        final Filme meuFilme = new Filme("O poderoso chefão", 1970);
        meuFilme.avalia(9);
        final Filme outroFilme = new Filme("Avatar" , 2023);
        outroFilme.avalia(6);
        var filmeDoPaulo = new Filme("Dogville" , 2003);
        filmeDoPaulo.avalia(10);
        final Serie lost = new Serie("Lost" , 2000);

        final ArrayList<Titulo> lista = new ArrayList<>();
        lista.add(filmeDoPaulo);
        lista.add(meuFilme);
        lista.add(outroFilme);
        lista.add(lost);

        for (Titulo item : lista) {

            System.out.println(item.getNome());

//          A partir da versão 17
            if (item instanceof Filme filme && filme.getClassificacao() > 2) {
                System.out.println("Classificação: " + filme.getClassificacao() + "\n");
            }

//          A partir da versão 14
//            if (item instanceof Filme filme) {
//                System.out.println("Classificação: " + filme.getClassificacao() + "\n");
//            }

//            Versoes antesriores
//            if (item instanceof Filme) {
//                final Filme filme = (Filme) item;
//                System.out.println("Classificação: " + filme.getClassificacao() + "\n");
//            }
        }



    }
}
