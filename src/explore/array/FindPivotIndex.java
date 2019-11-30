package explore.array;

/**
 * @author :DengSiYuan
 * @date :2019/11/30 21:49
 * @desc : 724.寻找数组的中心索引
 * 【题目】
 *      给定一个整数类型的数组 nums，请编写一个能够返回数组“中心索引”的方法。
 *  我们是这样定义数组中心索引的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
 *  如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
 * 【示例】
 *      输入:
 *          nums = [1, 7, 3, 6, 5, 6]
 *      输出: 3
 *      解释:索引3 (nums[3] = 6) 的左侧数之和(1 + 7 + 3 = 11)，与右侧数之和(5 + 6 = 11)相等。
 *              同时, 3 也是第一个符合要求的中心索引。
 *      输入:
 *          nums = [1, 2, 3]
 *      输出: -1
 *      解释: 数组中不存在满足此条件的中心索引。
 * 【说明】
 *      1.nums 的长度范围为 [0, 10000]。
 *      2.任何一个 nums[i] 将会是一个范围在 [-1000, 1000]的整数。
 */
public class FindPivotIndex {

    /**
     * 【想法】
     *      1.求出数组中所有元素的和
     *      2.从第一个元素开始遍历求和，求出前缀和
     *      3.若是总和 - 前缀和 - 当前元素 = 前缀和，那么当前元素的索引就是中心索引
     * 【复杂度分析】
     *      时间复杂度：O(N)，其中 NN 是 nums 的长度。
     *      空间复杂度：O(1)，使用了 S 和 leftsum 。
     */
    public int pivotIndex(int[] nums) {
        int sum = 0, leftsum = 0;
        for (int x: nums){
            sum += x;
        }
        for (int i = 0; i < nums.length; ++i) {
            if (leftsum == sum - leftsum - nums[i]){
                return i;
            }
            leftsum += nums[i];
        }
        return -1;
    }

}
