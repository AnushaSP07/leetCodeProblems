/*

You are given the head of a linked list, and an integer k.

Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).

 

Example 1:


Input: head = [1,2,3,4,5], k = 2
Output: [1,4,3,2,5]
Example 2:

Input: head = [7,9,6,6,7,8,3,0,9,5], k = 5
Output: [7,9,6,6,8,7,3,0,9,5]

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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode pNode = head;
        List<ListNode> nodeList = new ArrayList<>();
		// store these nodes.
        while (pNode != null) {
            nodeList.add(pNode);
            pNode = pNode.next;
        }

		// swap their values.
        int len = nodeList.size();
        int temp = nodeList.get(k - 1).val;
        nodeList.get(k - 1).val = nodeList.get(len - k).val;
        nodeList.get(len - k).val = temp;

        return head;
    }
}
