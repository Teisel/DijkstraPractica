
package practica1p2;


public class Nodo 
{
    private String name;
    private Nodo[] vecinos;

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
    
}
