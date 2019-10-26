## Solution1 - DP

#### complexity

| time     | space  |
| -------- | ------ |
| O(n^3/k) | O(n^2) |

DP

---

#### note

array 长度 -1 一定要是 K - 1的倍数 才能在最后剩下一堆被合并

```
dp[i][j] means the minimum cost needed to merge stones[i] ~ stones[j]
```

这道题太难了

---

#### code

```java
class Solution {
      public int mergeStones(int[] stones, int K) {
        int n = stones.length;
        if ((n - 1) % (K - 1) > 0) return -1;

        int[] prefix = new int[n+1];
        for (int i = 0; i <  n; i++)
            prefix[i + 1] = prefix[i] + stones[i];

        int[][] dp = new int[n][n];
        for (int m = K; m <= n; ++m)
            for (int i = 0; i + m <= n; ++i) {
                int j = i + m - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int mid = i; mid < j; mid += K - 1)
                    dp[i][j] = Math.min(dp[i][j], dp[i][mid] + dp[mid + 1][j]);
                if ((j - i) % (K - 1) == 0)
                    dp[i][j] += prefix[j + 1] - prefix[i];
            }
        return dp[0][n - 1];
    }
}
```

