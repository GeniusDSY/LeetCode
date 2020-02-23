package sword_finger_offer;

/**
 * @author :DengSiYuan
 * @date :2020/2/23 10:38
 * @desc :面试题15. 二进制中1的个数
 * 【题目】
 *      请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 【示例】
 *      输入：00000000000000000000000000001011
 *      输出：3
 *      解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 */
public class TheNumberOf1sInBinary {

    //您需要将n视为无符号值
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            n = n & (n - 1);
            res++;
        }
        return res;
    }

}
