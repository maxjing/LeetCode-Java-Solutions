/**
141. Linked List Cycle
Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
**/
public boolean hasCycle(ListNode head) {
    if(head == null) return false;
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
        if(slow == fast){
            return true;
        }
        slow = slow.next;
        fast = fast.next.next;
    }
    return false;
}