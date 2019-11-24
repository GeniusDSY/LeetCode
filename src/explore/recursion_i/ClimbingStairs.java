package explore.recursion_i;

/**
 * @author :DengSiYuan
 * @date :2019/11/24 16:59
 * @desc : 70.爬楼梯
 * 【题目】
 *      假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 *      每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 *
 * 【注意】
 *      给定 n 是一个正整数。
 *
 * 【示例】
 *      输入： 2
 *      输出： 2
 *      解释： 有两种方法可以爬到楼顶。
 *      1.  1 阶 + 1 阶
 *      2.  2 阶
 *
 *      输入： 3
 *      输出： 3
 *      解释： 有三种方法可以爬到楼顶。
 *      1.  1 阶 + 1 阶 + 1 阶
 *      2.  1 阶 + 2 阶
 *      3.  2 阶 + 1 阶
 */
public class ClimbingStairs {

    /**
     * 【解法一】 常规递归
     *      我们通过找规律列举发现：1 2 3 5 8 13...从第三项开始，后一项是前两项之和。
     *      那么我们可以使用递归！！
     * 【复杂度分析】
     *      时间复杂度：O(2^n)，树形递归的大小为 2^n。
     *      空间复杂度：O(n)，递归树的深度可以达到 n。
     */
    public int climbStairs1(int n) {
        if(n == 1 || n == 2){
            return n;
        }
        return climbStairs1(n - 2) + climbStairs1(n - 1);
    }

    /**
     * 【解法二】 记忆递归
     *      在上一种方法中，我们计算每一步的结果时出现了冗余。另一种思路是，我们可以把每一步的结果存储在 memo 数组之中，每当函数再次被调用，我们就直接从 memo 数组返回结果。
     * 在 memo 数组的帮助下，我们得到了一个修复的递归树，其大小减少到 n。
     * 【复杂度分析】
     *      时间复杂度：O(n)。树形递归的大小可以达到 n 。
     *      空间复杂度：O(n)。递归树的深度可以达到 n 。
     */
    public int climbStairs2(int n) {
        int memo[] = new int[n + 1];
        return climb_Stairs2(0, n, memo);
    }
    public int climb_Stairs2(int i, int n, int memo[]) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs2(i + 1, n, memo) + climb_Stairs2(i + 2, n, memo);
        return memo[i];
    }

    /**
     * 【解法三】    动态规划
     *      不难发现，这个问题可以被分解为一些包含最优子结构的子问题，即它的最优解可以从其子问题的最优解来有效地构建，我们可以使用动态规划来解决这一问题。
     *      第 i 阶可以由以下两种方法得到：
     *          - 在第 (i-1) 阶后向上爬一阶。
     *          - 在第 (i−2) 阶后向上爬 22 阶。
     *      所以到达第 i 阶的方法总数就是到第 (i−1) 阶和第 (i-2) 阶的方法数之和。
     *      令 dp[i] 表示能到达第 i 阶的方法总数：
     *          dp[i]=dp[i-1]+dp[i-2]
     * 【复杂度分析】
     *      时间复杂度：O(n)，单循环到 n 。
     *      空间复杂度：O(n)。dp 数组用了 n 的空间。
     */
    public int climbStairs3(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /**
     * 【解法四】    斐波那契数
     *      在上述方法中，我们使用 dpdp 数组，其中 dp[i]=dp[i-1]+dp[i-2]。可以很容易通过分析得出 dp[i] 其实就是第 i 个斐波那契数。
     *      Fib(n)=Fib(n−1)+Fib(n−2)
     * 现在我们必须找出以 1 和 2 作为第一项和第二项的斐波那契数列中的第 n 个数，也就是说 Fib(1)=1 且 Fib(2)=2。
     * 【复杂度分析】
     *      时间复杂度：O(n)。单循环到 n，需要计算第 n 个斐波那契数。
     *      空间复杂度：O(1)。使用常量级空间。
     */
    public int climbStairs4(int n) {
        if (n == 1) {
            return 1;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }

    /**
     * 【解法五】    Binets 方法
     * 【复杂度分析】
     *      时间复杂度：O(log(n))。遍历 log(n) 位。
     *      空间复杂度：O(1)。使用常量级空间。
     */
    public int climbStairs5(int n) {
        int[][] q = {{1, 1}, {1, 0}};
        int[][] res = pow(q, n);
        return res[0][0];
    }
    public int[][] pow(int[][] a, int n) {
        int[][] ret = {{1, 0}, {0, 1}};
        while (n > 0) {
            if ((n & 1) == 1) {
                ret = multiply(ret, a);
            }
            n >>= 1;
            a = multiply(a, a);
        }
        return ret;
    }
    public int[][] multiply(int[][] a, int[][] b) {
        int[][] c = new int[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                c[i][j] = a[i][0] * b[0][j] + a[i][1] * b[1][j];
            }
        }
        return c;
    }

    /**
     * 【解法六】    斐波那契公式
     * 【复杂度分析】
     *      时间复杂度：O(log(n))。pow 方法将会用去 log(n) 的时间。
     *      空间复杂度：O(1)。使用常量级空间。
     */
    public int climbStairs6(int n) {
        double sqrt5=Math.sqrt(5);
        double fibn=Math.pow((1+sqrt5)/2,n+1)-Math.pow((1-sqrt5)/2,n+1);
        return (int)(fibn/sqrt5);
    }

    public static void main(String[] args) {
        ClimbingStairs stairs = new ClimbingStairs();
        long start = System.nanoTime();
        System.out.println(stairs.climbStairs1(44));
        long end = System.nanoTime();
        System.out.println("普通递归运行时间：" + (end - start)/1000000.0 + "ms");
        start = System.nanoTime();
        System.out.println(stairs.climbStairs2(44));
        end = System.nanoTime();
        System.out.println("记忆递归运行时间：" + (end - start)/1000000.0 + "ms");
        start = System.nanoTime();
        System.out.println(stairs.climbStairs3(44));
        end = System.nanoTime();
        System.out.println("动态规划运行时间：" + (end - start)/1000000.0 + "ms");
        start = System.nanoTime();
        System.out.println(stairs.climbStairs4(44));
        end = System.nanoTime();
        System.out.println("斐波那契数运行时间：" + (end - start)/1000000.0 + "ms");
        start = System.nanoTime();
        System.out.println(stairs.climbStairs5(44));
        end = System.nanoTime();
        System.out.println("Binets方法运行时间：" + (end - start)/1000000.0 + "ms");
        start = System.nanoTime();
        System.out.println(stairs.climbStairs6(44));
        end = System.nanoTime();
        System.out.println("斐波那契公式运行时间：" + (end - start)/1000000.0 + "ms");
    }

}
