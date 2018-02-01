package com.bridgelabz.programs;
import java.util.Scanner;

/**
 * To calculate time require to create object by using System.nanoTime function
 * @author bridgeit
 *
 */
public class StopWatch{

	public static void main(String []args) {
		
		Scanner sc = new Scanner(System.in);
		
		//Using System.nanoTime();
	
		long Starttime = System.nanoTime();
		
		for(int i=0;i<1000000;i++) {
			
			Object obj = new Object();
		}
		
		 long Endtime = System.nanoTime();
		long elapsedTime = Endtime - Starttime; 
		
		
		System.out.println("Time require to create All obj in millis: "+elapsedTime);
		System.out.println("Time require to create each obj in millis: "+elapsedTime/1000000);
			
		//Using StopWatch
		
		
		 /*StopWatch watch = new StopWatch(); /It's related to springframework so not working
		  
	        watch.start();
	        for(int i=0; i< 1000000; i++){
	            Object obj = new Object();
	        }
	        watch.stop();
	        System.out.println("Total execution time to create 1000K objects in Java using StopWatch in millis: "
	                + watch.getTotalTimeMillis());
	    }*/

	}
}
