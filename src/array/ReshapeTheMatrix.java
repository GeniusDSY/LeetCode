package array;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author :DengSiYuan
 * @date :2019/9/15 20:42
 * @desc :566.重塑矩阵
 * 【题目】
 *      在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 *      给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 *      重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 *      如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 * 【示例】
 *      输入:
 *      nums =
 *          [[1,2],
 *          [3,4]]
 *          r = 1, c = 4
 *      输出:
 *          [[1,2,3,4]]
 *      解释:
 *          行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 * 【注意】
 *      - 给定矩阵的宽和高范围在 [1, 100]。
 *      - 给定的 r 和 c 都是正数。
 */
public class ReshapeTheMatrix {

    /**
     * 【想法】
     *      1、首先判断输入的行列是否刚好能存下原来的元素，不能就直接返回
     *      2、遍历原数组，依次装入结果数组中
     *      3、判定条件：行是否装满即就是 n < c若装满 进行 m++, n=0（换行操作）
     * @param nums
     * @param r
     * @param c
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(m*n)。我们只遍历整个矩阵 m*n。这里，m 和 n 指的是给定矩阵中的行数和列数。
     *      空间复杂度：O(m*n)。使用大小为 m*n 的结果矩阵。
     */
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int scope = nums.length * nums[0].length;
        int[][] result = new int[r][c];
        if (r * c != scope){
            return nums;
        }
        int m = 0,n = -1;
        for (int[] num : nums) {
            for (int i : num) {
                if (++n < c){
                    result[m][n] = i;
                }else {
                    result[++m][n = 0] = i;
                }
            }
        }
        return result;
    }

    /**
     * 【LeetCode 解法1 使用队列】
     *      最简单的方法是通过以行方式读取元素来提取给定矩阵的所有元素。在此实现中，我们使用队列来放置提取的元素。然后，我们可以取出以串行顺序形成的队列元素，并再次按行逐行排列所得到的所需矩阵中的元素。
     *      如果原始矩阵中的元素数量不等于所得矩阵中的元素数量，则不可能形成所得矩阵。
     * @param nums
     * @param r
     * @param c
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(m*n)。我们遍历 m * n 元素两次。这里，m 和 n 分别表示给定矩阵的行数和列数。
     *      空间复杂度：O(m*n)。形成的队列大小为 m*n 。
     */
    public int[][] matrixReshape1(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (nums.length == 0 || r * c != nums.length * nums[0].length) {
            return nums;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int[] num : nums) {
            for (int i : num) {
                queue.add(i);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = queue.remove();
            }
        }
        return res;
    }

    /**
     * 【LeetCode 解法2 除法和取模】
     *      这种方法背后的想法如下。你知道二维数组是如何存储在主存中的（本质上是一维）吗？它仅在内部表示为一维阵列。元素nums [i] [j] nums 数组通过使用以下形式的索引以一维数组的形式表示：$ nums [n * i + j] ，其中，其中 m 是给定矩阵中的列数。以相反的顺序查看相同的内容，同时将元素放在结果矩阵中的元素中，我们可以使用是给定矩阵中的列数。以相反的顺序查看相同的内容，同时将元素放在结果矩阵中的元素中，我们可以使用 count 变量，该变量对于遍历的每个元素都会递增，就像我们将元素放在一维中一样结果数组。但是，要将变量，该变量对于遍历的每个元素都会递增，就像我们将元素放在一维中一样结果数组。但是，要将 count 转换回列数为转换回列数为 c 的二维矩阵索引，我们可以获得的二维矩阵索引，我们可以获得 res [count / c] [count％c] 的索引，其中的索引，其中 count / c 是行号和是行号和 count％c $是列数字。因此，我们可以节省每一步所需的额外检查。
     * @param nums
     * @param r
     * @param c
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(m*n)。我们遍历 m * n 元素两次。这里，m 和 n 分别表示给定矩阵的行数和列数。
     *      空间复杂度：O(m*n)。形成的队列大小为 m*n 。
     */
    public int[][] matrixReshape2(int[][] nums, int r, int c) {
        int[][] res = new int[r][c];
        if (r * c != nums.length * nums[0].length) {
            return nums;
        }
        int count = 0;
        for (int[] num : nums) {
            for (int i : num) {
                res[count / c][count % c] = i;//妙，真的妙！！
                count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums ={{1,2},{3,4},{5,6},{7,8},{9,10}};
        ReshapeTheMatrix matrix = new ReshapeTheMatrix();
        long start = System.nanoTime();
        int[][] reshape=matrix.matrixReshape(nums,5,2);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int[] ints : reshape) {
            System.out.print("[");
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(",");
            }
            System.out.print("]");
        }
        System.out.println();
        start = System.nanoTime();
        reshape=matrix.matrixReshape1(nums,5,2);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int[] ints : reshape) {
            System.out.print("[");
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(",");
            }
            System.out.print("]");
        }
        System.out.println();
        start = System.nanoTime();
        reshape=matrix.matrixReshape2(nums,5,2);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int[] ints : reshape) {
            System.out.print("[");
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(",");
            }
            System.out.print("]");
        }
    }

}
