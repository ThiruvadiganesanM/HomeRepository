package Topics;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class StreamAssignment2 {
	public static void main(String[] args) {
		List<String> names=Arrays.asList("manoj","kishor","lokesh","david","tamil","gopal");
		Stream<String> strm=names.stream();
		String res=strm.filter(e->e.contains("a")).reduce((e1,e2)->e1.charAt(0)>e2.charAt(0)?e1:e2).get();
		System.out.println(res);
	}
}
