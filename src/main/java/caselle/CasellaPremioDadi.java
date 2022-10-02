package caselle;

import giocatori.Giocatore;

public class CasellaPremioDadi extends Decoratore {
    private int numeroCasella;

    public CasellaPremioDadi(Casella c) {
        super(c);
    }

    @Override
    public void add(Giocatore g) {
        System.out.print(g.getID()+" rigioca");
        System.out.print("\n");
        rigioca(g);
        super.add(g);
    }

    @Override
    public void remove(Giocatore g) {
        super.remove(g);
    }

    @Override
    public int getNumeroCasella() {
        return numeroCasella;
    }

    public void rigioca(Giocatore g){
        LuogoDiStallo.retLuogo().setG(g);
    }
}
