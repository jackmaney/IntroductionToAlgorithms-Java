package com.jackmaney.IntroductionToAlgorithms.search;

import java.util.AbstractList;

public class BinarySearch {
	
	public static <T extends Comparable<T>> int search(AbstractList<T> list,T element){
		return search(list,element,0,list.size() - 1);
	}
	
	public static <T extends Comparable<T>> int search(AbstractList<T> list
			,T element,int begin,int end){
		
		if(begin > end || begin < 0 || end >= list.size()){
			throw new IllegalArgumentException();
		}
		
		int result = -1;
		
		if(begin == end){
			result = list.get(begin).equals(element) ? begin : -1;
		}
		else{
			int middle = (begin + end) / 2;
			
			int comparison = list.get(middle).compareTo(element);
			
			if(comparison == 0){
				result = middle;
			}
			else if(comparison < 0){ //element is on the right (if it exists)
				result = search(list,element,middle + 1,end);
			}
			else{ //element is on the left (if it exists)
				
				/*
				 * We use upperIndex to avoid the edge case of when
				 * our beginning and ending indices are adjacent.
				 * In such a case, middle == begin, so we can't go
				 * from begin to middle - 1 == begin - 1.
				 */
				int upperIndex = begin + 1 == end ? begin : middle - 1;
				
				result = search(list,element,begin,upperIndex);
			}
		}
		
		return result;
	}
	
}
