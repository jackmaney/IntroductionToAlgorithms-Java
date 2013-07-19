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
	
	private <T> String join(AbstractList<T> list,String delimiter){
		
		String result = null;
		
		if(!list.isEmpty()){
			StringBuilder sb = new StringBuilder();
			sb.append(list.get(0).toString());
			
			for(int i = 1; i < list.size(); i++){
				sb.append(delimiter).append(list.get(i).toString());
			}
			
			result = sb.toString();
		}
		
		return result;
	}
	
	private <T> String join(AbstractList<T> list){
		return join(list," ");
	}
	
	public static <T extends Comparable<T>>  
		boolean applyNextMove(AbstractList<T> list,ArrayList<Integer> moves){
		
		/*
		 * We traverse from right to left, looking for the first (and only)
		 * negative entry of moves, call it -m at index i. Then, we temporarily store
		 * the element at index i, shuffle the elements from index i-m to i-1 
		 * to the right one, and then put the stored element at index i-m.
		 */
		for(int i = moves.size() - 1; i >= 0; i--){
			
			if(moves.get(i) < 0){
				T element = list.get(i);
				for(int j = i - 1; j >= i + moves.get(i); j--){
					list.set(j+1,list.get(j));
				}
				
				list.set(i + moves.get(i), element);
				return true;
			}
		}
		
		return false;
	}
	
	public static <T extends Comparable<T>>  
		boolean applyNextMove(AbstractList<T> list){
		
		ArrayList<Integer> moves = getMoves(list);
		
		return applyNextMove(list,moves);
	}
	
	
	
	
	
	public static <T extends Comparable<T>> 
		void printInsertionSortDiagram(AbstractList<T> list){
		
		while(true){
			
			ArrayList<Integer> moves = getMoves(list);
			
			int indexToMove = -1;
			int amountToMoveLeft = 1;
			
			
			
			for(int i = 0; i < moves.size(); i++){
				
				if(moves.get(i) < 0){
					indexToMove = i;
					amountToMoveLeft = moves.get(i);
					break;
				}
			}
			
			if(indexToMove < 0){
				break;
			}
			
			int firstIndexForPipe = -1;
			int lastIndexForPipe = -1;
			int indexCounter = 0;
			
			System.out.print(list.get(0));
			if(moves.get(0) > 0){
				firstIndexForPipe = 0;
				indexCounter = list.get(0).toString().length();
			}
			
			for(int i = 1; i < moves.size(); i++){
				
				if(moves.get(i-1) > 0){
					System.out.print(" -> ");
					indexCounter += 4;
				}
				else{
					System.out.print(" ");
					indexCounter++;
				}
				
				
				if(moves.get(i) > 0){
					if(firstIndexForPipe < 0){
						firstIndexForPipe = indexCounter + 1;
					}
				}
				else if(moves.get(i) < 0){
					lastIndexForPipe = indexCounter + 1;
				}
				
				System.out.print(list.get(i));
				indexCounter += list.get(i).toString().length();
			}
			
			System.out.println();
			
			for(int i = 0; i < firstIndexForPipe; i++){
				System.out.print(" ");
			}
			
			System.out.print("|");
			
			for(int i = firstIndexForPipe + 1; i < lastIndexForPipe - 1; i++){
				System.out.print("_");
			}
			
			System.out.println("|");
			System.out.println();
			
			if(!InsertionSort.applyNextMove(list)){
				break;
			}
			
		}
		
	}
	
	/*
	 * 5 -> 2 4 6 1 3
	 * |___|
	 * 
	 * 2 -> 4 -> 5 -> 6 -> 1 3
	 * ^___________________V 
	 */

	
}
