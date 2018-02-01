package com.bridgelabz.programs;

import java.util.*;

import com.bridgelabz.util.Utility;

public class MergeSort {

	public static void main(String args[]) {
		String[] list = { "harshal", "rahul", "shubham", "kalpesh", "nikhil", "amol" };
		String[] sortedArr = mergeSort(list);
		for (int i = 0; i < sortedArr.length; i++) {
			System.out.print(sortedArr[i] + " ");
		}
	}

	/**
	 * @param To devide whole arr[] in two parts until arr[] length!=1.
	 * @return and return the devided arr.
	 */
	public static String[] mergeSort(String[] list) {
		String[] sortedList = new String[list.length];

		if (list.length == 1) {
			sortedList = list;
			return sortedList;
		}

		int mid = list.length / 2;
		String[] left = null;
		String[] right = null;
		if ((list.length % 2) == 0) {
			left = new String[list.length / 2];
			right = new String[list.length / 2];
		} else {
			left = new String[list.length / 2];
			right = new String[(list.length / 2) + 1];
		}
		int i = 0;
		int j = 0;
		for (; i < mid; i++) {
			left[i] = list[i];
		}
		for (; i < list.length; i++) {
			right[j++] = list[i];
		}
		left = mergeSort(left);
		right = mergeSort(right);

		sortedList = Utility.mergeArray(left, right);

		return sortedList;
	}

	
}
