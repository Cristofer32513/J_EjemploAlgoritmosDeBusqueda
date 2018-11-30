import java.util.Random;
import java.util.Scanner;

public class PruebaAlgoritmosDeBusqueda {

	public static void main(String[] args) {
		AlgoritmosDeBusqueda algoritmos=new AlgoritmosDeBusqueda();
		
		@SuppressWarnings("resource")
		Scanner entrada=new Scanner(System.in);
		boolean repetirMenuPrincipal=true;
		int opcion=0;
		int[] datos=new int[0];
		
		do{
			System.out.println("1 = Algoritmo de busqueda Secuencial.");
			System.out.println("2 = (Sin funcion... Por Ahora)");
			System.out.println("3 = (Sin funcion... Por Ahora)");
			System.out.println("4 = Llenar vector a utilizar.");
			System.out.println("5 = Salir");
			System.out.println("-----------------------------------------");
			System.out.println("Elija una opcion...");
			opcion=entrada.nextInt();
			System.out.println();
			System.out.println();
			
			if(opcion>=1 && opcion <=5){
				switch(opcion){
				case 1:
					if(datos.length>0){
						System.out.println("  ======================================================VECTOR ORIGINAL======================================================\n");
						algoritmos.mostrarVector(datos);
						System.out.println("\n\n");
						System.out.println("  =================================================BUSQUEDA SECUENCIAL================================================\n");
						algoritmos.busquedaSecuencial(datos.clone());
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 2:
					if(datos.length>0){
						
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 3:
					if(datos.length>0){
						
					}
					else
						System.out.println("  *No se ha elegido un tamaño para el vector.");
					System.out.println();
					System.out.println();
					break;
				case 4:
					datos=new int[100];
					System.out.println("  Creando vector...");
					for(int i=0;i<datos.length;i++)
						datos[i]=new Random().nextInt(100);
					System.out.println();
					System.out.println("  El vector ha sido creado y llenado.");
					System.out.println();
					System.out.println("  *NOTA: El vector a utilizar en los metodos sera el mismo mientras que no se vuelva a llenar.");
					System.out.println();
					System.out.println();
					break;
				case 5:
					repetirMenuPrincipal=false;
					break;
				}
			}
			else{
				System.out.println("  *"+opcion+" no es una opcion valida, intenta otra vez.");
				System.out.println();
				System.out.println();
			}
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println();
		}
		while(repetirMenuPrincipal);
		System.out.println("Usted ha salido.");
	}
}