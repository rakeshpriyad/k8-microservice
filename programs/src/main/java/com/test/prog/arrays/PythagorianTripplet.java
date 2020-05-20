package com.test.prog.arrays;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Given an array of integers, write a function that returns true if there is a triplet (a, b, c) that satisfies a2 + b2 = c2.
 */
public class PythagorianTripplet {
	public static void main(String[] args) {
		int[] ar=new int[]{3,2,4,6,5};
		boolean isPythogorian =isPytogorianTrippletJ8(ar);
		System.out.println("Given Array is Pythogrian ="+isPythogorian);
	}
	static boolean isPytogorianTripplet(int arr[]){
		boolean isPythogorian=false;
		for(int i=0;i<arr.length;i++){
			arr[i]=arr[i]*arr[i];
		}
		Arrays.sort(arr);
		
		for(int i=0;i<arr.length-2;i++){
			if(arr[i+2]==arr[i]+arr[i+1]){
				isPythogorian=true;
			}
		}
		return isPythogorian;
	}

	static boolean isPytogorianTrippletJ8(int arr[]){
		IntStream is =Arrays.stream(arr);
		List<Integer> sortedS= is.map(data-> data*data).sorted().boxed().collect(Collectors.toList());
		return IntStream
				.range(0, sortedS.size()-2)
				.mapToObj(i -> sortedS.get(i+2)==sortedS.get(i)+sortedS.get(i+1)? sortedS.get(i+2):null).
				filter(x-> x!=null).count() >0? true:false;
	}
}
