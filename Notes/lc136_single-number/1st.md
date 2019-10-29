## Solution1 - HashMap

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |

use HashMap is expensive

---

#### note

需要熟悉 

```java
  for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
 }
```



---

#### code

```java
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if(entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
```

---

## Solution2 - XOR 

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(1)  |



---

#### note

2 xor 2 = 0, 最后就剩odd 的那一个 0 xor 5 = 5

xor works as below:

```
Let's say we have an array - [2,1,4,5,2,4,1].
What we are doing is essentially this-

=> 0 ^ 2 ^ 1 ^ 4 ^ 5 ^ 2 ^ 4 ^ 1

=> 0^ 2^2 ^ 1^1 ^ 4^4 ^5 (Rearranging, taking same numbers together)

=> 0 ^ 0 ^ 0 ^ 0 ^ 5

=> 0 ^ 5

=> 5 :)
```



---

#### code

```java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }
}
```

