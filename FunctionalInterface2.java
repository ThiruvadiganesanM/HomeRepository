package Topics;

import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterface2 {
public static void main(String[] args) {
	
	Predicate<String> p1=(String a)->{return a.endsWith("a");};
				//predicate is a functional interface which has
															//one method called test(), it takes String as 
															//input arguments and return boolean value
	System.out.println(p1.test("kaml"));
	System.out.println(p1.test("kaml"));
	
	
	Consumer<String> c1=(s)-> {System.out.println(s);};
	c1.accept("Ganesh");
	
	One on=()->{System.out.println("one method is running");};
	on.one();
}
}

interface One{
	public void one();
}
