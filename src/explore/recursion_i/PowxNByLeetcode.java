package explore.recursion_i;

/**
 * @author :DengSiYuan
 * @date :2019/11/26 9:43
 * @desc : 50.Pow(x, n)
 * 【题目】
 *      实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 【示例】
 *      输入: 2.00000, 10
 *      输出: 1024.00000
 *
 *      输入: 2.10000, 3
 *      输出: 9.26100
 *
 *      输入: 2.00000, -2
 *      输出: 0.25000
 *      解释: 2-2 = 1/22 = 1/4 = 0.25
 * 【说明】
 *      1. -100.0 < x < 100.0
 *      2. n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
public class PowxNByLeetcode {

    /**
     * 【解法一】        暴力解法
     *      接模拟该过程，将 x 连乘 n 次。
     *      如果 n < 0，我们可以用1/x,−n 代替 x,n 来保证 n≥0 。这个限制可以简化我们下面的讨论。
     *      但是我们仍需关注边界条件，尤其是正整数和负整数的不同范围限制。
     * 【复杂度分析】
     *      时间复杂度：O(n). 我们需要将 x 连乘 n 次。
     *      空间复杂度：O(1). 我们只需要一个变量来保存最终 x 的连乘结果。
     */
    public double myPow1(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        for (long i = 0; i < N; i++) {
            ans = ans * x;
        }
        return ans;
    }

    /**
     * 【解法二】    快速幂算法（递归）
     *      假定我们已经得到了x^n的结果，我们如何得到 x^2∗n的结果？
     *      很明显，我们不需要将x再乘n次。使用公式(x^n)^2=x^(2 * n)，我们可以在一次计算内得到 x^(2 * n)的值。
     *      使用该优化方法，我们可以降低算法的时间复杂度。
     * 【算法】     快速幂
     *      假定我们已经得到了x^(n/2)的结果,并且我们现在想得到 x^n 的结果.我们令 A 是x^(n/2)
     *   的结果，我们可以根据 n 的奇偶性来分别讨论x^n的值。
     *      如果 n 为偶数，我们可以用公式 (x^n)^2 = x^(2*n)来得到 x^n=A∗A。
     *      如果 n 为奇数，那么 A*A = x^(n-1)。直观上看，我们需要再乘一次 x即 x^n = A*A*x。该方法可以很方便的使用递归实现。
     *      我们称这种方法为 "快速幂"，因为我们只需最多 O(logn) 次运算来得到 x^n
     * 【复杂度分析】
     *      时间复杂度：O(logn).每一次我们使用公式(x^n)^2 = x^(2*n),n都变为原来的一半。因此我们需要至多O(logn) 次操作来得到结果。
     *      空间复杂度：O(logn). 每一次计算，我们需要存储 x^(n/2)的结果。我们需要计算O(logn) 次，所以空间复杂度为O(logn) 。
    */
    public double myPow2(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }
    private double fastPow(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    /**
     * 【解法三】    快速幂算法（循环）
     *      直观想法
     *          使用公式x^(a + b) = x^a*x^b，我们可以将 n 看做一系列正整数之和，n =∑ibi。如果我们可以很快得到 x ^ (b_i)结果，
     *          计算x^n的总时间将被降低。
     *     算法
     *      我们可以使用 n 的二进制表示来更好的理解该问题。使 n 的二进制从最低位 (LSB) 到最高位 (MSB) 表示为b1, b2, ...。
     *      对于第 i 位为，如果 bi = 1，意味着我们需要将结果累乘上 x^(2^i).
     * 【复杂度分析】
     *      时间复杂度：O(logn). 对每一个 n 的二进制位表示，我们都至多需要累乘 1 次，所以总的时间复杂度为 O(logn) 。
     *      空间复杂度：O(1). 我们只需要用到 2 个变量来保存当前的乘积和最终的结果 x
     */
    public double myPow3(double x, int n) {
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double ans = 1;
        double currentProduct = x;
        for (long i = N; i > 0; i /= 2) {
            if ((i % 2) == 1) {
                ans = ans * currentProduct;
            }
            currentProduct = currentProduct * currentProduct;
        }
        return ans;
    }
}
