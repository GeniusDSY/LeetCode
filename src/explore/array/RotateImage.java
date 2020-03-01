package explore.array;

/**
 * @author :DengSiYuan
 * @date :2020/3/1 15:53
 * @desc :48. 旋转图像
 * 【题目】
 *      给定一个 n × n 的二维矩阵表示一个图像。
 *      将图像顺时针旋转 90 度。
 *
 * 【说明】
 *      你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 【示例】
 *      给定 matrix =
 *                  [
 *                      [1,2,3],
 *                      [4,5,6],
 *                      [7,8,9]
 *                  ],
 *      原地旋转输入矩阵，使其变为:
 *                  [
 *                      [7,4,1],
 *                      [8,5,2],
 *                      [9,6,3]
 *                  ]
 */
public class RotateImage {

    /**
     * 【解法一】        转置加翻转
     *      最直接的想法是先转置矩阵，然后翻转每一行。这个简单的方法已经能达到最优的时间复杂度O(N^2)。
     * 【复杂度分析】
     *      时间复杂度：O(N^2).
     *      空间复杂度：O(1)由于旋转操作是就地完成的。
     */
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;

        // 转置矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int tmp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
        // 反转每一行
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - j - 1];
                matrix[i][n - j - 1] = tmp;
            }
        }
    }

    /**
     * 【解法二】    旋转四个矩形
     * 【复杂度分析】
     *      时间复杂度：O(N^2)是两重循环的复杂度。
     *      空间复杂度：O(1)由于我们在一次循环中的操作是 就地 完成的，并且我们只用了长度为 4 的临时列表做辅助。
     */
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2 + n % 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int[] tmp = new int[4];
                int row = i;
                int col = j;
                for (int k = 0; k < 4; k++) {
                    tmp[k] = matrix[row][col];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
                for (int k = 0; k < 4; k++) {
                    matrix[row][col] = tmp[(k + 3) % 4];
                    int x = row;
                    row = col;
                    col = n - 1 - x;
                }
            }
        }
    }

    /**
     * 【解法三】    在单次循环内旋转矩阵
     */
    public void rotate3(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i ++) {
            for (int j = 0; j < n / 2; j++) {
                int temp = matrix[n - 1 - j][i];
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
                matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
                matrix[j][n - 1 - i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }
    }

}
