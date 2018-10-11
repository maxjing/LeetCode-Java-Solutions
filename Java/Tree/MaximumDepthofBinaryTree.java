/**
104. Maximum Depth of Binary Tree
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
**/
public int maxDepth(TreeNode root) {
    if( root == null ) return 0;
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    int depth = 0;
    while( !q.isEmpty() ){
        depth++;
        int n = q.size();
        while(n > 0){
            TreeNode node = q.poll();
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
    }
    return depth;
}

public int maxDepth(TreeNode root) {
    if(root==null){
        return 0;
    }
    return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
}