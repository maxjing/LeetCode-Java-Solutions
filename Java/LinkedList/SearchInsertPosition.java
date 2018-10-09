/**
35. Search Insert Position
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Example 1:

Input: [1,3,5,6], 5
Output: 2
Example 2:

Input: [1,3,5,6], 2
Output: 1
Example 3:

Input: [1,3,5,6], 7
Output: 4
Example 4:

Input: [1,3,5,6], 0
Output: 0
**/
public int searchInsert(int[] nums, int target) {
    int i = 0;
    while (i < nums.length - 1){
        if(nums[i] == target){
            return i;
        }else if(nums[i] < target && nums[i+1] >= target){
            return i + 1;
        }
        i++;
    }
    if(nums[i] < target){
        return i + 1;
    }else {
        return 0;
    }
}


public int searchInsert(int[] nums, int target) {
   int size = nums.length;
   if(nums[size - 1] < target){
       return size;
   }
   if(nums[0] >= target){
       return 0;
   }
   int high = size - 1;
   int low = 0;

   while(low <= high){
        int mid = (high + low)/2;
       if(nums[mid] == target){
           return mid;
       }else if(nums[mid] > target){
           high = mid - 1;
       }else{
           low = mid + 1;
       }
   }
   return low; // cause low+1 will over high, it is the right point
}
