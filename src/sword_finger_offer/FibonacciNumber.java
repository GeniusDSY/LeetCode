package sword_finger_offer;

import java.util.HashMap;

/**
 * @author :DengSiYuan
 * @date :2019/9/13 10:12
 * @desc : 509、斐波那契数
 * 【题目】
 *      斐波那契数，通常用 F(n) 表示，形成的序列称为斐波那契数列。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *          F(0) = 0,   F(1) = 1
 *          F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *          给定 N，计算 F(N)。
 * 【示例】
 *      输入：2
 *      输出：1
 *      解释：F(2) = F(1) + F(0) = 1 + 0 = 1.
 *
 *      输入：3
 *      输出：2
 *      解释：F(3) = F(2) + F(1) = 1 + 1 = 2.
 * 【说明】
 *      0 ≤ N ≤ 30
 */
public class FibonacciNumber {

    /**
     * 【想法】
     *      动态规划：0,  1,  1,  2,  3,  5,...
     *      i=0		 num sum
     * 	    i=1			 num sum
     * 	    i=2				 num sum
     * 	    i=3					 num sum
     * 	    ....       ...
     * @param N
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)
     *      空间复杂度：O(1)
     */
    public int fib(int N) {
        int a = 0, b = 1, sum;
        for(int i = 0; i < N; i++){
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }
}
