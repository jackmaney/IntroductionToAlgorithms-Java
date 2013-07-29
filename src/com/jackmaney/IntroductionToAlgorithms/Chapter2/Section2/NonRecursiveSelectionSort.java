package com.jackmaney.IntroductionToAlgorithms.Chapter2.Section2;

import java.util.AbstractList;
import java.util.ArrayList;

public class NonRecursiveSelectionSort {

	public static <T extends Comparable<T>> void sort(AbstractList<T> list){
		
		for(int i = 0; i < list.size() - 1; i++){
			
			T temp = list.get(i);
			int index = smallestIndex(list,i+1);
			T smallest = list.get(index);
			list.set(i, smallest);
			list.set(index, temp);
		}
		
	}
	
	/**
	 * Returns the index of the <code>k</code>th smallest value of <code>list</code>
	 * (taking the first such index if multiple minima exist).
	 * 
	 * @param list
	 * @param k
	 */
	public static <T extends Comparable<T>> int smallestIndex(AbstractList<T> list,int k){
		
		if(k < 0 || k >= list.size()){
			throw new IllegalArgumentException();
		}
		
		/*
		 * Well, the sane solution would be to sort, but since
		 * we're implementing a sort algorithm, that would be cheating...
		 * 
		 * So, what we'll have to do is first find the minimum, then 
		 * search over every element except the minimum to find the 
		 * second smallest element, etc...
		 * 
		 * Rather than removing elements from <code>list</code>, we'll
		 * keep track of indices over which we can iterate.
		 * 
		 */
		
		ArrayList<Integer> allowedIndices = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++){
			allowedIndices.add(i);
		}
		
		int result = -1;
		
		for(int i = 0; i < k; i++){

			
			T min = null;

			
			for (Integer j : allowedIndices) {
				
				if(min == null){
					min = list.get(j);
				}
				else if(min.compareTo(list.get(j)) > 0){
					min = list.get(j);
				}
				
			}
			
			result = list.indexOf(min);
			
			/*
			 * Tricky, tricky! When testing this with T = Integer, I kept
			 * getting weird, unexpected results, because remove() couldn't
			 * tell if I wanted to remove the Integer result or the index
			 * represented by the integer result.
			 */
			allowedIndices.remove(new Integer(result));

		}
		
		return result;
	}
		
}
