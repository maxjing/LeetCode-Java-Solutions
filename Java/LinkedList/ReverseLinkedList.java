/**
206. Reverse Linked List
Reverse a singly linked list.

Example:

Input: 1->2->3->4->5->NULL
Output: 5->4->3->2->1->NULL

 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

public ListNode reverseList(ListNode head) {
    Stack<Integer> container = new Stack<>();
    ListNode temp = head;
    while(temp != null){
        container.push(temp.val);
        temp = temp.next;
    }
    ListNode res = new ListNode(-1);
    ListNode dummy = res;
    int size = container.size();
    for(int i = 0; i < size; i++){
        dummy.next = new ListNode(container.pop());
        dummy = dummy.next;
    }
    return res.next;
}

public ListNode reverseList(ListNode head) {
    if(head == null)
        return null;
    
    ListNode nextNode = head.next;
    head.next = null;
    while(nextNode != null){
        ListNode tempNode = nextNode.next;
        nextNode.next = head;
        head = nextNode;
        nextNode = tempNode;         
    }
    return head;
}