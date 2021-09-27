 public class Subsets {

  public static void main(String args[]) {
    System.out.println(subsets("abc", " "));
  }

  static String subsets(String in, String op) {

    if (in.length() == 0){
      System.out.println(op);
      return op;
    }
      

    String op1 = op;
    String op2 = op;
    op2 = op+in.charAt(0);
   
    in = in.substring(1);

    subsets(in, op1);
    subsets(in, op2);
    return op;
  }
}