package modelo;

import modelo.AsistentesAparte.Inverse;

public class Lineal 
{
	private Matriz[] matriz = new Matriz[2];
	private Inverse inverse = new Inverse();

	public Matriz[] getMatriz() {
		return matriz;
	}
	
	public void nuevaMatriz(int filas, int columnas)
	{
		for (int i = 0; i < matriz.length; i++) 
		{
			if(matriz[i] == null)
			{
				matriz[i] = new Matriz(filas, columnas);
				System.out.println("Matriz de "+filas+"x"+columnas+". id: "+i);
				break;
			}
		}
		
	}
	
	public void modificarComponentes(int idMatriz, double[][] componentes)
	{
		try 
		{
			matriz[idMatriz].setComponente(componentes);
			for (int i = 0; i < matriz[idMatriz].getFilas(); i++) 
			{
				for (int j = 0; j < matriz[idMatriz].getColumnas(); j++) 
				{
					System.out.println("Componente Posicion ["+(i+1)+", "+(j+1)+"]: "+componentes[i][j]);
				}
			}
			System.out.println("Operacion Exitosa!");
		} 
		catch (IndexOutOfBoundsException errorBusqueda) 
		{
			System.out.println("La matriz con id "+idMatriz+" no existe o aun no ha sido creado.");
		}
	}
	
	public void sumarXescalar(int idMatriz, double escalar)
	{
		try 
		{
			double[][] escalares = new double[matriz[idMatriz].getFilas()][matriz[idMatriz].getColumnas()];
			for (int i = 0; i < matriz[idMatriz].getFilas(); i++) 
			{
				for (int j = 0; j < matriz[idMatriz].getColumnas(); j++) 
				{
					escalares[i][j] += matriz[idMatriz].getComponente()[i][j]+escalar;
				}
			}
			matriz[idMatriz].setComponente(escalares);
			for (int i = 0; i < matriz[idMatriz].getFilas(); i++) 
			{
				for (int j = 0; j < matriz[idMatriz].getColumnas(); j++) 
				{
					System.out.println("Componente Posicion ["+(i+1)+", "+(j+1)+"]: "+matriz[idMatriz].getComponente()[i][j]);
				}
			}
		}
		catch (IndexOutOfBoundsException errorBusqueda) 
		{
			System.out.println("La matriz con id "+idMatriz+" no existe o aun no ha sido creado.");
		}
	}
	
	public void multiplicarXescalar(int idMatriz, double escalar)
	{
		try 
		{
			double[][] escalares = new double[matriz[idMatriz].getFilas()][matriz[idMatriz].getColumnas()];
			for (int i = 0; i < matriz[idMatriz].getFilas(); i++) 
			{
				for (int j = 0; j < matriz[idMatriz].getColumnas(); j++) 
				{
					escalares[i][j] += matriz[idMatriz].getComponente()[i][j]*escalar;
				}
			}
			matriz[idMatriz].setComponente(escalares);
			for (int i = 0; i < matriz[idMatriz].getFilas(); i++) 
			{
				for (int j = 0; j < matriz[idMatriz].getColumnas(); j++) 
				{
					System.out.println("Componente Posicion ["+(i+1)+", "+(j+1)+"]: "+matriz[idMatriz].getComponente()[i][j]);
				}
			}
		}
		catch (IndexOutOfBoundsException errorBusqueda) 
		{
			System.out.println("La matriz con id "+idMatriz+" no existe o aun no ha sido creado.");
		}
	}
	
	public void invertirMatriz(int idMatriz)
	{
		try 
		{
			matriz[idMatriz].setComponente(inverse.invert(matriz[idMatriz].getComponente()));
			for (int i = 0; i < matriz[idMatriz].getFilas(); i++) 
			{
				for (int j = 0; j < matriz[idMatriz].getColumnas(); j++) 
				{
					System.out.println("Componente Posicion ["+(i+1)+", "+(j+1)+"]: "+matriz[idMatriz].getComponente()[i][j]);
				}
			}
		} 
		catch (IndexOutOfBoundsException errorBusqueda) 
		{
			System.out.println("La matriz con id "+idMatriz+" no existe o aun no ha sido creado.");
		}
	}
	
