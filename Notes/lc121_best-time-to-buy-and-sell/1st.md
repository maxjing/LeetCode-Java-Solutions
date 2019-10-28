## Solution1

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |



---

#### note

单次交易

**注意**

需要max和maxCurr， maxCurr里面比较当前差值和0， 如果为负 就算成0

```java
maxCurr = Math.max(0, prices[i] - prices[i - 1] + maxCurr);
max = Math.max(max, maxCurr);
```



---

#### code

```java
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int maxCurr = 0;
        for(int i = 1; i < prices.length ; i++) {
            maxCurr = Math.max(0, prices[i] - prices[i - 1] + maxCurr);
            max = Math.max(max, maxCurr);
        }
        return max;
    }
}
```

