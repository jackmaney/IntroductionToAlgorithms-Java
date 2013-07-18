package com.jackmaney.IntroductionToAlgorithms.sort;

import java.util.AbstractList;
import java.util.ArrayList;

public class InsertionSort{
	
	//TODO: Figure out what the <T> is doing down there between static and void.
	//I figured out to do this by looking at the source of Collections.sort(),
	//but I haven't seen that before...
	//I just bought an electronic copy of Java Generics and Collections, which 
	//should shed some light on things.
	public static <T extends Comparable<T>> void sort(AbstractList<T> list){
		
		
		for(int j = 1; j < list.size(); j++){
			
			T key = list.get(j);
			
			int i = j - 1;
			while(i >= 0 && list.get(i).compareTo(key)>0){
				list.set(i+1,list.get(i));
				i--;
			}
			list.set(i+1,key);
		}
		
	}
	
	//The median of the n numbers 0,1,2,...,n-1 is (n-1)/2.
	private float medianIndex(int n){
		 
		return (float)(n-1) / 2;
	}
	
	//Each element returned is a 1 for "moves right", 
	//-n for "moves left n times" (n > 0, of course), and 0 for staying put
	public static <T extends Comparable<T>>  
		ArrayList<Integer> getMoves(AbstractList<T> list){
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++){
			result.add(0);
		}
		
		for(int j = 1; j < list.size(); j++){
			
			/*if the j^th element is less than the (j-1)^st element,
			 * then we start moving left, decrementing the j^th element
			 * of result and incrementing the positions to the left of result
			 * one by one until we figure out where the j^th element belongs.
			 */
			if(list.get(j).compareTo(list.get(j-1)) < 0){
				int i = j-1;
				while(i >= 0 && list.get(i).compareTo(list.get(j)) > 0){
					result.set(j,result.get(j) - 1);
					result.set(i,1);
					i--;
				}
				//We're only looking for moves of one iteration of the sort loop
				break;
			}
		}
		
		
		return result;
	}
	
	public static <T extends Comparable<T>> 
		void printInsertionSortDiagram(AbstractList<T> list){
		
		
		
		
	}
	
	/*
	 * 5 -> 2 4 6 1 3
	 * |___|
	 * 
	 * 2 -> 4 -> 5 -> 6 -> 1 3
	 * ^___________________V 
	 */

	
}
