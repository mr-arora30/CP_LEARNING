package com.leetcode.recurssion.InpOut;
class Permutation{
  public static void main(String args[]) {
    String in="ABC";
    String out="";
    out=in.substring(0,1);
    
    permute(out,in.substring(1));
    }
  /*public static String permute(String out, String inp){

          if(inp.length()==1){
            System.out.println(out);
            return out;
          }
          String out1=out;
          String out2=out;

          out2=out2.replace(inp.charAt(0)+"", inp.charAt(0) + " ");//this will fail when there are repeated chars
    
          inp=inp.substring(1);
          
          permute(out1, inp);
          permute(out2, inp);
          return out;

  }*/

  public static void permute(String out, String inp){
     if(inp.length()==0){
            System.out.println(out);
            return;
          }
          String out1=out;
          String out2=out;
          out1=out1+" "+inp.charAt(0);
         
          out2=out2+inp.charAt(0);
          inp=inp.substring(1);
          
          permute(out1, inp);
          permute(out2, inp);
          
  }
}