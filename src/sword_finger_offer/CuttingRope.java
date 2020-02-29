package sword_finger_offer;

/**
 * @author :DengSiYuan
 * @date :2020/2/23 9:17
 * @desc :面试题14-I.剪绳子
 * 【题目】
 *      给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m] 。
 *      请问 k[0]*k[1]*...*k[m] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 【示例】
 *      输入: 2
 *      输出: 1
 *      解释: 2 = 1 + 1, 1 × 1 = 1
 *
 *      输入: 10
 *      输出: 36
 *      解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 【提示】
 *      2 <= n <= 58
 */
public class CuttingRope {

    /**
     * 【解法一】    贪心算法
     *      【贪心规则】
     *          1、最高优先级：3。把绳子尽可能切为多个长度为3的片段，留下的最后一段绳子的长度可能为0,1,2三种情况。
     *          2、次高优先级：2。若最后一段绳子长度为2，则保留，不再拆为1+1 。
     *          3、最低优先级：1；若最后一段绳子长度为1；则应把最后的3+1替换为2+2，因为2×2>3×1。
     *      【复杂度分析】
     *          时间复杂度 O(1) ： 仅有求整、求余、次方运算。
     *          空间复杂度 O(1)： 变量a和b使用常数大小额外空间。
     */
    public int cuttingRope(int n) {
        if(n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if(b == 0) {
            return (int)Math.pow(3, a);
        }
        if(b == 1) {
            return (int)Math.pow(3, a - 1) * 4;
        }
        return (int)Math.pow(3, a) * 2;
    }

}