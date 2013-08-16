package com.jackmaney.IntroductionToAlgorithms.sort;

import java.util.AbstractList;
import java.util.ArrayList;



public class MergeSort {

	/*
	 * Note that this implementation already ignores the book's notion of "sentinels", 
	 * thus exercise 2.3-2 is already complete.
	 */
	
	public static <T extends Comparable<T>> void sort(AbstractList<T> list,int p, int r){
		if(p < r){
			int q = (int)Math.floor( ( (double)p + (double)r )/2);
			sort(list,p,q);
			sort(list,q+1,r);
			merge(list,p,q,r);
		}
	}
	
	public static <T extends Comparable<T>> void sort(AbstractList<T> list){
		sort(list,0,list.size() - 1);
	}
	
	public static <T extends Comparable<T>> void merge(AbstractList<T> list,int p, int q, int r){
		
		if(p > q || q >= r || r >= list.size() || p < 0){
			throw new IllegalArgumentException();
		}
		
		
		/*
		 * We want to replace merge elements between indices p and q (inclusive)
		 * to elements with indices q+1 to r (inclusive).
		 * 
		 */
		
		ArrayList<T> left = new ArrayList<>();
		ArrayList<T> right = new ArrayList<>();
		
		for(int i = 0; i <= q - p; i++){
			left.add(list.get(p + i));
		}
		
		for(int j = 1; j <= r - q; j++){
			right.add(list.get(q+j));
		}

		
		for(int k = p; k <= r; k++){
			
			T element = null;
			
			if(left.isEmpty() && right.isEmpty()){
				throw new ArrayIndexOutOfBoundsException();
			}
			else if(left.isEmpty()){
				element = right.remove(0);
			}
			else if(right.isEmpty()){
				element = left.remove(0);
			}
			else if(left.get(0).compareTo(right.get(0)) <= 0){
				element = left.remove(0);
			}
			else
			{
				element = right.remove(0);
			}
			
			list.set(k,element);
		}
		
	}
	
}
