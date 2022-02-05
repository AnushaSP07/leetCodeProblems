/*

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

 

Example 1:

Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6
Example 2:

Input: lists = []
Output: []
Example 3:

Input: lists = [[]]
Output: []

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
    public ListNode mergeKLists(ListNode[] lists) {
         if(lists == null || lists.length == 0) return null;
        
        ListNode head = new ListNode(0); // dummy node head
        ListNode temp = head; // taking into temporary variable
        List<Integer> l = new ArrayList<>();
        for(ListNode list : lists){ // adding all the values in the list
            while(list != null){
                l.add(list.val);
                list = list.next;
            }
        }
        Collections.sort(l); // sorting that list we get above
        for(int val : l){ // iterating over the list & creating new single linked list
            temp.next = new ListNode(val);
            temp = temp.next;
        }
        return head.next;
        
    }
}
