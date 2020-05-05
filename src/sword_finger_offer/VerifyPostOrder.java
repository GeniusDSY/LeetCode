package sword_finger_offer;

/**
 * @author :DengSiYuan
 * @date :2020/5/5 16:15
 * @desc :
 * 【题目】     面试题33. 二叉搜索树的后序遍历序列
 *      输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。
 *      假设输入的数组的任意两个数字都互不相同。
 *      参考以下这颗二叉搜索树：
 *              5
 *             / \
 *           2   6
 *          / \
 *        1   3
 * 【示例】
 *      输入: [1,6,3,2,5]
 *      输出: false
 *
 *      输入: [1,3,2,6,5]
 *      输出: true
 *
 * 【提示】
 *      数组长度 <= 1000
 */
public class VerifyPostOrder {

    public boolean verifyPostOrder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }
    boolean recur(int[] po, int i, int j) {
        if(i >= j){
            return true;
        }
        int l = i;
        while(po[l] < po[j]){
            l++;
        }
        int m = l;
        while(po[l] > po[j]){
            l++;
        }
        return l == j && recur(po, i, m - 1) && recur(po, m, j - 1);
    }

}
