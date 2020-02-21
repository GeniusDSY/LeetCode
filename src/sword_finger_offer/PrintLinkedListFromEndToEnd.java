package sword_finger_offer;

import base.base_structure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author :DengSiYuan
 * @date :2020/2/21 9:38
 * @desc :面试题06.从尾到头打印链表
 *【题目】
 *      输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *【示例】
 *      输入：head = [1,3,2]
 *      输出：[2,3,1]
 *【限制】
 *      0 <= 链表长度 <= 10000
 */
public class PrintLinkedListFromEndToEnd {

    /**
     * 【解法一】    栈
     *      - 创建一个栈，用于存储链表的节点
     *      - 创建一个指针，初始时指向链表的头节点
     *      - 当指针指向的元素非空时，重复下列操作：
     *          - 将指针指向的节点压入栈内
     *          - 将指针移到当前节点的下一个节点
     *      - 获得栈的大小 size，创建一个数组 print，其大小为 size
     *      - 创建下标并初始化 index = 0
     *      - 重复 size 次下列操作：
     *          - 从栈内弹出一个节点，将该节点的值存到 print[index]
     *          - 将 index 的值加 1
     *      - 返回 print
     * 【复杂性分析】
     *      时间复杂度：O(n)。正向遍历一遍链表，然后从栈弹出全部节点，等于又反向遍历一遍链表。
     *      空间复杂度：O(n)。额外使用一个栈存储链表中的每个节点。
     */
    public int[] reversePrint1(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode temp = head;
        while (temp != null) {
            stack.push(temp);
            temp = temp.next;
        }
        int size = stack.size();
        int[] print = new int[size];
        for (int i = 0; i < size; i++) {
            print[i] = stack.pop().val;
        }
        return print;
    }

    ArrayList<Integer> tmp = new ArrayList<Integer>();

    /**
     * 【解法二】        递归
     *      递推阶段： 每次传入 head.next ，以 head == null（即走过链表尾部节点）为递归终止条件，此时直接返回。
     *      回溯阶段： 层层回溯时，将当前节点值加入列表，即tmp.add(head.val)。
     *      最终，将列表 tmp 转化为数组 res ，并返回即可。
     * 【复杂度分析】
     *      时间复杂度 O(N)： 遍历链表，递归 N 次。
     *      空间复杂度 O(N)： 系统递归需要使用 O(N) 的栈空间。
     */
    public int[] reversePrint2(ListNode head) {
        recur(head);
        int[] res = new int[tmp.size()];
        for(int i = 0; i < res.length; i++){
            res[i] = tmp.get(i);
        }
        return res;
    }
    private void recur(ListNode head) {
        if(head == null){
            return;
        }
        recur(head.next);
        tmp.add(head.val);
    }
}
