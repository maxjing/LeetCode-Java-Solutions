## Solution1 - Two Pointer

#### complexity

| time | space |
| ---- | ----- |
| O(n) | O(1)  |

两个pointer 一个在左 一个在右 扫一遍 只需要O(n)

---

#### note

两个pointer 在首位， 哪边低往哪边灌水， 同时记录和replace下maxLeft 和 maxRight

---

#### code

```java
class Solution {
    public int trap(int[] height) {
        int res = 0;
        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        
        while(left < right) {
            if(height[left] < height[right]) {
                if(height[left] > maxLeft) {
                    maxLeft = height[left];
                }else {
                    res += maxLeft - height[left];
                }
                left++;
            }
            else{
                if(height[right] > maxRight){
                    maxRight = height[right];
                }else{
                    res += maxRight - height[right];
                }
                right--;
            }
        }
        return res;
        
    }
}
```

---

## Follow Up

* 如果某个bar高度为0就无法存水
  * 