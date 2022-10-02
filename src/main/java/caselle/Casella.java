package caselle;

import giocatori.Giocatore;

public interface Casella {
    public void add(Giocatore g);
    public void remove(Giocatore g);
    public int getNumeroCasella();
}
