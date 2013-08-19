import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Fiddle {

	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5));
		
		List<Integer> b = a.subList(1, 3);
		
		a.set(2,-17);
		
		System.out.println(a);
		System.out.println(b);

	}

}
