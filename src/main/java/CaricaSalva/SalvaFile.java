package CaricaSalva;

import gui.ImpostazioniPartita;

import javax.swing.*;
import java.io.*;
import java.util.StringTokenizer;

public class SalvaFile {
    private ImpostazioniPartita ip;
    StringBuilder st= new StringBuilder();

    public SalvaFile(ImpostazioniPartita ip){
        this.ip=ip;
    }

    public void caricaFile(){
        BufferedReader br=null;
        try {
            JFileChooser chooser = new JFileChooser();
            int res = chooser.showOpenDialog(null);
            if (res == JFileChooser.APPROVE_OPTION) {
                br = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                setRegole(br);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public void setRegole(BufferedReader br){
        int numeroRighe = 10;
        int numeroColonna=10;
        int numeroSerpenti=5;
        int numeroScale=5;
        int numeroDadi=2;
        int numeroGiocatori=4;
        boolean premio=false;
        boolean stop=false;
        boolean mazzo = false;
        boolean cartaAggiuntica=false;
        boolean controllaGioco=false;
        try{
            String r=" ";
            while(!r.equals("")) {
                r=br.readLine();
                if(r.equals("")){break;}
                StringTokenizer st=null;
                st = new StringTokenizer(r);
                String uno = st.nextToken();
                if (uno.equals("Numero_Righe")) {
                    String due = st.nextToken();
                    numeroRighe = Integer.parseInt(due);
                    if (numeroRighe < 5 || numeroRighe > 10) {
                        numeroRighe = 10;
                    }
                }
                if (uno.equals("Numero_Colonne")) {
                    String due = st.nextToken();
                    numeroColonna = Integer.parseInt(due);
                    if (numeroColonna < 5 || numeroColonna > 10) {
                        numeroColonna = 10;
                    }
                }
                if (uno.equals("Numero_Serpenti")) {
                    String due = st.nextToken();
                    numeroSerpenti = Integer.parseInt(due);
                    if (numeroSerpenti < 5 || numeroSerpenti > 10) {
                        numeroSerpenti = 5;
                    }
                }
                if (uno.equals("Numero_Scale")) {
                    String due = st.nextToken();
                    numeroScale = Integer.parseInt(due);
                    if (numeroScale < 5 || numeroScale > 10) {
                        numeroScale = 5;
                    }
                }
                if (uno.equals("Numero_Giocatori")) {
                    String due = st.nextToken();
                    numeroGiocatori = Integer.parseInt(due);
                    if (numeroGiocatori < 0 || numeroGiocatori > 4) {
                        numeroGiocatori = 4;
                    }
                }
                if (uno.equals("Numero_dadi")) {
                    String due = st.nextToken();
                    numeroDadi = Integer.parseInt(due);
                    if (numeroDadi < 0 || numeroDadi > 4) {
                        numeroDadi = 2;
                    }
                }
                if (uno.equals("Premio ")) {
                    String due = st.nextToken();
                    premio = Boolean.parseBoolean(due);
                }
                if (uno.equals("Stop")) {
                    String due = st.nextToken();
                    stop = Boolean.parseBoolean(due);
                }
                if (uno.equals("Mazzo")) {
                    String due = st.nextToken();
                    mazzo = Boolean.parseBoolean(due);
                }
                if (uno.equals("Carta_Lascia_Passare")) {
                    String due = st.nextToken();
                    if (mazzo) {
                        cartaAggiuntica = Boolean.parseBoolean(due);
                    }
                }
                if (uno.equals("Guarda_Partita")) {
                    String due = st.nextToken();
                    controllaGioco = Boolean.parseBoolean(due);
                }
            }
            ip = new ImpostazioniPartita(numeroRighe, numeroColonna, numeroSerpenti, numeroScale, numeroDadi, numeroGiocatori, premio, stop, mazzo, cartaAggiuntica,controllaGioco);
        } catch (IOException e) {
            System.out.print("fine");
        }
    }

    public void salvaFile() {
        st.append("Numero_Righe" + " " + ip.getNumeroRighe() + "\n");
        st.append("Numero_Colonne" + " " + ip.getNumeroColonna() + "\n");
        st.append("Numero_Serpenti" + " " + ip.getNumeroSerpenti() + "\n");
        st.append("Numero_Scale" + " " + ip.getNumeroScale() + "\n");
        st.append("Numero_Giocatori" + " " + ip.getNumeroGiocatori() + "\n");
        st.append("Numero_dadi" + " " + ip.getNumeroDadi() + "\n");
        st.append("Premio " + " " + ip.isPremio() + "\n");
        st.append("Stop" + " " + ip.isStop() + "\n");
        st.append("Mazzo" + " " + ip.isMazzo() + "\n");
        st.append("Carta_Lascia_Passare" + " " + ip.isCartaAggiuntica() + "\n");
        st.append("Guarda_Partita" + " " + ip.isControllaGioco() + "\n");
        try {
            JFileChooser chooser = new JFileChooser();
            int res = chooser.showSaveDialog(null);
            if (res == JFileChooser.APPROVE_OPTION) {
                PrintWriter writer = new PrintWriter(chooser.getSelectedFile());
                writer.println(st.toString());
                writer.flush();
                writer.close();
            }
        } catch (FileNotFoundException e) {
        }
    }

    public ImpostazioniPartita getIp() {
        return ip;
    }
}
