/*

29. Divide Two Integers
Medium

2824

9838

Add to List

Share
Given two integers dividend and divisor, divide two integers without using multiplication, division, and mod operator.

The integer division should truncate toward zero, which means losing its fractional part. For example, 8.345 would be truncated to 8, and -2.7335 would be truncated to -2.

Return the quotient after dividing dividend by divisor.

Note: Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For this problem, if the quotient is strictly greater than 231 - 1, then return 231 - 1, and if the quotient is strictly less than -231, then return -231.

 

Example 1:

Input: dividend = 10, divisor = 3
Output: 3
Explanation: 10/3 = 3.33333.. which is truncated to 3.
Example 2:

Input: dividend = 7, divisor = -3
Output: -2
Explanation: 7/-3 = -2.33333.. which is truncated to -2.

*/

class Solution {
   public int divide(int dividend, int divisor) {
        if(dividend==0){
            return 0;
        }
        int sign=1;
        if(dividend>0 && divisor<0){
            sign=-1;dividend*=-1;
        }
        else if(dividend<0 && divisor>0){
            sign=-1;divisor*=-1;
        }
        else if(dividend>0 && divisor>0){
            dividend*=-1;divisor*=-1;
        }
        int ans=iterDiv(dividend,divisor);
        if(ans<0){
            if(sign>0){
                return Integer.MAX_VALUE;
            }
            else{
                return Integer.MIN_VALUE;
            }
        }
        return ans*sign;
    }
    public int iterDiv(int dividend,int divisor){
        if(divisor<dividend){
            return 0;
        }
        int cnt=1;
        int divisorCopy=divisor;
        while((divisor<<1) <0 && (divisor<<1)>=dividend){
            cnt=cnt<<1;
            divisor=divisor<<1;
        }
        System.out.println(dividend+" "+divisor+" "+(dividend-divisor)+" "+divisorCopy);
        return cnt+iterDiv(dividend-divisor,divisorCopy);
    }
}
