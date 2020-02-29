package explore.array;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2020/2/29 10:43
 * @desc :136.只出现一次的数字
 * 【题目】
 *      给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
 * 【说明】
 *      你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 * 【示例】
 *      输入: [2,2,1]
 *      输出: 1
 *
 *      输入: [4,1,2,1,2]
 *      输出: 4
 */
public class SingleNumber {

    /**
     * 【解法一】
     *      1、排序
     *      2、遍历两个一比较
     */
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int j,result = 0;
        for(int i = 0;i < nums.length ; i = i + 2){
            j = i + 1;
            if(i == nums.length - 1 || nums[i] != nums[j]){
                result = nums[i];
                break;
            }
        }
        return result;
    }

    /**
     * 【解法二】        异或运算
     *      数字相同按位异或后为0，最后遍历异或一遍之后得出的结果即为出现一次的数字
     */
    public static int singleNumber2(int[] nums) {
        int n  = nums.length;
        int num=0;
        for(int i=0;i<n;i++){
            num ^= nums[i];
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(singleNumber2(new int[]{1, 1, 2, 2}));
    }

}
