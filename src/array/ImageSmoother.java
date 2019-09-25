package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/25 11:33
 * @desc : 661.图片平滑器
 * 【题目】
 *      包含整数的二维矩阵 M 表示一个图片的灰度。你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * 【示例】
 *      输入:
 *          [[1,1,1],
 *          [1,0,1],
 *          [1,1,1]]
 *      输出:
 *          [[0, 0, 0],
 *          [0, 0, 0],
 *          [0, 0, 0]]
 *      解释:
 *          对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 *          对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 *          对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * 【注意】
 *      给定矩阵中的整数范围为 [0, 255]。
 *      矩阵的长和宽的范围均为 [1, 150]。
 */
public class ImageSmoother {

    int row = 0;
    int col = 0;
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length < 1 || M[0] == null || M[0].length < 1) {
            return null;
        }

        row = M.length;
        col = M[row - 1].length;

        int ans[][] = new int[row][col];

        for (int i = 0;i < row;i++) {
            for (int j = 0;j < col;j++) {
                ans[i][j] = calcul(M,i,j);
            }
        }

        return ans;
    }

    // 上、下、左、右，上左，上右，下左，下右
    int dirR[] = {-1,1,0,0,-1,-1,1,1};
    int dirC[] = {0,0,-1,1,-1,1,-1,1};

    private int calcul(int arr[][],int i,int j) {
        int count = 1;
        int sum = arr[i][j];

        for (int k = 0;k < dirR.length;k++) {
            int nextR = i + dirR[k];
            int nextC = j + dirC[k];

            if (nextR >= 0 && nextR < row && nextC >= 0 && nextC < col) {
                count++;
                sum += arr[nextR][nextC];
            }
        }

        return sum / count;
    }

    public int[][] imageSmoother1(int[][] M) {
        int height = M.length;
        int width = M[0].length;
        int[][] result = new int[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result[i][j] = avg(M, i, j, height, width);
            }
        }
        return result;
    }

    int avg(int[][] M, int i, int j, int height, int width) {
        int sum = M[i][j];
        int count = 1;
        if (i > 0) {
            sum += M[i - 1][j];
            count++;
            if (j > 0) {
                sum += M[i - 1][j - 1];
                count++;
            }
            if (j < width - 1) {
                sum += M[i - 1][j + 1];
                count++;
            }
        }
        if (i < height - 1) {
            sum += M[i + 1][j];
            count++;
            if (j > 0) {
                sum += M[i + 1][j - 1];
                count++;
            }
            if (j < width - 1) {
                sum += M[i + 1][j + 1];
                count++;
            }
        }
        if (j > 0) {
            sum += M[i][j - 1];
            count++;
        }
        if (j < width - 1) {
            sum += M[i][j + 1];
            count++;
        }
        return sum / count;
    }

    public static void main(String[] args) {
        ImageSmoother smoother = new ImageSmoother();
        int[][] arr = new int[][]{{1,1,1},{1,0,1},{1,1,1}};
        long start = System.nanoTime();
        int[][] result = smoother.imageSmoother(arr);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int[] ints : result) {
            for (int i : ints) {
                System.out.print(i);
            }
        }
        System.out.println();
        start = System.nanoTime();
        result = smoother.imageSmoother1(arr);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int[] ints : result) {
            for (int i : ints) {
                System.out.print(i);
            }
        }
    }

}
