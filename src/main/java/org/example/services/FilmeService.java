package org.example.services;

import org.example.entidades.Filme;
import org.example.enums.TipoDeLocacao;
import org.jetbrains.annotations.NotNull;

import java.time.LocalDate;

public class FilmeService {

    public void alugarFilme(@NotNull Filme filme){
        if (filme.getQuantidade() <= 0) {
            System.out.println("Filme não possui estoque");
        }
        TipoDeLocacao tipo = TipoDeLocacao.valueOf(filme.getTipoDeAluguel());
        filme.setDataDeEntrega(LocalDate.now().plusDays(tipo.getDias()));
        filme.setPreco(tipo.getPreco());
        filme.setPontuacao(tipo.getPontuacao());
        filme.setQuantidade(filme.getQuantidade() - 1);
    }
}
