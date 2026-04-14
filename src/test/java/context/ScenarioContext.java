package context;

import org.example.entidades.Filme;

public class ScenarioContext {

    private Filme filme;

    public Filme getFilme() {
        return filme;
    }

    public boolean setFilme(Filme filme) {
        this.filme = filme;
        return false;
    }
}
