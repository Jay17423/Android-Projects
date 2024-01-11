package com.example.lib;

import java.util.Scanner;
public class sumOf {
    public static void main(String[] args){
        Scanner s1 = new Scanner(System.in);

        System.out.println("Enter your first number:");
        int n1=s1.nextInt();

        System.out.println("Enter your second number:");
        int n2=s1.nextInt();

        float d=n1/n2;
        float r=n1%n2;
        System.out.println("The division is :"+d);
        System.out.println("The remainder is :"+r);




    }
}
