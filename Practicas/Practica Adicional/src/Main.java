import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Main {

	public static boolean mayorDiversidad2(int[][] arr) {
		boolean ret = true;
		for (int c = 0; c < arr.length; c++)
			for (int f = 0; f < arr.length; f++)
					ret = ret && estaAscendente(arr[c]);
		return ret ;

	}
	
	
	
	public static boolean estaAscendente(int[] a) {
		boolean ret = false;
		for (int i = 0; i < a.length; i++) {
			while(a[i] >= a[i+1]) {
				ret = ret || true;
			}
			ret = ret || false;
		}
		return ret;
	}
	
	public static boolean hayPar(int[] a) {
		for (int i = 0; i < a.length; i++) {
			if(a[i] %2 == 0) {
				return true;
			}
		}
		return false;
	}
	
	
	public static void main(String[] args) {
		
		int[][] mtx1 = {{1, 2, 3}, {4, 5, 6}};
		int[][] mtx2 = {{1, 2, 3}, {4, 5, 5}};
		int[][] mtx3 = {{1, 2, 3}, {2, 4, 6}};
		
		System.out.println("Consigna 2: " + mayorDiversidad2(mtx1));
		System.out.println("Consigna 2: " + mayorDiversidad2(mtx2));
		System.out.println("Consigna 2: " + mayorDiversidad2(mtx3));
	}
	
}
