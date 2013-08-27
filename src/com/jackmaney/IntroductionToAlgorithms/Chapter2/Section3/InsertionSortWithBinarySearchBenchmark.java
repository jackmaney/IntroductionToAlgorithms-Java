package com.jackmaney.IntroductionToAlgorithms.Chapter2.Section3;

import java.util.ArrayList;
import java.util.Collections;

import org.perfidix.annotation.AfterEachRun;
import org.perfidix.annotation.BeforeEachRun;
import org.perfidix.annotation.Bench;

import com.jackmaney.IntroductionToAlgorithms.sort.InsertionSortWithBinarySearch;

public class InsertionSortWithBinarySearchBenchmark {

	private ArrayList<Integer> randomReverseSortedArrayList(int n,int range){
		if(n < 0 || range < 10000){
			throw new IllegalArgumentException();
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < n; i++){
			result.add(new Integer( (int)(1 + range * Math.random())));
		}
		
		Collections.sort(result,Collections.reverseOrder());
		return result;
	}
	
	private ArrayList<Integer> a;
	
	
	@BeforeEachRun
	public void setUp(){
		a = randomReverseSortedArrayList(20000, 20000);
	}
	
	@Bench(runs=100)
	public void binarySearchBenchmark(){
		InsertionSortWithBinarySearch.sort(a);
	}
	
	@AfterEachRun
	public void tearDown(){
		a = null;
	}
}
