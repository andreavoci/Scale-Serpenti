package tabella;

import giocatori.Giocatore;

public interface Tabella {
    public void add(Giocatore g, int posizione);
    public void remove(Giocatore g,int posizione);
}
