/*

Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.

 

Example 1:


Input: heights = [2,1,5,6,2,3]
Output: 10
Explanation: The above is a histogram where width of each bar is 1.
The largest rectangle is shown in the red area, which has an area = 10 units.
Example 2:


Input: heights = [2,4]
Output: 4
 
 */

/**
 * @param {number[]} heights
 * @return {number}
 */
var largestRectangleArea = function(heights) {
    let maxArea = 0, n = heights.length, left, right;
    
    for(let i = 0; i < heights.length; i++) {
        left = i - 1;
        right = i + 1;
        while(left >= 0 && heights[left] >= heights[i]) left--;
        while(right < n && heights[right] >= heights[i]) right++;
        maxArea = Math.max(heights[i] * (right - left - 1), maxArea);
    }
    return maxArea;
};
