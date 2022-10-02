package caselle;

import giocatori.Giocatore;

public class LuogoDiStallo {
    private static LuogoDiStallo l;
    private boolean ultimoLancio;
    private Giocatore g;
    private LuogoDiStallo(){ }

    public synchronized static LuogoDiStallo retLuogo(){
        if(l==null){
            return l=new LuogoDiStallo();
        }
        else{
            return l;
        }
    }

    public boolean getUltimoLancio() {
        return ultimoLancio;
    }

    public void setUltimoLancio(boolean ultimoLancio) {
        this.ultimoLancio = ultimoLancio;
    }

    public Giocatore getG() {
        return g;
    }

    public void setG(Giocatore g) {
        this.g = g;
    }
}
