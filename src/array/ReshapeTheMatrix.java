package array;

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
    }

}
