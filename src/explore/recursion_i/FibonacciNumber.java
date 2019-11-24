package explore.recursion_i;

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
     * 【递归解法】
     *      递归是解决斐波那契数列最好想的，最好理解的，但是递归就会引起更高的时间和空间消耗
     * @param N
     * @return
     */
    public int fib(int N) {
        int[] arr = new int[31];
        if (N == 0 || N == 1){
            return N;
        }else {
            return arr[N] = fib(N - 1) + fib(N - 2);
        }
    }

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
    public int fib1(int N) {
        int i = 0;
        int sum = 0, num = 1;
        while(i++ < N) {
            sum += num;
            num = sum - num;
        }
        return sum;
    }

    HashMap<Integer, Integer> cache = new HashMap<>();

    private int fib2(int N) {
        if (cache.containsKey(N)) {
            return cache.get(N);
        }
        int result;
        if (N < 2) {
            result = N;
        } else {
            result = fib2(N-1) + fib2(N-2);
        }
        // keep the result in cache.
        cache.put(N, result);
        return result;
    }

    public static void main(String[] args) {
        FibonacciNumber fib = new FibonacciNumber();
        long start = System.nanoTime();
        int result = fib.fib(30);
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("普通递归运行时间：" + (end - start)/1000000.0 + "ms");
        start = System.nanoTime();
        result = fib.fib1(30);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("动态规划运行时间：" + (end - start)/1000000.0 + "ms");
        start = System.nanoTime();
        result = fib.fib2(30);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("记忆化递归运行时间：" + (end - start)/1000000.0 + "ms");
    }

}
