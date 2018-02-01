package com.bridgelabz.programs;

import java.util.Scanner;

import com.bridgelabz.util.Utility;

public class Permutation
{
    public static void main(String[] args)
    {
        String str = "ABC";
        int n = str.length();
        Permutation permutation = new Permutation();
        Utility.permute(str, 0, n-1);
    }
    
    
    
}
