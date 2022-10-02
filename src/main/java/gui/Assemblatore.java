package gui;

import caselle.LuogoDiStallo;
import giocatori.Giocatore;
import giocatori.GiocatoreLocanda;
import giocatori.GiocatorePanchina;
import giocatori.GiocatoriPartita;
import oggetti.Mazzo;
import tabella.Direttore;
import tabella.TabellaProxy;

import java.io.IOException;

public class Assemblatore {
    private int righe;
    private int colonne;
    private int numeroSerpenti;
    private int numeroScale;
    private int numeroGiocatori;
    private int numeroDadi;
    private boolean caselleStop=false;
    private boolean casellapremio=false;
    private boolean casellapesca=false;
    private boolean cartaAggiuntiva=false;
    private boolean controllo=false;
    private GiocatoriPartita gp;
    private TabellaProxy tp;
    private PannelloGriglia pg;
    private PannelloControllo pc;
    LuogoDiStallo lds;

    public Assemblatore(int righe, int colonne, int numeroSerpenti, int numeroScale, int numeroGiocatori,int numeroDadi,PannelloGriglia pg,PannelloControllo pc) {
        this.righe = righe;
        this.colonne = colonne;
        this.numeroSerpenti = numeroSerpenti;
        this.numeroScale = numeroScale;
        this.numeroGiocatori = numeroGiocatori;
        this.numeroDadi=numeroDadi;
        this.pg=pg;
        this.pc=pc;
    }

    public void setCaselleStop(boolean caselleStop) {
        this.caselleStop = caselleStop;
    }

    public void setCasellapremio(boolean casellapremio) {
        this.casellapremio = casellapremio;
    }

    public void setCasellapesca(boolean casellapesca) {
        this.casellapesca = casellapesca;
    }

    public void setCartaAggiuntiva(boolean cartaAggiuntiva) {
        this.cartaAggiuntiva = cartaAggiuntiva;
    }

    public void setControllo(boolean controllo) {
        this.controllo = controllo;
    }

    public void partitaNormale() throws IOException {
        Direttore d = new Direttore(numeroSerpenti, numeroScale, pg);
        d.setCasellapesca(casellapesca);
        d.setCasellapremio(casellapremio);
        d.setCaselleStop(caselleStop);
        d.setCartaAggiuntiva(cartaAggiuntiva);
        gp=new GiocatoriPartita(numeroGiocatori,numeroDadi);
        tp= new TabellaProxy(righe,colonne,d);
        lds=LuogoDiStallo.retLuogo();
    }

    public void avviaPartita(){
        for(int i=0;i<numeroGiocatori;i++){
            Giocatore g=gp.getProssimo();
            tp.add(g,0);
            gp.setGiocatore(g);
            pg.getCella(0).aggiungiGiocatore(g.toString());
        }
    }

    public void mossa()  {
        Giocatore g=gp.getProssimo();
        if(!(g.getGiocatore() instanceof GiocatorePanchina || g.getGiocatore() instanceof GiocatoreLocanda)) {
            tp.remove(g,g.getPosizione());
            try {
                pg.getCella(g.getPosizione()).rimuoviGiocatore(g.toString());
            }catch (Exception e){System.out.print("");}
            pc.setPosizionePrima(g.getPosizione()+1);
        }
        int lancio= g.effettuaMossa();
        pc.setGiocailGiocatore(g.toString());
        pc.setUltimoLancio(lancio);
        if(lancio==0){
            pc.setPosizioneDopo(g.getPosizione()+1);
            gp.setGiocatore(g);
            return;
        }
        tp.add(g,g.getPosizione()+lancio);
        pg.getCella(g.getPosizione()).aggiungiGiocatore(g.toString());
        pc.setPosizioneDopo(g.getPosizione()+1);
        Mazzo m=Mazzo.getMazzo();
        if(m.getUltimaCarta()!=null){
            pc.setCartaMazzo(m.getUltimaCarta());
        }
        if(lds.getG()!=null) {
            if (lds.getUltimoLancio()) {
                tp.remove(g, g.getPosizione() );
                pg.getCella(g.getPosizione()).rimuoviGiocatore(g.toString());
                tp.add(g, g.getPosizione()  + lancio);
                pg.getCella(g.getPosizione()).aggiungiGiocatore(g.toString());
                pc.setPosizioneDopo(g.getPosizione()+1);
                lds.setG(null);
                lds.setUltimoLancio(false);
            } else {
                tp.remove(g, g.getPosizione());
                pg.getCella(g.getPosizione()).rimuoviGiocatore(g.toString());
                int lancio2 = g.effettuaMossa();
                tp.add(g, g.getPosizione()+ lancio2);
                pc.setPosizioneDopo(g.getPosizione()+1);
                pg.setUltimoLancio(lancio2);
                pg.getCella(g.getPosizione()).aggiungiGiocatore(g.toString());
                lds.setG(null);
            }
        }
        gp.setGiocatore(g);
    }
}
