package com.bitwise.operators;

public class Test {
	public static int get(int r)
	{
	  //   return (x && !(x & (x - 1)));
		int a = 20, b = 2, c = 3, d = 1;
		System.out.println( a>>b&c+d ) ;
		return 1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long x =  1L<<31;
		System.out.println(Integer.toBinaryString(10));
		System.out.println(Integer.toBinaryString(-11));
		System.out.println(Integer.toBinaryString(~10));
		System.out.println(Integer.toBinaryString(~8));
		int pos=(int) Math.floor((Math.log(1&-1)/Math.log(2))+1);
		System.out.println("pos "+pos);
		System.out.println(Integer.toBinaryString(7777));
		System.out.println(Long.toBinaryString(Long.MAX_VALUE));
//System.out.println(Math.log10((15&-15)/Math.log(2))+1);
		
		System.out.println(20|((1<<4)-1));
		System.out.println(Integer.toBinaryString(100));
		System.out.println(Integer.toBinaryString(36));
		System.out.println(Integer.toBinaryString(64));
		System.out.println(Integer.toBinaryString(96));
		System.out.println(Integer.toBinaryString(4));
		System.out.println(36^64);
		System.out.println(2^2^1);
//get(1);
//Math.log1p(x)
	}

}
