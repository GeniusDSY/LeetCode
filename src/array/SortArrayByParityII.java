package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/13 21:40
 * @desc :922、按奇偶排序数组
 * 【题目】
 *      给定一个非负整数数组 A， A 中一半整数是奇数，一半整数是偶数。
 * 对数组进行排序，以便当 A[i] 为奇数时，i 也是奇数；当 A[i] 为偶数时， i 也是偶数。
 * 你可以返回任何满足上述条件的数组作为答案。
 * 【示例】
 *      输入：[4,2,5,7]
 *      输出：[4,5,2,7]
 *      解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * 【提示】
 *      ① 2 <= A.length <= 20000
 *      ② A.length % 2 == 0
 *      ③ 0 <= A[i] <= 1000
 */
public class SortArrayByParityII {

    /**
     * 【个人想法】
     *      遍历一遍数组，将可以被2整除的放在从0开始依次递增2的索引位置处，不可以被2整除的放在从1开始依次递增2的索引位置处
     * @param A
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N),其中N为A的长度
     *      空间复杂度：O(N)
     */
    public int[] sortArrayByParityII(int[] A) {
        int[] result = new int[A.length];
        int i = 0;int j = 1;
        for (int a : A) {
            if(a % 2 == 0){
                result[i] = a;
                i += 2;
            }else {
                result[j] = a;
                j += 2;
            }
        }
        return result;
    }

    /**
     * 【LeetCode官方解法 2 双指针】
     *      【想法】
     *          我们可能会被面试官要求写出一种不需要开辟额外空间的解法。
     *
     * 在这个问题里面，一旦所有偶数都放在了正确的位置上，那么所有奇数也一定都在正确的位子上。所以只需要关注 A[0], A[2], A[4], ... 都正确就可以了。
     *
     * 将数组分成两个部分，分别是偶数部分 even = A[0], A[2], A[4], ... 和奇数部分 odd = A[1], A[3], A[5], ...。定义两个指针 i 和 j, 每次循环都需要保证偶数部分中下标 i 之前的位置全是偶数，奇数部分中下标 j 之前的位置全是奇数。
     *      【算法】
     *          让偶数部分下标 i 之前的所有数都是偶数。为了实现这个目标，把奇数部分作为暂存区，不断增加指向奇数部分的指针，直到找到一个偶数，然后交换指针 i，j 所指的数。
     * @param A
     * @return
     * 【复杂度分析】
     *      时间复杂度： O(N)，其中 N 是 A 的长度。
     *      空间复杂度： O(1)。
     */
    public int[] sortArrayByParityII1(int[] A) {
        int j = 1;
        for (int i = 0; i < A.length; i += 2) {
            if (A[i] % 2 == 1) {
                while (A[j] % 2 == 1) {
                    j += 2;
                }
                // Swap A[i] and A[j]
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        SortArrayByParityII parity = new SortArrayByParityII();
        int[] arr = new int[]{4,2,5,7};
        long start = System.nanoTime();
        int[] result = parity.sortArrayByParityII(arr);
        long end = System.nanoTime();
        for (int i : result) {
            System.out.print(i);
        }
        System.out.println("个人想法运行时间：" + (end-start)/ 1000000.0 + "ms");
        start = System.nanoTime();
        result = parity.sortArrayByParityII1(arr);
        end = System.nanoTime();
        for (int i : result) {
            System.out.print(i);
        }
        System.out.println("双指针法运行时间：" + (end-start)/ 1000000.0 + "ms");
    }

}
