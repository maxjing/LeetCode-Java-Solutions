/**
2. Add Two Numbers
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.
**/
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int sum = 0;
        int remainder = 0;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
            carry = sum / 10;
            remainder = sum % 10;
            head.next = new ListNode(remainder);
            l1 = (l1 != null ? l1.next : null);
            l2 = (l2 != null ? l2.next : null);
            head = head.next;
        }
        return res.next;
    }