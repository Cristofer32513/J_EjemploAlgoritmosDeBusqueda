import java.util.Scanner;

public class AlgoritmosDeBusqueda {
	
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