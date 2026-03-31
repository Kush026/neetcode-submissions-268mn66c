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

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode head = lists[0];

        for(int i = 1; i < lists.length; i++) {
            head = combine(head, lists[i]);
        }

        return head;
    }

    private ListNode combine(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        ListNode head;

        if(node1.val > node2.val) {
            head = node2;
            node2 = node2.next;
        }
        else {
            head = node1;
            node1 = node1.next;
        }

        ListNode tail = head;

        while (node1 != null && node2 != null) {
            if(node1.val > node2.val) {
                tail.next = node2;
                node2 = node2.next;
            }
            else {
                tail.next = node1;
                node1 = node1.next;
            }

            tail = tail.next;
        }

        if (node1 != null) {
            tail.next = node1;
        }
        else if (node2 != null) {
            tail.next = node2;
        }

        return head;
    }
}
