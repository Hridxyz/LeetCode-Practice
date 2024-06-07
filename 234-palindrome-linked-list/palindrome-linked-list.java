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
    public boolean isPalindrome(ListNode head) {
        
        
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow;
        ListNode prev = null;
        ListNode next;
        while(mid != null){
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;
        }
        ListNode left = head;
        ListNode right = prev;
        while(left != null && right != null){
            if(left.val != right.val){
                return false;
            }
            left = left.next;
            right = right.next;
            
        }
        return true;
    }
}