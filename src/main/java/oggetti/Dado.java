package oggetti;

import java.util.Random;

public class Dado {
    private int ultimoLancio;
    private static Dado d;

    private Dado() { }


    public static synchronized Dado getIstance() {
        if(d==null){
            return d=new Dado();
        }
        return d;
    }


    public static synchronized int lanciaDado() {
        int r = new Random().nextInt(6) + 1;
        d.ultimoLancio=r;
        return r;
    }

    public int getUltimoLancio(){
        return d.ultimoLancio;
    }
}
