## Solution1 - Backtracking

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |

only visit each node once

---

#### note

similar to subset

**注意**

backTracking 里面是两次backTracking， if else 之外再 remove last one

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        backTracking(root, sum, new ArrayList<>(), res);
        return res;
    }
    
    public void backTracking(TreeNode node, int sum, List<Integer> subList, List<List<Integer>> list) {
        if(node == null) {
            return;
        }
        subList.add(node.val);
        if(node.left == null && node.right == null && node.val == sum) {
            list.add(new ArrayList(subList));
        }else {
            backTracking(node.left, sum - node.val, subList, list);
            backTracking(node.right, sum - node.val, subList, list);
        }
        subList.remove(subList.size() - 1); 
    }
}
```

