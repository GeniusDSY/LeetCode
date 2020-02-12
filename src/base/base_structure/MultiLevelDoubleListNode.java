package base.base_structure;

/**
 * @author :DengSiYuan
 * @date :2020/2/12 17:46
 * @desc : 基础结构——多级双向链表
 */
public class MultiLevelDoubleListNode {

    public int val;
    public MultiLevelDoubleListNode prev;
    public MultiLevelDoubleListNode next;
    public MultiLevelDoubleListNode child;

    public MultiLevelDoubleListNode() {}

    public MultiLevelDoubleListNode(int val,MultiLevelDoubleListNode prev,MultiLevelDoubleListNode next,MultiLevelDoubleListNode child) {
        this.val = val;
        this.prev = prev;
        this.next = next;
        this.child = child;
    }

}
