## Solution1 - 

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |



---

#### note

起始i = 0， j = 1， loop时 都是+=2，所以i位一直都是偶数位，j一直都是奇数位

当遇到a[i]不是偶数时， 跑j直到a[j]是偶数， 交换 a[i] a[j]

---

#### code

```java
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int j = 1;
        for(int i = 0; i < A.length; i += 2) {
            if(A[i] % 2 == 1) {
                while(A[j] % 2 == 1) {
                    j += 2;
                }
                swap(A, i, j);
            }
        }
        return A;
    }
    
    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

A[3, 2, 4, 5]
1. A[j] = 2, A[i] = 3, swap -> [2,3,4,5]
A[3,5,2,4]
1. A[j] = 5, A[i] = 3 -> j+=2 -> A[j] = 4 -> swap -> [4, 5, 2, 3]
```

