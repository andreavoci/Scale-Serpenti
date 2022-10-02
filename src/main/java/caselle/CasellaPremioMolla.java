package caselle;

import giocatori.Giocatore;

public class CasellaPremioMolla extends Decoratore {
    private int numeroCasella;

    public CasellaPremioMolla(Casella c) {
        super(c);
    }

    @Override
    public void add(Giocatore g) {
        System.out.print(g.getID()+" salta avanti");
        System.out.print("\n");
        super.add(g);
        operazione(g);
    }

    @Override
    public void remove(Giocatore g) {
        super.remove(g);
    }

    @Override
    public int getNumeroCasella() {
        return super.getNumeroCasella();
    }

    public void operazione(Giocatore g){
        LuogoDiStallo.retLuogo().setG(g);
        LuogoDiStallo.retLuogo().setUltimoLancio(true);
    }
}
