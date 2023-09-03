package Topics;
@FunctionalInterface        					//for using this declaration of functional interface,
												//we can't add more than one method within the interface
interface Demo{
	void test();
	
}
class Practice implements Demo{
	
	@Override
	public void test() {
		System.out.println("Hi iam test method from demo interface");
		
	
	}
}
class LamdaExpression {
	public static void main(String[] args) {
		Demo d1=new Practice();
		d1.test();
	

	Demo d2=new Demo() {				// This is called annonoumous class created in stack, which has no name
	public void test() {
		System.out.println("Hi iam test method from anonnoumous class");
	}
	};
	d2.test();

	
	Demo d3=()->{System.out.println("Hi iam test method from Lamda expression");};
	d3.test();
	}										// -> this symbol is called Lamda expression
											// We can only use Lamda expression in functional interface
}