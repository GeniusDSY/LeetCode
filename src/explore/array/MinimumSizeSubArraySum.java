package explore.array;

import java.util.Vector;

/**
 * @author :DengSiYuan
 * @date :2019/12/10 22:18
 * @desc :209.长度最小的子数组
 * 【题目】
 *      给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
 * 【示例】
 *      输入: s = 7, nums = [2,3,1,2,4,3]
 *      输出: 2
 *      解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
 * 【进阶】
 *      如果你已经完成了O(n) 时间复杂度的解法, 请尝试 O(n log n) 时间复杂度的解法。
 */
public class MinimumSizeSubArraySum {

    /**
     * 【解法一】    暴力解法（两层循环）
     *      初始化 ans=INT_MAX
     *      用变量 i 从左到右遍历数组：
     *      用变量 j 从当前元素到数组尾部遍历：
     *      将 i 到 j 这些元素求和得到 sum
     *      如果和 sum 比 s 大：
     *      更新 ans=min(ans,(j−i+1))
     *      继续迭代
     * 【复杂度分析】
     *      时间复杂度：O(n^3)
     *      空间复杂度：O(1)。只是用了常数个额外变量。
     */
    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= s) {
                    ans = Math.min(ans, (j - i + 1));
                    break;
                }
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    /**
     * 【解法二】    双指针
     *      到现在为止，我们都保持子数组的左端点不动去找右端点。其实一旦知道这个位置开始的子数组不会是最优答案了，我们就可以移动左端点。
     *      我们用 2 个指针，一个指向数组开始的位置，一个指向数组最后的位置，并维护区间内的和 sum 大于等于 s 同时数组长度最小。
     *【复杂度分析】
     *      时间复杂度：O(n) 。每个指针移动都需要 O(n)的时间。
     *      空间复杂度：O(1)。
     * */
    public int minSubArrayLen2(int s, int[] nums){
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum >= s) {
                ans = Math.min(ans, i + 1 - left);
                sum -= nums[left++];
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

}
