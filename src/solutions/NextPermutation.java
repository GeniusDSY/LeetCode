package solutions;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2021/4/5 22:42
 * @desc : 31. 下一个排列
 * 【题目】
 * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
 * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
 * 必须 原地 修改，只允许使用额外常数空间。
 * 【示例】
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[1,3,2]
 * 示例 2：
 * 输入：nums = [3,2,1]
 * 输出：[1,2,3]
 * 示例 3：
 * 输入：nums = [1,1,5]
 * 输出：[1,5,1]
 * 示例 4：
 * 输入：nums = [1]
 * 输出：[1]
 * 【提示】
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 */
public class NextPermutation {

    /**
     * 1、先找出分界点，即从后向前第一个i-1比i小的索引值
     * 2、将后半部分排序，之后将i-1的值和后半部分第一个比他大的值进行交换
     * 3、将后半部分重新排序
     *
     * @param nums
     */
    public static void nextPermutation(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        int exIndex = -1;
        for (int i = length - 1; i >= 1; i--) {
            if (nums[i] > nums[i - 1]) {
                exIndex = i - 1;
                break;
            }
        }
        if (exIndex != -1) {
            Arrays.sort(nums, exIndex + 1, length);
            for (int i = exIndex + 1; i < length; i++) {
                if (nums[i] > nums[exIndex]) {
                    int temp = nums[i];
                    nums[i] = nums[exIndex];
                    nums[exIndex] = temp;
                    Arrays.sort(nums, exIndex + 1, length);
                    break;
                }
            }
        } else {
            Arrays.sort(nums);
        }
        System.out.println(Arrays.toString(nums));
    }

}
