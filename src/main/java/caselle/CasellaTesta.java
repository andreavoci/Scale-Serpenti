package caselle;

import giocatori.Giocatore;

public class CasellaTesta implements Casella {
    private int numeroTesta;
    private CasellaCoda coda;

    public CasellaTesta(int numeroTesta, CasellaCoda coda) {
        this.numeroTesta = numeroTesta;
        this.coda = coda;
    }

    @Override
    public void add(Giocatore g) {
        System.out.print(g.getID()+" percorre il serpente e scende giù");
        System.out.print("\n");
        coda.add(g);
    }

    @Override
    public void remove(Giocatore g) {}

    @Override
    public int getNumeroCasella() {
        return coda.getNumeroCasella();
    }
}
