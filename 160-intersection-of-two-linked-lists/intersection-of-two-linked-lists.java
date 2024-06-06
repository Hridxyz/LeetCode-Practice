public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        // Traverse both lists
        while (pointerA != pointerB) {
            // If pointerA reaches the end, reset it to headB
            if (pointerA == null) {
                pointerA = headB;
            } else {
                pointerA = pointerA.next;
            }

            // If pointerB reaches the end, reset it to headA
            if (pointerB == null) {
                pointerB = headA;
            } else {
                pointerB = pointerB.next;
            }
        }

        // Either both pointers meet at the intersection node or both are null
        return pointerA;
    }
}