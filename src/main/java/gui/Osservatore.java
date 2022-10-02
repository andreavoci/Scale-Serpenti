package gui;

import oggetti.Vincitore;

public class Osservatore extends Thread {
    private Assemblatore r;
    private Vincitore v;
    private PannelloGriglia pg;

    public Osservatore(Assemblatore r,PannelloGriglia pg){
        this.r=r;
        this.pg=pg;
        v=Vincitore.getPossibileVincitore();
    }

    public void run(){
        while(v.getVincitore()==null){
            r.mossa();
            try {
                sleep(2500);
            }catch (Exception e){
                System.out.print("");
            }
        }
        pg.operazione(v.getVincitore());
    }
}
