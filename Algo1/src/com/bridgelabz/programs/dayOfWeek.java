package com.bridgelabz.programs;

import java.util.*;
/**
 * @author Calculate day of the week by passing date,month and year to given formula.
 *
 */
public class dayOfWeek{

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		String str =null;
		boolean flag = true;
		
		while(flag){
		
			System.out.println("Enter Month :");
			int month = sc.nextInt();
			if(month<1 || month >12){
				System.out.println("Month are between 1 and 12");
				continue;
			}
				
			System.out.println("Enter Day :");
			int day = sc.nextInt();
			if(day<1 || day >31){
				System.out.println("Day are between 1 and 31");
				continue;
			}
			
			System.out.println("Enter year :");
			int year = sc.nextInt();
			if(year<1 || year>10000) {
				System.out.println("Year are between 1 and 10000");
				continue;
			}
			
			  	int y0 = year - (14 - month) / 12;
		        int x = y0 + y0/4 - y0/100 +y0/400;
		        int m0 = month + 12 * ((14 - month) / 12) - 2;
		        int d0 = (day + x + 31 * m0 / 12) % 7;  
		      
		      if(d0>=0 && d0<=6) {
		    	 
		    	 switch(d0) {
		    	 	
		    	 case 0:
		    		 	System.out.println("Day of the week is Sunday");
		    		 	break;
		    	 case 1:
		    		 	System.out.println("Day of the week is Monday");
		    	 		break;
		    	 case 2:
		    		 	System.out.println("Day of the week is Tuesday");
		    		 	break;
		    	 case 3:
		    		 	System.out.println("Day of the week is Wednesday");
	    		 	 	break;
		    	 case 4:
		    		 	System.out.println("Day of the week is Thursday");
		    		 	break;
		    	 case 5:
		    		 	System.out.println("Day of the week is Friday");
		    		 	break;
		    	 case 6:
		    		 	System.out.println("Day of the week is saturday");
		    		 	break;
		    	 default:
		    		 	System.out.println("Somthing Wrong...");
		    	 }
		     }
		}
	
		
	}
}
