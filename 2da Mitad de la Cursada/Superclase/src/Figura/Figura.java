package Figura;

public abstract class Figura {

	abstract double area();
	
	abstract double perimetro();
	
	public String tosString() {
		return getClass() + " con area " + area() + " y perimetro " + perimetro();
	}
	
}
