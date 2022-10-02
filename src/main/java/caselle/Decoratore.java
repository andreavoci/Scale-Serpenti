package caselle;

import giocatori.Giocatore;

public abstract class Decoratore implements Casella {
    private Casella c;

    public Decoratore(Casella c) {
        this.c = c;
    }

    @Override
    public void add(Giocatore g) {
        c.add(g);
    }

    @Override
    public void remove(Giocatore g) {
        c.remove(g);
    }

    @Override
    public int getNumeroCasella() {
        return c.getNumeroCasella();
    }
}
