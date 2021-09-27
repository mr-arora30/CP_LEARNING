import java.util.*;

public class ZigZagTraversal{
  public static List<List<Integer>> traverse(TreeNode root){
      List<List<Integer>> result = new LinkedList<>(); //used Linked List here
      if(root==null) return result;

      Queue<TreeNode> queue = new LinkedList<>();
      queue.offer(root);
      int levelCounter=0;
      while(!queue.isEmpty()){
          int levelSize=queue.size();
          List<Integer> currentLevel = new ArrayList<>(); // used ArrayList here
          
          for(int i=0;i<levelSize;i++){
            TreeNode currentNode = queue.poll();
            // add the node to the current level
            if(levelCounter%2==0)
            currentLevel.add(currentNode.val);
            
                 // insert the children of current node to the queue
            if(currentNode.left!=null) queue.offer(currentNode.left);
            if(currentNode.right!=null) queue.offer(currentNode.right);

          }
          result.add(0,currentLevel);
      }
      return result;
  }
  public static void main(String args[]){
  TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = ReverseLevelOrder.traverse(root);
    System.out.println("Reverse level order traversal: " + result);
  }
}

class TreeNode{
  int val;
  TreeNode left;
  TreeNode right;
  TreeNode(){};
  TreeNode(int val){
    this.val=val;
  }
  TreeNode(int val,TreeNode left,TreeNode right){
    this.val=val;
    this.left=left;
    this.right=right;
  }
}