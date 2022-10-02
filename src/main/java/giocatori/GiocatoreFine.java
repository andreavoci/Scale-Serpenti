package giocatori;

import oggetti.Dado;

public class GiocatoreFine implements State{
    private int posizione;
    private Dado dado;

    public GiocatoreFine(int posizione) {
        this.posizione = posizione;
        dado=dado.getIstance();
    }

    @Override
    public int effettuaLancio() {

        return dado.lanciaDado();
    }
}
