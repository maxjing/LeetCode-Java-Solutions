## Solution1 - Recursive

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |

traverse each node once

---

#### note

use preorder traverse, if null add 'x', always add a spliter','

---

#### code

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    public static final String spliter = ",";
    public static final String NN = "X";
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    private void buildString(TreeNode node, StringBuilder sb) {
        if(node == null) {
            sb.append(NN).append(spliter);
        }else {
            sb.append(node.val).append(spliter);
            buildString(node.left, sb);
            buildString(node.right, sb);
        }
    } 

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        Queue<String> nodes = new LinkedList<>();
        nodes.addAll(Arrays.asList(data.split(spliter)));
        return buildTree(nodes);
        
    }
    private TreeNode buildTree(Queue<String> nodes) {
        String val = nodes.poll();
        if(val.equals(NN)){
            return null;
        }else {
            TreeNode node = new TreeNode(Integer.valueOf(val));
            node.left = buildTree(nodes);
            node.right = buildTree(nodes);
            return node;
        }
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
```

---

## Solution2 - Iterative

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |



---

#### note

stack inorder traverse, iterative

---

#### code

```java
public class Codec {
    private final static char SP=',';
    private final static char EMPTY='#';
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb= new StringBuilder();
        if(root == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            if(curr == null){
                sb.append(EMPTY);
            }else{
                sb.append(curr.val);
 
                stack.push(curr.right);
                stack.push(curr.left);
            }
             
            sb.append(SP);
        }
         
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String array[] = data.split("\\" + SP);
        Queue<String> queue = new LinkedList<>();
        for(String val: array){
            queue.add(val);
        }
        return deserializeHelper(queue);
    }
     
    public TreeNode deserializeHelper(Queue<String> queue){
        if(queue.isEmpty()) return null;
        String valStr = queue.remove();
        if(valStr.equals("" + EMPTY)) return null;
        int val = Integer.valueOf(valStr);
        TreeNode root = new TreeNode(val);
        root.left = deserializeHelper(queue);
        root.right = deserializeHelper(queue);
         
        return root;
         
    }
}
```

---

