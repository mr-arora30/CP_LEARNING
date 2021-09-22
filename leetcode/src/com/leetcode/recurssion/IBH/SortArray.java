import java.util.*;

public class SortArray {
  static Integer ans[] = { 5, 2, 10, 3, 1, 8 };

  public static void main(String args[]) {
    // sortedArray(ans, ans.length);
    List<Integer> list = new ArrayList<Integer>(Arrays.asList(ans));

    // System.out.println(Arrays.toString(ans));
    sortedArray(list);
    System.out.println(list);

  }


  /*
  Hypothesis & Induction is array with single element is sorted 
  So here we break array to single element then use another hypothesis to
  inser the element at right place
  */
  public static void sortedArray(List<Integer> al) {

    if (al.size() == 1)
      return;

    int temp = al.get(al.size() - 1); // we save the last element of the array and remove
    al.remove(al.size() - 1);
    sortedArray(al);

    insert(al, temp);//need to place temp value at its right place

  }
/*
Hypothesis & Induction here is if last element of the array is less than temp value then it just needs to 
be added at the end of array, else we save the last element of the array in val and recursively call the method again until we find no element or an element which is smaller than temp and we append at the end array, and the value stored earlier is appened after temp is placed at its position
*/
  public static void insert(List<Integer> al, int temp) {
    // System.out.println("value of n : " + n);
    int val;
    if (al.size() == 0 || al.get(al.size() - 1) <= temp) {
      al.add(temp);
      return;
    }
    val = al.get(al.size() - 1);//stored last element which is greater than temp
    al.remove(al.size() - 1);//removed last element
    insert(al, temp);
    al.add(val); // add back the last element which was greater than temp
    return;
  }

  
}