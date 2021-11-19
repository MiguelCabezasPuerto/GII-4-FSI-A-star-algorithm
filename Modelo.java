package storagehouse;

import java.util.ArrayList;

public class Modelo {
      ArrayList<Nodo> abiertos;
      ArrayList<Nodo> cerrados ;

    public Modelo(){
        this.abiertos=new ArrayList<>();
        this.cerrados=new ArrayList<>();
    }  
    
    public ArrayList<Nodo> getAbiertos() {
        return abiertos;
    }

    public void setAbiertos(ArrayList<Nodo> abiertos) {
        this.abiertos = abiertos;
    }

    public ArrayList<Nodo> getCerrados() {
        return cerrados;
    }

    public void setCerrados(ArrayList<Nodo> cerrados) {
        this.cerrados = cerrados;
    }
        
}
