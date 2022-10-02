package caselle;

import giocatori.Giocatore;
import oggetti.Mazzo;

public class CasellaMazzo extends Decoratore {
    public CasellaMazzo(Casella c) {
        super(c);
    }

    @Override
    public void add(Giocatore g) {
        System.out.print(g.getID()+" pesca la carta");
        System.out.print("\n");
        pesca(g);
        super.add(g);
    }

    @Override
    public void remove(Giocatore g) {
        super.remove(g);
    }

    @Override
    public int getNumeroCasella() {
        return super.getNumeroCasella();
    }

    public void pesca(Giocatore g){
        Mazzo.getMazzo().pesca(g);
    }
}
