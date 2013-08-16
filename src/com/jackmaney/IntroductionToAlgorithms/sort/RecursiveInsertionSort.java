package com.jackmaney.IntroductionToAlgorithms.sort;

import java.util.AbstractList;

public class RecursiveInsertionSort {
	
	public static <T extends Comparable<T>> void sort(AbstractList<T> list, int index){
		if(index < 0 || index >= list.size()){
			throw new IllegalArgumentException();
		}
		
		if(index > 0){
			sort(list, index - 1);
			insert(list,index);
		}
		
	}
	
	public static <T extends Comparable<T>> void sort(AbstractList<T> list){
		sort(list,list.size() - 1);
	}
	
	public static <T extends Comparable<T>> void insert(AbstractList<T> list, int index){
		
		if(index < 0 || index >= list.size()){
			throw new IllegalArgumentException();
		}
		
		if(index > 0){
			T elementToInsert = list.get(index);
			
			for(int i = index - 1; i >= 0; i--){
				
				if(elementToInsert.compareTo(list.get(i)) <= 0){
					list.set(i+1,list.get(i));
					
					if(i == 0){
						list.set(0,elementToInsert);
					}
				}
				else{
					list.set(i+1,elementToInsert);
					break;
				}
			}
		}

	}
	
}
