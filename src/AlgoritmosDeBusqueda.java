import java.util.Scanner;

public class AlgoritmosDeBusqueda {
	
	public void mostrarVector(int[] datos){
		byte cont=1;
		for(int i=0;i<datos.length;i++){
			if(cont==15){
				System.out.println("  "+datos[i]+",	");
				cont=1;
			}
			else{
				System.out.print("  "+datos[i]+",	");
				cont++;
			}
		}
	}
	
	public void mostrarDatosDeEficiencia(long contadorComparaciones,
			long contadorIntercambios, long contadorRecorridos, long tiempoTotal){
		System.out.println("       DATOS DE EFICIENCIA DEL ALGORITMO");
		System.out.println();
		System.out.println("    - Cantidad  de  recorridos  realizados:	"+contadorRecorridos);
		System.out.println("    - Cantidad de comparaciones realizadas:	"+contadorComparaciones);
		System.out.println("    - Cantidad  de intercambios realizados:	"+contadorIntercambios);
		System.out.println("    - Tiempo     total     de    ejecucion:	"+(double)tiempoTotal/1000000000+" segundos");
		System.out.println("    - Tiempo     total     de    ejecucion:	"+(double)tiempoTotal/1000000+" milisegundos");
	}
	
	public void busquedaSecuencial(int[] datos){
		@SuppressWarnings("resource")
		Scanner entrada=new Scanner(System.in);
		boolean existe=false;
		
		System.out.println("Ingrese el numero a buscar");
		int numBuscado=entrada.nextInt();
		
		for(int i=0;i<datos.length;i++){
			if(datos[i]==numBuscado){
				existe=true;
				System.out.println("El numero si existe, se encuantra en a posicion "+(i+1));
				break;
			}
			else
				existe=false;
		}
		if(!existe)
			System.out.println("El numero no existe.");
	}
	
	
	
	
	
}