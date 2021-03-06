/*

665. Non-decreasing Array
Medium

3773

671

Add to List

Share
Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.

We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).

 

Example 1:

Input: nums = [4,2,3]
Output: true
Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
Example 2:

Input: nums = [4,2,1]
Output: false
Explanation: You can't get a non-decreasing array by modify at most one element.

*/

class Solution {
    public boolean checkPossibility(int[] nums) {
        for (int i=1, modified=0, prev = nums[0]; i<nums.length; i++) {
            if (nums[i] < prev) {
                if (modified++ == 1) return false;
                if (i>=2 && nums[i-2] > nums[i]) continue;
            }
            prev = nums[i];
        }
        return true;
    }
}
