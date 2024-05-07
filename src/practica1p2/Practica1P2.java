
package practica1p2;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Practica1P2 {

    private Grafo grafo = new Grafo();

    

    public static void main(String[] args) 
    {
        int op = 0;
        String inicio = "";
        String termino = ""; 
        
        crearGrafo();

        Grafo grafo = new Grafo();
        grafo = crearGrafo();

        
        while(op != 4)
        {
            System.out.println("Elija una opccion");
            System.out.println("1 --- Establecer un inicio");
            System.out.println("2 --- Establecer un final");
            System.out.println("3 --- Iniciar Dijkastra");
            System.out.println("4 --- Salir");
            
            op = isNumber();

            switch(op)
            {
                case 1:
                    inicio = getLetra(inicio, termino);
                break;
                
                case 2:
                    termino = getLetra(inicio, termino);
                break;
                
                case 3:
                    
                break;
            }
            
        }
    }
    
    private static int isNumber() {
        Scanner reader = new Scanner(System.in);
        int num = 0;
        try
        {
            num = reader.nextInt();
        }
        catch(InputMismatchException ime)
        {
        System.out.println("Solo puedes usar numeros");
        reader.next();
        return -1;
        }
        return num;
    } 
    
    private static String getLetra(String inicio, String termino)
    {
        String letra = "";
        String options = "ABCDEFGH";
        boolean flag = true;
        while(flag)
        {
            while(letra.equals(""))
            {
            
                System.out.println("Ingrese el nombre del nodo");
                Scanner reader = new Scanner(System.in);
                letra = reader.nextLine(); 
                letra = letra.toUpperCase();
                letra = letra.substring(0, 1);

            }   
            
            if ((options.contains(letra)) && (!letra.equals(inicio)) && (!letra.equals(termino)))
            {
                flag = !flag;
            }
            else
            {
                letra = "";
            }
        }
        
        
        letra = letra.substring(0, 1);
        return letra;
    }
    

    
    private static Grafo crearGrafo()
    {
        Grafo grafo = new Grafo();
        Nodo[] nodo = new Nodo[8];
        String name = "ABCDEFGH";
        Nodo[] tempNodo;
        int[] tempPeso;
        
        for (int i = 0; i < 8; i++)
        {
            nodo[i] = new Nodo();
            nodo[i].setName(name.substring(i, i + 1));
        }
        
        //A
        tempNodo = new Nodo[2];
        tempNodo[0] = nodo[1];
        tempNodo[1] = nodo[5];
        
        tempPeso = new int[2];
        tempPeso[0] = 2;
        tempPeso[1] = 1;
        
        nodo[0].setVecinos(tempNodo);
        nodo[0].setPeso(tempPeso);
        
        //B
        tempNodo = new Nodo[4];
        tempNodo[0] = nodo[0];
        tempNodo[1] = nodo[2];
        tempNodo[2] = nodo[3];
        tempNodo[3] = nodo[4];
        
        tempPeso = new int[4];
        tempPeso[0] = 2;
        tempPeso[1] = 2;
        tempPeso[2] = 2;
        tempPeso[3] = 4;
        
        nodo[1].setVecinos(tempNodo);
        nodo[1].setPeso(tempPeso);
        
        //C
        tempNodo = new Nodo[3];
        tempNodo[0] = nodo[1];
        tempNodo[1] = nodo[4];
        tempNodo[2] = nodo[7];
        
        tempPeso = new int[3];
        tempPeso[0] = 2;
        tempPeso[1] = 3;
        tempPeso[2] = 1;
        
        nodo[2].setVecinos(tempNodo);
        nodo[2].setPeso(tempPeso);
        
        //D
        tempNodo = new Nodo[3];
        tempNodo[0] = nodo[1];
        tempNodo[1] = nodo[4];
        tempNodo[2] = nodo[5];
        
        tempPeso = new int[3];
        tempPeso[0] = 2;
        tempPeso[1] = 4;
        tempPeso[2] = 3;
        
        nodo[3].setVecinos(tempNodo);
        nodo[3].setPeso(tempPeso);
        
        //E
        tempNodo = new Nodo[4];
        tempNodo[0] = nodo[1];
        tempNodo[1] = nodo[2];
        tempNodo[2] = nodo[3];
        tempNodo[3] = nodo[6];
        
        tempPeso = new int[4];
        tempPeso[0] = 4;
        tempPeso[1] = 3;
        tempPeso[2] = 4;
        tempPeso[3] = 7;
        
        nodo[4].setVecinos(tempNodo);
        nodo[4].setPeso(tempPeso);
        
        //F
        tempNodo = new Nodo[3];
        tempNodo[0] = nodo[0];
        tempNodo[1] = nodo[3];
        tempNodo[2] = nodo[6];
        
        tempPeso = new int[3];
        tempPeso[0] = 1;
        tempPeso[1] = 3;
        tempPeso[2] = 5;
        
        nodo[5].setVecinos(tempNodo);
        nodo[5].setPeso(tempPeso);
        
        //G
        tempNodo = new Nodo[3];
        tempNodo[0] = nodo[4];
        tempNodo[1] = nodo[5];
        tempNodo[2] = nodo[7];
        
        tempPeso = new int[3];
        tempPeso[0] = 7;
        tempPeso[1] = 5;
        tempPeso[2] = 3;
        
        nodo[6].setVecinos(tempNodo);
        nodo[6].setPeso(tempPeso);
        
        //H
        tempNodo = new Nodo[2];
        tempNodo[0] = nodo[2];
        tempNodo[1] = nodo[6];
        
        tempPeso = new int[2];
        tempPeso[0] = 1;
        tempPeso[1] = 3;
        
        nodo[7].setVecinos(tempNodo);
        nodo[7].setPeso(tempPeso);
        
        grafo.setGrafo(nodo);
        return grafo;
    }
}

