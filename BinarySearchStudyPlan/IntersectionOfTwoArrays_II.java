/*

350. Intersection of Two Arrays II
Easy

4486

710

Add to List

Share
Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.

 

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2,2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [4,9]
Explanation: [9,4] is also accepted.
 

Constraints:

1 <= nums1.length, nums2.length <= 1000
0 <= nums1[i], nums2[i] <= 1000
 
 
 */

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
         ArrayList<Integer> res=new ArrayList<>(); 
		HashMap<Integer,Integer> hm=new HashMap<>();
		for(int i=0;i<nums1.length;i++) {
			
				hm.put(nums1[i], hm.getOrDefault(nums1[i],0)+1);
			
		}
		for(int i=0;i<nums2.length;i++) {
			if(hm.containsKey(nums2[i])&& hm.get(nums2[i])>0) {
				res.add(nums2[i]);
				hm.put(nums2[i],hm.getOrDefault(nums2[i],0)-1 );
			}
			
			
		}
		
		int result[]=new int[res.size()];
    	int p=0;
    	for(int y:res) {
    		result[p]=y;
    		p++;
    		
    	}
    	return result;
    }
}
