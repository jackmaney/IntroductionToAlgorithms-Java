package com.jackmaney.IntroductionToAlgorithms.sort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class InsertionSortTest {
	
	private ArrayList<Integer> a;
	
	@Before
	public void setUp() throws Exception {
		a = new ArrayList<>(Arrays.asList(new Integer[]{5,3,2,4,1,7,6,0}));
	}

	@Test
	public void partialSort() {
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{5,1,2,3,4,7,6,0}));
		
		InsertionSort.sort(a,1,5);
		
		assertTrue(a.equals(expected));
	}
	
	@Test
	public void globalSort(){
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{0,1,2,3,4,5,6,7}));
		
		InsertionSort.sort(a);

		assertTrue(a.equals(expected));
	}

}
