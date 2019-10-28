## Solution1 - 

#### Question

A binary tree and a number k are given. Print every path in the tree with sum of the nodes in the path as k.
A path can start from any node and end at any node and must be downward only, i.e. they need not be root node and leaf node; and negative numbers can also be there in the tree.

#### complexity

| time                                     | space |
| ---------------------------------------- | ----- |
| O(n^2) worst case, O(nlogn) perfect tree | O(n)  |

similar to lc path-sum3

---

#### note

---

#### code

```java
class Solution {
    public static class Node {
        int val;
        Node left;
        Node right;
        Node(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> pathSum(Node root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        backTracking(root, sum, new ArrayList<>(), res);
        return res;
    }

    public static void backTracking(Node root, int sum, List<Integer> subList, List<List<Integer>> res) {
        if (root == null) {
            return;
        }
        subList.add(root.val);
        backTracking(root.left, sum, subList, res);
        backTracking(root.right, sum, subList, res);
        int f = 0;
        for (int i = subList.size() - 1; i >= 0; i--) {
            f += subList.get(i);
            if (f == sum) {
                List<Integer> newList = new ArrayList<>();
                for (int j = i; j < subList.size(); j++) {
                    newList.add(subList.get(j));
                }
                res.add(newList);
            }
        }
        subList.remove(subList.size() - 1);
    }
}
```

