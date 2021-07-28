package Figura;

public class Rectangulo extends Figura {

	private double base;
	private double altura;
	
	public Rectangulo(double b, double a) {
		base = b;
		altura = a;
	}

	@Override
	double area() {
		return base * altura;
	}

	@Override
	double perimetro() {
		return (base + altura) * 2;
	}

	public double getBase() {
		return base;
	}
	
	@Override
	public String toString() {
		return "Rectangulo con base " + base + " y altura " + altura;
	}

	
	
}
