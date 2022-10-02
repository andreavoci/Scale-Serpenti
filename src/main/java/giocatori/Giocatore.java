package giocatori;

import caselle.LuogoDiStallo;
import oggetti.Vincitore;

public class Giocatore {
    private int ID;
    private int posizione;
    private State giocatore;
    private int numeroDadi;
    private Memento m;
    private int contatore=0;
    private boolean lasciaPassare;
    private boolean vincitore;

    public Giocatore(int numeroDadi,int ID) {
        this.posizione = 0;
        this.ID=ID;
        this.numeroDadi = numeroDadi;
        if(numeroDadi==1){
            giocatore=new GiocatoreFine(posizione);
        }else {
            giocatore = new GiocatoreNormale(posizione, numeroDadi);
        }
        Vincitore.getPossibileVincitore().attach(this);
    }

    public int effettuaMossa(){
        if(contatore==0) {
            int i= giocatore.effettuaLancio();
            if(i/12==1){
                LuogoDiStallo.retLuogo().setG(this);
            }
            return i;
        }
        else{
            contatore--;
            int i=giocatore.effettuaLancio();
            if(i/12==1){
                LuogoDiStallo.retLuogo().setG(this);
            }
            if(contatore==0){
                restore();
            }
            return i;
        }
    }

    public void setGiocatore(State giocatore){
        if(giocatore instanceof GiocatoreLocanda){
            contatore=3;
        }
        if(giocatore instanceof GiocatorePanchina){
            contatore=1;
        }
        m=creaMemento();
        this.giocatore=giocatore;
    }

    private Memento creaMemento(){
        return new Memento(posizione,giocatore,numeroDadi);
    }

    private void restore(){
        giocatore=m.getGiocatore();
    }

    public State getGiocatore() {
        return giocatore;
    }

    public int getNumeroDadi() {
        return numeroDadi;
    }

    public void abbiamoUnVincitore(){
        Giocatore vincente=Vincitore.getPossibileVincitore().getVincitore();
        if(vincente==this){
            vincitore=true;
        }
        else{
            vincitore=false;
        }
    }

    public int getID() {
        return ID;
    }

    public void setLasciaPassare(boolean lasciaPassare) {
        this.lasciaPassare = lasciaPassare;
    }

    public boolean getLasciaPassare(){
        return lasciaPassare;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }

    public int getPosizione() {
        return posizione;
    }

    private class Memento{
        private int posizione;
        private State giocatore;
        private int numeroDadi;

        public Memento(int posizione, State giocatore, int numeroDadi) {
            this.posizione = posizione;
            this.giocatore = giocatore;
            this.numeroDadi = numeroDadi;
        }

        public int getPosizione() {
            return posizione;
        }

        public void setPosizione(int posizione) {
            this.posizione = posizione;
        }

        public State getGiocatore() {
            return giocatore;
        }

        public void setGiocatore(State giocatore) {
            this.giocatore = giocatore;
        }
    }

    public String toString(){
        return "G"+ID;
    }
}
