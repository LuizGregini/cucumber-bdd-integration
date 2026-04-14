package org.example.entidades;

import java.time.LocalDate;

public class Filme {

    private LocalDate dataDeEntrega;
    private int quantidade;
    private double preco;
    private String tipoDeAluguel = "SEM_VINCULO";

    private int pontuacao = 0;

    public int getPontuacao() {
        return pontuacao;
    }
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public LocalDate getDataDeEntrega() {
        return dataDeEntrega;
    }
    public void setDataDeEntrega(LocalDate dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }
    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTipoDeAluguel() {
        return tipoDeAluguel;
    }

    public void setTipoDeAluguel(String tipoDeAluguel) {
        this.tipoDeAluguel = tipoDeAluguel;
    }

    @Override
    public String toString() {
            return "Filme{" +
                    "Quantidade: " + quantidade +
                    ", Preço: " + preco +
                    ", Data de Entrega: " + dataDeEntrega +
                    ", Tipo de Aluguel: " + tipoDeAluguel +
                    ", Pontuação: " + pontuacao +
                    '}';
    }
}
