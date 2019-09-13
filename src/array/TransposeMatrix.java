package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/13 17:41
 * @desc : 867、转置矩阵
 * 【题目】
 *      给定一个矩阵 A， 返回 A 的转置矩阵。矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 【示例】
 *      输入：[[1,2,3],[4,5,6],[7,8,9]]
 *      输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 *      输入：[[1,2,3],[4,5,6]]
 *      输出：[[1,4],[2,5],[3,6]]
 * 【提示】
 *      ① 1 <= A.length <= 1000
 *      ② 1 <= A[0].length <= 1000
 */
public class TransposeMatrix {

    /**
     * 【想法】
     *      1、将原数组的行->新数组的列；原数组的列->新数组的行，创建新数组
     *      2、两层循环，外层循环循环列、内层循环循环行
     *      3、分别将每行的第一个（即第一列）装进新数组的第一行，以此类推
     * @param A
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(R * C)，其中 R 和 C 是给定矩阵 A 的行数和列数。
     *      空间复杂度：O(R * C)，也就是答案所使用的空间。
     */
    public int[][] transpose(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for (int i = 0; i < A[0].length; i++) {
            for (int j = 0; j < A.length; j++) {
                result[i][j] = A[j][i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        TransposeMatrix matrix = new TransposeMatrix();
        int[][] arr = new int[][]{{1,2,3},{4,5,6}};
        int[][] result = matrix.transpose(arr);
        for (int[] ints : result) {
            System.out.print("[");
            for (int anInt : ints) {
                System.out.print(anInt + ",");
            }
            System.out.print("],");
        }
    }
}
