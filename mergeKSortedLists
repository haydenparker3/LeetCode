/*
 * 23. Merge k Sorted Lists
 * LeetCode hard where instead of merging 2 sorted lists you merge k sorted lists.
 * increased difficulty because you have to find the which of the k pointers to add to the list
 * in log(n) runtime. PriorityQueue does this for you
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
    public ListNode mergeKLists(ListNode[] lists) {
        
        PriorityQueue<ListNode> p = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode n1, ListNode n2) {
                return Integer.compare(n1.val, n2.val);
            }
        });

        ListNode nHead = null;
        ListNode curr = null;
        
        for(int i = 0; i < lists.length; i++) { // adding starting pointers to queue
            if(lists[i] != null)
                p.add(lists[i]);
        }
        
        while(p.peek() != null) { // add to new list until all pointers finish
            ListNode add = p.poll(); // gets pointer to add in O(1) runtime
            if(add.next != null) // increment pointer
                p.add(add.next); // adds incremented pointer to priority queue in O(log(n)) runtime
            if(nHead == null) { // first ListNode made into the new head node
                nHead = add;
                curr = nHead;
            } else { // reuses ListNodes so your not actually "adding" to a new list
                curr.next = add;
                curr = curr.next;
            }
        }
        
        return nHead;
    }
}