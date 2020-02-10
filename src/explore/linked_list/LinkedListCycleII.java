package explore.linked_list;

import base.base_structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author :DengSiYuan
 * @date :2020/1/12 10:46
 * @desc : 142.环形链表II
 * 【题目】
 *      给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *      为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * 【说明】
 *      不允许修改给定的链表。
 * 【示例】
 *      输入：head = [3,2,0,-4], pos = 1
 *      输出：tail connects to node index 1
 *      解释：链表中有一个环，其尾部连接到第二个节点。
 *
 *      输入：head = [1,2], pos = 0
 *      输出：tail connects to node index 0
 *      解释：链表中有一个环，其尾部连接到第一个节点。
 *
 *      输入：head = [1], pos = -1
 *      输出：no cycle
 *      解释：链表中没有环。
 * 【进阶】
 *      你是否可以不用额外空间解决此题？
 *  Definition for singly-linked list.
 *      class ListNode {
 *        int val;
 *        ListNode next;
 *        ListNode(int x) {
 *            val = x;
 *            next = null;
 *        }
 *      }
 */
public class LinkedListCycleII {

    /**
     * 【解法一】    哈希表
     *      【想法】
     *          如果我们用一个 Set 保存已经访问过的节点，我们可以遍历整个列表并返回第一个出现重复的节点。
     *      【算法】
     *          首先，我们分配一个 Set 去保存所有的列表节点。我们逐一遍历列表，检查当前节点是否出现过，如果节点已经出现过，那么一定形成了环且它是环的入口。
     *          否则如果有其他点是环的入口，我们应该先访问到其他节点而不是这个节点。其他情况，没有成环则直接返回 null 。
     *          算法会在遍历有限个节点后终止，这是因为输入列表会被分成两类：成环的和不成环的。
     *          一个不成欢的列表在遍历完所有节点后会到达 null - 即链表的最后一个元素后停止。
     *          一个成环列表可以想象成是一个不成环列表将最后一个 null 元素换成环的入口。
     *          如果 while 循环终止，我们返回 null 因为我们已经将所有的节点遍历了一遍且没有遇到重复的节点，这种情况下，列表是不成环的。
     *          对于循环列表， while 循环永远不会停止，但在某个节点上， if 条件会被满足并导致函数的退出。
     * 【复杂度分析】
     *      时间复杂度：O(n)
     *      管是成环还是不成环的输入，算法肯定都只会访问每个节点一次。对于非成环列表这是显而易见的，因为第 n 个节点指向 null ，这会让循环退出。
     *      对于循环列表， if 条件满足时会导致函数的退出，因为它指向了某个已经访问过的节点。
     *      两种情况下，访问的节点数最多都是 n 个，所以运行时间跟节点数目成线性关系。
     *
     *      空间复杂度：O(n)
     *      不管成环或者不成欢的输入，我们都需要将每个节点插入 Set 中一次。两者唯一的区别是最后访问的节点后是 null 还是一个已经访问过的节点。
     *      因此，由于 Set 包含 n 个不同的节点，所需空间与节点数目也是线性关系的。
     */
    public ListNode detectCycle1(ListNode head) {
        Set<ListNode> visited = new HashSet<ListNode>();

        ListNode node = head;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }

    /**
     * 【解法二】    Floyd 算法
     *      【想法】
     *          当然一个跑得快的人和一个跑得慢的人在一个圆形的赛道上赛跑，会发生什么？在某一个时刻，跑得快的人一定会从后面赶上跑得慢的人。
     */
    public ListNode detectCycle2(ListNode head) {
        if (head == null) {
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an e***ance to
        // a cycle.
        ListNode intersect = getIntersect(head);
        if (intersect == null) {
            return null;
        }

        // To find the e***ance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    private ListNode getIntersect(ListNode head) {
        ListNode tortoise = head;
        ListNode hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null) {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare) {
                return tortoise;
            }
        }
        return null;
    }
}
