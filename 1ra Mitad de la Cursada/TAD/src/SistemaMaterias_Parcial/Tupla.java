package SistemaMaterias_Parcial;

public class Tupla<T1, T2> {

	private T1 x;
	private T2 y;

	public Tupla (T1 x, T2 y) {
		this.x = x;
		this.y = y;
	}
	
		public T1 getX() {
		return x;
	}

	public void setX(T1 x) {
		this.x = x;
	}

	public T2 getY() {
		return y;
	}

	public void setY(T2 y) {
		this.y = y;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((x == null) ? 0 : x.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tupla other = (Tupla) obj;
		if (x == null) {
			if (other.x != null)
				return false;
		} else if (!x.equals(other.x))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tupla [x=" + x + ", y=" + y + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}
