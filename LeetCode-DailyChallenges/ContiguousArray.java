/*

Given a binary array nums, return the maximum length of a contiguous subarray with an equal number of 0 and 1.

 

Example 1:

Input: nums = [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with an equal number of 0 and 1.
Example 2:

Input: nums = [0,1,0]
Output: 2
Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.

*/

class Solution {
    public int findMaxLength(int[] nums) {
         Map<Integer,Integer> m = new HashMap<>();
        m.put(0,-1);
        int max=0,count=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==0)
                count--;
            else
                count++;
            if(m.containsKey(count))
                max=Math.max(max, i-m.get(count));
            else
                m.put(count,i);
        }
        return max;
    }
}
