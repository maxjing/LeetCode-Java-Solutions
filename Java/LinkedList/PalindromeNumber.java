/**
9. Palindrome Number
Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Example 1:

Input: 121
Output: true
Example 2:

Input: -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
Example 3:

Input: 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
**/
public boolean isPalindrome(int x) {
    if(x < 0){
        return false;
    }
    char[] c = Integer.toString(x).toCharArray();
    int low = 0;
    int high = c.length - 1;
    while(low < high){
        if(c[low] != c[high]){
            return false;
        }
        low ++;
        high --;
    }
    return true;
}

public static boolean isPalindrome(int x) {
    if(x < 0){
        return false;
    }
    int y = 0;
    int temp = x;
    while(temp > 0){
        y = y * 10 + temp%10;
        temp /= 10;
    }
    return x == y;
}