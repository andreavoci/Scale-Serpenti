package gui;

import CaricaSalva.SalvaFile;

import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;

public class PannelloImpostazioni extends PannelloAbstract {
    private JTextField righe;
    private JTextField colonne;
    private JTextField numeroSerpenti;
    private JTextField numeroScale;
    private JTextField numeroGiocatori;
    private JTextField numeroDadi;
    private JCheckBox checkBoxMazzo;
    private JCheckBox checkBoxCellePremio;
    private JCheckBox checkBoxCelleStop;
    private JCheckBox checkBoxCartaAggiuntiva;
    private JCheckBox lasciaGiocare;
    private JButton bottone;
    private JButton salvaFile;
    private JButton back;
    ImpostazioniPartita ip;
    private PannelloAbstract pa;

    public PannelloImpostazioni() {
        JLabel labelrighe = new JLabel("Inserire numero righe");
        labelrighe.setBounds(250, 50, 200, 30);
        righe = new JTextField();
        righe.setBounds(420, 50, 30, 30);
        //
        JLabel labelcolonne = new JLabel("Inserire numero colonne");
        labelcolonne.setBounds(250, 100, 200, 30);
        colonne = new JTextField();
        colonne.setBounds(420, 100, 30, 30);
        //
        JLabel labelgiocatori = new JLabel("Inserire numero giocatori");
        labelgiocatori.setBounds(730, 50, 200, 30);
        numeroGiocatori = new JTextField();
        numeroGiocatori.setBounds(900, 50, 30, 30);
        //
        JLabel labeldadi = new JLabel("Inserire numero dadi");
        labeldadi.setBounds(730, 100, 200, 30);
        numeroDadi = new JTextField();
        numeroDadi.setBounds(900, 100, 30, 30);
        //
        JLabel labelserpenti = new JLabel("Inserire numero serpenti");
        labelserpenti.setBounds(490, 50, 200, 30);
        numeroSerpenti = new JTextField();
        numeroSerpenti.setBounds(660, 50, 30, 30);
        //
        JLabel labelscale = new JLabel("Inserire numero scale");
        labelscale.setBounds(490, 100, 200, 30);
        numeroScale = new JTextField();
        numeroScale.setBounds(660, 100, 30, 30);
        //
        checkBoxMazzo = new JCheckBox("Mazzo");
        checkBoxMazzo.setBounds(420, 200, 200, 30);
        //
        checkBoxCellePremio = new JCheckBox("Premio");
        checkBoxCellePremio.setBounds(420, 250, 200, 30);
        //
        checkBoxCelleStop = new JCheckBox("STOP");
        checkBoxCelleStop.setBounds(660, 200, 200, 30);
        //
        checkBoxCartaAggiuntiva = new JCheckBox("Carta Aggiuntiva");
        checkBoxCartaAggiuntiva.setBounds(660, 250, 200, 30);
        //
        lasciaGiocare = new JCheckBox("Controllo i Vari Spostamenti");
        lasciaGiocare.setBounds(490, 300, 200, 30);
        //
        bottone = new JButton("Conferma Regole");
        bottone.setBounds(490, 390, 200, 30);
        //
        setLayout(null);
        add(righe);
        add(colonne);
        add(numeroScale);
        add(numeroSerpenti);
        add(checkBoxMazzo);
        add(checkBoxCellePremio);
        add(checkBoxCelleStop);
        add(checkBoxCartaAggiuntiva);
        add(lasciaGiocare);
        add(labeldadi);
        add(labelgiocatori);
        add(numeroGiocatori);
        add(numeroDadi);
        add(labelrighe);
        add(labelcolonne);
        add(labelscale);
        add(labelserpenti);
        add(bottone);
        //
        bottone.addActionListener(this::actionPerformed);
        salvaFile=new JButton("Salva File");
        this.add(salvaFile);
        salvaFile.setBounds(490,430,200,30);
        salvaFile.addActionListener(this::actionPerformed);
        back = new JButton("Torna Indietro");
        this.add(back);
        back.setBounds(490,470,200,30);
        back.addActionListener(this::actionPerformed);
        JLabel nome = new JLabel("Scale e Serpenti");
        nome.setBounds(530, 550, 200,50);
        nome.setFont(new Font("Serif", Font.PLAIN, 18));
        this.add(nome);
    }

