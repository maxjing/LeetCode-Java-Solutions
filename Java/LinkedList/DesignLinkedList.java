/**
707. Design Linked List
Design your implementation of the linked list. You can choose to use the singly linked list or the doubly linked list. A node in a singly linked list should have two attributes: val and next. val is the value of the current node, and next is a pointer/reference to the next node. If you want to use the doubly linked list, you will need one more attribute prev to indicate the previous node in the linked list. Assume all nodes in the linked list are 0-indexed.

Implement these functions in your linked list class:

get(index) : Get the value of the index-th node in the linked list. If the index is invalid, return -1.
addAtHead(val) : Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
addAtTail(val) : Append a node of value val to the last element of the linked list.
addAtIndex(index, val) : Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
deleteAtIndex(index) : Delete the index-th node in the linked list, if the index is valid.
Example:

MyLinkedList linkedList = new MyLinkedList();
linkedList.addAtHead(1);
linkedList.addAtTail(3);
linkedList.addAtIndex(1, 2);  // linked list becomes 1->2->3
linkedList.get(1);            // returns 2
linkedList.deleteAtIndex(1);  // now the linked list is 1->3
linkedList.get(1);            // returns 3
Note:

All values will be in the range of [1, 1000].
The number of operations will be in the range of [1, 1000].
Please do not use the built-in LinkedList library.
**/


public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
public ListNode head;
public MyLinkedList() {
    ListNode head = null;
}


/** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
public int get(int index) {
    if(head == null){
        return -1;
    }
 
        ListNode runner = head;
        for(int i = 0; i < index ; i ++){
            if(runner.next != null){
                runner = runner.next;
            }else{
                return -1;
            }
        }
        return runner.val;
    
}

/** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
public void addAtHead(int val) {
    ListNode newHead = new ListNode(val);
    newHead.next = head;
    head = newHead;
}

/** Append a node of value val to the last element of the linked list. */
public void addAtTail(int val) {
    ListNode runner = head;
    while(runner.next  != null){
        runner = runner.next;
    }
    runner.next = new ListNode(val);
}

/** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
public void addAtIndex(int index, int val) {
    if(index == 0 && head == null){
        addAtHead(val);
    }else if(head== null && index != 0){
        return;
    }
    else{
        ListNode runner = head;
        for(int i = 0; i < index - 1; i ++){
            if(runner.next != null){
                runner = runner.next;
            }else{
                return;
            }
        }
        ListNode newNode = new ListNode(val);
        newNode.next = runner.next;
        runner.next = newNode;
    }
}

/** Delete the index-th node in the linked list, if the index is valid. */
public void deleteAtIndex(int index) {
    ListNode runner = head;
    if(head == null) return;
    if(index == 0){
        head = head.next;
    }
    else{
        for(int i = 0; i < index - 1; i ++){
            if(runner.next != null){
                runner = runner.next;
            }else{
                return;
            }
        }
          if(runner.next == null) return;
        runner.next = runner.next.next;
    }

}