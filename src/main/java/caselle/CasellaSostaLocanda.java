package caselle;

import giocatori.Giocatore;
import giocatori.GiocatoreLocanda;
import oggetti.Mazzo;

public class CasellaSostaLocanda extends CasellaSosta {
    public CasellaSostaLocanda(Casella c) {
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
        fermaGiocatore(g);
    }

    public void fermaGiocatore(Giocatore g){
        if(!g.getLasciaPassare()){
            GiocatoreLocanda gp=new GiocatoreLocanda(super.getNumeroCasella());
            System.out.print(g.getID()+" fermo in posizione "+super.getNumeroCasella());
            System.out.print("\n");
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
