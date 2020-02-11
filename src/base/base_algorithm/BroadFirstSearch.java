package base.base_algorithm;

import base.base_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :DengSiYuan
 * @date :2020/2/11 21:23
 * @desc : 广度优先搜索
 */
public class BroadFirstSearch {

    public void broadFirstSearchTree(TreeNode nodeHead) {
        if(nodeHead == null) {
            return;
        }
        Queue<TreeNode> myQueue = new LinkedList<>();
        myQueue.add(nodeHead);
        while(!myQueue.isEmpty()) {
            TreeNode node = myQueue.poll();
            System.out.print(node.val+" ");
            if(null != node.left) {
                myQueue.add(node.left);    //深度优先遍历，我们在这里采用每一行从左到右遍历
            }
            if(null != node.right) {
                myQueue.add(node.right);
            }
        }
    }



}
