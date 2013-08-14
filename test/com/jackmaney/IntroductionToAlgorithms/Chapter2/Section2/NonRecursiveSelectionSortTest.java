package com.jackmaney.IntroductionToAlgorithms.Chapter2.Section2;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.jackmaney.IntroductionToAlgorithms.Chapter2.Section2.NonRecursiveSelectionSort;

public class NonRecursiveSelectionSortTest {

	private ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5,3,2,6,4,1));
	@Test
	public void indexTest() {
		
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(5,2,1,4,0));
		
		for(int i = 0; i < a.size() - 1; i++){
			assertTrue(NonRecursiveSelectionSort.smallestIndex(a, i+1) == expected.get(i));
		}
		
	}
	
	@Test
	public void sortTest(){
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(1,2,3,4,5,6));
		
		NonRecursiveSelectionSort.sort(a);
		
		assertTrue(a.equals(expected));
	}


}
