## Solution1 - BFS Iterative

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |

visit each node once

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) {
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
             List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
            res.add(list);
        }
        return res;
    }
}
```

---

## Solution2 - DFS Recursive

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |



---

#### note

---

#### code

```java
public List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		levelOrderHelper(res, root, 0);
		return res;
	}
	
	public void levelOrderHelper(List<List<Integer>> res, TreeNode root, int level) {
		if (root == null)
			return;
		List<Integer> curr;
		if (level >= res.size()) {
			curr = new ArrayList<>();
			curr.add(root.val);
			res.add(curr);
		} else {
			curr = res.get(level); 
			curr.add(root.val); 
			//res.add(curr); // No need to add the curr into the res, because the res.get(index) method does not remove the index element
		}
		levelOrderHelper(res, root.left, level + 1);
		levelOrderHelper(res, root.right, level + 1);
	}
```

