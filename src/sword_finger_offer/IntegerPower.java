package sword_finger_offer;

/**
 * @author :DengSiYuan
 * @date :2020/2/23 10:55
 * @desc : 面试题16. 数值的整数次方
 * 【题目】
 *      实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 * 【示例】
 *      输入: 2.00000, 10
 *      输出: 1024.00000
 *
 *      输入: 2.10000, 3
 *      输出: 9.26100
 *
 *      输入: 2.00000, -2
 *      输出: 0.25000
 * 【说明】
 *      -100.0 < x < 100.0
 *      n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class IntegerPower {

    /**
     * 【解法一】    递归写法（分治思想）
     */
    public double myPow1(double x, int n) {
        // 特判，也可以认为是递归终止条件
        long N = n;
        if (N < 0) {
            return 1 / myPow(x, -N);
        }
        return myPow(x, N);
    }

    private double myPow(double x, long n) {
        if (n == 0) {
            return 1;
        }

        if (x == 1) {
            return 1;
        }

        // 根据指数是奇数还是偶数进行分类讨论
        // 使用位运算的 与 运算符代替了求余数运算

        if ((n & 1) == 0) {
            // 分治思想：分
            double square = myPow(x, n >>> 1);
            // 分治思想：合，下面同理
            return square * square;
        } else {
            // 是奇数的时候
            double square = myPow(x, (n - 1) >>> 1);
            return square * square * x;
        }
    }

    /**
     * 【解法二】    非递归
     */
    public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N *= -1;
        }

        double res = 1;
        while (N > 0) {
            if ((N & 1) == 1) {
                res *= x;
            }

            x *= x;
            N >>>= 1;
        }
        return res;
    }

}
