/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DigitalNumbers;

import java.util.Scanner;

/**
 *
 * @author rushalnew1
 */
public class DigitalNumbers {
    public static int convert_digit(int d){
        if(d == 1 || d == 3 || d == 4 || d == 5 || d == 7 || d == 9)
            return 9;
        return 8;
    }
    public static int reverse(int n){
        int m =0;
        while(n>0){
            int d =n%10;
            m =m*10 + d;
            n =n/10;
        }
        return m;
    }
    public static int maximise_digit(int n){
        int m =0;
        while(n>0){
            int d =n%10;
            m = m*10 + convert_digit(d);
            n =n/10;
        }
        return reverse(m);
    }
    public static void main(String[] args){
        System.out.print("Enter a Number in order to maximise it: ");
        Scanner sc= new Scanner(System.in);
        int n =sc.nextInt();
        int m =maximise_digit(n);
        System.out.println("Maximum Number:" + m);
    }
}
