package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/10 16:14
 * @desc : 832翻转图像
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * 示例 1:
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
 */
public class FlippingAnImage {


    /**
     * 想法：
     *    将二维数组作为一个数组对象看待
     *  （1）遍历二维数组的第一个[]
     *  （2）遍历二维数组的第二个[]折半进行首尾取异或交换
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int C = A[0].length;
        for (int[] row: A) {
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }
        }
        return A;
    }
    /**
     * 想法1：
     *   （1）定义一个一摸一样的新数组
     *   （2）遍历各个二维数组中的第一部分
     *   （3）反向遍历各个二维数组中的第二部分取反
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage2(int[][] A) {
        int[][] a = new int[A[0].length][A.length];
        for (int i = 0; i < A.length; i++) {
            for (int j = A[0].length-1; j >= 0; j--) {
                a[i][A[0].length-1-j] = 1 - A[i][j];
            }
        }
        return a;
    }

}
