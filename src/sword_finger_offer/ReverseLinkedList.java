package sword_finger_offer;

import base.base_structure.ListNode;

/**
 * @author :DengSiYuan
 * @date :2019/11/23 19:48
 * @desc : 面试题24. 反转链表
 * 【题目】
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 【示例】
 *      输入: 1->2->3->4->5->NULL
 *      输出: 5->4->3->2->1->NULL
 * 【限制】
 *      0 <= 节点个数 <= 5000
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class ReverseLinkedList {

    /**
     * 【解法一】  迭代
     *      假设存在链表 1 → 2 → 3 → Ø，我们想要把它改成 Ø ← 1 ← 2 ← 3。
     *      在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，
     *      因此必须事先存储其前一个元素。在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！
     * 【复杂度分析】
     *      时间复杂度：O(n)，假设 n 是列表的长度，时间复杂度是 O(n)。
     *      空间复杂度：O(1)。
     */
    public ListNode reverseList1(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    /**
     * 【解法二】  递归
     *      递归版本稍微复杂一些，其关键在于反向工作。假设列表的其余部分已经被反转，现在我该如何反转它前面的部分？
     * 假设列表为：
     *      n1 -> ... -> nk-1 -> nk -> nk+1 -> ... -> nm -> Ø
     * 若从节点 nk+1 到 nm已经被反转，而我们正处于 nk
     *      n1 -> ... -> nk-1 -> nk -> nk+1 <- ... <- nm
     *  我们希望 nk+1的下一个节点指向 nk。
     *  所以，nk.next.next = nk
     * ​要小心的是 n1的下一个必须指向 Ø 。如果你忽略了这一点，你的链表中可能会产生循环。如果使用大小为 2 的链表测试代码，则可能会捕获此错误。
     * 【复杂度分析】
     *      时间复杂度：O(n)，假设 n 是列表的长度，那么时间复杂度为 O(n)。
     *      空间复杂度：O(n)，由于使用递归，将会使用隐式栈空间。递归深度可能会达到 n 层。
     */
    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode temp = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return temp;
    }

}
