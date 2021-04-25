package solutions;

import base.base_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :DengSiYuan
 * @date :2021/4/25 11:24
 * @desc : 897.递增顺序搜索树
 * 【题目】
 *      给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，
 *      树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点.
 * 【示例】
 *      示例一
 *      输入：root = [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *      输出：[1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *      示例二
 *      输入：root = [5,1,7]
 *      输出：[1,null,5,null,7]
 * 【提示】
 *      树中节点数的取值范围是 [1, 100]
 *      0 <= Node.val <= 1000
 */
public class IncreasingOrderSearchTree {

    /**
     * 中序遍历之后生成新的树
     *      1、先对输入的二叉搜索树执行中序遍历，将结果保存到一个列表中；
     *      2、然后根据列表中的节点值，创建等价的只含有右节点的二叉搜索树，其过程等价于根据节点值创建一个链表
     * 时间复杂度：
     *      O(n)，其中n是二叉搜索树的节点总数。
     * 空间复杂度：
     *      O(n)，其中n是二叉搜索树的节点总数。需要长度为n的列表保存二叉搜索树的所有节点的值。
     */
    public TreeNode increasingBST1(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        inorder(root, res);

        TreeNode dummyNode = new TreeNode(-1);
        TreeNode currNode = dummyNode;
        for (int value : res) {
            currNode.right = new TreeNode(value);
            currNode = currNode.right;
        }
        return dummyNode.right;
    }

    private void inorder(TreeNode node, List<Integer> res) {
        if (node == null) {
            return;
        }
        inorder(node.left, res);
        res.add(node.val);
        inorder(node.right, res);
    }

    /**
     * 在中序遍历的过程中改变节点指向
     *      在中序遍历的时候，修改节点指向就可以实现。
     *      具体地，当我们遍历到一个节点时，把它的左孩子设为空，并将其本身作为上一个遍历到的节点的右孩子。
     * 时间复杂度：
     *      O(n)，其中n是二叉搜索树的节点总数。
     * 空间复杂度：
     *      O(n)。递归过程中的栈空间开销为O(n)。
     */
    TreeNode resNode;

    public TreeNode increasingBST2(TreeNode root) {
        TreeNode dummyNode = new TreeNode(-1);
        resNode = dummyNode;
        inorder(root);
        return dummyNode.right;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }
        inorder(node.left);

        // 在中序遍历的过程中修改节点指向
        resNode.right = node;
        node.left = null;
        resNode = node;

        inorder(node.right);
    }
}
