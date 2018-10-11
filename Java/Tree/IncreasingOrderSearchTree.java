/**
897. Increasing Order Search Tree
Given a tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only 1 right child.

Example 1:
Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]

       5
      / \
    3    6
   / \    \
  2   4    8
 /        / \ 
1        7   9

Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]

 1
  \
   2
    \
     3
      \
       4
        \
         5
          \
           6
            \
             7
              \
               8
                \
                 9 
**/

List<Integer> l = new ArrayList<>();
public List<Integer> inorderList(TreeNode root){
    if(root == null) return null;
    inorderList(root.left);
    l.add(root.val);
    inorderList(root.right);
    return l;
}
public TreeNode increasingBST(TreeNode root) {
    if(root == null) return null;
    List<Integer> inorder = inorderList(root);
    root = new TreeNode(inorder.get(0));
    TreeNode fakeRoot = root;
    for(int i = 1; i < inorder.size(); i++){
        fakeRoot.right = new TreeNode(inorder.get(i));
        fakeRoot = fakeRoot.right;
    }
    return root;
}

