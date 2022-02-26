/*

Given two non-negative integers low and high. Return the count of odd numbers between low and high (inclusive).

 

Example 1:

Input: low = 3, high = 7
Output: 3
Explanation: The odd numbers between 3 and 7 are [3,5,7].
Example 2:

Input: low = 8, high = 10
Output: 1
Explanation: The odd numbers between 8 and 10 are [9].

*/

class Solution {
    public double average(int[] salary) {
        
//         Arrays.sort(salary);
//         double avg = 0;
        
//         if(salary.length == )
//         for(int i = 1; i < salary.length-2; i++){
//             avg = salary[i]+salary[i+1];
//             avg = avg/2;
//         }
//         return avg;
        
        int sum = 0;
        int n = salary.length;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < salary.length; i++) {
            sum += salary[i];
            min = Math.min(min, salary[i]);
            max = Math.max(max, salary[i]);
        }
        sum -= min + max;
        return (double) sum / (n - 2);
    }
}
