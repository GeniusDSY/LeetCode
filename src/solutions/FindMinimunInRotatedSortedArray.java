package solutions;

/**
 * @author :DengSiYuan
 * @date :2021/4/10 14:43
 * @desc : 153.寻找旋转排序数组中的最小值
 * 【题目】
 *      已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。
 *      例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 *          若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 *          若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 *      注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 *      给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。
 *      请你找出并返回数组中的 最小元素 。
 * 【示例】
 *      示例 1：
 *          输入：nums = [3,4,5,1,2]
 *          输出：1
 *          解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
 *      示例 2：
 *          输入：nums = [4,5,6,7,0,1,2]
 *          输出：0
 *          解释：原数组为 [0,1,2,4,5,6,7] ，旋转 4 次得到输入数组。
 *      示例 3：
 *          输入：nums = [11,13,15,17]
 *          输出：11
 *          解释：原数组为 [11,13,15,17] ，旋转 4 次得到输入数组。
 * 【提示】
 *      1、n == nums.length
 *      2、1 <= n <= 5000
 *      3、-5000 <= nums[i] <= 5000
 *      4、nums 中的所有整数 互不相同
 *      5、nums 原来是一个升序排序的数组，并进行了 1 至 n 次旋转
 */
public class FindMinimunInRotatedSortedArray {

    /**
     * 二分法找最小值
     *
     * @param nums 数组
     * @return 数组中的最小值
     */
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = (low + high) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }

    /**
     * 因为事递增数列旋转之后的数组，因此最小值肯定在最大值的右边一位
     *
     * @param nums
     * @return
     */
    public int findMin1(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low + 1) / 2;   /* 先加一再除，mid更靠近右边的right */
            if (nums[low] < nums[mid]) {
                low = mid;                            /* 向右移动左边界 */
            } else if (nums[low] > nums[mid]) {
                high = mid - 1;                       /* 向左移动右边界 */
            }
        }
        /* 最大值向右移动一位就是最小值了（需要考虑最大值在最右边的情况，右移一位后对数组长度取余） */
        return nums[(high + 1) % nums.length];
    }

}
