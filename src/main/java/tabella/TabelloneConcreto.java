package tabella;

import caselle.Casella;
import giocatori.Giocatore;

public class TabelloneConcreto implements Tabella{
    private Casella[] lista;

    public TabelloneConcreto(Casella[] lista) {
        this.lista = lista;
    }

    public void add(Giocatore g, int posizione){
        lista[posizione].add(g);
    }

    public void remove(Giocatore g,int posizione){
        lista[posizione].remove(g);
    }
}
