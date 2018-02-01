package com.bridgelabz.util;

public class Utility {

	/**To acept a char[] and sort a char[] using third variable
	 * @param ab
	 */
	public static void sortAnagram(char []ab) {
		
		 for (int i = 0; i < ab.length; i++) {
	            for (int j = i + 1; j < ab.length; j++) {
	                if (ab[i] > ab[j]) {
	                    char temp = ab[i];
	                    ab[i] = ab[j];
	                    ab[j] = temp;
	                }
	            }
	        }		
	}
	/**
	 * To compare sorted str1 with str2 by each element if both are equal then return true
	 * otherwise return false.
	 * @return
	 */
	public static boolean isAnagram(String str1,String str2) {
		 
		if (str1.length() != str2.length()) {
	            return false;
	        }
	        char[] a = str1.toCharArray();
	       Utility.sortAnagram(a);
	        char[] b = str2.toCharArray();
	        Utility.sortAnagram(b);
	        for (int i = 0; i < a.length; i++) {
	            if (a[i] != b[i]) {
	                return false;
	            }
	        }
	        return true;
		
	}
	
}
