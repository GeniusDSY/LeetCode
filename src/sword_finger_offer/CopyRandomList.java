package sword_finger_offer;

import base.base_structure.RandomListNode;

import java.util.HashMap;

/**
 * @author :DengSiYuan
 * @date :2020/5/7 16:39
 * @desc :
 * 【题目】     面试题35. 复杂链表的复制
 *      请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，
 *      还有一个 random 指针指向链表中的任意节点或者 null。
 * 【示例】
 *      输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *      输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 *      输入：head = [[1,1],[2,1]]
 *      输出：[[1,1],[2,1]]
 *
 *      输入：head = [[3,null],[3,0],[3,null]]
 *      输出：[[3,null],[3,0],[3,null]]
 *
 *      输入：head = []
 *      输出：[]
 *      解释：给定的链表为空（空指针），因此返回 null。
 * 【提示】
 *      -10000 <= Node.val <= 10000
 *      Node.random 为空（null）或指向链表中的节点。
 *      节点数目不超过 1000 。
 */
public class CopyRandomList {

    //访问字典将旧节点引用作为“键”，将新节点引用作为“值”
    HashMap<RandomListNode, RandomListNode> visited = new HashMap<>();

    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) {
            return null;
        }

        RandomListNode oldNode = head;

        //创建新的头节点。
        RandomListNode newNode = new RandomListNode(oldNode.val,null,null);
        this.visited.put(oldNode, newNode);

        //迭代链表，直到克隆所有节点。
        while (oldNode != null) {
            //获取随机指针和下一个指针引用的节点的克隆。
            newNode.random = this.getClonedNode(oldNode.random);
            newNode.next = this.getClonedNode(oldNode.next);

            //在链接列表中向前移动一步。
            oldNode = oldNode.next;
            newNode = newNode.next;
        }
        return this.visited.get(head);
    }

    public RandomListNode getClonedNode(RandomListNode node) {
        //如果该节点存在，则
        if (node != null) {
            //检查节点是否在访问字典中
            if (this.visited.containsKey(node)) {
                //如果它在访问的字典中，则从字典中返回新的节点引用
                return this.visited.get(node);
            } else {
                //否则，创建一个新节点，添加到字典中并返回
                this.visited.put(node, new RandomListNode(node.val, null, null));
                return this.visited.get(node);
            }
        }
        return null;
    }

}
