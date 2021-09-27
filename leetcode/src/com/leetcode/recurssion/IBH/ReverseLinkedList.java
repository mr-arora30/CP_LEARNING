package com.leetcode.recurssion.IBH;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList{

   public static void main(String args[]) {
     ListNode listNode = new ListNode(1);
      listNode.next= new ListNode(2);
      listNode.next.next= new ListNode(3);
      listNode.next.next.next= new ListNode(4);
      listNode.next.next.next.next= new ListNode(5);
      System.out.println(listNode.toString());
      System.out.println(reverseList(listNode).toString());
   }
    /*
        Hypothesis f(n):  1->2->3->4->5->null -> 5->4->3->2->1->null
                 f(n-1):  1-2-3-4-null -> 4-3-2-1 null 
        
        Base --> if ll has a single element then its already reversed.
                if(ll.size=1)
        Induction :
            1->2->3->null<-4<-5
                    4->1->2->3-> null
    */
    public static ListNode reverseList(ListNode head) {
        
        if(head==null || head.next==null ){
            return head;
        }
        ListNode prev = head;
        head = head.next;
       ListNode node=reverseList(head); //returned as example 5
         // System.out.println(node.val);
          head.next=prev;
         // head.next.next=null; either this or below statement
       
         prev.next=null;
   
        return node; //returns always the last value of the call as its always returning the same value for node example 5
        
    
}

 
}
  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

      @Override
      public String toString() {
        // TODO Auto-generated method stub
        String ans="";
        ListNode node =this;
        while(node!=null){
        ans+=node.val+" ";
        node = node.next;
        }
        return ans;
      }
  }
