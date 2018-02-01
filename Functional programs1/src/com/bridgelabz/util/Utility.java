package com.bridgelabz.util;

import java.util.Scanner;

public class Utility {
	
	/**
	 * To identify the 3 unique numbers in array which addition is zero
	 */
	public static void sumOfZero() {
		Scanner sc =new Scanner(System.in);
		int count =0;
		System.out.println("Enter a arr size :");
		int size = sc.nextInt();
		System.out.println("Enter a arr elements :");
		int arr[] = new int[size];
		
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		
		for(int i=0;i<size-2;i++) {
			for(int j=i+1;j<size-1;j++) {
				for(int k=j+1;k<size;k++) {
					
					if(arr[i]+arr[j]+arr[k]==0) {
						
						System.out.println("Triples :"+arr[i]+" "+arr[j]+" "+arr[k]);
						count++;
					}
				}
			}
		}
		System.out.println("Num of pair "+count);
	}
	/**
     * To fix the first position element and pass remaining string to the same function
     *
     */
    public static void permute(String str, int l, int r)
    {
        if (l == r) {
        	System.out.println("l==r :");
            System.out.println(str);
        }else
        {
            for (int i = l; i <= r; i++)
            {
            	System.out.println("Before swap :"+str);	
                str = Utility.swap(str,l,i);
                System.out.println("After swap :"+str);
                permute(str, l+1, r);
                
            }
        }
    }
    /**
     * @param To interchanging the position of i and j 
     * 
     */
    public static String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    
}
