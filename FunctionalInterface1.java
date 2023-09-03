package Topics;
@FunctionalInterface
interface Calci{
	int add(int a, int b);
}
public class FunctionalInterface1 {
	public static void main(String[] args) {
		Calci c1=(a,b)->{return a+b;};
		System.out.println( c1.add(15,35));
	}
	
}
