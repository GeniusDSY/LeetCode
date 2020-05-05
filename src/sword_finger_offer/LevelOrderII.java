package sword_finger_offer;

import base.base_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author :DengSiYuan
 * @date :2020/5/5 15:51
 * @desc :
 * 【题目】     面试题32 - II. 从上到下打印二叉树 II
 *      从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 * 【示例】
 *      给定二叉树: [3,9,20,null,null,15,7],
 *          3
 *         / \
 *        9  20
 *          /  \
 *        15   7
 *      返回其层次遍历结果：
 *      [
 *          [3],
 *          [9,20],
 *          [15,7]
 *      ]
 * 【提示】
 *      节点总数 <= 1000
 */
public class LevelOrderII {

    public List<List<Integer>> levelOrderI(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        if(root != null){
            queue.add(root);
        }
        while(!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }

    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        dfs(root, lists, 0);
        return lists;
    }

    private void dfs(TreeNode root, List<List<Integer>> lists, int depth) {
        if (root == null){
            return;
        }
        if (lists.size() == depth){
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        dfs(root.left, lists, depth + 1);
        dfs(root.right, lists, depth + 1);
    }

}
