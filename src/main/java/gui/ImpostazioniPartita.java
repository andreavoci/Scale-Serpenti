package gui;

public class ImpostazioniPartita {
    private int numeroRighe;
    private int numeroColonna;
    private int numeroSerpenti;
    private int numeroScale;
    private int numeroDadi;
    private int numeroGiocatori;
    private boolean premio;
    private boolean stop;
    private boolean mazzo;
    private boolean cartaAggiuntica;
    private boolean controllaGioco;

    public ImpostazioniPartita(int numeroRighe, int numeroColonna, int numeroSerpenti, int numeroScale, int numeroDadi, int numeroGiocatori, boolean premio, boolean stop, boolean mazzo, boolean cartaAggiuntica, boolean controllaGioco) {
        this.numeroRighe = numeroRighe;
        this.numeroColonna = numeroColonna;
        this.numeroSerpenti = numeroSerpenti;
        this.numeroScale = numeroScale;
        this.numeroDadi = numeroDadi;
        this.numeroGiocatori = numeroGiocatori;
        this.premio = premio;
        this.stop = stop;
        this.mazzo = mazzo;
        this.cartaAggiuntica = cartaAggiuntica;
        this.controllaGioco = controllaGioco;
    }

    public boolean isCartaAggiuntica() {
        return cartaAggiuntica;
    }

    public void setCartaAggiuntica(boolean cartaAggiuntica) {
        this.cartaAggiuntica = cartaAggiuntica;
    }

    public int getNumeroRighe() {
        return numeroRighe;
    }

    public void setNumeroRighe(int numeroRighe) {
        this.numeroRighe = numeroRighe;
    }

    public int getNumeroColonna() {
        return numeroColonna;
    }

    public void setNumeroColonna(int numeroColonna) {
        this.numeroColonna = numeroColonna;
    }

    public int getNumeroSerpenti() {
        return numeroSerpenti;
    }

    public void setNumeroSerpenti(int numeroSerpenti) {
        this.numeroSerpenti = numeroSerpenti;
    }

    public int getNumeroScale() {
        return numeroScale;
    }

    public void setNumeroScale(int numeroScale) {
        this.numeroScale = numeroScale;
    }

    public int getNumeroDadi() {
        return numeroDadi;
    }

    public void setNumeroDadi(int numeroDadi) {
        this.numeroDadi = numeroDadi;
    }

    public int getNumeroGiocatori() {
        return numeroGiocatori;
    }

    public void setNumeroGiocatori(int numeroGiocatori) {
        this.numeroGiocatori = numeroGiocatori;
    }

    public boolean isPremio() {
        return premio;
    }

    public void setPremio(boolean premio) {
        this.premio = premio;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public boolean isMazzo() {
        return mazzo;
    }

    public void setMazzo(boolean mazzo) {
        this.mazzo = mazzo;
    }

    public boolean isControllaGioco() {
        return controllaGioco;
    }

    public void setControllaGioco(boolean controllaGioco) {
        this.controllaGioco = controllaGioco;
    }
}
