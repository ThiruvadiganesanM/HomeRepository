 package Topics;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;

public class StreamTopic {
	
	
		public static void main(String[] args) {
			//traditional method to find a name contains "O" in it
			List<String> names=Arrays.asList("Mohan","Kishor","Kishor","Lokesh","Selva","Gopal","Kishor","Lokesh");
			List<String> res=new ArrayList<>(); 
			for(String name:names) {
				if(name.contains("o")) {
					res.add(name);
				}
			}
			System.out.println(res);
			System.out.println(res.size());
			
			//Using Stream
			Stream<String> strm=names.stream();
			long count=strm.filter(e->e.contains("o")).count();
			System.out.println(count);
			strm=names.stream();
			List<String> res1=strm.filter(e->e.contains("o")).collect(Collectors.toList());
			System.out.println(res);
			
			
			strm=names.stream();
			Optional<String> s1=strm.filter(e->e.contains("o")).findFirst();
			System.out.println(s1);
			
			strm=names.stream();
			List<String>res2=strm.distinct().collect(Collectors.toList());
			System.out.println(res2);
			
			List<String> res3 = names.stream().filter(e->e.contains("o")).distinct().toList();		
					System.out.println(res3);
		
		}}

