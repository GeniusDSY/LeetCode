package base.base_algorithm;

import base.base_structure.TreeNode;
import java.util.Stack;

/**
 * @author :DengSiYuan
 * @date :2020/2/11 21:14
 * @desc : 深度优先搜索
 */
public class DepthFirstSearch {

    public void depthFirstSearchTree(TreeNode nodeHead) {
        if(nodeHead == null) {
            return;
        }
        Stack<TreeNode> myStack = new Stack<>();
        myStack.add(nodeHead);
        while(!myStack.isEmpty()) {
            TreeNode node = myStack.pop();    //弹出栈顶元素
            System.out.print(node.val+" ");
            if(node.right != null) {
                myStack.push(node.right);    //深度优先遍历，先遍历左边，后遍历右边,栈先进后出
            }
            if(node.left != null) {
                myStack.push(node.left);
            }
        }
    }
}
