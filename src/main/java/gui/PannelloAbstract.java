package gui;

import javax.swing.*;

public abstract class PannelloAbstract extends JPanel {
    private Gestore g;

    public PannelloAbstract(){}

    public void attach(Gestore g){
        this.g=g;
    }

    public void notifica(){
        g.update();
    }

    public abstract PannelloAbstract getState();
}
