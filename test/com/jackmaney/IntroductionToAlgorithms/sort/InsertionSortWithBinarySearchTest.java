package com.jackmaney.IntroductionToAlgorithms.sort;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class InsertionSortWithBinarySearchTest {
	
	private ArrayList<Integer> a;
	private ArrayList<Integer> b;
	private ArrayList<Integer> c;
	private ArrayList<Integer> d;
	
	@Before
	public void setUp(){
		a = new ArrayList<Integer>(Arrays.asList(6,1,3,2,4,7,5));
		b = new ArrayList<Integer>(Arrays.asList(1,0));
		c = new ArrayList<Integer>(Arrays.asList(1,3,4,2,7,6));
		d = new ArrayList<Integer>(Arrays.asList(2,3,4,5,1,6,5));
	}

	@Test
	public void indexTest() {
		assertTrue(InsertionSortWithBinarySearch.getInsertionIndex(c, new Integer(2), 0, 2)
				== 1);
		
		assertTrue(InsertionSortWithBinarySearch.getInsertionIndex(d, new Integer(1), 0, 3)
				== 0);
		
	}
	
	@Test
	public void sortTest(){
		
		
		InsertionSortWithBinarySearch.sort(a);
		InsertionSortWithBinarySearch.sort(b);
		InsertionSortWithBinarySearch.sort(c);
		InsertionSortWithBinarySearch.sort(d);
		
		assertTrue(a.equals(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,6,7))));
		assertTrue(b.equals(new ArrayList<Integer>(Arrays.asList(0,1))));
		assertTrue(c.equals(new ArrayList<Integer>(Arrays.asList(1,2,3,4,6,7))));
		assertTrue(d.equals(new ArrayList<Integer>(Arrays.asList(1,2,3,4,5,5,6))));
		
	}

}
