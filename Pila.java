package storagehouse;

import java.util.ArrayList;

public class Pila implements Cloneable{
	
	 private ArrayList<Caja> cajas;
	private int actual, limite;
	
	public Pila(ArrayList<Caja> cajas, int actual, int limite) {
		this.cajas = cajas;
		this.actual = actual;
		this.limite = limite;
	}

	public ArrayList<Caja> getCajas() {
		return cajas;
	}

	public void setCajas(ArrayList<Caja> cajas) {
		this.cajas = cajas;
	}

	public int getActual() {
		return actual;
	}

	public void setActual(int actual) {
		this.actual = actual;
	}

	public int getLimite() {
		return limite;
	}

	public void setLimite(int limite) {
		this.limite = limite;
	}
	
	@Override
    public Pila clone() throws CloneNotSupportedException {
        ArrayList<Caja>newCajas = new ArrayList<>();
        
        for(Caja c : this.cajas){
            newCajas.add(c.clone());
        }
        
        return new Pila(newCajas, this.actual, this.limite);
    } 
	
	public boolean equals(Pila pila){
        for (int i = 0; i < pila.getActual(); i++){
            if (!this.cajas.get(i).equals(pila.getCajas().get(i)))
                return false;
        }
        
        return true;
    }
}
