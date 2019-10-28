## Solution1 - Two Pointer

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |



---

#### note

---

#### code

```java
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int i = 0;
        int j = A.length - 1;
        while(i < j) {
            if(A[i] % 2 == 0) {
                i++;
            }
            if(A[j] % 2 == 1) {
                j--;
            }
            else {
                swap(i, j, A);
            }
        }
        return A;
    }
    
    public void swap(int i, int j, int[] A) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}

[3,2,4,5]
1. A[i] = 3, A[j] = 5 -> j-- -> A[j] = 4 -> swap -> [4,2,3,5]
  
```

---

## Solution2 - Array

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |

lc上慢很多， 用了新的array

---

#### note

---

#### code

```java
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int [] res = new int[A.length];
        int l = 0;
        int r = A.length - 1;
        for(int i = 0; i < A.length; i++ ){
            if(A[i] % 2 == 0){
                res[l] = A[i];
                l++;
            }else{
                res[r] = A[i];
                r--;
            }
        }
        return res;
    }
}
```

