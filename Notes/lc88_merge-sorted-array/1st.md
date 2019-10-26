## Solution1

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(1)  |

void no extra space

---

#### note

**注意**

检查 nums2 还有剩余的情况

```java
  while( j >= 0) {
            nums1[k--] = nums2[j--];
 }
```



---

#### code

```java
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            }
            else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
        while( j >= 0) {
            nums1[k--] = nums2[j--];
        }
        
    }
}
```

---

## Follow up

如果一个数组很大，另外一个数组很小

* 用二分查找 小数组元素在大数组元素中的位置