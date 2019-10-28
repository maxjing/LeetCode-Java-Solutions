## Solution1 - Brute Force

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(n)  |



---

#### note

check boundary and lengh为1的array

---

#### code

```java
class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        if(nums.length == 1) {
            return 0;
        }
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                if(nums[i] > nums[i + 1]) {
                    return 0;
                }
            }
            else if(i == nums.length - 1) {
                if(nums[i] > nums[i - 1]) {
                    return i;
                }
            }else {
                if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]){
                    return i;
                }
            }
        }
        return -1;
    }
}
```

---

## Solution2 - Sequence Search 

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O()   |



---

#### note

因为只有一个peak 所以只要找到比后面的数大的数即可

---

#### code

```java
class Solution {
    public int findPeakElement(int[] nums) {
        for(int i = 1; i < nums.length; i ++)
        {
            if(nums[i] < nums[i-1])
            {
                return i-1;
            }
        }
        return nums.length-1;
    }
}
```



## Solution3 - Binary Seach

#### complexity

| time    | space |
| ------- | ----- |
| O(logn) | O(1)  |

对已知长度的array search space 是o(1), 通常tree 是不知道长度的

---

#### note

为什么binarysearch能在不是sort过的array work 呢？ 因为要么就一直在一个持续增长的half跑到尽头，要么就是停在一个dip，不管哪一种情况 都能找到唯一的peak

---

#### code

```java
//iterative
class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            if(low == high) {
                return low;
            }
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[mid + 1]) {
              //mid is inclusive, 有可能就是这个mid是peakr
                high = mid;
            }
            else {
                low = mid + 1;
            }
            
        }
        return -1;
    }
}
```

```java
//recursive
class Solution {
    public int findPeakElement(int[] nums) 
    {
        return helper(nums, 0, nums.length - 1);
    }
    
    public int helper(int[] nums, int low, int high) {
        if(low == high) {
            return low;
        }else {
            int mid1 = low + (high - low) / 2;
            int mid2 = mid1 + 1;
            if(nums[mid1] > nums[mid2]) {
                return helper(nums, low, mid1);
            }
            else {
                return helper(nums, mid2, high);
            }
        }
    }
};

```

