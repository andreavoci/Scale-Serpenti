package oggetti;

import caselle.LuogoDiStallo;
import giocatori.Giocatore;
import giocatori.GiocatoreLocanda;
import giocatori.GiocatorePanchina;

public class ControlloreEventi {
    private static ControlloreEventi ce;
    private ControlloreEventi(){};

    public synchronized static ControlloreEventi getControllore(){
        if(ce==null){
            ce=new ControlloreEventi();
            return ce;
        }else{
            return ce;
        }
    }

    public void Evento(String s, Giocatore g){
        if(s.equals("Rilancia")){
            LuogoDiStallo lds=LuogoDiStallo.retLuogo();
            lds.setG(g);
        }
        if(s.equals("Locanda")){
            GiocatoreLocanda gp=new GiocatoreLocanda(g.getPosizione());
            g.setGiocatore(gp);
        }
        if(s.equals("Panchina")){
            GiocatorePanchina gp=new GiocatorePanchina(g.getPosizione());
            g.setGiocatore(gp);
        }
        if(s.equals("Molla")){
            LuogoDiStallo.retLuogo().setG(g);
            LuogoDiStallo.retLuogo().setUltimoLancio(true);
        }
        if(s.equals("LasciaPassare")){
            g.setLasciaPassare(true);
        }
    }
}
