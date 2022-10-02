package giocatori;

import java.util.Collections;
import java.util.LinkedList;

public class GiocatoriPartita {
    private int numeroGiocatori;
    private LinkedList<Giocatore> listaGiocatori;

    public GiocatoriPartita(int numeroGiocatori,int numeroDadi){
        listaGiocatori=new LinkedList<>();
        for(int i=0;i<numeroGiocatori;i++){
            Giocatore g=new Giocatore(numeroDadi,i+1);
            listaGiocatori.add(g);
        }
        Collections.shuffle(listaGiocatori);
    }

    public Giocatore getProssimo(){
        Giocatore g=listaGiocatori.getFirst();
        listaGiocatori.removeFirst();
        return g;
    }

    public void setGiocatore(Giocatore g){
        listaGiocatori.addLast(g);
    }
}
