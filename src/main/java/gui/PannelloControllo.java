package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.io.IOException;

public class PannelloControllo extends PannelloAbstract {
    private PannelloAbstract pa;
    private JLabel ultimoLancio;
    private JLabel giocailGiocatore;
    private JLabel mazzo;
    private ImpostazioniPartita ip;
    private JButton avviaPartita;
    private PannelloGriglia pg;
    private JLabel posizionePrima;
    private JLabel posizioneDopo;
    private JButton back;
    
    public PannelloControllo(int w,int h,ImpostazioniPartita ip) throws IOException {
        this.ip=ip;
        setLayout(null);
        pg= new PannelloGriglia(w,h,ip,this);
        this.add(pg);
        pg.setBounds(0,0,800,500);
        //
        JLabel val=new JLabel("Valore Ultimo Lancio:");
        val.setBounds(900,0,200,30);
        add(val);
        ultimoLancio=new JLabel("");
        ultimoLancio.setBounds(900,40,200,30);
        add(ultimoLancio);
        //
        JLabel val2=new JLabel("Gioca il Giocatore:");
        val2.setBounds(900,100,200,30);
        add(val2);
        giocailGiocatore=new JLabel("");
        giocailGiocatore.setBounds(900,140,200,30);
        add(giocailGiocatore);
        //
        if(ip.isMazzo()) {
            JLabel val3 = new JLabel( "Mazzo:");
            val3.setBounds(900, 180, 200, 30);
            add(val3);
            mazzo = new JLabel("");
            mazzo.setBounds(900, 220, 200, 30);
            add(mazzo);
        }
        if(ip.isControllaGioco()){
            avviaPartita=new JButton("Mossa Successiva");
            this.add(avviaPartita);
            avviaPartita.setBounds(900,500,200,30);
            avviaPartita.addActionListener(this::actionPerformed);
        }
        else{
            pg.avvia();
        }
        //
        JLabel val4 = new JLabel("Cella Precedente: ");
        val4.setBounds(900, 260, 200, 30);
        add(val4);
        posizionePrima = new JLabel("");
        posizionePrima.setBounds(900, 280, 200, 30);
        add(posizionePrima);
        //
        JLabel val5 = new JLabel("Cella Attuale: ");
        val5.setBounds(900, 320, 200, 30);
        add(val5);
        posizioneDopo = new JLabel("");
        posizioneDopo.setBounds(900, 360, 200, 30);
        add(posizioneDopo);
        //
        back = new JButton("Torna Indietro");
        add(back);
        back.setBounds(900, 560, 200, 30);
        back.addActionListener(this::actionPerformed);
        //
        JLabel nome = new JLabel("Scale e Serpenti");
        nome.setBounds(530, 550, 200,50);
        nome.setFont(new Font("Serif", Font.PLAIN, 18));
        this.add(nome);
    }

    public PannelloAbstract getState(){
        return pa;
    }

    public void setPa(PannelloAbstract pi){
        pa=pi;
        notifica();
    }

    public void setUltimoLancio( int i){
        ultimoLancio.setText(String.valueOf(i));
    }

    public void setGiocailGiocatore(String s){
        giocailGiocatore.setText(s);
    }

    public void setCartaMazzo(String s){
        mazzo.setText(s);
    }

    public void setPosizionePrima(int i){
        posizionePrima.setText(String.valueOf(i));
    }

    public void setPosizioneDopo(int i){
        posizioneDopo.setText(String.valueOf(i));
    }

    public void actionPerformed(ActionEvent e){
        Object o = e.getSource();
        if (o == avviaPartita) {
            try{
                pg.avviaPartita();
            }catch (Exception ca){}
        }
        else if (o == back){
            try{
                setPa(new PannelloImpostazioni());
            }catch(Exception exc){}
        }
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }

    public void comunicaVincitore(String s){
        infoBox(s,"Vince il giocatore");
    }
}
