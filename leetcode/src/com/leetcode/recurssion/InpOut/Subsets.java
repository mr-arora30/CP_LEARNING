package com.leetcode.recurssion.InpOut;

public class Subsets {

    public static void main(String args[]) {
        subsets("123", "");
    }

    static String subsets(String in, String op) {

        if (in.length() == 0) {
           // System.out.println(op);
            return op;
        }


        String op1 = op;
        String op2 = op;
        System.out.println(op2);
        op2 = op + in.charAt(0);

        in = in.substring(1);
       // System.out.println(in);
        subsets(in, op1);
        subsets(in, op2);
        return op;
    }
}