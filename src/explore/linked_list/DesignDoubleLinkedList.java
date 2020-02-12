package explore.linked_list;

import base.base_structure.DoubleListNode;

/**
 * @author :DengSiYuan
 * @date :2020/2/12 11:10
 * @desc : 707.设计链表（双链表）
 */
public class DesignDoubleLinkedList {

    int size;
    DoubleListNode head, tail;
    public DesignDoubleLinkedList() {
        size = 0;
        head = new DoubleListNode(0);
        tail = new DoubleListNode(0);
        head.next = tail;
        tail.prev = head;
    }


    /**
     * 获取链表中第index个节点的值。如果索引无效，则返回-1
     * @param index
     * @return
     */
    public int get(int index) {
        //如果索引无效
        if (index < 0 || index >= size) return -1;

        //选择最快的方法：从头开始或从尾部移动
        DoubleListNode curr = head;
        if (index + 1 < size - index)
            for(int i = 0; i < index + 1; ++i) {
                curr = curr.next;
            }
        else {
            curr = tail;
            for(int i = 0; i < size - index; ++i) {
                curr = curr.prev;
            }
        }
        return curr.val;
    }



    /**
     * 在链接列表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链接的lis的第一个节点。
     * @param val
     */
    public void addAtHead(int val) {
        addAtIndex(0,val);
    }

    /**
     * 将值val的节点追加到链接列表的最后一个元素。
     * @param val
     */
    public void addAtTail(int val) {
        addAtIndex(size - 1, val);
    }

    /**
     * 在链接列表的第index个节点之前添加一个值为val的节点。如果index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果索引大于长度，则不会插入该节点.
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        //如果索引大于长度，不会插入该节点。
        if (index > size) {
            return;
        }
        //[太奇怪了]如果index为负，则该节点将插入列表的开头.
        if (index < 0) index = 0;
        //查找要添加的节点的前任和后任
        DoubleListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for(int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next;
        }else {
            succ = tail;
            for (int i = 0; i < size - index; ++i) succ = succ.prev;
            pred = succ.prev;
        }
        //插入本身
        ++size;
        DoubleListNode toAdd = new DoubleListNode(val);
        toAdd.prev = pred;
        toAdd.next = succ;
        pred.next = toAdd;
        succ.prev = toAdd;
    }

    /**
     * 如果索引有效，则删除链接列表中的第index个节点.
     * @param index
     */
    public void deleteAtIndex(int index) {
        //如果索引无效，则不执行任何操作
        if (index < 0 || index >= size) return;

        //查找要删除的节点的前任和后任
        DoubleListNode pred, succ;
        if (index < size - index) {
            pred = head;
            for(int i = 0; i < index; ++i) pred = pred.next;
            succ = pred.next.next;
        }
        else {
            succ = tail;
            for (int i = 0; i < size - index - 1; ++i) succ = succ.prev;
            pred = succ.prev.prev;
        }

        //删除pred.next
        --size;
        pred.next = succ;
        succ.prev = pred;
    }

}
