## Solution1 - Recursive and Iterative

#### complexity

| time | space |
| ---- | ----- |
| O(h) | O(h)  |

height

---

#### note

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } 
        else if(root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        }else {
            return root;
        }
    }
}
```

```java
//iterative
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(true) {
            if(cur.val < p.val && cur.val < q.val) {
                cur = cur.right;
            }
            if(cur.val > p.val && cur.val > q.val) {
                cur = cur.left;
            }else{
                break;
            }
        }
        return cur;
    }
}
```

