package explore.array;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2019/11/30 22:22
 * @desc : 747.至少是其他数字两倍的最大数
 * 【题目】
 *      在一个给定的数组nums中，总是存在一个最大元素 。
 *      查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 *      如果是，则返回最大元素的索引，否则返回-1。
 *
 * 【示例】
 *          输入: nums = [3, 6, 1, 0]
 *          输出: 1
 *          解释: 6是最大的整数, 对于数组中的其他整数,
 *              6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *
 *          输入: nums = [1, 2, 3, 4]
 *          输出: -1
 *          解释: 4没有超过3的两倍大, 所以我们返回 -1.
 *
 * 【提示】
 *      1.nums 的长度范围在[1, 50].
 *      2.每个 nums[i] 的整数范围在 [0, 100].
 */
public class LargestNumberAtLeastTwiceOfOthers {

    public int dominantIndex1(int[] nums) {
        if (nums.length < 2){
            return 0;
        }
        int[] index = new int[101];
        for (int i = 0; i < nums.length; i++) {
            index[nums[i]] = i;
        }
        Arrays.sort(nums);
        if (nums[nums.length - 1] >= 2 * nums[nums.length - 2]){
            return index[nums[nums.length - 1]];
        }else {
            return -1;
        }
    }

    /**
     * 【解法二】    线性扫描
     *      1.扫描数组找到唯一的最大元素 m，并记录它的索引 maxIndex。
     *      2.再次扫描数组，如果我们找到 x != m，m < 2*x，我们应该返回 -1。
     *      3.否则返回 maxIndex
     * 【复杂度分析】
     *      时间复杂度：O(N)。N 指的是 nums 的大小
     *      空间复杂度：O(1)，只用了常数空间。
     */
    public int dominantIndex2(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        for (int i = 0; i < nums.length; ++i) {
            if (maxIndex != i && nums[maxIndex] < 2 * nums[i]){
                return -1;
            }
        }
        return maxIndex;
    }

    /**
     * 【想法】
     *      1、经过依次遍历，找到最大和第二大的两个元素的索引
     *      2、只要最大 > 第二大的二倍，返回最大值的索引，否则返回-1
     * 【复杂度分析】
     *      时间复杂度：O(N)
     *      空间复杂度：O(1)
     */
    public int dominantIndex3(int[] nums) {
        //判断数组长度，若小于2，则返回0
        if (nums.length < 2){
            return 0;
        }
        int maxIndex;
        int secondIndex;
        //定初始第一大和第二大索引值
        if (nums[0] < nums[1]){
            maxIndex = 1;
            secondIndex = 0;
        }else {
            maxIndex = 0;
            secondIndex = 1;
        }
        //经过一次遍历后找到最大值、第二大值的索引
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[maxIndex]){
                secondIndex = maxIndex;
                maxIndex = i;
                continue;
            }
            if (nums[i] < nums[maxIndex] && nums[i] > nums[secondIndex]){
                secondIndex = i;
            }
        }
        return nums[maxIndex] >= nums[secondIndex] * 2 ? maxIndex : -1;
    }

}
