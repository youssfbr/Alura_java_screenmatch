package com.github.youssfbr.screenmatch.calculos;

import com.github.youssfbr.screenmatch.modelos.Titulo;

public class CalculadoraDeTempo {
    private Integer tempoTotal = 0;

    public Integer getTempoTotal() {
        return tempoTotal;
    }

//    public void inclui(Filme f) {
//        tempoTotal += f.getDuracaoEmMinutos();
//    }
//    public void inclui(Serie s) {
//        tempoTotal += s.getDuracaoEmMinutos();
//    }

        public void inclui(Titulo titulo) {
        tempoTotal += titulo.getDuracaoEmMinutos();
    }

}
