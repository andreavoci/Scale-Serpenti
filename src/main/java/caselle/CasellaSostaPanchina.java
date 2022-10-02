package caselle;

import giocatori.Giocatore;
import giocatori.GiocatorePanchina;
import oggetti.Mazzo;

public class CasellaSostaPanchina extends CasellaSosta {
    public CasellaSostaPanchina(Casella c) {
        super(c);
    }

    @Override
    public void remove(Giocatore g) {
        super.remove(g);
    }

    @Override
    public void add(Giocatore g) {
        System.out.print(g.getID()+" STOP");
        System.out.print("\n");
        super.add(g);
        g.setPosizione(super.getNumeroCasella());
        fermaGiocatore(g);
    }

    public void fermaGiocatore(Giocatore g){
        if(!g.getLasciaPassare()){
            System.out.print(g.getID()+" fermo in posizione "+super.getNumeroCasella());
            System.out.print("\n");
            GiocatorePanchina gp=new GiocatorePanchina(super.getNumeroCasella());
            g.setGiocatore(gp);
        }
        else{
            g.setLasciaPassare(false);
            System.out.print("giocatore fortunato");
            System.out.print("\n");
            Mazzo.getMazzo().posaLasciaPassare("LasciaPassare");
        }
    }
}
