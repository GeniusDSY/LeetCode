package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :DengSiYuan
 * @date :2019/9/16 21:17
 * @desc :119.杨辉三角II
 * 【题目】
 *      给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。
 * 【示例】
 *      输入: 3
 *      输出: [1,3,3,1]
 * 【进阶】
 *      你可以优化你的算法到 O(k) 空间复杂度吗？
 */
public class PascalsTriangleII {

    /**
     * 【想法】
     *      和118的杨辉三角一样，唯一不同的是，只输出给定的行，不需要输出前面的行
     *      记录上一行的值，进行当前行值得计算
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = 1; j < i; j++) {
                int temp = cur.get(j);
                cur.set(j, pre + temp);
                pre = temp;
            }
            cur.add(1);
        }
        return cur;
    }


    /**
     * 【想法】
     *      从后向前赋值，进行覆盖
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow1(int rowIndex) {
        int pre = 1;
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j > 0; j--) {
                cur.set(j, cur.get(j - 1) + cur.get(j));
            }
            cur.add(1);//补上每层的最后一个 1
        }
        return cur;
    }

    /**
     * 【想法】
     *      杨辉三角其实可以看做由组合数构成
     *      根据组合数的公式，将(n-k)!约掉，化简就是下边的结果。
     *
     *      C^k_n = n!/(k!(n-k)!) = (n∗(n−1)∗(n−2)∗...(n−k+1))/k!
     *      然后我们就可以利用组合数解决这道题。
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow2(int rowIndex) {
        List<Integer> ans = new ArrayList<>();
        int N = rowIndex;
        for (int k = 0; k <= N; k++) {
            ans.add(Combination(N, k));
        }
        return ans;
    }

    private int Combination(int N, int k) {
        long res = 1;
        for (int i = 1; i <= k; i++) {
            res = res * (N - k + i) / i;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        PascalsTriangleII triangleII = new PascalsTriangleII();
        long start = System.nanoTime();
        List<Integer> result = triangleII.getRow(3);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (Integer integer : result) {
            System.out.print(integer);
        }
        System.out.println();
        start = System.nanoTime();
        result = triangleII.getRow1(3);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (Integer integer : result) {
            System.out.print(integer);
        }
        System.out.println();
        start = System.nanoTime();
        result = triangleII.getRow2(3);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (Integer integer : result) {
            System.out.print(integer);
        }
    }

}
