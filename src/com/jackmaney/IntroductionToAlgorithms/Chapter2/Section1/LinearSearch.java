package com.jackmaney.IntroductionToAlgorithms.Chapter2.Section1;

import java.util.AbstractList;

public class LinearSearch {
	
	public static <T extends Number> Integer search(AbstractList<T> list,T v){
		
		Integer result = null; 
		
		for(int i = 0; i < list.size(); i++){
			if(list.get(i).equals(v)){
				result = new Integer(i);
				break;
			}
		}
		
		return result;
	}
	
}
