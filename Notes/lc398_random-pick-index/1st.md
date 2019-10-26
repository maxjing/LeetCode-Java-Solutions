## Solution1 - Reservoir Sampling

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |

水塘抽样 类似的题 lc382

---

#### note

这个意思是在0 ~ count 中随机抽一个数，这个数正好是0的情况， 也就是1/n的概率。 count初始为0， 所以只有一个元素的时候，被抽中的概率是100%。而出现多次数字， 在forloop 里面会经历多次抽取， 概率自然会高

```java
//if count == 1, rnd.nextInt(++count) 只会 等于 1， 不包含count
if(rnd.nextInt(++count) == 0) {
  res = i;
}
```

---

#### code

```java
class Solution {
    int[] nums;
    Random rnd;
    public Solution(int[] nums) {
        this.nums = nums;
        this.rnd = new Random();
    }
    
    public int pick(int target) {
        int res = -1;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != target) {
                continue;
            }
            if(rnd.nextInt(++count) == 0) {
                res = i;
            }
        }
        return res;
    }
}
```

# 