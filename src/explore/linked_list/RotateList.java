package explore.linked_list;

import base.base_structure.ListNode;

/**
 * @author :DengSiYuan
 * @date :2020/2/28 11:11
 * @desc :61. 旋转链表
 * 【题目】
 *      给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * 【示例】
 *      输入: 1->2->3->4->5->NULL, k = 2
 *      输出: 4->5->1->2->3->NULL
 *      解释:
 *          向右旋转 1 步: 5->1->2->3->4->NULL
 *          向右旋转 2 步: 4->5->1->2->3->NULL
 *
 *      输入: 0->1->2->NULL, k = 4
 *      输出: 2->0->1->NULL
 *      解释:
 *          向右旋转 1 步: 2->0->1->NULL
 *          向右旋转 2 步: 1->2->0->NULL
 *          向右旋转 3 步: 0->1->2->NULL
 *          向右旋转 4 步: 2->0->1->NULL
 */
public class RotateList {

    /**
     * 【解法一】    快慢指针
     *      1、求出链表长度，算出需要反转的位置
     *      2、快指针先前行k步，之后快慢指针一起动
     *      3、当快指针到达末尾，慢指针当前节点即为切断处（新的头节点）
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0){
            return head;
        }
        k = k % getLength(head);
        ListNode fastNode = head,slowNode = head;
        while (k-- > 0){
            if (fastNode.next == null){
                fastNode = head;
            }else {
                fastNode = fastNode.next;
            }
        }
        while (fastNode.next != null){
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        fastNode.next = head;
        head = slowNode.next;
        slowNode.next = null;
        return head;
    }

    private int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        return 1 + getLength(head.next);
    }


}
