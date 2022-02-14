/*

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

 

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4
 
 
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        
       if (nums == null || nums.length == 0 || nums[0] >= target) {
            return 0;
        }
        if (nums[nums.length-1] < target) {
            return nums.length;
        }
        int start = 0;
        int end = nums.length-1;
        
        while (start + 1 < end) {
            int mid = start + (end - start)/2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid; 
            } else {
                start = mid;
            }
        }
        
        if (nums[end] < target) { //target greater than right bound
            return end+1;
        } else if (nums[start] > target) { // target less than left bound
            return start - 1;
        } else { //target between left and right bound
            return start + 1;
        }
    }
}
