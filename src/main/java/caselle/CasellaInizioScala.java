package caselle;

import giocatori.Giocatore;
import oggetti.Vincitore;

import java.util.HashSet;

public class CasellaInizioScala implements Casella {
    private HashSet<Giocatore> listaGiocatori;
    private int numeroCasella;
    private boolean controllo;

    public CasellaInizioScala(int numeroCasella) {
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
        if(controllo==true){
            Vincitore.getPossibileVincitore().setVincitore(g);
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

    public void setControllo(boolean controllo) {
        this.controllo = controllo;
    }
}
