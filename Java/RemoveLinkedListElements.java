/**
203. Remove Linked List Elements
Remove all elements from a linked list of integers that have value val.

Example:

Input:  1->2->6->3->4->5->6, val = 6
Output: 1->2->3->4->5
**/

public ListNode removeElements(ListNode head, int val) {
    if (head == null) return null;
    head.next = removeElements(head.next, val);
    return head.val == val ? head.next : head;
}

public ListNode removeElements(ListNode head, int val) {
    ListNode temp = new ListNode(-1);
    temp.next = head;
    ListNode pre = temp;
    ListNode cur = temp.next;
    while(cur != null){
        if(cur.val == val){
            pre.next = cur.next;
        }else {
            pre = pre.next;
        }
        cur = cur.next;
    }
    return temp.next;
}

public ListNode removeElements(ListNode head, int val) {
	ListNode slow = head, fast = head;
	while(fast != null && fast.next != null){
		slow = slow.next;
		fast = fast.next.next;
	}
	return slow;
}