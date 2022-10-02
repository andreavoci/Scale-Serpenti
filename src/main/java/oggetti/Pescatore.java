package oggetti;

public class Pescatore {
    private Carte c;
    private String cartaPescata;

    public Pescatore(boolean b){
        c=new Carte(b);
    }

    public String pesca(){
        cartaPescata= c.pescaCarta();
        return cartaPescata;
    }

    public void inserisci(){
        c.posaCarta(cartaPescata);
    }

    public void inserisci(String s){
        if(s.equals("LasciaPassare")) {
            c.posaCarta(s);
        }
        else throw new RuntimeException();
    }
}
