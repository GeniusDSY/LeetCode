package sword_finger_offer;

import base.base_structure.TreeNode;

/**
 * @author :DengSiYuan
 * @date :2020/4/15 10:51
 * @desc :
 * 【题目】
 *      给定一棵二叉搜索树，请找出其中第k大的节点。
 * 【示例】
 *      输入: root = [3,1,4,null,2], k = 1
 *          3
 *         / \
 *        1   4
 *             \
 *              2
 *      输出: 4
 *
 *      输入: root = [5,3,6,2,4,null,null,1], k = 3
 *          5
 *         / \
 *        3   6
 *       / \
 *      2   4
 *     /
 *    1
 *      输出: 4
 * 【限制】
 *      1 ≤ k ≤ 二叉搜索树元素个数
 */
public class KthLargest {

    int res, k;
    public int kthLargest(TreeNode root, int k) {
        this.k = k;
        dfs(root);
        return res;
    }
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        dfs(root.right);
        if(k == 0) {
            return;
        }
        if(--k == 0) {
            res = root.val;
        }
        dfs(root.left);
    }

}
