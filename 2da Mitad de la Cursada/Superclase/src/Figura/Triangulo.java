package Figura;

public class Triangulo extends Figura {

	private double lado1;
	private double lado2;
	private double lado3;

	public Triangulo(double la1, double la2, double la3) {
		if (la1 + la2 <= la3 || la2 + la3 <= la1 || la3 + la1 <= la2) {
			throw new RuntimeException("No es posible crear un triangulo");
		}
		lado1 = la1;
		lado2 = la2;
		lado3 = la3;
	}
	
	@Override
	double area() {
		double s = perimetro()/2;
		return Math.sqrt(s*(s-lado1) * s*(s-lado2) * s*(s-lado3));
	}

	@Override
	double perimetro() {
		return lado1 + lado2 + lado3;
	}

	@Override
	public String toString() {
		return "Triangulo con lados " + lado1 + ", " + lado2 + " y " + lado3;
	}

	
}
