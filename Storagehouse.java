package storagehouse;

import java.util.ArrayList;

public class Storagehouse {

    public static void main(String[] args) throws CloneNotSupportedException {
        Controlador controlador=new Controlador();
        ArrayList<Nodo> abiertos = new ArrayList<Nodo>();
		ArrayList<Nodo> cerrados = new ArrayList<Nodo>();
		ArrayList<Caja> listaProduccion = new ArrayList<Caja>();
		ArrayList<Nodo> grafo = new ArrayList<Nodo>();
		Listas listas = new Listas(abiertos, cerrados, listaProduccion, grafo);
        
        //Sucesores del nuevo nodo
		ArrayList<Nodo> sucesores = new ArrayList<Nodo>(); 
		
		//Variables para el nodo inicial
		Almacen estadoInicial;
		Nodo nodoInicial;
			
		//Nodo en el que siempre vamos a guardar el primer nodo de abiertos
		Nodo primerNodoAbiertos;
        
        //Flag para ver si esta en abiertos o en cerrados
		int abiertosCerrados;
        
        //Obtenemos la lista de producción y la guardamos
		listas.listaProduccion = (controlador.inicializarLista());
        
        //Configuramos el nodo inicial y lo añadimos a abiertos y al grafo
		estadoInicial = controlador.configurarEstadoInicial();
		nodoInicial = controlador.configurarNodoInicial(estadoInicial, listas);
		listas.abiertos.add(nodoInicial);
		listas.grafo.add(nodoInicial);
        
        while(true){

            if(listas.abiertos.isEmpty()) {
				System.out.print("Fallo: Abiertos vacío");
				return;
			} else{
                //Cogemos el primer nodo de abiertos
				primerNodoAbiertos = listas.abiertos.get(0);
				
                //Eliminamos el primer nodo de abiertos y lo metemos en cerrados
                listas.abiertos.remove(0);
				listas.cerrados.add(primerNodoAbiertos);
				
                // Si el estado es el objetivo terminamos
				if (primerNodoAbiertos.getListaProduccionNodo().isEmpty() && controlador.pilasLlenas(primerNodoAbiertos)) {
					break;
				}
				
                //Calculamos los sucesores del primer nodo de abiertos y los metemos en abiertos
				controlador.expandir(primerNodoAbiertos, listas);

                controlador.ordenarAbiertos(listas);
                                                 
            }
        
        }
        controlador.imprimirSolucion(listas.getGrafo().get(listas.grafo.size() - 1), listas);
    }
}
    
