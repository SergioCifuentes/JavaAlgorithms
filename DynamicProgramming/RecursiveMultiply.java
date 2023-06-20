public class RecursiveMultiply {
    public static int counter = 0;
	
	public static int minProductHelper(int smaller, int bigger) {
		if (smaller == 0) {
			return 0;
		} else if (smaller == 1) {
			return bigger;
		} 
		
		int s = smaller >> 1;
		int halfProd = minProductHelper(s, bigger);
		
		if (smaller % 2 == 0) {
			counter++;
			return halfProd + halfProd;
		} else {
			counter+=2;
			return halfProd + halfProd + bigger;
		}
	}

	
	public static int minProduct(int a, int b) {
		int bigger = a < b ? b : a;
		int smaller = a < b ? a : b;
		
		return minProductHelper(smaller, bigger);
	}
	
	public static void main(String[] args) {
		int a = 410;
		int b = 105;
        System.out.println(Integer.toBinaryString(a));
            System.out.println(Integer.toBinaryString(b));
		int product = a * b;
		int minProduct = minProduct2(a, b);
		if (product == minProduct) {
			System.out.println("Success: " + a + " * " + b + " = " + product);
		} else {
			System.out.println("Failure: " + a + " * " + b + " = " + product + " instead of " + minProduct);
		}
		System.out.println("Adds: " + counter);

       
	}

    public static int minProduct2(int a, int b) {
		if (a < b) return minProduct(b, a);
		int value = 0;
		while (a > 0) {
            counter++;
			if ((a % 10) % 2 == 1) {

				value += b;
			}
			a >>= 1;
			b <<= 1;
		}	
		return value;
	}
}
