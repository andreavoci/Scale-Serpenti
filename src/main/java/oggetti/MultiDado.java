package oggetti;

public class MultiDado {
    private int ultimoLancio;
    private Dado dado;
    private int n;

    public MultiDado(int n){
        this.n=n;
        this.dado=dado.getIstance();
    }

    public int lanciaDado() {
        int numeroTotale= 0;
        for(int i=0;i<n;i++){
            numeroTotale=dado.lanciaDado()+numeroTotale;
        }
        ultimoLancio=numeroTotale;
        return numeroTotale;
    }

    public int getUltimoLancio(){
        return ultimoLancio;
    }
}
