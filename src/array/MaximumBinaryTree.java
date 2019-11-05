package array;

/**
 * @author :DengSiYuan
 * @date :2019/11/5 15:55
 * @desc : 654.最大二叉树
 * 【题目】
 *      给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 *          1、二叉树的根是数组中的最大元素。
 *          2、左子树是通过数组中最大值左边部分构造出的最大二叉树。
 *          3、右子树是通过数组中最大值右边部分构造出的最大二叉树。
 *      通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 * 【示例 】
 *      输入：[3,2,1,6,0,5]
 *      输出：返回下面这棵树的根节点：
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *        \
 *         1
 * 【提示】
 *      给定的数组的大小在 [1, 1000] 之间。
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class MaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums == null || nums.length == 0){
            return null;
        }
        TreeNode node = new TreeNode(nums[0]);
        TreeNode curMax = node;
        int curIndex = 0;
        for(int i = 1; i < nums.length ; i++){
            //大于则将原来最大的节点置于其左
            if(nums[i] > nums[curIndex]){
                TreeNode temp = new TreeNode(nums[i]);
                temp.left = curMax;
                curMax = temp;
                curIndex = i;
            } else {
                //小于则遍历原最大节点的右子树，找到其合适的位置。
                TreeNode temp = curMax;
                while(temp.right != null){
                    TreeNode right = temp.right;
                    if(right.val > nums[i]){
                        temp = temp.right;
                    } else {
                        TreeNode temp1 = new TreeNode(nums[i]);
                        temp1.left = right;
                        temp.right = temp1;
                        break;
                    }
                }
                if(temp.right == null){
                    temp.right = new TreeNode(nums[i]);
                }
            }
        }
        return curMax;
    }

}
