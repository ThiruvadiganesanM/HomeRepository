package Topics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAssignment1 {
	public static void main(String[] args) {
		List<String> names=Arrays.asList("manoj","kishor","lokesh","david","tamil","gopal");
		Stream<String> strm=names.stream();
		List<String> res=strm.filter(e->e.length()==6).map(e->e.substring(0,3)).toList();
		System.out.println(res);
	}
}
