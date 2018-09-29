/**
21. Merge Two Sorted Lists
DescriptionHintsSubmissionsDiscussSolution
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4
**/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       if(l1 == null && l2 == null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else {
            ListNode listNode = new ListNode(0);
            ListNode temp = listNode;
            ListNode a1 = l1;
            ListNode a2 = l2;
            while(a1 != null && a2 != null){
                if(a1.val <= a2.val){
                    temp.next = a1;
                    a1 = a1.next;
                } else {
                    temp.next = a2;
                    a2 = a2.next;
                }
                temp = temp.next;
            }
            if(a1 == null){
                temp.next = a2;
            }else {
                temp.next = a1;
            }
            return listNode.next;
        }    
    }
}