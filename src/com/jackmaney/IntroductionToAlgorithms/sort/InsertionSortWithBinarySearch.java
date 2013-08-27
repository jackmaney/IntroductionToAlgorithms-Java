package com.jackmaney.IntroductionToAlgorithms.sort;

import java.util.AbstractList;

public class InsertionSortWithBinarySearch {

	public static <T extends Comparable<T>> void sort(AbstractList<T> list){
		
		for(int j = 1; j < list.size(); j++){
			
			T key = list.get(j);
			
			int insertionIndex = getInsertionIndex(list,key,0,j-1);
			
			/*
			 * insertionIndex == -1 precisely when we need to keep 
			 * the jth element right where it is (ie it should already be
			 * at the end of the first j+1 elements).
			 */
			if(insertionIndex >= 0){
				
				for(int i = j-1; i >= insertionIndex; i--){
					list.set(i+1,list.get(i));
				}
				
				list.set(insertionIndex, key);
			}
		}
	}
	
	public static <T extends Comparable<T>> int getInsertionIndex(AbstractList<T> list,
			T key,int begin,int end){
		
		if(end < begin || end >= list.size() || begin < 0){
			throw new IllegalArgumentException();
		}
		
		int result = -1;
		
		/*
		 * We only need to do a binary search if key needs to be inserted between
		 * the indices of begin and end.
		 */
		if(key.compareTo(list.get(end)) < 0){
			
			if(end == begin){
				if(begin == 0 && key.compareTo(list.get(0)) >= 0){
					result = -1;
				}
				else{
					result = begin;
				}
			}
			else{
				int middle = (end + begin) / 2;
				
				int compareMiddle = key.compareTo(list.get(middle));
				int compareOnePastMiddle = key.compareTo(list.get(middle + 1));
				
				if(compareMiddle >= 0 && compareOnePastMiddle < 0){
					result = middle + 1;
				}
				else if(compareMiddle < 0){
					
					/*
					 * Normally, we'd want to search the interval [begin, middle - 1]
					 * 
					 * However, we have two edge cases:
					 * 
					 * If begin + 1 == end, then middle == begin, and we want to search
					 * the interval [begin,middle] (ie [begin,begin]), since middle - 1 < begin.
					 * 
					 * If begin + 2 == end (and, consequently, middle == begin + 1), 
					 * then we want to search the interval [begin,middle], since there's 
					 * a possibility that we want to insert our key between begin and middle.
					 *
					 */
					
					int lastIndex = middle - 1;
					
					if(begin + 2 >= end){
						lastIndex++;
					}
					
					result = getInsertionIndex(list, key, begin, lastIndex);
					
				}
				else if(compareOnePastMiddle >= 0){
					result = getInsertionIndex(list, key, middle + 1, end);
				}
				
			}
			
		}
		
		return result;
	}
}
