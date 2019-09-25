package modelo;

import modelo.AsistentesAparte.Inverse;

public class Matriz 
{
	private double[][] componente = new double[6][6];
	private Inverse inverse = new Inverse();
	private int filas = 1, columnas = 1;
	
	public Matriz(int pFilas, int pColumnas)
	{
		this.filas = pFilas; this.columnas = pColumnas;
	}

	public double[][] getComponente() {
		return componente;
	}

	public void setComponente(double[][] componente) {
		this.componente = componente;
	}

	public Inverse getInverse() {
		return inverse;
	}

	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}
}
