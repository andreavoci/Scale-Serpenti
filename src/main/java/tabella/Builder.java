package tabella;

import java.io.IOException;

public interface Builder {
    public void inserisciSerpenti(int n) throws IOException;
    public void inserisciScale(int n) throws IOException;
    public void inserisciPremio() throws IOException;
    public void inserisciSosta() throws IOException;
    public void inserisciPesca() throws IOException;
    public void casellaVittora() throws IOException;
}
