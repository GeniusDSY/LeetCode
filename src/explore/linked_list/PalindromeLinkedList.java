package explore.linked_list;

import base.base_structure.ListNode;

import java.util.*;

/**
 * @author :DengSiYuan
 * @date :2020/2/2 16:58
 * @desc :234.回文链表
 * 【题目】
 *      请判断一个链表是否为回文链表。
 *
 * 【示例】
 *      输入: 1->2
 *      输出: false
 *
 *      输入: 1->2->2->1
 *      输出: true
 *
 * 【进阶】
 *      你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class PalindromeLinkedList {
    /**
     * 【解法一】    数组双指针
     *      简单粗暴，全部遍历一遍装到数组中，首尾双指针进行解决
     * 【复杂度分析】
     *      时间复杂度：O(n)，其中 n 指的是链表的元素个数。
     *          第一步： 遍历链表并将值复制到数组中，O(n)。
     *          第二步：双指针判断是否为回文，执行了 O(n/2) 次的判断，即 O(n)。
     *          总的时间复杂度：O(n)。
     *      空间复杂度：O(n)，其中 nn 指的是链表的元素个数，我们使用了一个数组列表存放链表的元素值。
     */
    public boolean isPalindrome1(ListNode head) {
        List<Integer> vals = new ArrayList<>();

        // Convert LinkedList into ArrayList.
        ListNode currentNode = head;
        while (currentNode != null) {
            vals.add(currentNode.val);
            currentNode = currentNode.next;
        }

        // Use two-pointer technique to check for palindrome.
        int front = 0;
        int back = vals.size() - 1;
        while (front < back) {
            // Note that we must use ! .equals instead of !=
            // because we are comparing Integer, not int.
            if (!vals.get(front).equals(vals.get(back))) {
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) return false;
            if (currentNode.val != frontPointer.val) return false;
            frontPointer = frontPointer.next;
        }
        return true;
    }

    /**
     * 【解法二】    递归
     *      currentNode 指针是先到尾节点，由于递归的特性再从后往前进行比较。frontPointer 是递归函数外的指针。
     *      若 currentNode.val != frontPointer.val 则返回 false。反之，frontPointer 向前移动并返回 true。
     *      之所以起作用的原因是递归处理节点的顺序是相反的（记住上面打印的算法）。由于递归，从本质上，我们同时在正向和逆向迭代。
     * 【复杂度分析】
     *      时间复杂度：O(n)，其中 n 指的是链表的大小。
     *      空间复杂度：O(n)，其中 n 指的是链表的大小。
     */
    public boolean isPalindrome2(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }

    /**
     * 【解法三】
     *      避免使用 O(n) 额外空间的方法就是改变输入。
     *      我们可以将链表的后半部分反转（修改链表结构），然后将前半部分和后半部分进行比较。比较完成后我们应该将链表恢复原样。虽然不需要恢复也能通过测试用例，因为使用该函数的人不希望链表结构被更改。
     *      我们可以分为以下几个步骤：
     *          1、找到前半部分链表的尾节点。
     *          2、反转后半部分链表。
     *          3、判断是否为回文。
     *          4、恢复链表。
     *          5、返回结果。
     * 【复杂度分析】
     *      时间复杂度：O(n)，其中 n 指的是链表的大小。
     *      空间复杂度：O(1)，我们是一个接着一个的改变指针，我们在堆栈上的堆栈帧不超过 O(1)。
     */
    public boolean isPalindrome3(ListNode head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
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

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
