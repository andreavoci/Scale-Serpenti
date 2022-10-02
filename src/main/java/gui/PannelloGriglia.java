package gui;

import giocatori.Giocatore;
import oggetti.Vincitore;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class PannelloGriglia extends JPanel {
    private Cella[] lista;
    private ImpostazioniPartita ip;
    private JLabel ultimoLancio;
    private JLabel giocailGiocatore;
    private JLabel mazzo;
    private JButton vaiAvanti;
    private PannelloControllo padre;
    private Assemblatore a;

    public PannelloGriglia(int w, int h,ImpostazioniPartita ip,PannelloControllo pc) throws IOException {
        super(new GridLayout(w, h));
        lista = new Cella[h * w];
        this.ip = ip;
        this.padre=pc;
        int contatore = 0;
        boolean uno = false;
        int contatore2 = 0;
        for (int i = 0; i < w; i++) {
            if (i % 2 == 0) {
                uno = false;
            } else {
                uno = true;
                contatore2 = contatore + w + 1;
            }
            for (int j = 0; j < h; j++) {
                contatore = contatore + 1;
                if (uno) {
                    contatore2 = contatore2 - 1;
                }
                Cella c = new Cella(i, j, contatore, ip.getNumeroGiocatori());
                add(c);
                lista[contatore - 1] = c;
            }
        }
        setBorder(BorderFactory.createLineBorder(Color.black));
        a = new Assemblatore(ip.getNumeroRighe(), ip.getNumeroColonna(), ip.getNumeroSerpenti(), ip.getNumeroScale(), ip.getNumeroGiocatori(), ip.getNumeroDadi(), this,padre);
        a.setCasellapremio(ip.isPremio());
        a.setCasellapesca(ip.isMazzo());
        a.setCaselleStop(ip.isStop());
        a.setCartaAggiuntiva(ip.isCartaAggiuntica());
        a.setControllo(ip.isControllaGioco());
        a.partitaNormale();
        a.avviaPartita();
    }

    public Cella getCella(int i){
        return lista[i];
    }

    public void setUltimoLancio(int i){
        padre.setUltimoLancio(i);
    }

    public void setGiocatore(String s){
        padre.setGiocailGiocatore(s);
    }

    public static void infoBox(String infoMessage, String titleBar){
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public void avviaPartita() {
        Vincitore v= Vincitore.getPossibileVincitore();
        if(v.getVincitore()==null){
            a.mossa();
        }
        if(v.getVincitore()!=null){
            infoBox("VINCE IL GIOCATORE "+v.getVincitore().toString(),"VITTORIA!");
        }
    }

    public void avvia(){
        Osservatore o=new Osservatore(a,this);
        o.start();
    }

    public void operazione(Giocatore g){
        infoBox("VINCE IL GIOCATORE "+g.toString(),"VITTORIA!");
    }
}
