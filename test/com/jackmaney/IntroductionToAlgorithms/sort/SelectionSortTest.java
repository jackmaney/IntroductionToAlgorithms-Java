package com.jackmaney.IntroductionToAlgorithms.sort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

import com.jackmaney.IntroductionToAlgorithms.sort.SelectionSort;

public class SelectionSortTest {

	@Test
	public void sortTest() {
		
		ArrayList<Double> a = new ArrayList<>();
		//Arrays.asList(-2.1,0,3.1415,2.718,-6,1.414)
		
		a.add(-2.1);
		a.add(0d);
		a.add(3.1415);
		a.add(2.718);
		a.add(-6d);
		a.add(1.414);
		
		ArrayList<Double> expected = new ArrayList<>();
		
		expected.add(-6d);
		expected.add(-2.1);
		expected.add(0.0d);
		expected.add(1.414);
		expected.add(2.718);
		expected.add(3.1415);
		
		SelectionSort.sort(a);
		
		assertTrue(a.equals(expected));
	}

}
