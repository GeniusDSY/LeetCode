package explore.linked_list;

import base.base_structure.ListNode;

/**
 * @author :DengSiYuan
 * @date :2020/1/13 21:36
 * @desc : 160.相交链表
 * 【题目】
 *      编写一个程序，找到两个单链表相交的起始节点。
 *      如下面的两个链表：
 *      A:     a1->a2
 *                  \
 *                   c1->c2->c3
 *                  /
 *      B: b1->b2->b3
 *      在节点 c1 开始相交。
 * 【示例】
 *      A:     4->1
 *                 \
 *                  8->4->5
 *                 /
 *      B: 5->0->1
 *      在节点 8 开始相交。
 *      输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 *      输出：Reference of the node with value = 8
 *      输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。
 *      从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。
 * 【注意】
 *      如果两个链表没有交点，返回 null.
 *      在返回结果后，两个链表仍须保持原有的结构。
 *      可假定整个链表结构中没有循环。
 *      程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
public class IntersectionOfTwoLinkedLists {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
