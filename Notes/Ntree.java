public class NTree {
    public static class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
    public static List<Integer> getPreorderList(Node root){
        List<Integer> l = new LinkedList<>();
        if(root == null) return l;
        Stack<Node> s = new Stack<>();
        s.add(root);
        while( !s.isEmpty() ){
            root = s.pop();
            l.add(root.val);
            int n = root.children.size();
            for(int i = n - 1; i >= 0; i--){
                s.add(root.children.get(i));
            }
        }
        return l;
    }
    public static List<Integer> recursivePreorder(Node root){
        List<Integer> l = new ArrayList<>();
        if(root == null) return l;
        l.add(root.val);
        for(Node node : root.children){
            recursivePreorder(node);
        }
        return l;
    }

    public static List<Integer> getPostorderList(Node root){
        List<Integer> l = new LinkedList<>();
        if(root == null) return l;
        Stack<Node> s = new Stack<>();
        s.add(root);
        while( ! s.isEmpty() ){
            root = s.pop();
            l.add(root.val);
            int n = root.children.size();
            for(int i = 0; i < n; i++){
                s.add(root.children.get(i));
            }
        }
        Collections.reverse(l);
        return l;
    }

    List<Integer> list = new ArrayList<>();
    public List<Integer> recursivePostorder(Node root){
       
        if(root == null) return list;
      
        for(Node node : root.children){
            recursivePostorder(node);
        }
        list.add(root.val);
        return list;
    }

    public static List<List<Integer>> getLevelOrderList(Node root){
        List<List<Integer>> l = new ArrayList<>();
        if(root == null) return l;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while( !q.isEmpty() ){
            List<Integer> level = new ArrayList<>();
            int s = q.size();
            for(int i = 0; i < s; i++){
                root = q.poll();
                level.add(root.val);
                int n = root.children.size();
                for(int j = 0; j < n; j ++){
                    q.add(root.children.get(i));
                }

            }
            l.add(level);

        }
        return l;
    }

}



public int maxDepth(Node root) {
    if(root==null){
        return 0;
    }
    if(root.children.size() == 0) return 1;
    else{
        int maxdepth = 1;
        for(Node node : root.children){
            maxdepth = Math.max(maxdepth, maxDepth(node) + 1);
        }
        return maxdepth;
    }
}
