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
    public int pairSum(ListNode head) {

        ListNode slow = head, fast = head, prev = null;
        /**
        a - > b
        */

        

        while(fast != null) {
            fast = fast.next.next;
            ListNode temp = slow.next;
            slow.next = prev;
            prev = slow;
            slow = temp;

            System.out.println(slow.val);
        }

        int sum = Integer.MIN_VALUE;

        while(slow != null) {
            sum = Math.max(sum, slow.val + prev.val);

            slow = slow.next;
            prev = prev.next;
        }

        return sum;     
    }
}