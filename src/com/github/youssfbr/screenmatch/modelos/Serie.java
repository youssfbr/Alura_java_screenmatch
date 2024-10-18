package com.github.youssfbr.screenmatch.modelos;

public class Serie extends Titulo {
    private Integer temporadas;
    private Boolean ativa;
    private Integer episodiosPorTemporada;
    private Integer minutosPorEpisodio;

    public Serie(String nome , Integer anoDeLancamento) {
        super(nome , anoDeLancamento);
    }

    public Integer getTemporadas() {
        return temporadas;
    }

    public void setTemporadas(Integer temporadas) {
        this.temporadas = temporadas;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Integer getEpisodiosPorTemporada() {
        return episodiosPorTemporada;
    }

    public void setEpisodiosPorTemporada(Integer episodiosPorTemporada) {
        this.episodiosPorTemporada = episodiosPorTemporada;
    }

    public Integer getMinutosPorEpisodio() {
        return minutosPorEpisodio;
    }

    public void setMinutosPorEpisodio(Integer minutosPorEpisodio) {
        this.minutosPorEpisodio = minutosPorEpisodio;
    }

    @Override
    public Integer getDuracaoEmMinutos() {
        return temporadas * episodiosPorTemporada * minutosPorEpisodio ;
    }

    @Override
    public String toString() {
        return "Série: " + getNome() + " (" + getAnoDeLancamento() + ")";
    }
}
