/**
429. N-ary Tree Level Order Traversal

Given an n-ary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 
We should return its level order traversal:
[
     [1],
     [3,2,4],
     [5,6]
]
**/
class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list = new LinkedList<>();
        if(root == null) return list;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while( !q.isEmpty() ){
            List<Integer> current = new LinkedList<>();
            int length = q.size();
            for(int i = 0; i < length; i ++){
                root = q.peek();
                q.remove();
                current.add(root.val);
                for(Node node : root.children){
                    q.add(node);
                }
            }
            list.add(current);
        }
        return list;

    }
}