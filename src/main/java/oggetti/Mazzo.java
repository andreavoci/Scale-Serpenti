package oggetti;

import giocatori.Giocatore;

public class Mazzo {
    private static Mazzo m;
    private Mazzo(){}
    private Pescatore p;
    private static ControlloreEventi ce;
    private String ultimaCarta;

    public synchronized static Mazzo getMazzo(){
        if(m==null){
            m=new Mazzo();
            ce=ControlloreEventi.getControllore();
            return m;
        }
        else{
            return m;
        }
    }

    public void setP(Pescatore p) {
        this.p = p;
    }

    public void pesca(Giocatore g){
        String s=p.pesca();
        ce.Evento(s,g);
        System.out.print("la carta pescata è:"+s);
        System.out.print("\n");
        ultimaCarta=s;
        if(!(s.equals("LasciaPassare"))) {
            p.inserisci();
        }
    }

    public String getUltimaCarta(){
        return ultimaCarta;
    }

    public void posaLasciaPassare(String s){
        p.inserisci(s);
    }
}
