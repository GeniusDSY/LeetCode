package array;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2019/9/10 20:13
 * @desc : 977、有序数组的平方
 * 【题目】
 *      给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 * 【示例】
 *      输入：[-4,-1,0,3,10]
 *      输出：[0,1,9,16,100]
 * 【提示】
 *      ① 1 <= A.length <= 10000
 *      ② -10000 <= A[i] <= 10000
 *      ③ A 已按非递减顺序排序。
 */
public class SquaresOf_A_SortedArray {

    /**
     * 【想法】
     *      创建一个新的数组，它每个元素是给定数组对应位置元素的平方，然后排序这个数组。
     * @param A
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(NlogN)，其中 N 是数组 A 的长度。
     *      空间复杂度：O(N)。
     */
    public static int[] sortedSquares(int[] A){
        for (int i = 0; i < A.length; i++) {
            A[i] *= A[i];
        }
        Arrays.sort(A);
        return A;
    }

    /**
     * 【想法】
     *      因为只存在负数最小值和正数最大值的排序问题，即给定数组最左端和最右端的大小问题。
     *  因此定义两个索引（left、right）进行首尾对比，将大的一个存入结果数组，小的进行下一轮对比。以此类推。
     * @param A
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)，其中 N 是数组 A 的长度。
     *      空间复杂度：O(N)
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

    /**
     * 【LeetCode官方解法 2 双指针】
     *      【思路】
     *      因为数组 A 已经排好序了， 所以可以说数组中的负数已经按照平方值降序排好了，数组中的非负数已经按照平方值升序排好了。
     *      举一个例子，若给定数组为 [-3, -2, -1, 4, 5, 6]，数组中负数部分 [-3, -2, -1] 的平方为 [9, 4, 1]，数组中非负部分 [4, 5, 6] 的平方为 [16, 25, 36]。
     *      我们的策略就是从前向后遍历数组中的非负数部分，并且反向遍历数组中的负数部分。
     *      【算法】
     *      我们可以使用两个指针分别读取数组的非负部分与负数部分 —— 指针 i 反向读取负数部分，指针 j 正向读取非负数部分。
     *      那么，现在我们就在使用两个指针分别读取两个递增的数组了（按元素的平方排序）。接下来，我们可以使用双指针的技巧合并这两个数组。
     * @param A
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)，其中 N 是数组 A 的长度。
     *      空间复杂度：O(N)。
     */
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
