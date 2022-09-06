/*

814. Binary Tree Pruning
Medium

3653

96

Add to List

Share
Given the root of a binary tree, return the same tree where every subtree (of the given tree) not containing a 1 has been removed.

A subtree of a node node is node plus every node that is a descendant of node.

 

Example 1:


Input: root = [1,null,0,0,1]
Output: [1,null,0,null,1]
Explanation: 
Only the red nodes satisfy the property "every subtree not containing a 1".
The diagram on the right represents the answer.
Example 2:


Input: root = [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]
Example 3:


Input: root = [1,1,0,1,1,0,1,0]
Output: [1,1,0,1,1,null,1]
 
 
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node) {
        if (node == null) return false;
        
        // Check if any node in the left subtree contains a 1.
        boolean leftContainsOne = containsOne(node.left);
        
        // Check if any node in the right subtree contains a 1.
        boolean rightContainsOne = containsOne(node.right);

        // If the left subtree does not contain a 1, prune the subtree.
        if (!leftContainsOne) node.left = null;
        
        // If the right subtree does not contain a 1, prune the subtree.
        if (!rightContainsOne) node.right = null;
        
        // Return true if the current node, its left or right subtree contains a 1.
        return node.val == 1 || leftContainsOne || rightContainsOne;
    }
}
