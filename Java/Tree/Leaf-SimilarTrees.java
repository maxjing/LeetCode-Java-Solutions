/**
872. Leaf-Similar Trees
Consider all the leaves of a binary tree.  From left to right order, the values of those leaves form a leaf value sequence.
**/
public boolean leafSimilar(TreeNode root1, TreeNode root2) {
    if(root1 == null && root2 == null) return true;
    else if(root1 == null || root2 == null) return false;
    List<Integer> r1 = new ArrayList<>();
    List<Integer> r2 = new ArrayList<>();
    leafList(root1, r1);
    leafList(root2, r2);
    return r1.equals(r2);

}
public void leafList(TreeNode root, List<Integer> l){
    if(root == null) return;
    if(root.left == null && root.right == null){
        l.add(root.val);
    }
    leafList(root.left, l);
    leafList(root.right, l);

}