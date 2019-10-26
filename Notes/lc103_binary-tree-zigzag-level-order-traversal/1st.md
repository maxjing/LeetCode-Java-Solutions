## Solution1 - BFS

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |

---

#### note

BFS level order traverse, 用direction++ 来判断是否需要reverse

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
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        } 
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int direction = 1;
        while( !q.isEmpty()) {
            int size = q.size();
            direction++;
            List<Integer> subList = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                subList.add(node.val);
                if(node.left != null) {
                    q.add(node.left);
                } 
                if(node.right != null) {
                    q.add(node.right);
                }
                
            }
            if(direction % 2 != 0) {
                Collections.reverse(subList);
            }
            res.add(subList);
            
        }
        return res;
    }
}
```

