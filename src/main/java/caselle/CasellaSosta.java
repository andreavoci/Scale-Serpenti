package caselle;

import giocatori.Giocatore;

public class CasellaSosta extends Decoratore {
    public CasellaSosta(Casella c) {
        super(c);
    }

    @Override
    public void add(Giocatore g){
        super.add(g);
    }

    @Override
    public void remove(Giocatore g){
        super.remove(g);
    }
}
