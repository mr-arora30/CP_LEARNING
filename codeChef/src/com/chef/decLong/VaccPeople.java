package com.chef.decLong;
import java.util.*;

public class VaccPeople {

    public static void main(String args[]) {


        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        //int age[];
        double riskGroup=0;
        double comGroup=0;
        while(t-->0){

        	int N = sc.nextInt();
        	double D = sc.nextDouble();
        	riskGroup=0;
        	comGroup=0;
        	//int size = (int) N;
        	//age = new int[size];
        	int age;
        	int i=0;
        	while(N-->0){

        		age=sc.nextInt();
        		if((age>9) && (age < 80))
        			comGroup++;
        		else
        			riskGroup++;
        	}
        	if(comGroup<D)
        		comGroup=D;
        	if(riskGroup<D)
        		riskGroup=D;
        	System.out.println("riskGroup "+riskGroup + " comGroup " +comGroup);
        	System.out.println(((int)Math.ceil(comGroup/D)+(int)Math.ceil(riskGroup/D)));
        	
        }

        sc.close();
    }
}