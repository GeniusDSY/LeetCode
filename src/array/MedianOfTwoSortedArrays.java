package array;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2019/9/25 18:29
 * @desc : 4.寻找两个有序数组的中位数
 * 【题目】
 *      给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *      请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *      你可以假设 nums1 和 nums2 不会同时为空。
 * 【示例】
 *      （1）
 *          nums1 = [1, 3]
 *          nums2 = [2]
 *          则中位数是 2.0
 *      （2）
 *          nums1 = [1, 2]
 *          nums2 = [3, 4]
 *          则中位数是 (2 + 3)/2 = 2.5
 */
public class MedianOfTwoSortedArrays {

    /**
     * 【想法】
     *      （1）合并
     *      （2）排序
     *      （3）取中间值
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] arr = new int[len];
        int i = 0;
        for (int m : nums1) {
            arr[i++] = m;
        }
        for (int n : nums2) {
            arr[i++] = n;
        }
        Arrays.sort(arr);
        int mid = len / 2;
        if (len % 2 == 0) {
            return (arr[mid-1] + arr[mid]) / 2.0;
        }else {
            return arr[mid];
        }
    }

    /**
     * 【想法】
     *      （1）将两个数组分别分成两个部分
     *      （2）进行大小判断查找
     * @param nums1
     * @param nums2
     * @return
     * 【复杂度分析】
     *
     * 时间复杂度：O(log(min(m,n)))，
     *          首先，查找的区间是 [0, m]。
     *          而该区间的长度在每次循环之后都会减少为原来的一半。
     *          所以，我们只需要执行 log(m) 次循环。由于我们在每次循环中进行常量次数的操作，所以时间复杂度为 O(log(m))。
     * 由于 m≤n，所以时间复杂度是 O(log(min(m,n)))。
     *      空间复杂度：O(1)，
     *          我们只需要恒定的内存来存储 9 个局部变量， 所以空间复杂度为 O(1)
     */
    public double findMedianSortedArrays1(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) { // to ensure m<=n
            int[] temp = nums1; nums1 = nums2; nums2 = temp;
            int tmp = m; m = n; n = tmp;
        }
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && nums2[j-1] > nums1[i]){
                iMin = i + 1; // i is too small
            }
            else if (i > iMin && nums1[i-1] > nums2[j]) {
                iMax = i - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = nums2[j-1]; }
                else if (j == 0) { maxLeft = nums1[i-1]; }
                else { maxLeft = Math.max(nums1[i-1], nums2[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = nums2[j]; }
                else if (j == n) { minRight = nums1[i]; }
                else { minRight = Math.min(nums2[j], nums1[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }
    

    public static void main(String[] args) {
        MedianOfTwoSortedArrays arrays = new MedianOfTwoSortedArrays();
        int[] num1 = new int[]{1,3};
        int[] num2 = new int[]{2};
        long start = System.nanoTime();
        double result = arrays.findMedianSortedArrays(num1,num2);
        long end = System.nanoTime();
        System.out.println("合并排序运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
        start = System.nanoTime();
        result = arrays.findMedianSortedArrays1(num1,num2);
        end = System.nanoTime();
        System.out.println("分治算法运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
    }

}
