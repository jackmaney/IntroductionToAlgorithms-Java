package com.jackmaney.IntroductionToAlgorithms.Chapter2.Section2;

import java.util.AbstractList;
import java.util.ArrayList;

public class SelectionSort {

	public static <T extends Comparable<T>> void sort(AbstractList<T> list){
		
		if(list.size() > 1){
			
			T min = list.get(0);
			int minIndex = 0;
			
			for(int i = 1; i < list.size(); i++){
				
				if(list.get(i).compareTo(min) < 0){
					min = list.get(i);
					minIndex = i;
				}
			}
			
			if(minIndex > 0){
				T temp = list.get(0);
				list.set(0,min);
				list.set(minIndex,temp);
			}
			
			ArrayList<T> restOfList = new ArrayList<>();
			
			for(int i = 1; i < list.size(); i++){
				restOfList.add(list.get(i));
			}
			
			sort(restOfList);
			
			for(int i = 1; i < list.size(); i++){
				list.set(i,restOfList.get(i - 1));
			}
			
		}

	}
	
}
