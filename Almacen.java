package storagehouse;

import java.util.ArrayList;

public class Almacen {
	
	private ArrayList<Pila> pilas;
	
	public Almacen(ArrayList<Pila> pilas) {
		this.pilas = pilas;
	}

	public ArrayList<Pila> getPilas() {
		return pilas;
	}

	public void setPilas(ArrayList<Pila> pilas) {
		this.pilas = pilas;
	}
	
    @Override
    public Almacen clone() throws CloneNotSupportedException{
    	ArrayList<Pila>newPilas=new ArrayList<>();
    	for(Pila p:this.pilas){
    		newPilas.add(p.clone());
    	}
    	return new Almacen(newPilas);
    }
    
    public boolean equals(Almacen almacen){
        for (int i = 0; i < this.pilas.size(); i++){
            if (this.pilas.get(i).getActual() != almacen.getPilas().get(i).getActual()) return false;
            if (!this.pilas.get(i).equals(almacen.getPilas().get(i))){
                return false;
            }
        }
        return true;
    }
}
