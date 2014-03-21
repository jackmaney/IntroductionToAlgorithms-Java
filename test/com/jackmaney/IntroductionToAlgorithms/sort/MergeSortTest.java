package com.jackmaney.IntroductionToAlgorithms.sort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class MergeSortTest {

	
	private ArrayList<Integer> sorted = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));

	@Test
	public void mergeTest() {
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1,3,6,2,4,5,7));
		
		MergeSort.merge(a, 0, 2, 6);
		
		assertTrue(a.equals(sorted));
	}
	
	@Test
	public void mergeSortTest(){
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(7,4,3,1,6,2,5));
		MergeSort.sort(a);
		assertTrue(a.equals(sorted));
	}

}
