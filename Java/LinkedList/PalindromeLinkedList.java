/**
234. Palindrome Linked List
Given a singly linked list, determine if it is a palindrome.

Example 1:

Input: 1->2
Output: false
Example 2:

Input: 1->2->2->1
Output: true
**/

public static boolean isPalindrome(ListNode head) {
      ListNode s = head;
      ListNode f = head;
      while(f != null && f.next != null){
          s = s.next;
          f = f.next.next;
      }
      s = reverse(s);
      f= head;
      while(s != null){
          if(s.val != f.val){
              return false;
          }
          s = s.next;
          f = f.next;
      }
      return true;


}

public static ListNode reverse(ListNode head){
      ListNode prev = null;
        while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
}