    public PannelloAbstract getState() {
        return pa;
    }

    public void setPa(PannelloAbstract pi) {
        pa = pi;
        notifica();
    }

    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o == bottone|| o == salvaFile ) {
            try {
                int righe2 = Integer.parseInt(righe.getText());
                int colonna2 = Integer.parseInt(colonne.getText());
                int intSerpenti = Integer.parseInt(numeroSerpenti.getText());
                int intScale = Integer.parseInt(numeroScale.getText());
                int intGiocatori = Integer.parseInt(numeroGiocatori.getText());
                int intDado = Integer.parseInt(numeroDadi.getText());
                boolean premio = false;
                boolean stop = false;
                boolean mazzo = false;
                boolean cartaAggiuntiva = false;
                boolean controllo = true;
                boolean lascia=false;
                if (righe2 < 6 || righe2 > 10) {
                    righe.setText("0");
                    controllo = false;
                }
                if (colonna2 < 6 || colonna2 > 10) {
                    colonne.setText("0");
                    controllo = false;
                }
                if (intSerpenti < 2 || intSerpenti > 10||intSerpenti>righe2) {
                    numeroSerpenti.setText("0");
                    controllo = false;
                }
                if (intScale < 2 || intScale > 10||intSerpenti>righe2) {
                    numeroScale.setText("0");
                    controllo = false;
                }
                if (intDado < 0 || intDado > 4) {
                    numeroDadi.setText("0");
                    controllo = false;
                }
                if (intGiocatori < 0 || intGiocatori > 4) {
                    numeroGiocatori.setText("0");
                    controllo = false;
                }
                if (checkBoxCellePremio.isSelected()) {
                    premio = true;
                }
                if (checkBoxCelleStop.isSelected()) {
                    stop = true;
                }
                if (checkBoxMazzo.isSelected()) {
                    mazzo = true;
                }
                if (checkBoxCartaAggiuntiva.isSelected() && checkBoxMazzo.isSelected()) {
                    cartaAggiuntiva = true;
                }
                if(lasciaGiocare.isSelected()){
                    lascia=true;
                }
                if (controllo) {
                    if(o==bottone) {
                        ip = new ImpostazioniPartita(righe2, colonna2, intSerpenti, intScale, intDado, intGiocatori, premio, stop, mazzo, cartaAggiuntiva, lascia);
                        setPa(new PannelloControllo(righe2, colonna2, ip));
                    }if(o == salvaFile){
                        ip = new ImpostazioniPartita(righe2, colonna2, intSerpenti, intScale, intDado, intGiocatori, premio, stop, mazzo, cartaAggiuntiva, lascia);
                        SalvaFile sf=new SalvaFile(ip);
                        sf.salvaFile();
                    }
                }
                if(!controllo){
                    String c="Hai inserito valori minori o maggiori di quelli ammessi! Gli errori sono contrassegnati con 0 e ricorda che puoi mettere al massimo 4 giocatori, 3 dadi e 10 righe, colonne, scale e serpenti!";
                    infoBox(c,"ATTENZIONE");
                }
            }catch (Exception exc){
                String st="Stai cercando di usare un file corrotto o sbagliato! Riprova a inserire il file e se continui a riscontrare un messaggio di errore controlla le impostazioni o prova a salvare e ricaricaricare un nuovo file!";
                String titolo="ATTENZIONE";
                infoBox(st,titolo);
            }
        }
        else if(o==back){
            try{
                setPa(new PannelloIniziale());
            }catch (Exception exc){}
        }
    }

    public static void infoBox(String infoMessage, String titleBar) {
        JOptionPane.showMessageDialog(null, infoMessage, "ERRORE " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}
