package storagehouse;

import java.util.Comparator;

public class OrdenadorAbiertos implements Comparator<Nodo> {
	
	@Override
    public int compare(Nodo nodo1, Nodo nodo2) {
        return nodo1.getDistancia().compareTo(nodo2.getDistancia());
    }
}
