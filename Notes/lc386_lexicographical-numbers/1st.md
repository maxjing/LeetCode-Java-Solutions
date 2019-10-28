## Solution1 - DFS

#### complexity

| time | space                    |
| ---- | ------------------------ |
| O(n) | O(number of digits of n) |

```
       1        2        3    ...
      /\        /\       /\
   10 ...19  20...29  30...39   ....
```

number of digits of n will be the h

---

#### note

loop 0 ~ 9, dfs 每次添加进res后， loop i = 0 ~ 9 每次 curr * 10 确保 1 然后 10， 2 之后是20 21.。。。

**注意**

两次 boundary check 外层dfs 当前是否大于n, 内层dfs 当前i * 10 + i是否大于n

---

#### code

```java
public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for(int i=1;i<10;++i){
          dfs(i, n, res); 
        }
        return res;
    }
    
    public void dfs(int cur, int n, List<Integer> res){
        if(cur>n)
            return;
        else{
            res.add(cur);
            for(int i=0;i<10;++i){
              //this will save time
                if(10*cur+i>n)
                    return;
                dfs(10*cur+i, n, res);
            }
        }
    }
}
```

