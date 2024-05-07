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
    public ListNode removeNodes(ListNode head) {
        if (head == null) return null;
        
        // Reverse the linked list
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        // Now prev is the new head of the reversed linked list
        ListNode newHead = prev;
        
        // Filter nodes
        ListNode filteredHead = null;
        ListNode filteredTail = null;
        int max = Integer.MIN_VALUE;
        while (prev != null) {
            if (prev.val >= max) {
                max = prev.val;
                if (filteredHead == null) {
                    filteredHead = filteredTail = new ListNode(prev.val);
                } else {
                    filteredTail.next = new ListNode(prev.val);
                    filteredTail = filteredTail.next;
                }
            }
            prev = prev.next;
        }
        
        // Reverse the filtered list to restore original order
        prev = null;
        curr = filteredHead;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev; // This is the head of the modified linked list
    }
}
