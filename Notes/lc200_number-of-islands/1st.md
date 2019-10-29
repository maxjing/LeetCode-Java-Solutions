## Solution1 - DFS

#### complexity

| time         | space |
| ------------ | ----- |
| O(4mn), O(n) | O(1)  |

m row, n column, dfs will go the 4 directions, so O(4mn)

---

#### note

第一次接触到dfs， 首先找到为1的点，然后做dfs把它上下左右为1的点变成0， 就不会重复计算

**注意边界条件** 

```java
i < 0 || i >= grid.length || j < 0 || j >= grid[0].length
```

---



#### code

```java
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int count = 0;
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return;
        }else {
            if(grid[i][j] == '1') {
                grid[i][j] = '0';
                dfs(grid, i + 1, j);
                dfs(grid, i - 1, j);
                dfs(grid, i, j + 1);
                dfs(grid, i, j - 1);
            }
        }

    }
}
```



## Solution2 - Union Find

#### complexity

| time          | space |
| ------------- | ----- |
| O(4mn), O(mn) | O(1)  |

m row, n column, dfs will go the 4 directions, so O(4mn), 应该是一样的complexity, leetcode 慢很多 但是

---

#### note

并查集，手写一个union find，constructor, union, find

variabe 必须有一个id[], 然后根据题目， 这道题需要count

constructor (m, n grid) 里initialize 这个id[]长度为mn, 并统计出所有的land(1)

```java
id[1] = 1, id[2] = 2....
```

**pathway compress 路径压缩 需要说明一下** 

```java
while(id[p] != p) {
  id[p] = id[id[p]];
  p = id[p];
}
```

**注意边界条件**

```java
i < m - 1 && grid[i + 1][j] == '1'; //down
j < n - 1 && grid[i][j+1] == '1'; //right
```



#### code

```java
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        UnionFind uf = new UnionFind(m, n, grid);
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == '0') continue;
                int p = i * n + j;
                int q;
              	//up
                if(i > 0 && grid[i-1][j] == '1') {
                    q = p - n;
                    uf.union(p, q);
                }
              	//down
                if(i < m - 1 && grid[i+1][j] == '1') {
                    q = p + n;
                    uf.union(p, q);
                }
              	//left
                if(j > 0 && grid[i][j-1] == '1') {
                    q = p - 1;
                    uf.union(p, q);
                } 
              	//right
                if(j < n - 1 && grid[i][j+1] == '1') {
                    q = p + 1;
                    uf.union(p , q);
                }
            }

        }
        return uf.count;
    }
    
}   
    
class UnionFind {
    public int count = 0;
    public int[] id = null;
    public UnionFind(int m, int n, char[][] grid) {
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
              //depends on the question
                if(grid[i][j] == '1') {
                    count++;
                }
            }
        }
        id = new int[m*n];
        for(int i = 0; i < m*n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        while(id[p] != p) {
            id[p] = id[id[p]];
            p = id[p];
        }
        return p;
    }

    public void union(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if(pRoot == qRoot) {
            return;
        }
        id[pRoot] = qRoot;
        count--;
    }

}
```

---

## Follow Up

* 如果island和外界相连就不要计数，只计算完全被水包围的island
  * 从四周做bfs，把1改成0. 然后就是原题了。
* UF 和 dfs， bfs 比较
  * uf 适合动态生成集合。 bfs dfs 都是对已知数据的遍历
  * dfs 容易爆栈 stack overflow