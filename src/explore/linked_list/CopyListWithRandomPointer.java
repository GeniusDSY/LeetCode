package explore.linked_list;

import base.base_structure.RandomListNode;

import java.util.HashMap;

/**
 * @author :DengSiYuan
 * @date :2020/2/15 20:45
 * @desc :138. 复制带随机指针的链表
 * 【题目】
 *      给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点或空节点。
 *      要求返回这个链表的 深拷贝。 
 *      我们用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 *          val：一个表示 Node.val 的整数。
 *          random_index：随机指针指向的节点索引（范围从 0 到 n-1）；如果不指向任何节点，则为  null 。
 * 【示例】
 *      输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *      输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 *      输入：head = [[1,1],[2,1]]
 *      输出：[[1,1],[2,1]]
 * 【提示】
 *      1、-10000 <= Node.val <= 10000
 *      2、Node.random 为空（null）或指向链表中的节点。
 *      3、节点数目不超过 1000 。
 */
public class CopyListWithRandomPointer {

    //HashMap将旧节点作为键，将新节点作为其值。
    HashMap<RandomListNode, RandomListNode> visitedHash = new HashMap<>();

    /**
     * 【解法一】    方法 1：回溯
     *      【想法】
     *          回溯算法的第一想法是将链表想象成一张图。链表中每个节点都有 2 个指针（图中的边）。
     *          因为随机指针给图结构添加了随机性，所以我们可能会访问相同的节点多次，这样就形成了环。
     *          此方法中，我们只需要遍历整个图并拷贝它。拷贝的意思是每当遇到一个新的未访问过的节点，你都需要创造一个新的节点。
     *          遍历按照深度优先进行。我们需要在回溯的过程中记录已经访问过的节点，否则因为随机指针的存在我们可能会产生死循环。
     *       【算法】
     *          1、从头指针开始遍历整个图。我们将链表看做一张图。
     *          2、当我们遍历到某个点时，如果我们已经有了当前节点的一个拷贝，我们不需要重复进行拷贝。
     *          3、如果我们还没拷贝过当前节点，我们创造一个新的节点，并把该节点放到已访问字典中，即：
     *              visited_dictionary[current_node] = cloned_node_for_current_node.
     *          4、我们针对两种情况进行回溯调用：一个顺着 random 指针调用，另一个沿着 next 指针调用。
     *              步骤 1 中将 random 和 next 指针分别红红色和蓝色标注。然后我们分别对两个指针进行函数递归调用：
     * 【复杂度分析】
     *      时间复杂度：O(N)，其中N是链表中节点的数目。
     *      空间复杂度：O(N)。如果我们仔细分析，我们需要维护一个回溯的栈，同时也需要记录已经被深拷贝过的节点，也就是维护一个已访问字典。渐进时间复杂度为 O(N) 。
     */
    public RandomListNode copyRandomList1(RandomListNode head) {
        if (head == null) {
            return null;
        }

        //如果我们已经处理了当前节点，那么我们只需返回它的克隆版本.
        if (this.visitedHash.containsKey(head)) {
            return this.visitedHash.get(head);
        }

        //创建一个值与旧节点相同的新节点。（即复制节点）
        RandomListNode node = new RandomListNode(head.val, null, null);

        //将此值保存在哈希图中。这是必需的，因为可能由于随机指针的随机性在遍历期间循环，这将有助于我们避免。
        this.visitedHash.put(head, node);

        //从下一个指针开始递归复制剩余的链表，然是随机指针。
        //因此，我们有两个独立的递归调用。
        //最后，我们为创建的新节点更新下一个和随机指针。
        node.next = copyRandomList1(head.next);
        node.random = copyRandomList1(head.random);

        return node;
    }

    //访问字典将旧节点引用作为“键”，将新节点引用作为“值”
    HashMap<RandomListNode, RandomListNode> visited = new HashMap<>();

    public RandomListNode copyRandomList2(RandomListNode head) {

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
