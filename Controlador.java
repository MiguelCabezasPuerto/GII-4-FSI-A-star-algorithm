package storagehouse;

import java.util.ArrayList;

public class Controlador {
    
    public Controlador(){}
    
    /**********************************************************************************/
	//Función que inicializa la lista de producción
	/**********************************************************************************/
	public ArrayList<Caja> inicializarLista() {
		ArrayList<Caja> lista = new ArrayList<Caja>();

		lista.add(new Caja(1,1,17));
		lista.add(new Caja(2,2,17));
		lista.add(new Caja(3,3,17));
		lista.add(new Caja(4,4,17));
		lista.add(new Caja(5,1,17));
		lista.add(new Caja(6,2,17));
		lista.add(new Caja(7,3,17));
		lista.add(new Caja(8,4,17));
		lista.add(new Caja(9,1,17));
		lista.add(new Caja(10,2,17));
		lista.add(new Caja(11,3,17));
		lista.add(new Caja(12,4,17));
		lista.add(new Caja(13,1,18));
		lista.add(new Caja(14,2,18));
		lista.add(new Caja(15,3,18));
		lista.add(new Caja(16,4,18));
		lista.add(new Caja(17,1,18));
		lista.add(new Caja(18,2,18));
		lista.add(new Caja(19,3,19));
		lista.add(new Caja(20,4,19));
		
		return lista;
	}
	/**********************************************************************************/
      
	
	/**********************************************************************************/
	//Función para comprobar si un estado es invalido
	/**********************************************************************************/  
    public boolean estadoInvalido(Nodo nodoSucesor, int posicionPila, Caja cajaNueva) {
    	if (nodoSucesor.getEstado().getPilas().get(posicionPila).getCajas().isEmpty()) {
    		return false;
    	} else {
    		Caja primeraCaja = nodoSucesor.getEstado().getPilas().get(posicionPila).getCajas().get(0);
    		
    		if (primeraCaja.getDiaSalida() >= cajaNueva.getDiaSalida()) {
    			return false;
    		} else {
    			return true;
    		}
    	}
	}
    /**********************************************************************************/
    
    
    /**********************************************************************************/
	//Función recursiva que imprime la solución en función de los apuntadores
	/**********************************************************************************/
	public void imprimirSolucion(Nodo nodoAimprimir, Listas listas) {
		mostrarNodo(nodoAimprimir);
		System.out.println();
		System.out.println();
		System.out.println();
		
		//Si es antecesor es null hemos terminado si no volvemos a llamar a la función
		if (nodoAimprimir.getAntecesor() == null) {
			return;
		} else {
			imprimirSolucion(nodoAimprimir.getAntecesor(), listas);
		}
	}
	/**********************************************************************************/
    
	
   /**********************************************************************************/
	//Función para configurar el estado del nodo inicial con todas las pilas vacías
	/**********************************************************************************/
	public Almacen configurarEstadoInicial() {
		ArrayList<Pila> pilas = new ArrayList<Pila>();
		ArrayList<Caja> cajas = new ArrayList<Caja>();
		
		pilas.add(new Pila(cajas,0,4));
		pilas.add(new Pila(cajas,0,4));
		pilas.add(new Pila(cajas,0,4));
		pilas.add(new Pila(cajas,0,4));
		pilas.add(new Pila(cajas,0,4));
		
		Almacen almacen = new Almacen(pilas);
		return almacen;
	}
	/**********************************************************************************/
	
	
	/**********************************************************************************/
	//Función para configurar el nodo inicial, sin sucesores, sin antecesor, el estado 
	//es un almacén con las pilas vacías y el coste es cero
	/**********************************************************************************/
	public Nodo configurarNodoInicial(Almacen estado, Listas listas) {
		Nodo nodo = new Nodo(null, null, estado, 0, 0, listas.listaProduccion,true);
		return nodo;
	}
	/**********************************************************************************/
	
	
    /**********************************************************************************/
	//Función para imprimir el estado de un nodo cualquiera
	/**********************************************************************************/
	public void mostrarNodo(Nodo nodo) {
		int indice = 1;
		System.out.printf("Distancia del nodo: %d\n", nodo.getDistancia());
		for (Pila p : nodo.getEstado().getPilas()) {
			System.out.printf("Pila %d | Actual: %d | Limite: %d", indice, p.getActual(), p.getLimite());
			System.out.println();
			for (Caja c : p.getCajas()) {
				System.out.printf("[%d, %d, %d]", c.getId(), c.getDiaEntrada(), c.getDiaSalida());
				System.out.println();
			}
			indice++;
			System.out.println();
			System.out.println();
		}
	}
	/**********************************************************************************/
	
	
    /**********************************************************************************/
	//Funcion para ordenar la lista de abiertos en función de una heurística
	/**********************************************************************************/
	public void ordenarAbiertos(Listas listas) {
        listas.abiertos.sort(new OrdenadorAbiertos());
	}
	/**********************************************************************************/
	
	
    /**********************************************************************************/
	//Función que calcula la distancia de los nodos para su posterior ordenación
	/**********************************************************************************/
	public int calcularDistancia (Nodo nodo) {
		int sumaDiasSalidaCajas = 0;
		int sumaNumeroHuecos = 0;
		
		for (Pila p : nodo.getEstado().getPilas()) {
			sumaNumeroHuecos += (p.getLimite() - p.getActual());
			for (Caja c : p.getCajas()) {
				sumaDiasSalidaCajas += c.getDiaSalida();
			}
		}
		
		return -(sumaNumeroHuecos + sumaDiasSalidaCajas);
	}
	/**********************************************************************************/
	
	
    /**********************************************************************************/
	//Funcion que comprueba si las pilas están llenas (Estado objetivo)
	/**********************************************************************************/
	public boolean pilasLlenas(Nodo nodo) {
		int pilasLlenas = 0;
		
		for (Pila p : nodo.getEstado().getPilas()) {
			if (p.getActual() == p.getLimite()) {
				pilasLlenas++;
			}
		}
		
		if (pilasLlenas == 5) {
			return true;
		}
		
		return false;
	}
	/**********************************************************************************/
	
	
    /**********************************************************************************/
	//Funcion para comparar dos nodos
	/**********************************************************************************/
	public boolean compararNodos (Nodo n1, Nodo n2) {
		 return n1.getEstado().equals(n2.getEstado());
	}
	/**********************************************************************************/
   
	
	/**********************************************************************************/
	//Funcion para ver si es antecesor
	/**********************************************************************************/
	public boolean nodoAntecesor (Nodo sucesor, Nodo padre) {
		Nodo antecesor = padre.getAntecesor();
		Nodo temporal;
		
		while (antecesor != null) {
			if(compararNodos(sucesor, antecesor)) {
				return true;
			}
			
			temporal = antecesor.getAntecesor();
			antecesor = temporal;
		}
		
		return false;
	}
	/**********************************************************************************/
	
	
	/**********************************************************************************/
	//Funcion para ver si esta en abiertos
	/**********************************************************************************/
	public boolean nodoEnAbiertos(Nodo sucesor, Listas listas, Nodo padre) {
		for (Nodo n : listas.abiertos) {
			if (compararNodos(sucesor, n)) {
				if(n.getCoste() > sucesor.getCoste()) {
					n.setAntecesor(sucesor.getAntecesor());
				}
				return true;
			}
		}
		return false;
	}
	/**********************************************************************************/
	
	
	/**********************************************************************************/
	//Funcion para ver si esta en cerrados
	/**********************************************************************************/
	public boolean nodoEnCerrados(Nodo sucesor, Listas listas, Nodo padre) {
		for (Nodo n : listas.cerrados) {
			if (compararNodos(sucesor, n)) {
				return true;
			}
		}
		return false;
	}
	/**********************************************************************************/
	
	
	/**********************************************************************************/
	//Funcion para calcular los antecesores cuando un sucesor esta en cerrados
	/**********************************************************************************/
	public void calcularAntecesores (Nodo nodo, Nodo padreAnterior, Nodo posiblePadre) {
		if (padreAnterior.getCoste() > posiblePadre.getCoste()) {
			nodo.setAntecesor(posiblePadre);
			nodo.setCoste(posiblePadre.getCoste() + 1);
		}
		
		for (Nodo n : nodo.getSucesores()) {
			calcularAntecesores(n, n.getAntecesor(), posiblePadre);
		}
	}
	/**********************************************************************************/
	
	
	/**********************************************************************************/
	//Funcion para ver si es antecesor
	/**********************************************************************************/
    public void expandir(Nodo padre, Listas listas) throws CloneNotSupportedException{
		ArrayList<Nodo> sucesores = new ArrayList<Nodo>();
		ArrayList<Caja> listaProduccionTemporal = null;
		
		for (int j = 0; j < padre.getListaProduccionNodo().size(); j++) {
			//Clonamos la lista del nodo
			listaProduccionTemporal = new ArrayList<Caja>();
			listaProduccionTemporal.addAll(padre.getListaProduccionNodo());
			
			//Sacar de la lista de produccion la caja nueva
			Caja cajaNueva = listaProduccionTemporal.remove(j);
			
			for (int i = 0; i < padre.getEstado().getPilas().size(); i++) {
				
				//Clonamos el nodo padre
				Nodo nuevoSucesor = padre.clone();
				
				if(nuevoSucesor.getEstado().getPilas().get(i).getActual() < nuevoSucesor.getEstado().getPilas().get(i).getLimite() && (!estadoInvalido(nuevoSucesor,i,cajaNueva))) {
						nuevoSucesor.getEstado().getPilas().get(i).getCajas().add(0, cajaNueva);
						nuevoSucesor.getEstado().getPilas().get(i).setActual(nuevoSucesor.getEstado().getPilas().get(i).getActual() + 1);
		                                
						//Aumentamos el coste en 1
						nuevoSucesor.setCoste(nuevoSucesor.getCoste() + 1);
						
						//Ponemos el nodo padre como antecesor del nuevo sucesor
						nuevoSucesor.setAntecesor(padre);
						
						//Calculamos la distancia del nuevo sucesor para luego poder ordenar abiertos
						nuevoSucesor.setDistancia(calcularDistancia(nuevoSucesor));
						
						nuevoSucesor.setListaProduccionNodo(listaProduccionTemporal);
						
						if (!nodoAntecesor(nuevoSucesor, padre)) {
							if (nodoEnAbiertos(nuevoSucesor, listas, padre)) {
								//Añadimos el nuevo nodo a la lista de sucesores del padre
								sucesores.add(nuevoSucesor);
							} else if (nodoEnCerrados(nuevoSucesor, listas, padre)) {
								//Añadimos el nuevo nodo a la lista de sucesores del padre
								sucesores.add(nuevoSucesor);
								
								Nodo posiblePadre = null;
								//Buscamos el posible padre
								for (Nodo n : listas.cerrados) {
									if (compararNodos(nuevoSucesor, n)) {
										posiblePadre = n.getAntecesor();
									}
								}
								
								//Calculamos los antecesores
								calcularAntecesores(nuevoSucesor, padre, posiblePadre);
							} else {
								//Metemos el nuevo sucesor en abiertos
								listas.abiertos.add(nuevoSucesor);
								
								//Añadimos el nuevo nodo a la lista de sucesores del padre
								sucesores.add(nuevoSucesor);
								
								//Añadimos el nuevo sucesor al grafo
								listas.grafo.add(nuevoSucesor);
							}
						}
	            } 
	        } 
		}
		
        if(!sucesores.isEmpty()){
            padre.setSucesores(sucesores);
        }
    } 
}
/**********************************************************************************/