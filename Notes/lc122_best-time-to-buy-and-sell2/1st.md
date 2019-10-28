## Solution1

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(1)  |



---

#### note

可多次交易，重复打擂台比较 差值即可

---

#### code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 1 ; i < prices.length; i++) {
          //max += Math.max(prices[i] - prices[i - 1], 0);
            if(prices[i] - prices[i-1] > 0) {
                max += prices[i] - prices[i-1];
            }
        }
        return max;
    }
}
```

