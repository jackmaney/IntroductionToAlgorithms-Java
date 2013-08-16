package com.jackmaney.IntroductionToAlgorithms.sort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class RecursiveInsertionSortTest {

	

	@Test
	public void basicInsertTest() {
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(1,3,4,2,7,6,5));
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,7,6,5));
		
		RecursiveInsertionSort.insert(a, 3);
		
		assertTrue(a.equals(expected));
	}
	
	@Test
	public void edgeCaseInsertTest(){
		
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(2,3,4,1,7,6,5));
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,7,6,5));
		
		RecursiveInsertionSort.insert(a, 3);
		
		assertTrue(a.equals(expected));
	}
	
	@Test
	public void sortTest(){
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(2,3,4,1,7,6,5));
		ArrayList<Integer> expected = new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7));
		
		RecursiveInsertionSort.sort(a);
		
		assertTrue(a.equals(expected));
	}

}
