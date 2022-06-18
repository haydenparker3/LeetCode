/*
 * 25. Reverse Nodes in k-Group
 */

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode front = head; // head of section
        ListNode next = head; // head of next section
        ListNode prevf = null; // head of previous section (end of previous section since reversed)
        
        ListNode nhead = null; // new head
        
        while(front != null) { // atleast one section to reverse
            int nodes = 0; // nodes in section;
            while(nodes < k && next != null) { //counts nodes in next section
                nodes++;
                next = next.next;
            }
            // next ends up as the head of the next section
            
            if(nodes == k) { // only reverse sections with k nodes
                ListNode curr = front.next; // curr starts on second node
                ListNode prev = front; // previous node
                front.next = next; // front of section points to head of next section
                int index = 1; // starts with 1 node done

                while(index < nodes) { // reverses remainding nodes
                    ListNode ncurr = curr.next;
                    curr.next = prev;
                    prev = curr;
                    curr = ncurr;
                    index++;
                }

                if(nhead == null) // prev of first section is new head of list
                    nhead = prev;

                if(prevf != null) // end of previous section points to head of this section
                    prevf.next = prev;
            }
            
            prevf = front; // update previous front
            front = next; // update current front to next
        }
        
        return nhead; // return new head
    }
}
