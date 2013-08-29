package com.jackmaney.IntroductionToAlgorithms.Chapter2.Section3;

import java.util.ArrayList;
import java.util.Collections;

import org.perfidix.annotation.AfterEachRun;
import org.perfidix.annotation.BeforeEachRun;
import org.perfidix.annotation.Bench;

import com.jackmaney.IntroductionToAlgorithms.search.BinarySearch;

public class BinarySearchBenchmark {

	private ArrayList<Integer> randomSortedArrayList(int n,int range){
		if(n < 0 || range < 10000){
			throw new IllegalArgumentException();
		}
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < n; i++){
			result.add(new Integer( (int)(1 + range * Math.random())));
		}
		
		Collections.sort(result);
		return result;
	}
	
	private ArrayList<Integer> a = randomSortedArrayList(10000, 10000);
	private Integer needle = null;
	
	private Integer getNeedle(){
		Integer result = null;
		
		while(true){
			result = new Integer((int)(Math.random() * 10000 + 1));
			if(!a.contains(result)){
				break;
			}
		}
		return result;
	}
	
	@BeforeEachRun
	public void setUp(){
		needle = getNeedle();
	}
	
	@Bench(runs=100)
	public void binarySearchBenchmark(){
		BinarySearch.search(a, needle);
	}
	
	@AfterEachRun
	public void tearDown(){
		needle = null;
	}
}
