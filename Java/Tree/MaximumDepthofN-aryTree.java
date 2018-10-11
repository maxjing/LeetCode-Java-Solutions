/**559. Maximum Depth of N-ary Tree
Given a n-ary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
**/
    
public static int maxDepth(Node root) {
    if (root == null) return 0;
    Queue<Node> q = new LinkedList<>();
    q.add(root);
    int depth = 0;
    while(!q.isEmpty()){
        depth ++;
        for(int i = 0; i < q.size() - 1;i++){
            Node node = q.peek();
            q.remove();
            int n = node.children.size();
            for(int j = 0; j < n; j++){
                q.add(node.children.get(j));
            }
        }
    }
    return depth;
}


public int maxDepth(Node root) {
    return recurse(root);
}

public int recurse(Node root) {
    if(root == null) return 0;
    if( root.children == null) return 1;
    
         int max=0;
    for(Node each: root.children)
        max = Math.max(max, recurse(each));
        
    return 1+max;
}  
