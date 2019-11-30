package explore.recursion_i;

import base.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author :DengSiYuan
 * @date :2019/11/30 19:25
 * @desc : 95.不同的二叉搜索树II
 * 【题目】
 *      给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * 【示例】
 *      输入: 3
 *      输出:
 *          [
 *              [1,null,3,2],
 *              [3,2,null,1],
 *              [3,1,null,null,2],
 *              [2,1,3],
 *              [1,null,2,null,3]
 *          ]
 * 【解释】
 * 以上的输出对应以下 5 种不同结构的二叉搜索树：
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 */
public class UniqueBinarySearchTreesII {


    /**
     * 【解法一】    递归
     *      根据题意，我们可以得知现有一组有序数列，需要根据他生成二叉搜索树，那么由于二叉搜索树的特点，我们从中选取任意
     *      一个数字作为根节点，那么该根节点左边为它的左子树可以使用的数字，右边为它的右子树可以使用的数字，
     *      之后向下以此类推，选取子树的跟节点，左右子树分配赋值的操作。那么我们可以使用递归做这道题。
     * 【算法】
     *      我们从序列 1 ..n 中取出数字 i，作为当前树的树根。于是，剩余 i - 1 个元素可用于左子树，n - i 个元素用于右子树。
     * 如 前文所述，这样会产生 G(i - 1) 种左子树 和 G(n - i) 种右子树，其中 G 是卡特兰数。
     * 现在，我们对序列 1 ... i - 1 重复上述过程，以构建所有的左子树；然后对 i + 1 ... n 重复，以构建所有的右子树。
     *      这样，我们就有了树根 i 和可能的左子树、右子树的列表。
     *      最后一步，对两个列表循环，将左子树和右子树连接在根上。
     * 【复杂度分析】
     *      时间复杂度 : 主要的计算开销在于构建给定根的全部可能树，也就是卡特兰数 Gn。该过程重复了 n 次，也就是 nGn。
     *                  卡特兰数以 (4^n)(n^(3/2))增长。因此，总的时间复杂度为 O((4^n)(n^(1/2)))。
     *                  这看上去很大，但别忘了，我们可是要生成 Gn~(4^n)(n^(3/2))棵树的。
     *
     *      空间复杂度 :Gn棵树，每个有 n 个元素，共计 nGn。也就是 O((4^n)(n^(1/2)))。
     */
    public List<TreeNode> generateTrees1(int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateTrees(1, n);
    }

    private LinkedList<TreeNode> generateTrees(int start, int end) {
        //生成结果集
        LinkedList<TreeNode> allTrees = new LinkedList<>();
        //判断二叉树（包括子树）是否所有数字填写完毕
        if (start > end){
            allTrees.add(null);
            return allTrees;
        }

        //开始进行遍历填写（i是分界点，左是左子树可用元素，右是右子树可用元素）
        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> leftTrees = generateTrees(start,i-1);
            LinkedList<TreeNode> rightTrees = generateTrees(i+1,end);
            for (TreeNode leftTree : leftTrees) {
                for (TreeNode rightTree : rightTrees) {
                    TreeNode currentTree = new TreeNode(i);
                    currentTree.left = leftTree;
                    currentTree.right = rightTree;
                    allTrees.add(currentTree);
                }
            }
        }
        return allTrees;
    }

    /**
     * 【解法二】    动态规划
     *      举例子理解：n=3
     *      1.数字个数为0的所有解：null
     *      2.数字个数为1的所有解：1、2、3
     *      3.数字个数为2的所有解（只考虑连续数字）：12、21、23、32
     *      4.数字个数为3的所有解：(1、null、2、null、3)、(1、null、3、2、null)、(2、1、3)、(3、1、null、2、null)、(3、2、1、null、null)、
     */
    public List<TreeNode> generateTrees2(int n) {
        List<TreeNode>[] dp = new ArrayList[n + 1];
        dp[0] = new ArrayList<>();
        if (n == 0) {
            return dp[0];
        }
        dp[0].add(null);
        //长度为 1 到 n
        for (int len = 1; len <= n; len++) {
            dp[len] = new ArrayList<TreeNode>();
            //将不同的数字作为根节点，只需要考虑到 len
            for (int root = 1; root <= len; root++) {
                int left = root - 1;  //左子树的长度
                int right = len - root; //右子树的长度
                for (TreeNode leftTree : dp[left]) {
                    for (TreeNode rightTree : dp[right]) {
                        TreeNode treeRoot = new TreeNode(root);
                        treeRoot.left = leftTree;
                        //克隆右子树并且加上偏差
                        treeRoot.right = clone(rightTree, root);
                        dp[len].add(treeRoot);
                    }
                }
            }
        }
        return dp[n];
    }
    private TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }

}
