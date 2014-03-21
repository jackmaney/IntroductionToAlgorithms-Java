package com.jackmaney.IntroductionToAlgorithms.Chapter2.EndOfChapter;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class InsertionWithMergeSortTest {

	private Integer[] intArray;
	ArrayList<Integer> a;
	@Before
	public void setUp() throws Exception {
		intArray = new Integer[]{8,1,7,5,0,6,2,3,2,7,9,-5};
		a = new ArrayList<Integer>(Arrays.asList(intArray));
	}

	@Test
	public void test() {
		Integer[] expectedList = new Integer[] {-5,0,1,2,2,3,5,6,7,7,8,9}; 
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(expectedList));
		
		InsertionWithMergeSort.sort(a, 3);

		assertTrue(a.equals(expected));
	}

}
