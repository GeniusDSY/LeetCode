package sword_finger_offer;

import base.base_structure.TreeNode;

import java.util.*;

/**
 * @author :DengSiYuan
 * @date :2020/5/5 16:08
 * @desc :
 * 【题目】     面试题32 - III. 从上到下打印二叉树 III
 *      请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
 *      第三行再按照从左到右的顺序打印，其他行以此类推。
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
 *          [20,9],
 *          [15,7]
 *      ]
 * 【提示】
 *      节点总数 <= 1000
 */
public class LevelOrderIII {

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
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
            if(res.size() % 2 == 1){
                Collections.reverse(tmp);
            }
            res.add(tmp);
        }
        return res;
    }

    public List<List<Integer>> levelOrderII(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root, ans, 1);
        return ans;
    }

    public void helper(TreeNode root, List<List<Integer>> ans, int level){
        if(root == null){
            return;
        }
        LinkedList<Integer> levelList;
        if(level > ans.size()) {
            levelList = new LinkedList<>();
            ans.add(levelList);
        } else {
            levelList = (LinkedList<Integer>)ans.get(level - 1);
        }
        if((level & 1) == 1) {
            levelList.addLast(root.val);
        } else {
            levelList.addFirst(root.val);
        }
        helper(root.left, ans, level + 1);
        helper(root.right, ans, level + 1);
    }

}
