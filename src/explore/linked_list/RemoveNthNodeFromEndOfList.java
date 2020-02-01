package explore.linked_list;

import base.ListNode;

import java.util.Stack;

/**
 * @author :DengSiYuan
 * @date :2020/2/1 22:02
 * @desc : 19.删除链表的倒数第N个节点
 * 【题目】
 *      给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * 【示例】
 *      给定一个链表: 1->2->3->4->5, 和 n = 2.
 *      当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 【说明】
 *      给定的 n 保证是有效的。
 * 【进阶】
 *      你能尝试使用一趟扫描实现吗？
 */
public class RemoveNthNodeFromEndOfList {
    /**
     * 【解法一】 栈
     *      第一个想到的方法当然是栈，先入栈，再根据倒数的第几个节点进行出栈删除
     * 【复杂度】
     *      时间复杂度：O(N)
     *      空间复杂度: O(1)
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        Stack<ListNode> stack = new Stack<>();
        ListNode node = head;
        while (node != null){
            stack.push(node);
            node = node.next;
        }
        if (n == stack.size()){
            head = head.next;
            return head;
        }
        int i = 1;
        while (i < n){
            stack.pop();
            i++;
        }
        ListNode currNode = stack.pop();
        ListNode preNode = stack.pop();
        preNode.next = currNode.next;
        return head;
    }

    /**
     * 【解法二】    双指针一次遍历
     *      第一个指针从列表的开头向前移动 n+1 步，而第二个指针将从列表的开头出发。现
     *      在，这两个指针被 n 个结点分开。我们通过同时移动两个指针向前来保持这个恒定的间隔，直
     *      到第一个指针到达最后一个结点。此时第二个指针将指向从最后一个结点数起的第 n 个结点。
     *      我们重新链接第二个指针所引用的结点的 next 指针指向该结点的下下个结点。
     * 【复杂度】
     *      时间复杂度：O(N)
     *      空间复杂度：O(1)
     */
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        // Advances first pointer so that the gap between first and second is n nodes apart
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }
        // Move first to the end, maintaining the gap
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}
