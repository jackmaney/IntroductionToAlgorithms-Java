package com.jackmaney.IntroductionToAlgorithms.Chapter2.EndOfChapter;

import java.util.AbstractList;
import java.util.ArrayList;

import com.jackmaney.IntroductionToAlgorithms.sort.InsertionSort;
import com.jackmaney.IntroductionToAlgorithms.sort.MergeSort;

public class InsertionWithMergeSort {
	
	public static <T extends Comparable<T>> void sort(AbstractList<T> list, int k){
		
		int n = list.size();
		
		if(n == 0 || k <= 0 || k > n || n % k != 0){
			throw new IllegalArgumentException();
		}
		
		int quotient = n / k;
		
		/*
		 * Do insertion sort on the following:
		 *   * Elements at indices 0--(k-1)
		 *   * Elements at indices k--(2 * k - 1)
		 *   .
		 *   .
		 *   .
		 *   * Elements at indices ((quotient - 1) * k - 1)--(quotient * k - 1)
		 */
		
		/*
		 * For the merge method below, we will also keep track of the beginning
		 * index of each sublist.
		 */
		ArrayList<Integer> mergeIndices = new ArrayList<Integer>();
		
		for(int i = 0; i < quotient; i++){
			InsertionSort.sort(list, i * k, (i + 1) * k);
			
			mergeIndices.add(i * k);
		}
		
		
		merge(list,mergeIndices);
		
	}
	
	public static <T extends Comparable<T>> void merge(AbstractList<T> list, ArrayList<Integer> mergeIndices){
		
		// If we only have two or three sublists, merge them and get it over with.
		if(mergeIndices.size() == 2 || mergeIndices.size() == 3){
			MergeSort.merge(list,0,mergeIndices.get(1) - 1,list.size() - 1);
		}
		else if(mergeIndices.size() > 1){
			
			/*
			 * If there are an odd number of lists, we'll lump the last two lists together
			 * by removing the last merge index.
			 */
			
			if(mergeIndices.size() % 2 == 1){
				mergeIndices.remove(mergeIndices.size() - 1);
			}
			
			/*
			 * Keep track of merge indices for the next recursive step.
			 */
			ArrayList<Integer> newMergeIndices = new ArrayList<>();
			
			// We're now guaranteed an even number of merge indices, so we'll go through them, two by two.
			for(int i = 0; i <= mergeIndices.size() - 2; i += 2){
				
				int beginFirst = mergeIndices.get(i);
				
				int beginSecond = mergeIndices.get(i + 1);
				
				int endSecond = i < mergeIndices.size() - 3 ? mergeIndices.get(i + 2) - 1 : list.size() - 1;
				
				MergeSort.merge(list, beginFirst, beginSecond - 1, endSecond);
				
				newMergeIndices.add(beginFirst);
			}
			
			/*
			 * Now, to recurse, we go through the same method with the same list,
			 * but with the new merge indices.
			 */
			
			merge(list, newMergeIndices);
		}
		
		
	}
}
