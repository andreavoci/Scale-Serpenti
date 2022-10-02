package caselle;

import giocatori.Giocatore;

public class CasellaFineScala implements Casella {
    private CasellaInizioScala cimaScala;
    private int numeroCasella;

    public CasellaFineScala(CasellaInizioScala cimaScala, int numeroCasella) {
        this.cimaScala = cimaScala;
        this.numeroCasella = numeroCasella;
    }

    @Override
    public void add(Giocatore g) {
        System.out.print(g.getID()+" sale la scala fino in cima");
        System.out.print("\n");
        cimaScala.add(g);
    }

    @Override
    public void remove(Giocatore g) { }

    @Override
    public int getNumeroCasella() {
        return cimaScala.getNumeroCasella();
    }
}
