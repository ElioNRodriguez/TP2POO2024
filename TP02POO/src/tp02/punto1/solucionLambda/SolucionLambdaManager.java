package tp02.punto1.solucionLambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class SolucionLambdaManager {
	private static List<Integer> lista = new ArrayList<>();

    public List<Integer> generarNumerosAleatorios(int N) {
        Random random = new Random();
        lista = random.ints(0, 101).distinct().limit(N).boxed().collect(Collectors.toList());
        return lista;
    }

    public void modificarMaximo() {
        lista.replaceAll(num -> num.equals(Collections.max(lista)) ? (int) Math.pow(num, 2) : num);
    }

    public void eliminarMultiplos(int X) {
        lista.removeIf(num -> num % X == 0);
    }

    public void sumarFactorialMenoresDe5() {
        lista.replaceAll(num -> num < 5 ? num + factorial(num) : num);
    }

    private int factorial(int n) {
        return n <= 1 ? 1 : n * factorial(n - 1);
    }

    public void getMenosRepetido() {
        Map<Integer, Integer> repeticiones = lista.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.summingInt(e -> 1)));

        int repeticionMinima = repeticiones.values().stream() 
                .filter(frecuencia -> frecuencia > 1)//filtro los numeros que aparecen mas de 1 vez
                .min(Integer::compare)//encuentro el menos repetido
                .orElse(-1);//uso este valor para saber si no hay repetidos
        
        if (repeticionMinima == -1) {
            System.out.println("No hay números repetidos.");
        } else {
            int numMenosRepetido = repeticiones.entrySet().stream()
                    .filter(entry -> entry.getValue() == repeticionMinima)
                    .map(Map.Entry::getKey)
                    .findFirst()               
                    .orElse(-1);
            System.out.println("El número Menos Repetido es: " + numMenosRepetido);
        }
    }

    public void getParesEImpares() {
        List<Integer> pares = lista.stream().filter(num -> num % 2 == 0).collect(Collectors.toList());
        List<Integer> impares = lista.stream().filter(num -> num % 2 != 0).collect(Collectors.toList());
        System.out.println("Pares: " + pares);
        System.out.println("Impares: " + impares);
    }

    public void mostrarColeccion() {    	
        System.out.println("Colección: " + lista);    	
    }
}
