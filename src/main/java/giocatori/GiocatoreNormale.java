package giocatori;

import caselle.Casella;
import oggetti.MultiDado;

import java.util.HashSet;

public class GiocatoreNormale implements State {
    private int posizione;
    private MultiDado dado;
    private int numeroDadi;

    public GiocatoreNormale(int posizione,int numeroDadi){
        this.posizione=posizione;
        dado=new MultiDado(numeroDadi);
    }

    @Override
    public int effettuaLancio() {
        return  dado.lanciaDado();
    }
}
