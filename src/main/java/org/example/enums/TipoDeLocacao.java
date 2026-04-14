package org.example.enums;

public enum TipoDeLocacao {

    EXTENDIDO(3, 8.00, 1),
    COMUM(1, 4.00, 1),
    SEM_VINCULO(1, 3.00, 1);

    private final int dias;
    private final double preco;
    private final int pontuacao;

    TipoDeLocacao(int dias, double preco, int pontuacao) {
        this.dias = dias;
        this.preco = preco;
        this.pontuacao = pontuacao;
    }

    public int getDias() {
        return dias;
    }

    public double getPreco() {
        return preco;
    }

    public int getPontuacao() {
        return pontuacao;
    }
}
