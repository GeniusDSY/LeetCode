package explore.recursion_i;

import base.ListNode;

/**
 * @author :DengSiYuan
 * @date :2019/11/22 20:40
 * @desc : 24.两两交换链表中的节点
 * 【题目】
 *      给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *      你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * 【示例】
 *      给定 1->2->3->4, 你应该返回 2->1->4->3.
 */



public class SwapNodesInPairs {

    /**
     * 【解法一】
     *      非递归
     *      若使用非递归，即就是对链表进行遍历，两两进行位置的交换
     *      例：1 -> 2 -> 3 -> 4
     */
    public ListNode swapPairs1(ListNode head) {
        ListNode pre = new ListNode(0);
        pre.next = head;
        ListNode temp = pre;
        while(temp.next != null && temp.next.next != null) {
            //奇数节点（1）复制到（start）
            ListNode start = temp.next;
            //偶数节点（2）复制到（end）
            ListNode end = temp.next.next;
            //奇数节点赋值偶数节点（1变成2）
            temp.next = end;
            //奇数节点的next赋值偶数节点（start -> next = end -> next）
            start.next = end.next;
            //更新end节点
            end.next = start;
            //替换下一次循环的判断节点
            temp = start;
        }
        return pre.next;
    }

    /**
     * 【解法二】
     *      递归
     *      将奇数节点的next复制到下一次调用，而将偶数点的next指向奇数节点
     *
     */
    public ListNode swapPairs2(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs2(next.next);
        next.next = head;
        return next;
    }
}
