package com.jackmaney.IntroductionToAlgorithms.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import com.jackmaney.IntroductionToAlgorithms.sort.MergeSort;

public class SumSearch {

	public static Set<Integer> search(Set<Integer> set,int x){
		
		if(set.isEmpty()){
			throw new IllegalArgumentException();
		}
		
		ArrayList<Integer> list = new ArrayList<>();
		list.addAll(set);
		Set<Integer> result = null;
		
		MergeSort.sort(list);
		
		for(int i = 0; i < list.size(); i++){
			
			int y = list.get(i);
			int index = BinarySearch.search(list, new Integer(x - y));
			
			if(index >= 0 && index != i){
				result = new HashSet<Integer>();
				result.add(y);
				result.add(list.get(index));
				break;
			}
			
		}
		
		return result;
	}
	
}
