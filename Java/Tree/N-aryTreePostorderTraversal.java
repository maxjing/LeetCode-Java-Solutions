/**
590. N-ary Tree Postorder Traversal
Given an n-ary tree, return the postorder traversal of its nodes' values.
**/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> list = new ArrayList<>();
    public List<Integer> postorder(Node root) {
        if(root == null) return list;
        for(Node node : root.children){
            postorder(node);
        }
        list.add(root.val);
        return list;
    }
}

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        if(root == null) return list;
        
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            for(Node node : root.children){
                stack.add(node);
            }
        }
        Collections.reverse(list);
        return list;
    }
}