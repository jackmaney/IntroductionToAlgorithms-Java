package com.jackmaney.IntroductionToAlgorithms.search;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class SumSearchTest {

	private Set<Integer> a = new HashSet<Integer>(Arrays.asList(2,1,3,4,7,6,5));
	
	@Test
	public void sumSearchTest() {
		
		HashSet<Integer> result = new HashSet<Integer>(Arrays.asList(2,7));
		assertTrue(SumSearch.search(a, 9).equals(result));
		assertTrue(SumSearch.search(a, 14) == null);
		
	}

}
