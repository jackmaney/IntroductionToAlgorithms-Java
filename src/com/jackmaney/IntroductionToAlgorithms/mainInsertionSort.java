package com.jackmaney.IntroductionToAlgorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Vector;

import com.jackmaney.IntroductionToAlgorithms.sort.InsertionSort;

public class mainInsertionSort {

	public static void main(String[] args) {
		
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(5,2,4,6,1,3));
		
		//InsertionSort.sort(a);
		
		//System.out.println(a);
		
		Vector<Integer> b = new Vector<Integer>(Arrays.asList(2,4,5,6,1,3));
		
		System.out.println(InsertionSort.getMoves(b));
		
	}

}
