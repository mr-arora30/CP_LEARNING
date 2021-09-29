package com.leetcode.recurssion.InpOut;

import java.util.HashSet;

public class UniqueSubsets {
    static HashSet<String> set = new HashSet();

    public static void main(String args[]) {
        uniqueSubstes("aabc", "");
        System.out.println(set);
    }

    public static void uniqueSubstes(String in, String out) {
        if (in.length() == 0) {
            set.add(out);
            //  System.out.println(out);
            return;
        }
        String op1 = out;
        String op2 = out;
        op2 = out + in.charAt(0);

        in = in.substring(1);

        uniqueSubstes(in, op1);
        uniqueSubstes(in, op2);
        return;

    }
}
