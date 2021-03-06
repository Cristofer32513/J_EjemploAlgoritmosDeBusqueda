import java.util.Arrays;
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
			long contadorRecorridos, long tiempoTotal){
		System.out.println("       DATOS DE EFICIENCIA DEL ALGORITMO");
		System.out.println();
		System.out.println("    - Cantidad  de  recorridos  realizados:	"+contadorRecorridos);
		System.out.println("    - Cantidad de comparaciones realizadas:	"+contadorComparaciones);
		System.out.println("    - Tiempo     total     de    ejecucion:	"+(double)tiempoTotal/1000000000+" segundos");
		System.out.println("    - Tiempo     total     de    ejecucion:	"+(double)tiempoTotal/1000000+" milisegundos");
	}
	
	//ALGORITMO DE BUSQUEDA SECUENCIAL
	public void busquedaSecuencial(int[] datos){
		long contadorComparaciones=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		
		@SuppressWarnings("resource")
		Scanner entrada=new Scanner(System.in);
		boolean existe=false;
		
		System.out.println("Ingrese el numero a buscar");
		int numBuscado=entrada.nextInt();
		System.out.println();
		System.out.println();
		
		tiempoInicial=System.nanoTime();
		contadorRecorridos++;
		for(int i=0;i<datos.length;i++){
			contadorComparaciones++;
			if(datos[i]==numBuscado){
				existe=true;
				System.out.println("   El numero si existe, se encuantra en la posicion "+(i+1));
				break;
			}
			else
				existe=false;
		}
		if(!existe)
			System.out.println("   *El numero no existe.");
		tiempoTotal=System.nanoTime()-tiempoInicial;
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorRecorridos, tiempoTotal);
	}
	
	//ALGORITMO DE BUSQUEDA BINARIA
	public int busquedaBinaria(int[] datos, int elemento){
		long contadorComparaciones=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		
		int centro, primero, valorCentro, ultimo;
		primero=0;
		ultimo=datos.length-1;
		tiempoInicial=System.nanoTime();
		contadorRecorridos++;
		while(primero<=ultimo){
			centro=(primero+ultimo)/2;
			valorCentro=datos[centro];
			//System.out.println("Comparando "+elemento+" con "+ datos[centro]);
			contadorComparaciones++;
			if(elemento==valorCentro){
				tiempoTotal=System.nanoTime()-tiempoInicial;
				System.out.println();
				System.out.println();
				mostrarDatosDeEficiencia(contadorComparaciones, contadorRecorridos, tiempoTotal);
				System.out.println();
				System.out.println();
				return centro;
			}
			else if(elemento<valorCentro)
				ultimo=centro-1;
			else
				primero=centro+1;
		}
		tiempoTotal=System.nanoTime()-tiempoInicial;
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorRecorridos, tiempoTotal);
		System.out.println();
		System.out.println();
		return -1;
	}
}


//ALGORITMO DE BUSQUEDA POR FUCNIONES HASH
class HashCero{
	String[] arreglo;
	int tama�o, cont;
	
	public HashCero(int tam){
		tama�o=tam;
		arreglo=new String[tam];
		Arrays.fill(arreglo, "-1");
	}
	
	/**
    *
    * @param cadenaArreglo
    * @param arreglo
    */
	
	public void mostrarDatosDeEficiencia(long contadorComparaciones,
			long contadorRecorridos, long tiempoTotal){
		System.out.println("       DATOS DE EFICIENCIA DEL ALGORITMO");
		System.out.println();
		System.out.println("    - Cantidad  de  recorridos  realizados:	"+contadorRecorridos);
		System.out.println("    - Cantidad de comparaciones realizadas:	"+contadorComparaciones);
		System.out.println("    - Tiempo     total     de    ejecucion:	"+(double)tiempoTotal/1000000000+" segundos");
		System.out.println("    - Tiempo     total     de    ejecucion:	"+(double)tiempoTotal/1000000+" milisegundos");
	}
	
	public void funcionHash(String[] cadenaArreglo, String[] arreglo){
		int i;
		for(i=0;i<cadenaArreglo.length;i++){
			String elemento=cadenaArreglo[i];
			int indiceArreglo=Integer.parseInt(elemento)%97;
			//System.out.println("El indice es "+indiceArreglo+" para el elemento "+elemento);
			
			while(arreglo[indiceArreglo]!="-1"){
				indiceArreglo++;
				//System.out.println("Ocurrio una colisison para el indice "+(indiceArreglo-1)+
						//" cambiar al indice "+indiceArreglo);
				indiceArreglo%=tama�o;
			}
			arreglo[indiceArreglo]=elemento;
		}
	}

	public void mostar(){
		int incremento = 0,i,j;
		for(i=0; i < 1; i++){
			incremento +=100;
			System.out.print("POSICION:	");
			for(j=incremento-100;j<incremento;j++){
				System.out.format("| %3s"+"",j);
			}
			System.out.println("|");
			System.out.println();
			System.out.print("ELEMENTO:	");
			for(j= incremento -100; j< incremento;j++){
				if (arreglo[j].equals("-1")){
					System.out.print(" |        ");
				}
				else{
					System.out.print(String.format("| %3s"+"", arreglo[j]));
				}
			}
			System.out.println("|");
			System.out.println();
			System.out.println();
		}
	}
	
	public String buscarClave(String elemento){
		long contadorComparaciones=0, contadorRecorridos=0;
		long tiempoTotal=0, tiempoInicial=0;
		
		int indiceArreglo=Integer.parseInt(elemento)%97;
		int contador=0;
		
		tiempoInicial=System.nanoTime();
		contadorRecorridos++;
		while(arreglo[indiceArreglo]!="-1"){
			contadorComparaciones++;
			if(arreglo[indiceArreglo].equals(elemento)){
				tiempoTotal=System.nanoTime()-tiempoInicial;
				System.out.println();
				System.out.println();
				mostrarDatosDeEficiencia(contadorComparaciones, contadorRecorridos, tiempoTotal);
				System.out.println();
				System.out.println();
				System.out.println("  El elemento "+elemento+" fue encontrado en la posicion "+indiceArreglo);
				return arreglo[indiceArreglo];
			}
			indiceArreglo++;
			indiceArreglo%=tama�o;
			contador++;
			if(contador>97)
				break;
		}
		tiempoTotal=System.nanoTime()-tiempoInicial;
		System.out.println();
		System.out.println();
		mostrarDatosDeEficiencia(contadorComparaciones, contadorRecorridos, tiempoTotal);
		System.out.println();
		System.out.println();
		return null;
	}	
}