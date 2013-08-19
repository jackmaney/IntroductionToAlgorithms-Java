import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import com.jackmaney.IntroductionToAlgorithms.search.BinarySearch;


public class BinarySearchTest {

	private ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(-2,0,1,3,5,7,8,10,13,17));
	private ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));

	@Test
	public void evenSearch() {
		
		ArrayList<Integer> expected = new ArrayList<Integer>(
				Arrays.asList(0,-1,1,2,-1,3,-1,4,-1,5,6,-1,7,-1,-1,8,-1,-1,-1,9));
		
		ArrayList<Integer> searchValues = new ArrayList<>();
		
		for(int i = -2; i <= 17; i++){
			searchValues.add(BinarySearch.search(a, new Integer(i)));
		}
		
		assertTrue(expected.equals(searchValues));
	}
	
	@Test
	public void oddSearch(){
		ArrayList<Integer> expected = new ArrayList<Integer>(
				Arrays.asList(-1,0,1,2,3,4,5,6,-1,-1));
		
		ArrayList<Integer> searchValues = new ArrayList<>();
		
		for(int i = 0; i < 10; i++){
			searchValues.add(BinarySearch.search(b, new Integer(i)));
		}
		
		assertTrue(expected.equals(searchValues));
	}

}
