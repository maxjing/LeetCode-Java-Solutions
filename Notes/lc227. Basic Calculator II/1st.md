## Solution1 

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(1)  |

use variables

---

#### note

**注意**

写testcase的时候要注意， 出现sign的时候再计算上一个sign的结果 

3 + 5 / 2， 看到 / 才会去更新sum = 3

```java
3 + 5/2
0: num = 0, tempsum = 0, sum = 0, sign = +
1. c = 3, num = 3, tempsum = 0, sum = 0, sign = +
2. c = +, tempsum = 3, sum = 0, num = 0, sign = +
3. c = 5, tempsum = 3, sum = 0, num = 5, sign = +
4. c = /, tempsum = 5, sum = 3, num = 0, sign = /
5. c = 2, num = 2, tempsum = 5/2 = 2, sign = /
6. sum + tempsum = 3 + 2 = 5
```



---

#### code

```java
class Solution {
    public int calculate(String s) {
        int num = 0;
        int tempSum = 0;
        int sum = 0;
        int sign = '+';
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                num = num * 10 + c - '0';
            }
            if(!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if(sign == '+') {
                    sum += tempSum;
                    tempSum = num;
                } else if(sign == '-') {
                    sum += tempSum;
                    tempSum = -num;
                } else if(sign == '*') {
                    tempSum *= num;
                } else if(sign == '/') {
                    tempSum /= num;
                }
                sign = c;
                num = 0;
            }
        }
        return sum + tempSum;
    }
}
```

