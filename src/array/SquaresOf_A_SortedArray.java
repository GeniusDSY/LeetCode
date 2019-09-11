package array;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2019/9/10 20:13
 * @desc : 977、有序数组的平方
 */
public class SquaresOf_A_SortedArray {

    /**
     * 利用了库函数较慢
     * @param A
     * @return
     */
    public static int[] sortedSquares(int[] A){
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * 想法：
     *    因为只存在负数最小值和正数最大值的排序问题，即给定数组最左端和最右端的大小问题。
     *    因此定义两个索引（left、right）进行首尾对比，将大的一个存入结果数组，
     *    小的进行下一轮对比。以此类推。
     * @param A
     * @return
     */
    public static int[] sortedSquares2(int[] A){
        //定义一个存放结果的数组
        int[] result = new int[A.length];
        //结果数组索引
        int index = A.length-1;
        //原数组右索引
        int right = A.length-1;
        //原数组左索引
        int left = 0;
        //左索引大于右索引时即计算完成
        while (left <= right) {
            //若右索引大于左索引，将右索引计算结果存入结果数组，原数组右索引--
            if (A[left] * A[left] < A[right] * A[right]){
                result[index] = A[right] * A[right];
                right--;
            }
            //若左索引大于右索引，将左索引计算结果存入结果数组，原数组左索引--
            else {
                result[index] = A[left] * A[left];
                left++;
            }
            //存入一个元素后，维护结果数组索引
            index--;
        }
        return result;
    }

    public static int[] sortedSquares3(int[] A){
        int N = A.length;
        int j = 0;
        //找到第一个非负数
        while (j < N && A[j] < 0) {
            j++;
        }
        //i表示最后一个负数的索引
        int i = j-1;
        //创建新数组准备存储平方数
        int[] ans = new int[N];
        int t = 0;
        //判断最大负数和最小非负数的大小
        while (i >= 0 && j < N) {
            //负数的平方小于非负数的平方
            if (A[i] * A[i] < A[j] * A[j]) {
                ans[t++] = A[i] * A[i];
                i--;
                } else {
                ans[t++] = A[j] * A[j];
                j++;
            }
        }
        while (i >= 0) {
            ans[t++] = A[i] * A[i];
            i--;
        }
        while (j < N) {
            ans[t++] = A[j] * A[j];
            j++;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a = {-8,-3,0,1,2,4,5};
        int[] result = sortedSquares2(a);
        for (int i : result) {
            System.out.println(i);
        }
    }

}
