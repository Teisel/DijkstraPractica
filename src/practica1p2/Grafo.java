
package practica1p2;

import java.util.*;


public class Grafo 
{
    private Nodo[] grafo;
    
    public Grafo(){}

    public Nodo[] getGrafo() {
        return grafo;
    }

    public void setGrafo(Nodo[] grafo) {
        this.grafo = grafo;
    }
    
    public void dijkstra(String inicio, String termino) {
    
    resetNodos();
    
    Nodo inicioNodo = findNodo(inicio);
    Nodo terminoNodo = findNodo(termino);

    if (inicioNodo == null || terminoNodo == null) {
        System.out.println("Nodo no encontrado");
        return;
    }

    inicioNodo.setDistancia(0);

    PriorityQueue<Nodo> queue = new PriorityQueue<>((n1, n2) -> n1.getDistancia() - n2.getDistancia());
    queue.add(inicioNodo);

    Map<Nodo, Integer> distanciaMap = new HashMap<>();
    Map<Nodo, Nodo> previousMap = new HashMap<>();

    while (!queue.isEmpty()) {
        Nodo nodo = queue.poll();
        nodo.setVisitado(true);

        for (int i = 0; i < nodo.getVecinos().length; i++) {
            Nodo vecino = nodo.getVecinos()[i];
            int peso = nodo.getPeso()[i];

            if (!vecino.isVisitado()) {
                int distancia = nodo.getDistancia() + peso;
                if(distancia < vecino.getDistancia())
                {
                    vecino.setDistancia(distancia);
                    distanciaMap.put(vecino, distancia);
                    previousMap.put(vecino, nodo);
                    queue.add(vecino);
                }
                
            }
        }
    }

    List<Nodo> shortestPath = new ArrayList<>();
    Nodo currentNode = terminoNodo;
    while (currentNode != null) {
        shortestPath.add(0, currentNode);
        currentNode = previousMap.get(currentNode);
    }

    int currentDistance = 0;
    System.out.println("Ruta más corta desde " + inicio + " a " + termino + ":");
    for (Nodo nodo : shortestPath) {
        System.out.print(nodo.getName() + " (Distancia: " + nodo.getDistancia() + ") -> ");
    }
    System.out.println("Fin");

    System.out.println("Distancia mínima: " + terminoNodo.getDistancia());

    resetNodos();
}

    private Nodo findNodo(String name) {
        for (Nodo nodo : grafo) {
            if (nodo.getName().equals(name)) {
                return nodo;
            }
        }
        return null;
    }
    
    private void resetNodos()
    {
        for (int i = 0; i<grafo.length; i++)
            {
                grafo[i].setVisitado(false);
                grafo[i].setDistancia(Integer.MAX_VALUE);
            }
    }
    
}
