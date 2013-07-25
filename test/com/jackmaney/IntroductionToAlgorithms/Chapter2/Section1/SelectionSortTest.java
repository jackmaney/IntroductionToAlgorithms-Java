package com.jackmaney.IntroductionToAlgorithms.Chapter2.Section1;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.jackmaney.IntroductionToAlgorithms.Chapter2.Section2.SelectionSort;

public class SelectionSortTest {

	private ArrayList<Integer> a = new ArrayList<>(Arrays.asList(5,3,2,6,4,1));
	@Test
	public void indexTest() {
		
		ArrayList<Integer> expected = new ArrayList<>(Arrays.asList(5,2,1,4,0));
		
		for(int i = 0; i < a.size() - 1; i++){
			assertTrue(SelectionSort.smallestIndex(a, i+1) == expected.get(i));
		}
		
	}

}
