package com.jackmaney.IntroductionToAlgorithms.sort;

import java.util.AbstractList;

public class ReverseInsertionSort {

public static <T extends Comparable<T>> void sort(AbstractList<T> list){
	
		for(int j = 1; j < list.size(); j++){
			
			T key = list.get(j);
			
			int i = j - 1;
			while(i >= 0 && list.get(i).compareTo(key)<0){
				list.set(i+1,list.get(i));
				i--;
			}
			list.set(i+1,key);
		}
		
	}
	
}
