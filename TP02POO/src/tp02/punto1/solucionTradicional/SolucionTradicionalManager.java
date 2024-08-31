package tp02.punto1.solucionTradicional;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;



public class SolucionTradicionalManager {
    private static List<Integer> lista = new ArrayList<>();
    
    public List<Integer> generarNumerosAleatorios(int N) {
        Random random = new Random();
        while (lista.size() < N) {
            int numero = random.nextInt(101); // Genero un número entre 0 y 100
            if (!lista.contains(numero)) { // Verific si el número ya está en la lista
                lista.add(numero); // Agrega solo si no está en la lista
            }
        }
        return lista;
    }
  
    public void modificarMaximo() {
        int maxIndex = lista.indexOf(Collections.max(lista));
        lista.set(maxIndex, (int) Math.pow(lista.get(maxIndex), 2));//eleva el valor del max encontrado al cuadrado
    }

    public void eliminarMultiplos(int X) {
        for (int i = lista.size() - 1; i >= 0; i--) {
            if (lista.get(i) % X == 0) {
                lista.remove(i);
            }
        }
    }

    public void sumarFactorialMenoresDe5() {
        for (int i = 0; i < lista.size(); i++) {
            int valor = lista.get(i);
            if (valor < 5) {
            	var nuevoValor = (valor + factorial(valor));
                lista.set(i, nuevoValor);
               // System.out.println("Actualizado: " + valor + " es: " + nuevoValor); //probando si funciona
            }
        }
    }

   private int factorial(int n) {
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact = i*fact;
        }
        //System.out.println("Factorial de " + n + " es: " + fact); // probando si funciona
        return fact;
    }

   public void getMenosRepetido() {
	    Map<Integer, Integer> repeticiones = new HashMap<>();

	    for (int num : lista) {
	        repeticiones.put(num, repeticiones.getOrDefault(num, 0) + 1);
	    }

	    int minRepetido = Integer.MAX_VALUE;
	    for (int frecuenciaMin : repeticiones.values()) {
	        if (frecuenciaMin > 1 && frecuenciaMin < minRepetido) {
	            minRepetido = frecuenciaMin;
	        }
	    }
	    
	    if (minRepetido == Integer.MAX_VALUE) {
	        System.out.println("No hay números repetidos.");
	    } else {

	        for (Map.Entry<Integer, Integer> entry : repeticiones.entrySet()) {
	            if (entry.getValue() == minRepetido) {
	                System.out.println("El número menos repetido es: " + entry.getKey());
	                break;//como el tp no contempla minRepetidos con la misma frecuencia, solo muestro uno
	            }
	        }
	    }
	}

    public void getParesEImpares() {
        List<Integer> pares = new ArrayList<>();
        List<Integer> impares = new ArrayList<>();
        for (int num : lista) {
            if (num % 2 == 0) {
                pares.add(num);
            } else {
                impares.add(num);
            }
        }
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
    }

    public void mostrarColeccion() {    	
        System.out.println("Coleccion: "+lista);    	
    }
}