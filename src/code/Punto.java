package code;

public class Punto {
	private double x;
	private double y;
	
	public Punto(double x,double y) {
		this.x = Math.rint(x*100)/100;
		this.y = Math.rint(y*100)/100;
	}
	
	public double calcularDistancia(Punto punto) {
		return Math.rint(Math.sqrt(Math.pow(punto.x - this.x,2) + Math.pow(punto.y - this.y, 2))*100)/100;
	}
	
	public Punto devolverPunto() {
		return this;
	}
	
	public String mostrarPunto() {
		return ("x:" + this.x + " y:" + this.y);
	}
}
