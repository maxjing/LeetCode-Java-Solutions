## Solution1 - 

#### complexity

| time   | space |
| ------ | ----- |
| O(n^2) | O(n)  |

hashmap but look for substring and insertion

---

#### note

```
Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:  
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
```



---

#### code

```java
class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList();
        HashMap<String, List<String>> h = new HashMap();
        for(String path: paths){
            String[] tokens = path.split(" ");
            String dir = tokens[0];
            for(int i = 1; i < tokens.length; i++){
                String files = tokens[i];
                int start = files.indexOf("(");
                String content = files.substring(start);
                String pre = files.substring(0, start);
                if(h.containsKey(content)){
                    h.get(content).add(dir + "/" + pre);
                } else {
                    h.put(content, new ArrayList());
                    h.get(content).add(dir + "/" + pre);
                }
            }
        }
        for(String k: h.keySet()){
            if(h.get(k).size() > 1){
                res.add(h.get(k));    
            }
            
        }
        return res;
    }
}
```

