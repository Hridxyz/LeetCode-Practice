/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        Boolean cycle = false;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast){
                cycle = true;
                break;
            }
        }
        slow = head;
        if(cycle){
        while (slow != fast){
            slow = slow.next;
            fast = fast.next;
        }
        }
        else {return null;}
        return slow;
    }
}