package gui;

import CaricaSalva.SalvaFile;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class PannelloIniziale extends PannelloAbstract {
    private JButton gioca_normale;
    private JButton setImpostazioni;
    private PannelloAbstract pa;

    public PannelloIniziale() throws IOException {
        JLabel titolo = new JLabel("Scale e Serpenti");
        titolo.setBounds(390, 100, 500,100);
        titolo.setFont(new Font("Serif", Font.PLAIN, 72));
        this.add(titolo);
        JLabel firma = new JLabel("by Andrea Voci");
        firma.setBounds(1048, 550, 200,50);
        firma.setFont(new Font("Serif", Font.PLAIN, 18));
        this.add(firma);
        gioca_normale = new JButton("Gioca");
        gioca_normale.setBounds(500, 300, 200, 50);
        this.add(gioca_normale);
        gioca_normale.addActionListener(this::actionPerformed);
        setImpostazioni =new JButton("Carica");
        setImpostazioni.setBounds(500, 400, 200 , 50);
        this.add(setImpostazioni);
        setImpostazioni.addActionListener(this::actionPerformed);
        setLayout(null);
    }

    public PannelloAbstract getState(){
        return pa;
    }

    public void setPa(PannelloAbstract pi){
        pa=pi;
        notifica();
    }

    public void actionPerformed(ActionEvent e)  {
        Object o = e.getSource();
        if (o == gioca_normale) {
            setPa(new PannelloImpostazioni());
        } else if (o == setImpostazioni) {
            String s="Se non l'hai gia fatto, personalizza le impostazioni cliccando su Gioca e salva il file per caricarlo in futuro in maniera corretta!";
            String tot=s+"\n";
            infoBox(tot,"AVVERTENZA");
            ImpostazioniPartita ip=null;
            SalvaFile sf=new SalvaFile(ip);
            sf.caricaFile();
            ip=sf.getIp();
            if(ip!=null){
                try {
                    setPa(new PannelloControllo(ip.getNumeroRighe(), ip.getNumeroColonna(), ip));
                }catch (Exception er){System.out.print("ERRORE");}
            }
        }
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "" + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
