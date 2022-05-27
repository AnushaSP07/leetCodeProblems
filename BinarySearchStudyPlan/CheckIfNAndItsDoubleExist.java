/*

1346. Check If N and Its Double Exist
Easy

952

122

Add to List

Share
Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).

More formally check if there exists two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
 

Example 1:

Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
Example 2:

Input: arr = [7,1,14,11]
Output: true
Explanation: N = 14 is the double of M = 7,that is, 14 = 2 * 7.
Example 3:

Input: arr = [3,1,7,11]
Output: false
Explanation: In this case does not exist N and M, such that N = 2 * M.

*/

 Arrays.sort(arr);
        
        int n = arr.length;
        for(int i=0; i<n; i++){
            int curr = arr[i];
            
            int st = 0, en = n-1;
            while(st<=en){
                int mid = en - (en-st)/2;
                if(arr[mid] == curr*2 && i != mid){
                    return true;
                } else if(arr[mid] > curr*2){
                    en = mid-1;
                } else{
                    st = mid+1;
                }
            }
        }
        
        return false;
    }
