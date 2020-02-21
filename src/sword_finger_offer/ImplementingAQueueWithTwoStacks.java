package sword_finger_offer;

import java.util.Stack;

/**
 * @author :DengSiYuan
 * @date :2020/2/21 11:22
 * @desc : 面试题09. 用两个栈实现队列
 * 【题目】
 *      用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 *      分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * 【示例】
 *      输入：
 *          ["CQueue","appendTail","deleteHead","deleteHead"]
 *          [[],[3],[],[]]
 *      输出：[null,null,3,-1]
 *      输入：
 *          ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 *          [[],[],[5],[2],[],[]]
 *      输出：[null,-1,null,null,5,2]
 * 【提示】
 *      1、1 <= values <= 10000
 *      2、最多会对 appendTail、deleteHead 进行 10000 次调用
 */
public class ImplementingAQueueWithTwoStacks {

    Stack<Integer> stack1;
    Stack<Integer> stack2;
    int size;

    /**
     * 【复杂度分析】
     *      插入元素
     *          时间复杂度：O(n)。插入元素时，对于已有元素，每个元素都要弹出栈两次，压入栈两次，因此是线性时间复杂度。
     *          空间复杂度：O(n)。需要使用额外的空间存储已有元素。
     *      删除元素
     *      时间复杂度：O(1)。判断元素个数和删除队列头部元素都使用常数时间。
     *      空间复杂度：O(1)。从第一个栈弹出一个元素，使用常数空间。
     */
    public ImplementingAQueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        size = 0;
    }

    public void appendTail(int value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        size++;
    }

    public int deleteHead() {
        if (size == 0) {
            return -1;
        }
        size--;
        return stack1.pop();
    }

}
