## Solution1 - Reservoir Sampling

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |

水塘抽样 类似的题 lc398

---

#### note

与398 不一样的是，r initialize with root.val, 在第一个循环里面 random.nextInt(2) 从0, 1中选 root 或者 root.next 

---

#### code

```java
public class Solution {
    ListNode head;
    Random random;
    public Solution(ListNode h) {
        head = h;       
        random = new Random();        
    }
    public int getRandom() {
        ListNode c = head;
        int r = c.val;
        for(int i=1;c.next != null;i++){
            
            c = c.next;
            if(random.nextInt(i + 1) == i){
              r = c.val;   
            }                      
        }
        return r;
    }
}
```

# 