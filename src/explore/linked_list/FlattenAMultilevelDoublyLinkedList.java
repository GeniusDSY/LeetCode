package explore.linked_list;

import base.base_structure.MultiLevelDoubleListNode;


/**
 * @author :DengSiYuan
 * @date :2020/2/12 17:44
 * @desc : 430.扁平化多级双向链表
 *【题目】
 *      您将获得一个双向链表，除了下一个和前一个指针之外，它还有一个子指针，可能指向单独的双向链表。
 *      这些子列表可能有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。
 *      扁平化列表，使所有结点出现在单级双链表中。您将获得列表第一级的头部。
 * 【示例】
 *      输入:
 *          1---2---3---4---5---6--NULL
 *                  |
 *                  7---8---9---10--NULL
 *                      |
 *                      11--12--NULL
 *      输出:
 *          1-2-3-7-8-11-12-9-10-4-5-6-NULL
 */
public class FlattenAMultilevelDoublyLinkedList {

    public MultiLevelDoubleListNode flatten(MultiLevelDoubleListNode head) {
        if (head == null) {
            return head;
        }
        // 伪头以确保prev指针永远不会为空
        MultiLevelDoubleListNode pseudoHead = new MultiLevelDoubleListNode(0, null, head, null);
        flattenDFS(pseudoHead, head);
        // 将伪头与真实头分离
        pseudoHead.next.prev = null;
        return pseudoHead.next;
    }
    /**
     * 返回扁平化列表的尾部
     */
    public MultiLevelDoubleListNode flattenDFS(MultiLevelDoubleListNode prev, MultiLevelDoubleListNode curr) {
        if (curr == null) {
            return prev;
        }
        curr.prev = prev;
        prev.next = curr;
        //curr.next将在递归函数中得到调整
        MultiLevelDoubleListNode tempNext = curr.next;
        MultiLevelDoubleListNode tail = flattenDFS(curr, curr.child);
        curr.child = null;
        return flattenDFS(tail, tempNext);
    }

}
