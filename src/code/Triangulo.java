package code;

import java.util.ArrayList;
import lib.ClasificacionPorAngulo;
import lib.ClasificacionPorLado;

public class Triangulo {
	private Punto puntoA;
	private Punto puntoB;
	private Punto puntoC;
	
	public Triangulo(Punto puntoA, Punto puntoB, Punto puntoC) {
		this.puntoA = puntoA;
		this.puntoB = puntoB;
		this.puntoC = puntoC;
	}
	
	public ArrayList<Double> calcularLados() {
		ArrayList<Double> lados = new ArrayList<Double>();
		
		Double ladoAB = puntoA.calcularDistancia(puntoB);
		Double ladoBC = puntoB.calcularDistancia(puntoC);
		Double ladoCA = puntoC.calcularDistancia(puntoA);
						
		lados.add(ladoAB);
		lados.add(ladoBC);
		lados.add(ladoCA);
		
		return lados;
	}
	
	public ArrayList<Double> calcularAngulos() {
		ArrayList<Double> angulos = new ArrayList<Double>();
		ArrayList<Double> lados = calcularLados();
		
		Double ladoA = lados.get(0);
		Double ladoB = lados.get(1);
		Double ladoC = lados.get(2);
				
		Double anguloCAB = calcularAngulo(ladoA, ladoB, ladoC);
		Double anguloABC = calcularAngulo(ladoB, ladoC, ladoA);
		Double anguloBCA = calcularAngulo(ladoC, ladoA, ladoB);
		
		angulos.add(anguloCAB);
		angulos.add(anguloABC);
		angulos.add(anguloBCA);
		
		return angulos;
	}
	
	private Double calcularAngulo(Double ladoCatetoOpuestoA, Double ladoCatetoAdyacenteB, Double ladoCatetoAdyacenteC) {
		Double numerador = Math.pow(ladoCatetoOpuestoA, 2) - Math.pow(ladoCatetoAdyacenteB, 2) - 
				Math.pow(ladoCatetoAdyacenteC, 2);
		Double denominador = -2 * ladoCatetoAdyacenteB * ladoCatetoAdyacenteC;
		Double arcosenoA = Math.acos(numerador/denominador);
		return Math.rint(Math.toDegrees(arcosenoA)*100)/100;
	}
	
	public ClasificacionPorLado retornarClasificacionPorLado(ArrayList<Double> lados) {
		int repetidos = 0;
		for (int i=0; i<= lados.size(); i++) {			
			if (i+1 < lados.size()){ 
				for(int j=i+1; j<lados.size();j++){					
					if (lados.get(i).equals(lados.get(j)))
						repetidos++;
				}					
			}
		}
		
		switch (repetidos) {
			case 0:
				return ClasificacionPorLado.ESCALENO;						
			case 1:
				return ClasificacionPorLado.ISOSCELES;							
			case 2:				
			case 3:	
				return ClasificacionPorLado.EQUILATERO;				
			default:
				return ClasificacionPorLado.DESCONOCIDO;
		}
	}
	
	public ClasificacionPorAngulo retornarClasificacionPorAngulo(ArrayList<Double> angulos) {
		
		if (esTrianguloAcutangulo(angulos))
			return ClasificacionPorAngulo.ACUTANGULO;
		else if (esTrianguloRectangulo(angulos))
			return ClasificacionPorAngulo.RECTANGULO;
		else if(esTrianguloObtusangulo(angulos))
			return ClasificacionPorAngulo.OBTUSANGULO;
		else	
			return ClasificacionPorAngulo.DESCONOCIDO;			
	}
	
	private Boolean esTrianguloAcutangulo(ArrayList<Double> angulos) {
		int agudos = 0;
		for (int i=0; i< angulos.size(); i++){			
			if (angulos.get(i)<90 && angulos.get(i) > 0)
				agudos++;
		}
		
		return (agudos == 3);
	}
	
	private Boolean esTrianguloRectangulo(ArrayList<Double> angulos) {
		int recto = 0;
		for (int i=0; i< angulos.size(); i++){
			if (angulos.get(i).intValue() ==90)
				recto++;
		}
		
		return (recto == 1);
	}
	
	private Boolean esTrianguloObtusangulo(ArrayList<Double> angulos) {
		int agudos = 0;
		int obtuso = 0;
		
		for (int i=0; i< angulos.size(); i++){
			if (angulos.get(i)<90 && angulos.get(i) > 0)
				agudos++;
			if (angulos.get(i)>90)
				obtuso++;
		}
		
		return (agudos == 2 && obtuso == 1);
	}
	
	public void mostrarTriangulo(){
		ArrayList<Double> lados = calcularLados();
		ArrayList<Double> angulos = calcularAngulos();
		
		System.out.println("Datos del Triángulo:");
		System.out.println("\t PuntoA: " + puntoA.mostrarPunto() + 
				" PuntoB: " + puntoB.mostrarPunto() + 
				" PuntoC: " + puntoC.mostrarPunto());
		System.out.println("\t Lados:" + lados.toString());
		System.out.println("\t Ángulos:" + angulos.toString());
		System.out.println("\t Clasificación por lado:" + retornarClasificacionPorLado(lados).toString());
		System.out.println("\t Clasificación por ángulo:" + retornarClasificacionPorAngulo(angulos).toString());
	}	
							
}