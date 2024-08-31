package tp02.punto1.prueba;

import java.util.Scanner;
import tp02.punto1.solucionLambda.SolucionLambdaManager;
import tp02.punto1.solucionTradicional.SolucionTradicionalManager;

public class Prueba {

	public static void main(String[] args) {
		
		//---------COMENTAR O DESCOMENTAR UN manager PARA PROBAR UNA SOLUCION U OTRA------------
		
			SolucionLambdaManager manager = new SolucionLambdaManager();
			//SolucionTradicionalManager manager = new SolucionTradicionalManager();
			
	        Scanner scanner = new Scanner(System.in);
	        
	        System.out.println("Ingrese Cantidad de Numeros a Generar: ");
	        int N = scanner.nextInt();	       
	        manager.generarNumerosAleatorios(N);
	        
	        manager.mostrarColeccion();
	        
	        System.out.print("Eliminar Multiplos de: ");
	        int X = scanner.nextInt();	        
	        manager.eliminarMultiplos(X);
	        
	        manager.modificarMaximo();
	        manager.sumarFactorialMenoresDe5();
	        manager.mostrarColeccion();
	        manager.getMenosRepetido();
	        manager.getParesEImpares();	    
	        manager.mostrarColeccion();
	        scanner.close();
	  }

	}


