package giocatori;

public class GiocatoreLocanda implements State {
    private int posizione;

    public GiocatoreLocanda(int posizione) {
        this.posizione = posizione;
    }

    @Override
    public int effettuaLancio() {
        return 0;
    }
}
