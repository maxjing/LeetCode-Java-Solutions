/**
404. Sum of Left Leaves
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
**/

public int sumOfLeftLeaves(TreeNode root) {
    if(root == null) return 0;
    int sum = 0;
    Stack<TreeNode> s = new Stack<>();
    s.push(root);
    while( !s.isEmpty() ){
        TreeNode temp = s.pop();
        if(temp.left != null){
            if(temp.left.left == null && temp.left.right == null){
                sum += temp.left.val;
            }else{
                s.push(temp.left);
            }
        }
        if(temp.right != null){
            if(temp.right.left != null || temp.right.right != null){
                s.push(temp.right);
            }
        }
    }
    return sum;
}

//iterative
public int sumOfLeftLeaves(TreeNode root) {
       if(root == null) return 0;
    int sum = 0;
    if(root.left != null){
        if(root.left.left == null && root.left.right == null){
            sum += root.left.val;
        }else{
            sum += sumOfLeftLeaves(root.left);
        }
    }
    sum += sumOfLeftLeaves(root.right);
    return sum;
}