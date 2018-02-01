package com.bridgelabz.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;



public class Utility {
	
	/**
	 * @param Accept two String and check it is permute or not
	 */
	public static boolean permutations(String str1,String str2){
			 boolean flag = true;
			char ch1[] = str1.replaceAll("\\s","").toCharArray();
			char ch2[] = str2.replaceAll("\\s","").toCharArray();
			 Arrays.sort(ch1);
			 Arrays.sort(ch2);
			 int l1 = ch1.length;
			 int l2 = ch2.length;
			 if(l1!=l2) {
				 System.out.println("Length diff so String are not anagram..");
			 }
			 else {
				
				 for(int i=0;i<l1;i++) {
					 if(ch1[i]==ch2[i]) {
						 flag = true;
					 }
					 else {
						 flag=false;
						 break;
					 }
				 }
				 
			 }
			return flag;
		}
/**
 * To search a int num present in arr[] using binary search.
 */
public static void binarySearchInt() {
		
		Scanner sc = new Scanner(System.in);
			System.out.println("binarySearchInt :");
			System.out.println("Enter size of arr");
			int size = sc.nextInt();
			int arr[] = new int[size];
			System.out.println("Enter Integer elements");
			for(int i=0;i<size;i++) {
				arr[i] = sc.nextInt(); 
			}
			System.out.println("Enter a num to search");
			int num = sc.nextInt();
			int length = arr.length;
			int low =0;
			int high = length -1;
			int mid;
			if(low+high%2==0) {
				mid= (low+high)/2;
			}else {
				mid = ((low+high)/2)+1;
			}
			while(low<=high) {
					
					if(num==arr[mid]) {
						System.out.println(arr[mid]+" is found at position "+mid);
						break;
					}
					else if(num<arr[mid]) {
						high = mid -1;
						mid = (low+high)/2;
					}
					else if(num>arr[mid]){
						low = mid +1;
						mid = (low+high)/2;
					}
					else {
						System.out.println(num+" is not present");
						break;
					}
					
			}
		
	}


/**
 *  To search a string present in arr[] using binary search.
 */
public static void binarySearchStr() {
	Scanner sc =new Scanner(System.in);
	System.out.println("Enter a size");
	int size =sc.nextInt();
	String str[]= new String[size];
	System.out.println("Enter a String..");
	for(int i=0;i<size;i++) {
		str[i] = sc.next();
	}
	
	Arrays.sort(str);
	System.out.println("Enter a char");
	String key = sc.next();
	
	int low = 0;
	int high = size-1;
	int mid = (low+high)/2;
	
	while(low<=high) {
		
		if(str[mid].compareTo(key)==0) {
			
			System.out.println(str[mid]+" Char is found at position "+mid);
			break;
		}
		else if(str[mid].compareTo(key)<0) {
		
			low = mid+1;

			mid = (low+high)/2;
		}
		else if(str[mid].compareTo(key)>0) {
			
			high = mid-1;

			mid = (low+high)/2; 
		}
		else {
			System.out.println("Element not found");
			break;
		}
	}		
}
/**
 * to sort int arr[] using insertion sort.
 */
public static void insertionSortInt() {
	Scanner sc = new Scanner(System.in);
	System.out.println(" ");
	System.out.println("insertionSortInt :");
	System.out.println("Enter size of arr");
	int size = sc.nextInt();
	int arr[] = new int[size];
	System.out.println("Enter a arr..");
	
	for(int i=0;i<size;i++) {
	arr[i] = sc.nextInt();
	}
	
	for(int j=1;j<size;j++) {
		
		int key = arr[j];
		int i = j-1;
		
		while((i>-1)&&(arr[i]>key)){
			
			 arr[i+1] = arr[i];
			 i--;
		}
		
		 arr[i+1]=key;
	}
	 
	 for(int i=0;i<size;i++ ){
		 System.out.print(" "+arr[i]);
	 }
}
/**
 * To sort string[] using insertion sort.
 */
public static void insertionSortStr() {
	Scanner sc = new Scanner(System.in);
	System.out.println("insertionSortStr :");
	System.out.println("Enter String");
	String str = sc.nextLine();
	int length = str.length();
	char ch[] = new char[length];
	
	for(int i=0;i<length;i++) {
		ch[i]=str.charAt(i);
	}
	
	for(int j=1;j<length;j++) {
		char key = ch[j];
		int i = j-1;
		
		while((i>-1)&&(ch[i]>key)) {
			
				ch[i+1] = ch[i];
				i--;
		}	
		ch[i+1] = key;
	}
	
	for(int i=0;i<length;i++) {
		System.out.print(" "+ch[i]);
	}
}
/**
 * To sort int arr[] using bubble sort.
 */
public static void bubbleSortInt() {
	Scanner sc = new Scanner(System.in);
	System.out.println("bubbleSortInt :");
	System.out.println("Enter size of array");
	int size  = sc.nextInt();
	int arr[] = new int[size];
	System.out.println("Enter arr elements");
	
	for(int i=0;i<size;i++) {
		arr[i]=sc.nextInt();
	}
	
	for(int i=0;i<size-1;i++) {
		
		boolean flag= false;
		
		for(int j=0;j<size-1;j++) {
			if(arr[j]>arr[j+1]) {
				int temp = arr[j];
				arr[j] = arr[j+1];
				arr[j+1] = temp;
				flag = true;
			}
		}
		
	}
	
	for(int i=0;i<size;i++) {
		System.out.print(" "+arr[i]);
	}
}

/**
 * To sort String[] using bubble sort.
 */
public static void bubbleSortStr() {
	Scanner sc = new Scanner(System.in);
	System.out.println("bubbleSortStr :");
	System.out.println("Enter a string");
	String str = sc.nextLine();
	int length = str.length();
	char ch[] = new char[length];
	
	for(int i=0;i<length;i++) {
		ch[i]=str.charAt(i);
	}
	
	for(int i=0;i<length-1;i++) {
		
	
		
		for(int j=0;j<length-1;j++) {
			if(ch[j]>ch[j+1]) {
				char temp = ch[j];
				ch[j] = ch[j+1];
				ch[j+1]=temp;
				
			}
		}
		
	}
	
	for(int i=0;i<length;i++) {
		System.out.print(ch[i]);
	}
}
/**
 * To check num palindrom or not in 1 -1000.
 */
public static void numPalindrom() {
	System.out.println("Prime num which are Palindrom between 1 to 1000 :");

	for(int i=1;i<=1000;i++) {
		int count=0;
			for(int j=1;j<=i;j++) {
				if(i%j==0) {
					count++;
					
				}
			}
			if(count==2) {
				
				int num =i;
				int rev=0;
				int sum=0;
				while(num>0) {
					rev = num%10;
					sum=(sum*10)+rev;
					num=num/10;
				}
				if(sum==i) {
					
					System.out.println(i);
				}
			}
			
			
	}
	
}
/**
 *To find word is present in the list or not.
 */
public static boolean findWord(String str,String key) {

	String strArray[] = str.toLowerCase().split(" ");
	
	Arrays.sort(strArray);
	int length = strArray.length;
	int low =0;
	int high =length-1;
	int mid = (low+high)/2;
	boolean flag = false;
	while(low<=high) {

		if(strArray[mid].compareTo(key)==0) {
			
			flag=true;
			break;
		}
		else if(strArray[mid].compareTo(key)<0) {
			low = mid+1;
			mid =(low+high)/2;
		}
		else if(strArray[mid].compareTo(key)>0) {
			high = mid-1;
			mid = (low+high)/2;
		}
		else {
			flag=false;
		}
	}
	return flag;
}
/**
 * @param left = left sorted arr
 * @param right = right sorted arr
 * @return To merge the two array by comparing each element and sort. 
 */
public static String[] mergeArray(String[] left, String[] right) {
	String[] mergeArr = new String[left.length + right.length];
	int leftIndex = 0;
	int rightIndex = 0;
	int midIndex = 0;
	int num = 0;
	while (leftIndex < left.length || rightIndex < right.length) {

		if (leftIndex == left.length) {
			mergeArr[midIndex++] = right[rightIndex++];
		} else if (rightIndex == right.length) {
			mergeArr[midIndex++] = left[leftIndex++];
		} else {
			num = left[leftIndex].compareToIgnoreCase(right[rightIndex]);
			if (num < 0) {
				mergeArr[midIndex++] = left[leftIndex++];
			} else if (num > 0) {
				mergeArr[midIndex++] = right[rightIndex++];
			} else {
				mergeArr[midIndex++] = left[leftIndex++];
			}
		}
	}
	return mergeArr;
}
/**
 * @author To calculate monthly Payment by passing loan,year and interest to Satndard formula. 
 *
 */
public static double mothlyPayment(double P,double Y,double R) {
	double n = 12*Y;
	double r = R/(12*100);
	double cal = Math.pow((1+r),(-n));
	double payment = (P*r)/(1-cal);
	return payment;
}

}
