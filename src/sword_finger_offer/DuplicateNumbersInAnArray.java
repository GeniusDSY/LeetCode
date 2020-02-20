package sword_finger_offer;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2020/2/20 15:21
 * @desc : 面试题03.数组中重复的数字
 * 【题目】
 *      找出数组中重复的数字。
 *      在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *【示例】
 *      输入：
 *          [2, 3, 1, 0, 2, 5, 3]
 *      输出：2 或 3
 *【限制】
 *      2 <= n <= 100000
 */
public class DuplicateNumbersInAnArray {

    public int findRepeatNumber1(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] ^ nums[i+1]) == 0){
                result = nums[i];
            }
        }
        return result;
    }

    public int findRepeatNumber2(int[] nums) {
        for(int i=0;i<nums.length;i++){
            while(nums[i]!=i){
                if(nums[i] == nums[nums[i]]){
                    return nums[i];
                }
                int temp = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = temp;
            }
        }
        return 0;
    }
}
