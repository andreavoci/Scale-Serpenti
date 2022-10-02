package gui;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

public class Cella extends JPanel {
    int digit; //il numero mostrato
    int x, y; //posizioni sulla griglia
    int numeroCella;
    int numeroGiocatori;
    JLabel img;
    JLabel vittoria;
    ArrayList<JLabel> lista;

    Cella(int x, int y,int numeroCella,int giocatori) throws IOException {
        this.numeroCella=numeroCella;
        this.x = x;
        this.y = y;
        numeroGiocatori=giocatori;
        img=new JLabel();
        vittoria=new JLabel();
        setLayout(new GridLayout(3,3));
        setBorder(BorderFactory.createLineBorder(Color.black));
        setPreferredSize(new Dimension(70, 70));
        JLabel val=new JLabel(String.valueOf(numeroCella));
        val.setBounds(10,100,10,10);
        this.add(val);
        this.add(img);
    }

    public void setImg(String s){
        try {
            BufferedImage wPic = ImageIO.read(this.getClass().getResource(s));
            img.setIcon(new ImageIcon(wPic));
            if(s.equals("img/fine.jpg")){
                vittoria.setIcon(new ImageIcon(wPic));
            }
        }catch(Exception e){
            System.out.print("qui");
        }
    }

    public void rimuoviGiocatore(String s){
        for(int i=0;i<lista.size();i++){
            if(lista.get(i).getText().equals(s)){
                lista.get(i).setText("");
                lista.get(i).setOpaque(false);
                lista.get(i).setBackground(Color.WHITE);
                lista.remove(i);
            }
        }
        if(lista.size()==0){
            lista=null;
        }
    }

    public void aggiungiGiocatore(String s){
        if(lista==null) {
            lista = new ArrayList<>();
            JLabel giocatore=new JLabel(s);
            giocatore.setBackground(Color.BLUE);
            giocatore.setOpaque(true);
            this.add(giocatore);
            lista.add(giocatore);
        }else{
            JLabel giocatore=new JLabel(s);
            giocatore.setBackground(Color.BLUE);
            giocatore.setOpaque(true);
            this.add(giocatore);
            lista.add(giocatore);
        }
    }
}
