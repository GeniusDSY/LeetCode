package sword_finger_offer;

import base.base_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :DengSiYuan
 * @date :2020/2/20 14:44
 * @desc : 面试题27. 二叉树的镜像
 * 【题目】
 *      请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 【示例】
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * 镜像输出：
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 *      输入：root = [4,2,7,1,3,6,9]
 *      输出：[4,7,2,9,6,3,1]
 *  
 *
 * 【限制】
 *      0 <= 节点个数 <= 1000
 */
public class MirrorTree {

    /**
     * 【解法一】    层次遍历
     */
    public TreeNode mirrorTree1(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode node = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while(!queue.isEmpty()){
            node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if(node.left != null){
                queue.offer(node.left);
            }
            if(node.right != null){
                queue.offer(node.right);
            }
        }
        return root;
    }

    /**
     * 【解法二】    递归
     */
    public TreeNode mirrorTree2(TreeNode root) {
        if (root==null){
            return null;
        }
        return helper(root);
    }
    private TreeNode helper(TreeNode node){
        if (node==null) {
            return null;
        }
        TreeNode mid=node.left;
        node.left=helper(node.right);
        node.right=helper(mid);
        return node;
    }
}
