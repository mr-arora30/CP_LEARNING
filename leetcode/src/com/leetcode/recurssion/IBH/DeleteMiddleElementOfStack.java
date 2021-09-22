import java.util.*;

public class DeleteMiddleElementOfStack{
  public static void main(String args[]){
    Stack<Integer> stack = new Stack<>();
    stack.push(5);
    stack.push(4);
    stack.push(3);
    stack.push(2);
    stack.push(1);
    //SortStack.sortAStack(stack);
    int k = stack.size()/2 + 1;
    deleteMidElement(stack, k);
    System.out.println(stack);

  }
  public static void deleteMidElement(Stack<Integer> stack, int k){
    if(k==1){
      stack.pop();
      return;
    }
    int temp=stack.pop();
    deleteMidElement(stack,k-1);
    stack.push(temp);
  }

}