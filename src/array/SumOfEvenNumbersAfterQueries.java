package array;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2019/9/17 9:52
 * @desc : 985.查询后得偶数和
 * 【题目】
 *      给出一个整数数组 A 和一个查询数组 queries。
 *      对于第 i 次查询，有 val = queries[i][0], index = queries[i][1]，我们会把 val 加到 A[index] 上。然后，第 i 次查询的答案是 A 中偶数值的和。
 *      此处给定的 index = queries[i][1] 是从 0 开始的索引，每次查询都会永久修改数组 A。）
 *      返回所有查询的答案。你的答案应当以数组 answer 给出，answer[i] 为第 i 次查询的答案。
 * 【示例】
 *      输入：A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 *      输出：[8,6,2,4]
 *      解释：
 *          开始时，数组为 [1,2,3,4]。
 *      将 1 加到 A[0] 上之后，数组为 [2,2,3,4]，偶数值之和为 2 + 2 + 4 = 8。
 *      将 -3 加到 A[1] 上之后，数组为 [2,-1,3,4]，偶数值之和为 2 + 4 = 6。
 *      将 -4 加到 A[0] 上之后，数组为 [-2,-1,3,4]，偶数值之和为 -2 + 4 = 2。
 *      将 2 加到 A[3] 上之后，数组为 [-2,-1,3,6]，偶数值之和为 -2 + 6 = 4。
 * 【提示】
 *      1 <= A.length <= 10000
 *      -10000 <= A[i] <= 10000
 *      1 <= queries.length <= 10000
 *      -10000 <= queries[i][0] <= 10000
 *      0 <= queries[i][1] < A.length-queries
 */
public class SumOfEvenNumbersAfterQueries {

    /**
     * 【思路】
     *      （1）先求出初始数组中的所有偶数元素的和
     *      （2）遍历要改变的条件数组，进行操作，判断改变前后是否为偶数进行+-相应操作
     *      （3）添加到结果数组中
     * @param A
     * @param queries
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N+Q)，其中 N 是数组 A 的长度， Q 是询问 queries 的数量。
     *      空间复杂度：O(N+Q)，事实上我们只使用了 O(1) 的额外空间。
     */
    public int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int temp = 0;
        for (int i : A) {
            temp += i % 2 == 0 ? i : 0;
        }
        int[] result = new int[queries.length];
        for (int i = 0,j = 0; i < queries.length; i++,j++) {
            int a = A[queries[i][1]];
            A[queries[i][1]] += queries[i][0];
            if (a % 2 == 0){
                temp -= a;
            }
            if (A[queries[i][1]]%2 == 0){
                temp += A[queries[i][1]];
            }
            result[j] = temp;
        }
        return result;
    }

    public static void main(String[] args) {
        SumOfEvenNumbersAfterQueries queries = new SumOfEvenNumbersAfterQueries();
        int[] A = new int[]{1,2,3,4};
        int[][] querie = {{1,0},{-3,1},{-4,0},{2,3}};
        long start = System.nanoTime();
        int[] result = queries.sumEvenAfterQueries(A,querie);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int i : result) {
            System.out.print(i);
        }

    }
}
