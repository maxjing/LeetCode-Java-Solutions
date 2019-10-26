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

