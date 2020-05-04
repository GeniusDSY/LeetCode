package sword_finger_offer;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2020/5/4 16:45
 * @desc :
 */
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[]{};
        }
        int line = matrix[0].length;
        int row = matrix.length;
        int index = 0;
        int[] result = new int[row * line];
        while (true) {
            for (int ele : matrix[0]) {
                result[index++] = ele;
            }
            matrix = Arrays.copyOfRange(matrix, 1, row);
            if (matrix.length == 0) {
                break;
            }
            line = matrix[0].length;
            row = matrix.length;
            int[][] ans = new int[line][row];
            for (int i = line - 1; i >= 0; i--) {
                for (int j = 0; j < row; j++) {
                    ans[line - 1 - i][j] = matrix[j][i];
                }
            }
            matrix = ans;
            row = matrix.length;
        }
        return result;
    }
}
