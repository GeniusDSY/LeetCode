package sword_finger_offer;

import base.base_structure.TreeNode;

/**
 * @author :DengSiYuan
 * @date :2020/5/4 16:16
 * @desc :
 * 【题目】     面试题28. 对称的二叉树
 *      请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *      例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
 *              1
 *             / \
 *            2   2
 *           / \ / \
 *          3  4 4  3
 * 但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:
 *              1
 *             / \
 *            2   2
 *             \   \
 *             3    3
 * 【示例】
 *      输入：root = [1,2,2,3,4,4,3]
 *      输出：true
 *
 *      输入：root = [1,2,2,null,3,null,3]
 *      输出：false
 * 【限制】
 *      0 <= 节点个数 <= 1000
 */
public class IsSymmetric {

    public boolean isSymmetric(TreeNode root) {
        return root == null || recur(root.left, root.right);
    }
    private boolean recur(TreeNode L, TreeNode R){
        if(L == null && R == null){
            return true;
        }
        if(L == null || R == null || L.val != R.val){
            return false;
        }
        return recur(L.left, R.right) && recur(L.right,R.left);
    }

}
