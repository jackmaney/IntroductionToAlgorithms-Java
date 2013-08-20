package com.jackmaney.IntroductionToAlgorithms.Chapter2.Section2;

import java.util.ArrayList;

import org.perfidix.annotation.AfterEachRun;
import org.perfidix.annotation.BeforeEachRun;
import org.perfidix.annotation.Bench;
import org.perfidix.annotation.BenchClass;

import com.jackmaney.IntroductionToAlgorithms.sort.NonRecursiveSelectionSort;
import com.jackmaney.IntroductionToAlgorithms.sort.SelectionSort;

@BenchClass(runs = 10)
public final class SelectionSortBenchmark {

	private static ArrayList<Double> randomArrayList(int n){
		if(n <= 0){
			throw new IllegalArgumentException();
		}
		
		ArrayList<Double> result = new ArrayList<>();
		
		for(int i = 0; i < n; i++){
			result.add(Math.random());
		}
		
		return result;
	}
	
	private ArrayList<Double> a;
	
	@BeforeEachRun
	public void setUp(){
		a = randomArrayList(2000);
	}
	
	@AfterEachRun
	public void tearDown(){
		a = null;
	}
	
	@Bench
	public void nonRecursiveSort(){
		NonRecursiveSelectionSort.sort(a);
	}
	
	@Bench
	public void recursiveSort(){
		SelectionSort.sort(a);
	}
	
}
