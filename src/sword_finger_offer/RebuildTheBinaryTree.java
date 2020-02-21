package sword_finger_offer;

import base.base_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author :DengSiYuan
 * @date :2020/2/21 10:09
 * @desc : 面试题07.重建二叉树
 * 【题目】
 *      输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 【示例】
 *      前序遍历 preorder = [3,9,20,15,7]
 *      中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 【限制】
 *      0 <= 节点个数 <= 5000
 */
public class RebuildTheBinaryTree {

    /**
     * 【解法一】    递归
     *      二叉树的前序遍历顺序是：根节点、左子树、右子树，每个子树的遍历顺序同样满足前序遍历顺序。
     *      二叉树的中序遍历顺序是：左子树、根节点、右子树，每个子树的遍历顺序同样满足中序遍历顺序。
     *      使用一个 Map 存储中序遍历的每个元素及其对应的下标，目的是为了快速获得一个元素在中序遍历中的位置。调用递归方法，对于前序遍历和中序遍历，下标范围都是从 0 到 n-1，其中 n 是二叉树节点个数。
     *      递归方法的基准情形有两个：
     *          1、判断前序遍历的下标范围的开始和结束，若开始大于结束，则当前的二叉树中没有节点，返回空值 null。
     *          2、若开始等于结束，则当前的二叉树中恰好有一个节点，根据节点值创建该节点作为根节点并返回。
     *      若开始小于结束，则当前的二叉树中有多个节点。在中序遍历中得到根节点的位置，从而得到左子树和右子树各自的下标范围和节点数量，知道节点数量后，在前序遍历中即可得到左子树和右子树各自的下标范围，然后递归重建左子树和右子树，并将左右子树的根节点分别作为当前根节点的左右子节点。
     * 【复杂度分析】
     *      时间复杂度：O(n)。对于每个节点都有创建过程以及根据左右子树重建过程。
     *      空间复杂度：O(n)。存储整棵树的开销。
     */
    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        Map<Integer, Integer> indexMap = new HashMap<>();
        int length = preorder.length;
        for (int i = 0; i < length; i++) {
            indexMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, length - 1, inorder, 0, length - 1, indexMap);
    }

    public TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd, int[] inorder, int inorderStart, int inorderEnd, Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart == preorderEnd) {
            return root;
        } else {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes, inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd, inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
            return root;
        }
    }

    /**
     * 【解法二】    迭代
     *      1、使用前序遍历的第一个元素创建根节点。
     *      2、创建一个栈，将根节点压入栈内。
     *      3、初始化中序遍历下标为 0。
     *      4、遍历前序遍历的每个元素，判断其上一个元素（即栈顶元素）是否等于中序遍历下标指向的元素。
     *          （1）若上一个元素不等于中序遍历下标指向的元素，则将当前元素作为其上一个元素的左子节点，并将当前元素压入栈内。
     *          （2）若上一个元素等于中序遍历下标指向的元素，则从栈内弹出一个元素，同时令中序遍历下标指向下一个元素，之后继续判断栈顶元素是否等于中序遍历下标指向的元素，
     *          （3）若相等则重复该操作，直至栈为空或者元素不相等。然后令当前元素为最后一个想等元素的右节点。
     *      5、遍历结束，返回根节点。
     * 【复杂度分析】
     *      时间复杂度：O(n)。前序遍历和后序遍历都被遍历。
     *      空间复杂度：O(n)。额外使用栈存储已经遍历过的节点。
     */
    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        int length = preorder.length;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }

    // 使用全局变量是为了让递归方法少传一些参数，不一定非要这么做
    private Map<Integer, Integer> reverses;
    private int[] preorder;

    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        int preLen = preorder.length;
        int inLen = inorder.length;

        // 可以不做判断，因为题目中给出的数据都是有效的
        if (preLen != inLen) {
            return null;
        }

        this.preorder = preorder;

        // 以空间换时间，否则，找根结点在中序遍历中的位置需要遍历
        reverses = new HashMap<>(inLen);
        for (int i = 0; i < inLen; i++) {
            reverses.put(inorder[i], i);
        }

        return buildTree(0, preLen - 1, 0, inLen - 1);
    }

    /**
     * 根据前序遍历数组的 [preL, preR] 和 中序遍历数组的 [inL, inR] 重新组建二叉树
     *
     * @param preL 前序遍历数组的区间左端点
     * @param preR 前序遍历数组的区间右端点
     * @param inL  中序遍历数组的区间左端点
     * @param inR  中序遍历数组的区间右端点
     * @return 构建的新二叉树的根结点
     */
    private TreeNode buildTree(int preL, int preR,
                               int inL, int inR) {
        if (preL > preR || inL > inR) {
            return null;
        }
        // 构建的新二叉树的根结点一定是前序遍历数组的第 1 个元素
        int pivot = preorder[preL];
        TreeNode root = new TreeNode(pivot);

        int pivotIndex = reverses.get(pivot);

        // 这一步得画草稿，计算边界的取值，必要时需要解方程
        root.left = buildTree(preL + 1, preL + (pivotIndex - inL), inL, pivotIndex - 1);
        root.right = buildTree(preL + (pivotIndex - inL) + 1, preR, pivotIndex + 1, inR);
        return root;
    }
}