	public void matrizTranspuesta(int idMatriz)
	{
		try 
		{
			double[][] escalares = new double[matriz[idMatriz].getColumnas()][matriz[idMatriz].getFilas()];
			for (int i = 0; i < matriz[idMatriz].getColumnas(); i++) 
			{
				for (int j = 0; j < matriz[idMatriz].getFilas(); j++) 
				{
					escalares[i][j] += matriz[idMatriz].getComponente()[j][i];
				}
			}
			matriz[idMatriz].setComponente(escalares);
			for (int i = 0; i < matriz[idMatriz].getFilas(); i++) 
			{
				for (int j = 0; j < matriz[idMatriz].getColumnas(); j++) 
				{
					System.out.println("Componente Posicion ["+(i+1)+", "+(j+1)+"]: "+matriz[idMatriz].getComponente()[i][j]);
				}
			}
		} 
		catch (IndexOutOfBoundsException errorBusqueda) 
		{
			System.out.println("La matriz con id "+idMatriz+" no existe o aun no ha sido creado.");
		}
	}
	
	public void sumarMatrices(int idMatrizA, int idMatrizB)
	{
		try 
		{
			if(matriz[idMatrizA].getFilas() == matriz[idMatrizB].getFilas() && matriz[idMatrizA].getColumnas() == matriz[idMatrizB].getColumnas())
			{
				if(matriz[(matriz.length-1)] == null)
				{
					matriz[(matriz.length-1)] = new Matriz(matriz[idMatrizA].getFilas(), matriz[idMatrizB].getColumnas()); //Matriz Respuesta
				}
//				double[][] matA = new double[matriz[(matriz.length-1)].getFilas()][matriz[(matriz.length-1)].getColumnas()];
//				double[][] matB = new double[matriz[(matriz.length-1)].getFilas()][matriz[(matriz.length-1)].getColumnas()];
				double[][] matRespuesta = new double[matriz[(matriz.length-1)].getFilas()][matriz[(matriz.length-1)].getColumnas()];
				for (int i = 0; i < matriz[(matriz.length-1)].getFilas(); i++) 
				{
					for (int j = 0; j < matriz[(matriz.length-1)].getColumnas(); j++) 
					{
//						matA[i][j] += matriz[idMatrizA].getComponente()[i][j];
//						matB[i][j] += matriz[idMatrizB].getComponente()[i][j];
						matRespuesta[i][j] = matriz[idMatrizA].getComponente()[i][j] + matriz[idMatrizB].getComponente()[i][j];
					}
				}
				matriz[(matriz.length-1)].setComponente(matRespuesta);
				for (int i = 0; i < matriz[(matriz.length-1)].getFilas(); i++) 
				{
					for (int j = 0; j < matriz[(matriz.length-1)].getColumnas(); j++) 
					{
						System.out.println("Componente Posicion ["+(i+1)+", "+(j+1)+"]: "+matriz[(matriz.length-1)].getComponente()[i][j]);
					}
				}
			}
		} 
		catch (IndexOutOfBoundsException errorBusqueda) 
		{
			System.out.println("Alguna matriz con id no existe o aun no ha sido creado.");
		}
	}
	
	public void multiplicarMatrices(int idMatrizA, int idMatrizB)
	{
		try 
		{
			if(matriz[idMatrizA].getColumnas() == matriz[idMatrizB].getFilas())
			{
				if(matriz[(matriz.length-1)] == null)
				{
					matriz[(matriz.length-1)] = new Matriz(matriz[idMatrizA].getFilas(), matriz[idMatrizB].getColumnas()); //Matriz Respuesta
				}
//				double[][] matA = new double[matriz[(matriz.length-1)].getFilas()][matriz[(matriz.length-1)].getColumnas()];
//				double[][] matB = new double[matriz[(matriz.length-1)].getFilas()][matriz[(matriz.length-1)].getColumnas()];
				double[][] matRespuesta = new double[matriz[(matriz.length-1)].getFilas()][matriz[(matriz.length-1)].getColumnas()];
				for (int i = 0; i < matriz[(matriz.length-1)].getFilas(); i++) 
				{
					for (int j = 0; j < matriz[(matriz.length-1)].getColumnas(); j++) 
					{
//						matA[i][j] += matriz[idMatrizA].getComponente()[i][j];
//						matB[i][j] += matriz[idMatrizB].getComponente()[i][j];
						matRespuesta[i][j] = matriz[idMatrizA].getComponente()[i][j] * matriz[idMatrizB].getComponente()[i][j];
					}
				}
				matriz[(matriz.length-1)].setComponente(matRespuesta);
				for (int i = 0; i < matriz[(matriz.length-1)].getFilas(); i++) 
				{
					for (int j = 0; j < matriz[(matriz.length-1)].getColumnas(); j++) 
					{
						System.out.println("Componente Posicion ["+(i+1)+", "+(j+1)+"]: "+matriz[(matriz.length-1)].getComponente()[i][j]);
					}
				}
			}
		} 
		catch (IndexOutOfBoundsException errorBusqueda) 
		{
			System.out.println("Alguna matriz con id no existe o aun no ha sido creado.");
		}
	}
}