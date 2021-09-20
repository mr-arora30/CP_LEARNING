public class MaxHeightOfTree {

  public static int maxDepth(TreeNode root) {

    if (root == null)
      return 0;

    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));

  }

  public static void main(String args[]) {

    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.left.left = new TreeNode(3);
    root.left.left.left = new TreeNode(4);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(3);
    System.out.println(maxDepth(root));
  }

}

class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }
}
