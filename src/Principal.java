
import java.util.Random;
import code.Punto;
import code.Triangulo;

public class Principal {

	public static void main(String[] args) {
		
		Random rand = new Random();
		double min = -20;
		double max = 20;
		
		// Equilatero/acutangulo		
		Punto p1 = new Punto(7.3, 3.1);			
		Punto p2 = new Punto(1.0, -4.0);		
		Punto p3 = new Punto(-2.0, 5.0);			
		
		Triangulo trianguloEquilateroAcutangulo = new Triangulo(p1, p2, p3);
		trianguloEquilateroAcutangulo.mostrarTriangulo();
		
		// Isosceles/acutangulo		
		p1 = new Punto(-2.0, -2.0);			
		p2 = new Punto(3.0, -2.0);		
		p3 = new Punto(0.0, 2.0);			
		
		Triangulo trianguloIsoscelesAcutangulo = new Triangulo(p1, p2, p3);
		trianguloIsoscelesAcutangulo.mostrarTriangulo();
		
		// Escaleno/acutangulo		
		p1 = new Punto(2.0, 2.0);			
		p2 = new Punto(3.0, 8.0);		
		p3 = new Punto(7.0, 2.0);			
		
		Triangulo trianguloEscalenoAcutangulo = new Triangulo(p1, p2, p3);
		trianguloEscalenoAcutangulo.mostrarTriangulo();
		
		// Isosceles/rectangulo							
		p1 = new Punto(6.0, 0.0);		
		p2 = new Punto(0.0, 6.0);			
		p3 = new Punto(0.0, 0.0);
		
		Triangulo trianguloIsoscelesRectangulo = new Triangulo(p1, p2, p3);
		trianguloIsoscelesRectangulo.mostrarTriangulo();
					
		// Escaleno/rectangulo		
		p1 = new Punto(2.0, 2.0);			
		p2 = new Punto(2.0, 8.0);		
		p3 = new Punto(7.0, 2.0);			
		
		Triangulo trianguloEscalenoRectangulo = new Triangulo(p1, p2, p3);
		trianguloEscalenoRectangulo.mostrarTriangulo();
				
		// Isosceles/obtusangulo							
		p1 = new Punto(-5.12, 3.12);			
		p2 = new Punto(0.0, 0.0);		
		p3 = new Punto(6.0, 0.0);			
		
		Triangulo trianguloIsoscelesObtusangulo = new Triangulo(p1, p2, p3);
		trianguloIsoscelesObtusangulo.mostrarTriangulo();
							
		// Escaleno/obtusangulo		
		p1 = new Punto(-9.0, 2.0);			
		p2 = new Punto(-10.0, -17.0);		
		p3 = new Punto(-18.0, 17.0);			
		
		Triangulo trianguloEscalenoObtusangulo = new Triangulo(p1, p2, p3);
		trianguloEscalenoObtusangulo.mostrarTriangulo();				
		
		// triangulos randomicos
		for(int i=0; i<10; i++){
			
			double randomNumX = (max - min) * rand.nextDouble() + min;
			double randomNumY =  (max - min) * rand.nextDouble() + min;
			Punto punto1 = new Punto(randomNumX, randomNumY);
			
			randomNumX = (max - min) * rand.nextDouble() + min;
			randomNumY =  (max - min) * rand.nextDouble() + min;
			Punto punto2 = new Punto(randomNumX, randomNumY);
			
			randomNumX = (max - min) * rand.nextDouble() + min;
			randomNumY =  (max - min) * rand.nextDouble() + min;
			Punto punto3 = new Punto(randomNumX, randomNumY);			
			
			Triangulo triangulo = new Triangulo(punto1, punto2, punto3);
			triangulo.mostrarTriangulo();
		}
	}

}
