## Solution1 - Recursive

#### complexity

| time | space   |
| ---- | ------- |
| O(n) | O(logn) |

space complexity of tree is depending on the depth 

---

#### note

如果root == null return false，如果root 没有 children, return root.val = sum

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return root.val == sum;
        }
        
        return hasPathSum(root.left, sum-root.val) || hasPathSum(root.right, sum-root.val);
    }
}
```

