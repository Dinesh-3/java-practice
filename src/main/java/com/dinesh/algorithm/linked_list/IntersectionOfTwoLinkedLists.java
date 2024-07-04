package com.dinesh.algorithm.linked_list;

/**
 *
 * 160. Intersection of Two Linked Lists
 * https://leetcode.com/problems/intersection-of-two-linked-lists
 *
 * https://takeuforward.org/strivers-a2z-dsa-course/strivers-a2z-dsa-course-sheet-2/
 *
 */
public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode first = headA;
        ListNode second = headB;

        while(first != second) {
            first = first == null ? headB: first.next;
            second = second == null ? headA: second.next;
        }

        return first;

    }
}
