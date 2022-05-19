/*

852. Peak Index in a Mountain Array
Easy

2681

1638

Add to List

Share
Let's call an array arr a mountain if the following properties hold:

arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... arr[i-1] < arr[i]
arr[i] > arr[i+1] > ... > arr[arr.length - 1]
Given an integer array arr that is guaranteed to be a mountain, return any i such that arr[0] < arr[1] < ... arr[i - 1] < arr[i] > arr[i + 1] > ... > arr[arr.length - 1].

 

Example 1:

Input: arr = [0,1,0]
Output: 1
Example 2:

Input: arr = [0,2,1,0]
Output: 1
Example 3:

Input: arr = [0,10,5,2]
Output: 1
 

Constraints:

3 <= arr.length <= 104
0 <= arr[i] <= 106
arr is guaranteed to be a mountain array.

*/

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
       
        int start = 0;
        int end = arr.length - 1;
        
        while(start < end){
            int mid = start + (end - start)/2;
            if(arr[mid] > arr[mid+1]){
                end = mid;
        // here in ascending order of array
        // this may be ans but look at left e.i why end != mid -1
            }else{
        // you are in asc part of arry
                start = mid + 1;// bcz we know that mid+1 element is > mid element
                
            }
        }
        // in the end start == end & pointing to the largest number bcz of the 2 checks above
        // start and end are always trying to find the max element in the above 2 checks
        // hence, when they are pointing to just one element, that is the max bcz that is what the check say
        //more elboration: at every point of time of start and end they have the best possible ans till that time
        // if we are saying that only one item is remaining, hence bcz of above line that is the best possible solution
        return start;// or return end as both are equal
    }
}
