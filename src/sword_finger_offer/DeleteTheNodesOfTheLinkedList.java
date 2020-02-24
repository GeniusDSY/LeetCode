package sword_finger_offer;

import base.base_structure.ListNode;

/**
 * @author :DengSiYuan
 * @date :2020/2/24 11:50
 * @desc : 面试题18. 删除链表的节点
 * 【题目】
 *      给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 *      返回删除后的链表的头节点。
 *【示例】
 *      输入: head = [4,5,1,9], val = 5
 *      输出: [4,1,9]
 *      解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 *
 *      输入: head = [4,5,1,9], val = 1
 *      输出: [4,5,9]
 *      解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
 *【说明】
 *      1、题目保证链表中节点的值互不相同
 *      2、若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
 */
public class DeleteTheNodesOfTheLinkedList {

    /**
     * 【解法】
     *      1、判断是否头节点需要删除（特殊节点单独考虑）
     *      2、进行遍历判断是否为删除节点
     *      3、进行节点的删除
     * 【复杂度分析】
     *      时间复杂度：O(N)
     *      空间复杂度：O(1)
     */
    public ListNode deleteNode(ListNode head, int val) {
        if (head.val == val){
            return head.next;
        }
        ListNode node = head;
        while (node.next != null){
            if (node.next.val == val) {
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }
}
