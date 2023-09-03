
package Topics;
import java.util.*;
import java.util.stream.Stream;
public class ParallelStreamTopic {
	public static void main(String[] args) {
		List<Integer> nums=new ArrayList<>();
		Random r1=new Random();
		for(int i=1;i<10000;i++) {
			nums.add(r1.nextInt());
		}
		nums.forEach(System.out::println);
		//nums.forEach(e->System.out.println(e));
		
		
		//let we count the positive numbers among these 10000 numbers in stream
		long start=System.currentTimeMillis();			
		Stream<Integer> strm=nums.stream();
		long count=strm.filter(e->e>0).count();
		System.out.println("count of positive numbers ="+count);
		long end=System.currentTimeMillis();
		System.out.println("Total time taken="+ (end-start));	//find the compiling time
		
		
		start=System.currentTimeMillis();
		Stream<Integer> pstrm=nums.parallelStream();
		long counts=pstrm.filter(e->e>0).count();
		System.out.println("count of positive numbers ="+counts);
		end=System.currentTimeMillis();
		System.out.println("Total time taken="+ (end-start));
	}
}
