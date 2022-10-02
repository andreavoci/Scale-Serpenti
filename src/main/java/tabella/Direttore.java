package tabella;

import gui.PannelloGriglia;
import oggetti.Mazzo;
import oggetti.Pescatore;

import java.io.IOException;
import java.util.ArrayList;

public class Direttore {
    private int numeroSerpenti;
    private int numeroScale;
    private boolean caselleStop;
    private boolean casellapremio;
    private boolean casellapesca;
    private boolean cartaAggiuntiva;
    private PannelloGriglia pg;

    public Direttore(int numeroSerpenti, int numeroScale, PannelloGriglia pg) {
        this.numeroSerpenti = numeroSerpenti;
        this.numeroScale = numeroScale;
        this.caselleStop=false;
        this.casellapremio=false;
        this.casellapesca=false;
        this.cartaAggiuntiva=false;
        this.pg=pg;
    }

    public void Build(BuilderConcreto bc) throws IOException {
        bc.setPannelloGriglia(pg);
        bc.inserisciSerpenti(numeroSerpenti);
        bc.inserisciScale(numeroScale);
        bc.caselleRestanti();
        bc.casellaVittora();
        if(caselleStop){
            bc.inserisciSosta();
        }
        if(casellapremio) {
            bc.inserisciPremio();
        }
        if(casellapesca){
            bc.inserisciPesca();
            if(cartaAggiuntiva) {
                Pescatore p = new Pescatore(true);
                Mazzo.getMazzo().setP(p);
            }else{
                Pescatore p=new Pescatore(false);
                Mazzo.getMazzo().setP(p);
            }
        }
    }

    public void BuildConPosizioni(BuilderConcreto bc, ArrayList<Punti> lista, ArrayList<Punti> lista2) throws IOException {
        bc.setPannelloGriglia(pg);
        bc.inserisciSerpenti(numeroSerpenti,lista);
        bc.inserisciScale(numeroScale,lista2);
        bc.caselleRestanti();
        bc.casellaVittora();
        if(caselleStop){
            bc.inserisciSosta();
        }
        if(casellapremio) {
            bc.inserisciPremio();
        }
        if(casellapesca){
            bc.inserisciPesca();
            if(cartaAggiuntiva) {
                Pescatore p = new Pescatore(true);
                Mazzo.getMazzo().setP(p);
            }else{
                Pescatore p=new Pescatore(false);
                Mazzo.getMazzo().setP(p);
            }
        }
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
        if(casellapesca==true) {
            this.cartaAggiuntiva = cartaAggiuntiva;
        }
    }
}
