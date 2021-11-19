package storagehouse;

import java.util.ArrayList;

public class Nodo {

	private Almacen estado;
	private ArrayList<Nodo> sucesores;
	private Nodo antecesor;
	private int coste;
	private Integer distancia;
	private ArrayList<Caja> listaProduccionNodo;
        private boolean valido;
	
	public Nodo(ArrayList<Nodo> sucesores, Nodo antecesor, Almacen estado, int coste, Integer distancia, ArrayList<Caja> listaProduccionNodo,boolean valido) {
		this.sucesores = sucesores;
		this.antecesor = antecesor;
		this.estado = estado;
		this.coste = coste;
		this.distancia = distancia;
		this.listaProduccionNodo = listaProduccionNodo;
                this.valido=valido;
	}

	public ArrayList<Nodo> getSucesores() {
		return sucesores;
	}

	public void setSucesores(ArrayList<Nodo> sucesores) {
		this.sucesores = sucesores;
	}

	public Nodo getAntecesor() {
		return antecesor;
	}

	public void setAntecesor(Nodo antecesor) {
		this.antecesor = antecesor;
	}

	public Almacen getEstado() {
		return estado;
	}

	public void setEstado(Almacen estado) {
		this.estado = estado;
	}

	public int getCoste() {
		return coste;
	}

	public void setCoste(int coste) {
		this.coste = coste;
	}
	
	
	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	
	public ArrayList<Caja> getListaProduccionNodo() {
		return listaProduccionNodo;
	}

	public void setListaProduccionNodo(ArrayList<Caja> listaProduccionNodo) {
		this.listaProduccionNodo = listaProduccionNodo;
	}

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

        
	@Override
    public Nodo clone() throws CloneNotSupportedException{
         Almacen newAlmacen=this.estado.clone();
         if(this.antecesor != null){
              Nodo newAntecesor=null;
              ArrayList<Nodo>newSucesores=new ArrayList<>();
              if(this.sucesores != null){
                  for(Nodo n:this.sucesores){
                      newSucesores.add(n.clone());
                  }
                  return new Nodo(newSucesores, null, newAlmacen, this.coste, this.distancia, this.listaProduccionNodo,this.valido);
              }
              return new Nodo(newSucesores, newAntecesor, newAlmacen, this.coste, this.distancia, this.listaProduccionNodo,this.valido);
         }
         else{
              ArrayList<Nodo>newSucesores=new ArrayList<>();
              
             if(this.sucesores != null){
                 for(Nodo n:this.sucesores){
                     newSucesores.add(n.clone());
                 }
                 return new Nodo(newSucesores, null, newAlmacen, this.coste, this.distancia, this.listaProduccionNodo,this.valido);
             }
             else{
                 return new Nodo(null, null, newAlmacen, this.coste, this.distancia, this.listaProduccionNodo,this.valido);
             } 
         }
    }
}
