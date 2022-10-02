package oggetti;

import giocatori.Giocatore;

import java.util.ArrayList;

public class Vincitore {
    private static Vincitore v;
    private ArrayList<Giocatore> listaOsservatori;
    private Giocatore g;

    private Vincitore(){
    }

    public synchronized static Vincitore getPossibileVincitore(){
        if(v==null){

            return v=new Vincitore();
        }
        else{
            return v;
        }
    }

    public void attach(Giocatore g){
        if(listaOsservatori==null){
            listaOsservatori=new ArrayList<>();
        }
        listaOsservatori.add(g);
    }

    public void notifica(){
        for(Giocatore g: listaOsservatori){
            g.abbiamoUnVincitore();
        }
    }

    public void setVincitore(Giocatore g){
        notifica();
        this.g=g;
    }

    public Giocatore getVincitore(){
        return g;
    }
}
