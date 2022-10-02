package gui;

import javax.swing.*;
import java.io.IOException;

public class Gestore {
    PannelloAbstract pannelloCorrente;
    JFrame finestra;
    JPanel currentPanel;

    public Gestore(JFrame finestra,PannelloIniziale pa){
        pa.attach(this);
        this.finestra=finestra;
        pannelloCorrente=pa;
        this.setCurrentPanel(pannelloCorrente);
        this.avviaFinestra();
    }

    public void avviaFinestra(){
        finestra.setVisible(true);
    }

    public void setCurrentPanel(JPanel panel){
        currentPanel=panel;
        finestra.setContentPane(panel);
        finestra.revalidate();
    }

    public void update(){
        pannelloCorrente=pannelloCorrente.getState();
        pannelloCorrente.attach(this);
        setCurrentPanel(pannelloCorrente);
    }

    public static void main(String[] args) throws IOException {
        Gestore g=new Gestore(new Finestra(),new PannelloIniziale());
        g.avviaFinestra();
    }
}
