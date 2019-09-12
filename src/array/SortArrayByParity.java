package array;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2019/9/12 14:12
 * @desc :905. 按奇偶排序数组
 * 【题目】
 *      给定一个非负整数数组 A，返回一个数组，在该数组中，A 的所有偶数元素之后跟着所有奇数元素。
 * 你可以返回满足此条件的任何数组作为答案。
 * 【示例】
 *      输入：[3,1,2,4]
 *      输出：[2,4,3,1]
 *      输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 */
public class SortArrayByParity {

    /**
     * 【个人想法】 一次循环---首尾赋值
     *      用两个指针分别指向数组的头尾，遍历数组。
     *      若可以被二整除，则从头赋值，否则从尾部赋值
     * @param A
     * @return
     */
    public int[] sortArrayByParity(int[] A) {
        int[] result = new int[A.length];
        int j = A.length-1,m = 0;
        for (int i : A) {
            if (i % 2 == 0){
                result[m] =i;
                m++;
            }else {
                result[j] = i;
                j--;
            }
        }
        return result;
    }

    /**
     * 【LeetCode官方解法 1】 排序
     *  使用排序算法，按照模 2 的结果排序。
     * @param A
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(NlogN)，其中 N 是 A 的长度。
     *      空间复杂度：排序空间为 O(N)，取决于内置的 sort 函数实现。
     */
    public int[] sortArrayByParity1(int[] A) {
        Integer[] B = new Integer[A.length];
        for (int t = 0; t < A.length; ++t) {
            B[t] = A[t];
        }
        Arrays.sort(B, (a, b) -> Integer.compare(a%2, b%2));
        for (int t = 0; t < A.length; ++t) {
            A[t] = B[t];
        }
        return A;
        /* Alternative:
        return Arrays.stream(A)
                     .boxed()
                     .sorted((a, b) -> Integer.compare(a%2, b%2))
                     .mapToInt(i -> i)
                     .toArray();
        */
    }

    /**
     * 【LeetCode官方解法 2】 两遍扫描
     *      第一遍输出偶数，第二遍输出奇数
     * @param A
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)，其中 N 是 A 的长度。
     *      空间复杂度：O(N)，存储结果的数组。
     */
    public int[] sortArrayByParity2(int[] A) {
        int[] ans = new int[A.length];
        int t = 0;

        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 0) {
                ans[t++] = A[i];
            }
        }
        for (int i = 0; i < A.length; ++i) {
            if (A[i] % 2 == 1) {
                ans[t++] = A[i];
            }
        }
        return ans;
    }

    /**
     * 【LeetCode官方解法 3】
     *      想法：
     *          如果希望原地排序，可以使用快排，一个经典的算法。
     *      算法：
     *          维护两个指针 i 和 j，循环保证每刻小于 i 的变量都是偶数
     *          （也就是 A[k] % 2 == 0 当 k < i），所有大于 j 的都是奇数。
     *          所以， 4 种情况针对 (A[i] % 2, A[j] % 2)：
     *              如果是 (0, 1)，那么万事大吉 i++ 并且 j--。
     *              如果是 (1, 0)，那么交换两个元素，然后继续。
     *              如果是 (0, 0)，那么说明 i 位置是正确的，只能 i++。
     *              如果是 (1, 1)，那么说明 j 位置是正确的，只能 j--。
     *          通过这 4 种情况，循环不变量得以维护，并且 j-i 不断变小。最终就可以得到奇偶有序的数组。
     * @param A
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)，其中 N 是 A 的长度。循环的每一步都让 j-i 至少减少了一。（注意虽然快排的复杂度是 O(NlogN)，但是我们只需要一轮扫描就可以了）。
     *      空间复杂度：O(1)，不需要额外空间。。
     */
    public int[] sortArrayByParity3(int[] A) {
        int i = 0, j = A.length - 1;
        while (i < j) {
            if (A[i] % 2 > A[j] % 2) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            if (A[i] % 2 == 0){ i++;}
            if (A[j] % 2 == 1){ j--;}
        }
        return A;
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,1,2,4};
        SortArrayByParity parity = new SortArrayByParity();
        long start = System.nanoTime();
        int[] result = parity.sortArrayByParity(a);
        long end = System.nanoTime();
        for (int i : result) {
            System.out.print(i);
        }
        System.out.println("两头插入运行时间：" + (end-start)/ 1000000.0 + "mm");
        long start1 = System.nanoTime();
        int[] result1 = parity.sortArrayByParity1(a);
        long end1 = System.nanoTime();
        for (int i : result1) {
            System.out.print(i);
        }
        System.out.println("排序运行时间：" + (end1-start1)/ 1000000.0 + "mm");
        long start2 = System.nanoTime();
        int[] result2 = parity.sortArrayByParity2(a);
        long end2 = System.nanoTime();
        for (int i : result2) {
            System.out.print(i);
        }
        System.out.println("两遍扫描运行时间：" + (end2-start2)/ 1000000.0 + "mm");
        long start3 = System.nanoTime();
        int[] result3 = parity.sortArrayByParity3(a);
        long end3 = System.nanoTime();
        for (int i : result3) {
            System.out.print(i);
        }
        System.out.println("原地算法运行时间：" + (end3-start3)/ 1000000.0 + "mm");
    }

}
