package tabella;

import caselle.*;
import gui.Cella;
import gui.PannelloGriglia;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class BuilderConcreto implements  Builder {
    private Casella[] c;
    private int numeroCaselle;
    private int numeroDadi;
    private int righe;
    private int colonne;
    private PannelloGriglia pg;
    private Cella[] lista;

    public BuilderConcreto(int righe, int colonne) {
        numeroCaselle=righe*colonne;
        this.righe=righe;
        this.colonne=colonne;
        c = new Casella[numeroCaselle ];
        numeroDadi=2;
    }

    @Override
    public void inserisciSerpenti(int n)  {
        for(int i=0;i<n;i++){
            boolean posizionata=false;
            while (!posizionata) {
                int g = 1+new Random().nextInt(numeroCaselle - (colonne+2)) ;
                if (c[g] == null) {
                    int s = new Random().nextInt( numeroCaselle- (g+1+colonne))+(g+colonne) ;
                    if(c[s]==null && s!=g){
                        CasellaCoda coda=new CasellaCoda(g);
                        inserisciCodaGrafica(g);
                        c[g]=coda;
                        c[s]=new CasellaTesta(s,coda);
                        int somma1=g+1;
                        int somma2=s+1;
                        System.out.print("Casella Coda Serpente è la numero: "+somma1+"; Casella Testa Serpente è la numero: "+somma2);
                        System.out.print("\n");
                        inserisciSerpentiGrafica(s);
                        posizionata=true;
                    }
                }
            }
        }
    }

    @Override
    public void inserisciScale(int n)  {
        for(int i=0;i<n;i++){
            boolean posizionata=false;
            while (!posizionata) {
                int g = 1 + new Random().nextInt(numeroCaselle - (colonne + 1));
                if (c[g] == null) {
                    int s = new Random().nextInt(numeroCaselle - (g + colonne)) + (g + colonne);
                    if (c[s] == null && s != g) {
                        CasellaInizioScala scalaSu = new CasellaInizioScala(s);
                        c[s] = scalaSu;
                        inserisciScaleGrafica(s);
                        c[g] = new CasellaFineScala(scalaSu, g);
                        inserisciScaleGrafica2(g);
                        int somma1 = g + 1;
                        int somma2 = s + 1;
                        System.out.print("Casella Fine Scala è la numero: " + somma1 + "; Casella Cima Scala è la numero: " + somma2);
                        System.out.print("\n");
                        posizionata = true;
                    }
                }
            }
        }
    }

    public void caselleRestanti(){
        for(int i=0;i<numeroCaselle;i++){
            if(c[i]==null){
                c[i]=new CasellaVuota(i);
            }
        }
    }

    @Override
    public void inserisciPremio() throws IOException {
        boolean posizionate=false;
        while(!posizionate){
            int g =1+ new Random().nextInt(numeroCaselle - 2);
            if(c[g] instanceof CasellaVuota){
                CasellaPremioDadi csp=new CasellaPremioDadi(c[g]);
                int somma1=g+1;
                c[g]=csp;
                System.out.print("Casella Rilancia è la numero: "+somma1);
                System.out.print("\n");
                inserisciPremioDadiGrafica(g);
                posizionate=true;
            }
        }
        boolean posizionate2=false;
        while(!posizionate2){
            int g =1+ new Random().nextInt(numeroCaselle - 2);
            if(c[g] instanceof CasellaVuota){
                CasellaPremioMolla csp=new CasellaPremioMolla(c[g]);
                c[g]=csp;
                int somma1=g+1;
                System.out.print("Casella Molla è la numero: "+somma1);
                System.out.print("\n");
                inserisciPremioMollaGrafica(g);
                posizionate2=true;
            }
        }
    }

    @Override
    public void inserisciSosta() throws IOException {
        boolean posizionate=false;
        while(!posizionate){
            int g =1+ new Random().nextInt(numeroCaselle - 2);
            if(c[g] instanceof CasellaVuota){
                CasellaSostaPanchina csp=new CasellaSostaPanchina(c[g]);
                c[g]=csp;
                int somma1=g+1;
                System.out.print("Casella Panchina è la numero: "+somma1);
                System.out.print("\n");
                inserisciSostaPGrafica(g);
                posizionate=true;
            }
        }
        boolean posizionate2=false;
        while(!posizionate2){
            int g =1+ new Random().nextInt(numeroCaselle - 2);
            if(c[g] instanceof CasellaVuota){
                CasellaSostaLocanda csp=new CasellaSostaLocanda(c[g]);
                c[g]=csp;
                int somma1=g+1;
                System.out.print("Casella Locanda è la numero: "+somma1);
                System.out.print("\n");
                inserisciSostaLGrafica(g);
                posizionate2=true;
            }
        }
    }

    @Override
    public void inserisciPesca() {
        boolean posizionate=false;
        while (!posizionate){
            int g =1+ new Random().nextInt(numeroCaselle - 2);
            if(c[g] instanceof CasellaVuota){
                CasellaMazzo csp=new CasellaMazzo(c[g]);
                c[g]=csp;
                int somma1=g+1;
                System.out.print("Casella Pesca è la numero: "+somma1);
                System.out.print("\n");
                inserisciPescaGrafica(g);
                posizionate=true;
            }
        }
    }

    @Override
    public void casellaVittora()  {
        CasellaVittoria cv =new CasellaVittoria(c[numeroCaselle-1]);
        if(c[numeroCaselle-1] instanceof CasellaInizioScala) {
            CasellaInizioScala css = (CasellaInizioScala) c[numeroCaselle - 1];
            css.setControllo(true);
        }
        c[numeroCaselle-1]=cv;
        inserisciCasellaVittoriaGrafica(numeroCaselle-1);
    }

    public void inserisciScale(int numeroScale, ArrayList<Punti> lista){
        for(int i=0;i<numeroScale;i++){
            Punti p=lista.get(i);
            CasellaInizioScala scalaSu=new CasellaInizioScala(p.getY());
            c[p.getY()]=scalaSu;
            inserisciScaleGrafica(p.getY());
            c[p.getX()]=new CasellaFineScala(scalaSu,p.getX());
            inserisciScaleGrafica2(p.getX());
        }
    }

    public void inserisciSerpenti(int numeroSerpenti, ArrayList<Punti> lista){
        for(int i=0;i<numeroSerpenti;i++){
            Punti p=lista.get(i);
            CasellaCoda coda=new CasellaCoda(p.getX());
            inserisciCodaGrafica(p.getX());
            c[p.getX()]=coda;
            c[p.getY()]=new CasellaTesta(p.getY(),coda);
            inserisciSerpentiGrafica(p.getY());
        }
    }

    public Casella[] getC() {
        return c;
    }

    public void inserisciSerpentiGrafica(int i)  {
        try {
            pg.getCella(i).setImg("img/serpente.jpg");
            pg.getCella(i).setBackground(new Color(107,142,35));
        }catch (Exception e){
            System.out.print("testa");
        }
    }
    public void inserisciCodaGrafica(int i) {
        try {
            pg.getCella(i).setImg("img/coda.jpg");
            pg.getCella(i).setBackground(new Color(85,107,47));
        }catch (Exception e){
            System.out.print("coda");
        }
    }

    public void inserisciScaleGrafica(int i)  {
        try {
            pg.getCella(i ).setImg("img/scala.jpg");
            pg.getCella(i).setBackground(new Color(184,134,11));
        }catch (Exception e){
            System.out.print("scala");
        }
    }

    public void inserisciScaleGrafica2(int i)  {
        try {
            pg.getCella(i ).setImg("img/scala.jpg");
            pg.getCella(i).setBackground(new Color(218,165,32));
        }catch (Exception e){
            System.out.print("scala");
        }
    }

    public void inserisciPescaGrafica(int i)  {
        try{
            pg.getCella(i).setImg("img/mazzo.jpg");
            pg.getCella(i).setBackground(new Color(193, 133, 10));
        }catch (Exception e){
            System.out.print("pesca");
        }
    }

    public void inserisciSostaPGrafica(int i) throws IOException {
        try {
            pg.getCella(i ).setImg("img/panchina.jpg");
            pg.getCella(i).setBackground(new Color(19, 193, 190));
        }catch (Exception e){
            System.out.print("sosta");
        }
    }
    public void inserisciSostaLGrafica(int i)  {
        try {
            pg.getCella(i ).setImg("img/locanda.png");
            pg.getCella(i).setBackground(new Color(148, 105, 193));
        } catch (Exception e){
            System.out.print("sosta");
        }
    }

    public void inserisciPremioMollaGrafica(int i)  {
        try{
            pg.getCella(i).setImg("img/molla.jpg");
            pg.getCella(i).setBackground(new Color(61, 193, 169));
        }catch (Exception e){
            System.out.print("premio");
        }
    }

    public void inserisciPremioDadiGrafica(int i)  {
        try{
            pg.getCella(i).setImg("img/dadi.jpg");
            pg.getCella(i).setBackground(new Color(193, 28, 187));
        }catch (Exception e){
            System.out.print("dado");
        }
    }

    public void inserisciCasellaVittoriaGrafica(int i)  {
        try{
            pg.getCella(i).setImg("img/fine.jpg");
            pg.getCella(i).setBackground(new Color(152, 193, 19));
        }catch (Exception e){
            System.out.print("vittoria");
        }
    }

    public void setPannelloGriglia(PannelloGriglia pannelloGriglia) {
        this.pg = pannelloGriglia;
    }
}
