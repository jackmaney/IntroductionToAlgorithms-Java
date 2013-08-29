package com.jackmaney.IntroductionToAlgorithms.search;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class SumSearchTest {

	private ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(2,1,3,4,7,6,5));
	private ArrayList<Integer> b = new ArrayList<Integer>(Arrays.asList(2,1,2));
	
	@Test
	public void sumSearchTest() {
		
		ArrayList<Integer> result = new ArrayList<Integer>(Arrays.asList(2,7));
		assertTrue(SumSearch.search(a, 9).equals(result));
		assertTrue(SumSearch.search(a, 14) == null);
		
		result.set(0,2);
		result.set(1,2);
		assertTrue(SumSearch.search(b, 4).equals(result));
		
	}

}
