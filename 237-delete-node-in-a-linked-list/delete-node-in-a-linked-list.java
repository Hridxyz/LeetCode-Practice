/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) {
            throw new IllegalArgumentException("Invalid node to delete.");
        }

        // Copy the value from the next node to the current node
        node.val = node.next.val;

        // Bypass the next node
        node.next = node.next.next;
    }

    
}