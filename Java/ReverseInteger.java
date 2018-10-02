/**
7. Reverse Integer
DescriptionHintsSubmissionsDiscussSolution
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
**/
public int reverse(int x) {
    boolean isNegative = false;
    if(x > Integer.MAX_VALUE || x < Integer.MIN_VALUE || x==0){
        return 0;
    }else {
        int trueNumber = x;
        if(x < 0){
            trueNumber = x - 2*x;
            isNegative = true;
        }
        StringBuilder sb = new StringBuilder();
        while(trueNumber > 0){
            sb.append( trueNumber % 10);
            trueNumber /= 10;
        }
        int res;
        try{
            res = new Integer(sb.toString());
        }catch (NumberFormatException e){
            return 0;
        }
        return isNegative ? res - 2* res : res;
    }
}

//better one
public int reverse(int x) {
    long y=0;
    while(x!=0)
    {
        y=y*10 + x%10;
        x=x/10;
    if(y>Integer.MAX_VALUE || y<Integer.MIN_VALUE){
        return 0;
        }
    }     
    return (int)y;
}