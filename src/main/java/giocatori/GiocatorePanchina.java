package giocatori;

public class GiocatorePanchina implements State {
    private int posizione;

    public GiocatorePanchina(int posizione) {
        this.posizione = posizione;
    }

    @Override
    public int effettuaLancio() {
        return 0;
    }
}
