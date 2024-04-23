
package practica1p2;


public class Nodo 
{
    private String name;
    private Nodo[] vecinos;
    private int[] peso;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nodo[] getVecinos() {
        return vecinos;
    }

    public void setVecinos(Nodo[] vecinos) {
        this.vecinos = vecinos;
    }

    public int[] getPeso() {
        return peso;
    }

    public void setPeso(int[] peso) {
        this.peso = peso;
    }
    
    
    
}
