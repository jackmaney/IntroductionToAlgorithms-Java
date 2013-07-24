package com.jackmaney.IntroductionToAlgorithms.Chapter2.Section1;

import java.util.Vector;

import com.jackmaney.IntroductionToAlgorithms.sort.ReverseInsertionSort;

public class Exercise2 {

	public static void main(String[] args) {
		
		Vector<Double> a = new Vector<>();
		
		a.add(-1091.8);
		a.add(3.14);
		a.add(2.17828);
		a.add(0d);
		a.add(-1.5);
		a.add(91.889);
		a.add(-2d);
		
		System.out.println(a);
		
		ReverseInsertionSort.sort(a);
		
		System.out.println(a);
	}

}
