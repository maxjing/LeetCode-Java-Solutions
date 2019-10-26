## Solution1 - DFS

#### complexity

| time     | space |
| -------- | ----- |
| O(V + E) | O(n)  |

用了hashmap, 遍历所有的node 和 edge 一次

---

#### note

用一个global hashmap 记录下 遍历过的node， map没有的话 创建一个newnode(node.val, new ArrayList<>())

再DFS他的neighbors

**注意**

node其实是一个arraylist

存map的时候要在recursive neighbor 之前 不然会爆栈

```java
 map.put(node.val, newNode);  
for(Node neighbor : node.neighbors) {
      newNode.neighbors.add(clone(neighbor));
 }
```



---

#### code

```java
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    HashMap<Integer, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        Node res = clone(node);
        return res;
    }
    
    public Node clone(Node node) {
        if(node == null) {
            return null;
        }
        if(map.containsKey(node.val)) {
            return map.get(node.val);
        }
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);
        if(node.neighbors != null) {
            for(Node neighbor : node.neighbors) {
                newNode.neighbors.add(clone(neighbor));
            }
        }
        return newNode;
        
    }
    
}
```

