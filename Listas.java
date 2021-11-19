package storagehouse;

import java.util.ArrayList;

public class Listas {
    ArrayList<Nodo> abiertos;
	ArrayList<Nodo> cerrados;
	ArrayList<Caja> listaProduccion;
	ArrayList<Nodo> grafo;
	
	public Listas (ArrayList<Nodo> abiertos, ArrayList<Nodo> cerrados, ArrayList<Caja> listaProduccion, ArrayList<Nodo> grafo) {
		this.abiertos = abiertos;
		this.cerrados = cerrados;
		this.listaProduccion = listaProduccion;
		this.grafo = grafo;
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

	public ArrayList<Caja> getListaProduccion() {
		return listaProduccion;
	}

	public void setListaProduccion(ArrayList<Caja> listaProduccion) {
		this.listaProduccion = listaProduccion;
	}

	public ArrayList<Nodo> getGrafo() {
		return grafo;
	}

	public void setGrafo(ArrayList<Nodo> grafo) {
		this.grafo = grafo;
	}
}
