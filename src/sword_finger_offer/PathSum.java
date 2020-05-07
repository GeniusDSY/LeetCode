package sword_finger_offer;

import base.base_structure.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author :DengSiYuan
 * @date :2020/5/7 16:10
 * @desc :
 * 【题目】     面试题34. 二叉树中和为某一值的路径
 *      输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * 【示例】
 *      给定如下二叉树，以及目标和 sum = 22，
 *
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 *      返回:
 *          [
 *              [5,4,11,2],
 *              [5,8,4,5]
 *          ]
 * 【提示】
 *      节点总数 <= 10000
 */
public class PathSum {

    LinkedList<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        recur(root, sum);
        return res;
    }
    void recur(TreeNode root, int tar) {
        if(root == null){
            return;
        }
        path.add(root.val);
        tar -= root.val;
        if(tar == 0 && root.left == null && root.right == null){
            res.add(new LinkedList(path));
        }
        recur(root.left, tar);
        recur(root.right, tar);
        path.removeLast();
    }

}
