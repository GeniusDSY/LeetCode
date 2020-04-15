package sword_finger_offer;

import base.base_structure.ListNode;

/**
 * @author :DengSiYuan
 * @date :2020/4/15 10:39
 * @desc :
 * 【题目】
 *      输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 【示例】
 *      输入：1->2->4, 1->3->4
 *      输出：1->1->2->3->4->4
 * 【限制】
 *      0 <= 链表长度 <= 1000
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dum = new ListNode(0),cur = dum;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                cur.next = l1;
                l1 = l1.next;
            }else{
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 != null ? l1 : l2;
        return dum.next;
    }

}
