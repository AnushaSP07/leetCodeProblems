/*

69. Sqrt(x)
Easy

3843

3207

Add to List

Share
Given a non-negative integer x, compute and return the square root of x.

Since the return type is an integer, the decimal digits are truncated, and only the integer part of the result is returned.

Note: You are not allowed to use any built-in exponent function or operator, such as pow(x, 0.5) or x ** 0.5.

 

Example 1:

Input: x = 4
Output: 2
Example 2:

Input: x = 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since the decimal part is truncated, 2 is returned.

*/

class Solution {
    public int mySqrt(int x) {
        long low =0 ,high = x/2 +1;

       while(low<=high){
         long mid = low + (high-low)/2;
         if(mid*mid==x)
           return (int)mid;
        else if(mid*mid>x && (mid-1)*(mid-1)<x)
           return (int)mid-1;
         else if(mid*mid>x)
           high = mid-1;
         else 
           low = mid+1;
       }
      return -1;
    }
}
