package caselle;

import giocatori.Giocatore;
import oggetti.Vincitore;

public class CasellaVittoria extends Decoratore {
    public CasellaVittoria(Casella c) {
        super(c);
    }

    @Override
    public int getNumeroCasella() {
        return super.getNumeroCasella();
    }

    @Override
    public void remove(Giocatore g) {
        super.remove(g);
    }

    @Override
    public void add(Giocatore g) {
        vincitore(g);
        super.add(g);
    }

    public void vincitore(Giocatore g){
        Vincitore.getPossibileVincitore().setVincitore(g);
    }
}
