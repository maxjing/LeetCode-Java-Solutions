/**
589. N-ary Tree Preorder Traversal

Given an n-ary tree, return the preorder traversal of its nodes' values.
**/
class Solution {
    List<Integer> list = new ArrayList<>();
    public List<Integer> preorder(Node root) {
        if(root == null) return list;
        list.add(root.val);
        for(Node node : root.children){
            preorder(node);
        }
        return list;
    }
}

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            list.add(root.val);
            for(int i = root.children.size() - 1; i >=0; i--){
                stack.add(root.children.get(i));
            }
        }
        return list;
    }
}