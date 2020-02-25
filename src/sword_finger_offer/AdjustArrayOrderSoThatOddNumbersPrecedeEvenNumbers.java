package sword_finger_offer;

/**
 * @author :DengSiYuan
 * @date :2020/2/25 21:36
 * @desc : 面试题21.调整数组顺序使奇数位于偶数前面
 * 【题目】
 *      输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * 【示例】
 *      输入：nums = [1,2,3,4]
 *      输出：[1,3,2,4]
 *      注：[3,1,2,4] 也是正确的答案之一。
 * 【提示】
 *      1、1 <= nums.length <= 50000
 *      2、1 <= nums[i] <= 10000
 */
public class AdjustArrayOrderSoThatOddNumbersPrecedeEvenNumbers {

    /**
     * 【解法一】    双指针
     *      1、首i尾j进行判断，向中心交换
     *      2、首奇尾偶不变i++,j--
     *         首偶尾奇交换i++,j--，
     *         首偶尾偶头指针不移动j--，
     *         首奇尾奇尾指针不动i++
     */
    public int[] exchange(int[] nums) {
        int length = nums.length;
        int temp = 0,i = 0,j = length - 1;
        while(i < j){
            if (nums[i] % 2 == 0 && nums[j] % 2 != 0){
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;j--;
            }else if (nums[i] % 2 != 0 && nums[j] % 2 == 0){
                i++;j--;
            }else if (nums[i] % 2 == 0 && nums[j] % 2 == 0){
                j--;
            }else {
                i++;
            }
        }
        return nums;
    }

}
