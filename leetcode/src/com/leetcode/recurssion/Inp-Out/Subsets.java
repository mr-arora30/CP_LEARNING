 public class Subsets {

  public static void main(String args[]) {
    System.out.println(subsets("abc", " "));
  }

  static String subsets(String in, String op) {

    if (in.length() == 0)
      return op;

    String op1 = op;
    String op2 = op;
    op2 = in.charAt(0) + op;
    /*
     * if(in.length()==1) in=null; else
     */
    in = in.substring(0, in.length() - 1);

    subsets(in, op1);
    subsets(in, op2);
    return op;
  }
}