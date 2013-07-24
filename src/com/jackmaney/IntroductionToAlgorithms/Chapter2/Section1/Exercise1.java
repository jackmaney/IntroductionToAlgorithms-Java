package com.jackmaney.IntroductionToAlgorithms.Chapter2.Section1;

import java.util.ArrayList;
import java.util.Arrays;

import com.jackmaney.IntroductionToAlgorithms.sort.InsertionSort;

public class Exercise1 {

	public static void main(String[] args) {
		
		Integer[] arr = {31,41,59,26,41,58};
		ArrayList<Integer> arrList = new ArrayList<Integer>(Arrays.asList(arr));
		
		InsertionSort.printInsertionSortDiagram(arrList);

	}

}

/*Output:

31 -> 41 -> 59 -> 26 41 58
|_________________|

26 31 41 59 -> 41 58
         |_____|

26 31 41 41 59 -> 58
            |_____|

26 31 41 41 58 59

*/

