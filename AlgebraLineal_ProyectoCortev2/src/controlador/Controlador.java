package controlador;

import java.util.Scanner;

import modelo.Lineal;

public class Controlador 
{
	private Lineal mundo = new Lineal();
	private Scanner sc = new Scanner(System.in);
	private String comando = new String();

	public Controlador()
	{
		iniciarPrograma();
	}
	
	public void iniciarPrograma()
	{
		boolean activo = true;
		try 
		{
			while(activo == true)
			{
				System.out.print("user: ");
				comando = sc.next();
				switch(comando)
				{
				case("?"):
					ayuda();
					break;
				case("ayuda"):
					ayuda();
					break;
				default:
					System.err.println("Comando Invalido");
					break;
				case("0"):
					activo = false;
					break;
				case("nuevaMatriz"):
					nuevaMatriz();
					break;
				case("sumarEscalar"):
					sumarEscalar();
					break;
				case("multiplicarEscalar"):
					multiplicarEscalar();
					break;
				case("modificarComponentes"):
					modificarComponentes();
					break;
				case("invertirMatriz"):
					invertirMatriz();
					break;
				case("matrizTranspuesta"):
					matrizTranspuesta();
					break;
				case("sumarMatrices"):
					sumarMatrices();
					break;
				case("multiplicarMatrices"):
					multiplicarMatrices();
					break;
				}
			}
		} 
		catch (Exception e) 
		{
			System.err.println(e.toString());
		}
	}
	
	public void ayuda()
	{
		System.out.println("Comando\tDescripcion\n"
				+ "? o ayuda\tMuestra esta ayuda\n"
				+ "0\tSale del programa\n"
				+ "nuevaMatriz\tCrea una nueva matriz\n"
				+ "modificarComponentes\tModifica los componentes de la matriz seleccionada\n"
				+ "sumarEscalar\tSuma los componentes de la matriz seleccionada por un escalar\n"
				+ "multiplicarEscalar\tMultiplica los componentes de la matriz seleccionada por un escalar\n"
				+ "sumarMatrices\tSuma una matriz A con una matriz B y crea una Matriz respuesta para ver los resultados\n"
				+ "multiplicarMatrices\tMultiplica una matriz A con una matriz B y crea una Matriz respuesta para ver los resultados\n"
				+ "invertirMatriz\tInvierte la matriz seleccionada\n"
				+ "matrizTranspuesta\tTranspone la matriz seleccionada");
	}
	
	public void nuevaMatriz()
	{
		System.out.print("Ingrese Filas: ");
		int filas = sc.nextInt();
		System.out.print("Ingrese Columnas: ");
		int columnas = sc.nextInt();
		if(filas > 0 && filas < 6 || columnas > 0 && columnas < 6)
		{
			mundo.nuevaMatriz(filas, columnas);
		}
		else
		{
			System.err.print("La matriz no es de las dimensiones permitidas");
		}
	}
	
	public void sumarEscalar()
	{
		System.out.print("Ingrese el id de la matriz adicionada: ");
		int matriz = sc.nextInt();
		System.out.print("Ingrese el escalar a sumar: ");
		double escalar = sc.nextDouble();
		mundo.sumarXescalar(matriz, escalar);
	}
	
	public void multiplicarEscalar()
	{
		System.out.print("Ingrese el id de la matriz adicionada: ");
		int matriz = sc.nextInt();
		System.out.print("Ingrese el escalar a multiplicar: ");
		double escalar = sc.nextDouble();
		mundo.multiplicarXescalar(matriz, escalar);
	}
	
	public void modificarComponentes()
	{
		System.out.print("Ingrese el id de la matriz adicionada: ");
		int matriz = sc.nextInt();
		double[][] componentes = new double[mundo.getMatriz()[matriz].getFilas()][mundo.getMatriz()[matriz].getFilas()];
		try 
		{
			for (int i = 0; i < mundo.getMatriz()[matriz].getFilas(); i++) 
			{
				for (int j = 0; j < mundo.getMatriz()[matriz].getFilas(); j++) 
				{
					System.out.print("Ingresa el componente de posicion ["+(i+1)+", "+(j+1)+"]: ");
					componentes[i][j] += sc.nextDouble();
				}
			}
			mundo.modificarComponentes(matriz, componentes);
		} 
		catch (IndexOutOfBoundsException e) 
		{
			System.err.print("La matriz no existe");
		}
	}
	
	public void invertirMatriz()
	{
		System.out.print("Ingrese el id de la matriz adicionada: ");
		int matriz = sc.nextInt();
		try 
		{
			mundo.invertirMatriz(matriz);
		} 
		catch (IndexOutOfBoundsException e) 
		{
			System.err.print("La matriz no existe");
		}
	}
	
	public void matrizTranspuesta()
	{
		System.out.print("Ingrese el id de la matriz adicionada: ");
		int matriz = sc.nextInt();
		try 
		{
			mundo.matrizTranspuesta(matriz);
		} 
		catch (IndexOutOfBoundsException e) 
		{
			System.err.print("La matriz no existe");
		}
	}
	
	public void sumarMatrices()
	{
		System.out.print("Ingrese el id de la matriz A: ");
		int matrizA = sc.nextInt();
		System.out.print("Ingrese el id de la matriz B: ");
		int matrizB = sc.nextInt();
		try 
		{
			mundo.sumarMatrices(matrizA, matrizB);
		} 
		catch (IndexOutOfBoundsException e) 
		{
			System.err.print("La matriz no existe");
		}
	}
	
	public void multiplicarMatrices()
	{
		System.out.print("Ingrese el id de la matriz A: ");
		int matrizA = sc.nextInt();
		System.out.print("Ingrese el id de la matriz B: ");
		int matrizB = sc.nextInt();
		try 
		{
			mundo.multiplicarMatrices(matrizA, matrizB);
		} 
		catch (IndexOutOfBoundsException e) 
		{
			System.err.print("La matriz no existe");
		}
	}

}
