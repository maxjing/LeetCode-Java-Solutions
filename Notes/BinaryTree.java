List<Integer> l = new ArrayList<>();
public List<Integer> postorderTraversal(TreeNode root) {
    if(root == null) return l;
   
    postorderTraversal(root.left);
    postorderTraversal(root.right);
     l.add(root.val);
    return l;
}

    public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> l = new ArrayList<>();
    if(root == null) return l;
    Stack<TreeNode> s = new Stack<>();
    s.add(root);
    while( !s.isEmpty()){
        root = s.pop();
        l.add(root.val);
        if(root.left != null){
            s.add(root.left);
        }
        if(root.right != null){
            s.add(root.right);
        
    }
    Collections.reverse(l);
    return l;
    
}

    List<Integer> l = new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return l;
        l.add(root.val);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        
        return l;
        
    }

  public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> l = new ArrayList<>();
    if(root == null) return l;
    Stack<TreeNode> s = new Stack<>();
    s.add(root);
    while( !s.isEmpty() ){
        root = s.pop();
        l.add(root.val);
        if(root.right != null) s.add(root.right);
        if(root.left != null)   s.add(root.left);
    }
    
    return l;
}