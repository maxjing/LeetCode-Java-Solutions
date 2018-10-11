/** use queue to levelorder
**/
public void LevelOrder(Node root) {
	Queue<Node> q = new LinkedList<Node>();
	q.add(root);
	while (q.isEmpty() == false) {
		Node x = q.peek();
		q.remove();
		if(x.left!=null) s.add(x.left);	
		if(x.right!=null) s.add(x.right);
			
		System.out.print(" " + x.data);
	}
}
/**use stack preorder
**/
public void DFS(Node root) {
	Stack<Node> s = new Stack<Node>();
	s.add(root);
	while (s.isEmpty() == false) {
		Node x = s.pop();
		if(x.right!=null) s.add(x.right);
		if(x.left!=null) s.add(x.left);			
		System.out.print(" " + x.data);
	}
}

/** n-ray tree
**/
Iterative

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while(!stack.isEmpty()) {
            root = stack.pop();
            list.add(root.val);
            for(Node node: root.children)
                stack.add(node);
        }
        Collections.reverse(list);
        return list;
    }
}
Recursive

class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if (root == null)
            return list;
        
        for(Node node: root.children)
            postorder(node);
        
        list.add(root.val);
        
        return list;
    }
}

Iterative Solution

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        
        while (!stack.empty()) {
            root = stack.pop();
            list.add(root.val);
            for (int i = root.children.size() - 1; i >= 0; i--)
                stack.add(root.children.get(i));
        }
        
        return list;
    }
}



Recursive Solution

class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if (root == null)
            return list;
        
        list.add(root.val);
        for(Node node: root.children)
            preorder(node);
                
        return list;
    }
}

//bfs
    public int maxDepth(Node root) {
        if (root == null) return 0;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int depth = 0;
        while(!q.isEmpty()){
            depth ++;
            int s = q.size();
            for(int i = 0; i < q.size() ;i++){
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

//dfs
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