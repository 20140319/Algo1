package com.s.algorithm1.w1;

import java.util.Arrays;
import java.util.Random;

public class MergeSort {
	
	Random random = new Random();
	
	public void doSort(int length) {
		
		int[] data = new int[length];
		for (int i=0; i<length; i++) {
			data[i] = random.nextInt(100);
		}
		for (int i=0;i<length;i++) {
			System.out.print(data[i] + " ");
		}
		
		System.out.println("");
		System.out.println("-------- result --------");
		int[] result = sort(data);
		
		for (int i=0;i<length;i++) {
			System.out.print(result[i] + " ");
		}
    }
	
	private int[] sort(int[] inputArray) {
		int size = inputArray.length;
		if (size == 1) return inputArray;
		
		int[] part1 = Arrays.copyOfRange(inputArray, 0, size/2);
		int[] part2 = Arrays.copyOfRange(inputArray,  size/2,  size);
	
		if (!isSorted(part1)) part1 = sort(part1);
		if (!isSorted(part2)) part2 = sort(part2);
	
		int[] mergeResult = new int[size];
		
		int p1 = 0;
		int p2 = 0;
		int p3 = 0;
		for (int i=0; i<size; i++) {
			if (p1 == part1.length) { 
				for (int k=p2;k<part2.length;k++) {
					mergeResult[p3] = part2[k];
					p3++;
				}
				break;
			}
			
			if (p2 == part2.length) {
				for (int k=p1;k<part1.length;k++) {
					mergeResult[p3] = part1[k];
					p3++;
				}
				break;
			}
			
			if (part1[p1] < part2[p2]) {
				mergeResult[p3] = part1[p1];
				p1++;
			} else {
				mergeResult[p3] = part2[p2];
				p2++;
			}
			
			p3++;
		}
	
		return mergeResult;
	}

	private boolean isSorted(int[] ay) {

		if (ay.length == 1) return true;
		
		for(int i=0; i<ay.length-1; i++) {
			if (ay[i] > ay[i+1]) return false; 
		}
	
		return true;
	}
}
