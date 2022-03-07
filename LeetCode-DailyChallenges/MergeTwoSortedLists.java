/*

You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      ListNode sentinel = new ListNode(); 
        ListNode lastAdded = sentinel; 
       while(l1 != null && l2 != null){
           ListNode smaller =  l1.val < l2.val ? l1:l2;
           lastAdded.next = smaller; 
           if(smaller == l1) l1 = l1.next; 
           else l2 = l2.next; 
           lastAdded = smaller; 
           lastAdded.next = sentinel; 
       }
        lastAdded.next = l1 == null ? l2:l1; 
        return sentinel.next; 
       
    }
}
