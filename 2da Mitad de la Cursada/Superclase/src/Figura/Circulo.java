package Figura;

public class Circulo extends Figura {

	double radio;
	
	public Circulo(double r) {
		radio = r;
	}
	
	@Override
	double area() {
		return radio * radio * Math.PI;
	}

	@Override
	double perimetro() {
		return radio * 2 * Math.PI;
	}

	@Override
	public String toString() {
		return "Circulo con radio " + radio;
	}

	
	
	
	
	
	
}
