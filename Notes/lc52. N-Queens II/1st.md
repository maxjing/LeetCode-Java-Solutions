## Solution1 - Modify lc 51

#### complexity

| time  | space  |
| ----- | ------ |
| O(n!) | O(n^2) |



---

#### note

不需要 generateboard function， row == n 时只需要加1占位

---

#### code

```java
class Solution {
    public int totalNQueens(int n) {
        List<Integer> res= new ArrayList<>();
        backTracking(0, n, new ArrayList<>(), res);
        return res.size();
    }
    
        public void backTracking(int row, int n, List<Integer> subList, List<Integer> list) {
        if(row == n) {
            list.add(1);
        }
        
        for(int i = 0; i < n; i++) {
            subList.add(i);
            if(isValid(subList)) {
                backTracking(row + 1, n, subList, list);
            }
            subList.remove(subList.size() - 1);
        }
    }
    private boolean isValid(List<Integer> list) {
        int curr_row = list.size() - 1;
        for(int i = 0; i < curr_row; i++) {
            int colDiff = Math.abs(list.get(i) - list.get(curr_row));
            int rowDiff = curr_row - i;
            //same col  || diagonal
            if(colDiff == 0 || rowDiff == colDiff) {
                return false;
            }
        }
        return true;
    }
}
```

---

## Solution2 

#### complexity

| time  | space |
| ----- | ----- |
| O(n!) | O(n)  |



---

#### note

在对角线上 row + col 和 row - col 会相同的，因为出现了负数 把row - col 加上n就好了

![img](https://windliang.oss-cn-beijing.aliyuncs.com/52_2.jpg)

---

#### code

```java
public int totalNQueens(int n) {
    List<Integer> ans = new ArrayList<>();
    boolean[] cols = new boolean[n]; // 列
    boolean[] d1 = new boolean[2 * n]; // 主对角线 
    boolean[] d2 = new boolean[2 * n]; // 副对角线
    return backtrack(0, cols, d1, d2, n, 0);
}

private int backtrack(int row, boolean[] cols, boolean[] d1, boolean[] d2, int n, int count) { 
    if (row == n) {
        count++;
    } else {
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n; //主对角线加 n
            int id2 = row + col;
            if (cols[col] || d1[id1] || d2[id2])
                continue;
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            count = backtrack(row + 1, cols, d1, d2, n, count);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }

    }
    return count;
}
```

