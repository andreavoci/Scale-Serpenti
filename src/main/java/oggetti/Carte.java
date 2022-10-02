package oggetti;

import java.util.Collections;
import java.util.LinkedList;

public class Carte {
    private LinkedList<String> list;

    public Carte(boolean b){
        list=new LinkedList<>();
        String locanda="Locanda";
        String panchina="Panchina";
        String molla="Molla";
        String rilancia="Rilancia";
        list.add(locanda);
        list.add(molla);
        list.add(panchina);
        list.add(rilancia);
        if(b==true){
            String LasciaPassare="LasciaPassare";
            list.add(LasciaPassare);
        }
        Collections.shuffle(list);
    }

    public String pescaCarta(){
        return list.removeFirst();
    }

    public void posaCarta(String r){
        list.addLast(r);
    }
}
