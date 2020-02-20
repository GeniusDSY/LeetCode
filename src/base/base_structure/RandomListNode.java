package base.base_structure;

/**
 * @author :DengSiYuan
 * @date :2020/2/15 20:38
 * @desc : 基础结构——随机指针链表
 */
public class RandomListNode {

    public int val;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode() {}

    public RandomListNode(int val,RandomListNode next,RandomListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }

}
