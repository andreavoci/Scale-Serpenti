package tabella;

import giocatori.Giocatore;
import giocatori.GiocatoreFine;
import giocatori.GiocatoreNormale;

import java.io.IOException;

public class TabellaProxy {
    private TabelloneConcreto tabella;
    private int numeroCaselle;

    public TabellaProxy(int righe,int colonne,Direttore d) throws IOException {
        BuilderConcreto bc=new BuilderConcreto(righe,colonne);
        d.Build(bc);
        tabella=new TabelloneConcreto(bc.getC());
        numeroCaselle=righe*colonne;
    }

    public void add(Giocatore g, int posizione){
        if(posizione>numeroCaselle-1){
            int i=(numeroCaselle-1)-(posizione-(numeroCaselle-1));
            tabella.add(g,i);
        }else{
            tabella.add(g,posizione);
        }
        if((numeroCaselle-1)-g.getPosizione()<=6 && !(g.getGiocatore() instanceof GiocatoreFine)){
            quasiAllaFine(g);
        }
        if((numeroCaselle-1)-g.getPosizione()>6 && (g.getGiocatore() instanceof GiocatoreFine)){
            tornaNormale(g);
        }
    }

    public void remove(Giocatore g,int posizione){
        tabella.remove(g,posizione);
    }

    public void quasiAllaFine(Giocatore g){
        GiocatoreFine gf= new GiocatoreFine(g.getPosizione());
        g.setGiocatore(gf);
    }

    public void tornaNormale(Giocatore g){
        GiocatoreNormale gn=new GiocatoreNormale(g.getPosizione(),g.getNumeroDadi());
        g.setGiocatore(gn);
    }
}
