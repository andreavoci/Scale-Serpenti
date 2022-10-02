package caselle;

import giocatori.Giocatore;

import java.util.HashSet;

public class CasellaCoda implements Casella {
    private HashSet<Giocatore> listaGiocatori;
    private int numeroCasella;

    public CasellaCoda(int numeroCasella) {
        this.numeroCasella = numeroCasella;
    }

    @Override
    public void add(Giocatore g) {
        if(listaGiocatori==null){
            listaGiocatori=new HashSet<Giocatore>();
            listaGiocatori.add(g);
            g.setPosizione(numeroCasella);
        }
        else{
            listaGiocatori.add(g);
            g.setPosizione(numeroCasella);
        }
    }

    @Override
    public void remove(Giocatore g) {
        listaGiocatori.remove((Giocatore)g);
        if(listaGiocatori.size()==0){
            listaGiocatori=null;
        }
    }

    @Override
    public int getNumeroCasella() {
        return numeroCasella;
    }
}
