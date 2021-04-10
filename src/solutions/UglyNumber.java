package solutions;

/**
 * @author :DengSiYuan
 * @date :2021/4/10 15:49
 * @desc : 263.丑数
 * 【题目】
 *      给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 *      丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 * 【示例】
 *      示例 1：
 *          输入：n = 6
 *          输出：true
 *          解释：6 = 2 × 3
 *      示例 2：
 *          输入：n = 8
 *          输出：true
 *          解释：8 = 2 × 2 × 2
 *      示例 3：
 *          输入：n = 14
 *          输出：false
 *          解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 *      示例 4：
 *          输入：n = 1
 *          输出：true
 *          解释：1 通常被视为丑数。
 */
public class UglyNumber {

    /**
     * 除到不能除为止，看最后结果是不是1
     *
     * @param n
     * @return
     */
    public boolean isUgly(int n) {
        if (n <= 0) {
            return false;
        }
        int[] factors = {2, 3, 5};
        for (int factor : factors) {
            while (n % factor == 0) {
                n /= factor;
            }
        }
        return n == 1;
    }
}
