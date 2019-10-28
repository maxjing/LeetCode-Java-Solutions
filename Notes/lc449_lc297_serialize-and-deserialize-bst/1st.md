## Solution1 - Recursive

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |

similar to lc297

---

#### note

与297一样 可以用相同的办法 但是这题考察的是运用bst的特性，而297是bt

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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }
    
    public void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) return;
        sb.append(root.val).append(",");
        serialize(root.left, sb);
        serialize(root.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;
        Queue<String> q = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserialize(q, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    public TreeNode deserialize(Queue<String> q, int lower, int upper) {
        if (q.isEmpty()) return null;
        String s = q.peek();
        int val = Integer.parseInt(s);
        if (val < lower || val > upper) return null;
        q.poll();
        TreeNode root = new TreeNode(val);
        root.left = deserialize(q, lower, val);
        root.right = deserialize(q, val, upper);
        return root;
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

similar to lc297

---

#### note

use stack to do iterative

---

#### code

```java
public class Codec {
    private final static char SP=',';
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb= new StringBuilder();
        if(root == null) return "";
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode curr = stack.pop();
            sb.append(curr.val).append(SP);
            if(curr.right!=null) stack.push(curr.right);
            if(curr.left !=null) stack.push(curr.left);
             
        }
         
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
 
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        String array[] = data.split("\\" + SP);
        Queue<Integer> queue = new LinkedList<>();
        for(String val: array){
            queue.add(Integer.valueOf(val));
        }
         
        return deserializeHelper(queue);
    }
     
    public TreeNode deserializeHelper(Queue<Integer> queue){
        if(queue.isEmpty()) return null;
        Integer curr = queue.remove();
     
        Queue<Integer> smallerQueue = new LinkedList<>();
        while(!queue.isEmpty() && queue.peek() < curr){
            smallerQueue.add(queue.remove());
        }
         
        TreeNode root = new TreeNode(curr);
        root.left = deserializeHelper(smallerQueue);
        root.right = deserializeHelper(queue);
         
        return root;
         
    }
}
```

