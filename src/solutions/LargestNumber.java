package solutions;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2021/4/12 15:21
 * @desc : 179.最大数
 * 【题目】
 *      给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
 *      注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。
 * 【示例】
 *      示例 1：
 *          输入：nums = [10,2]
 *          输出："210"
 *      示例 2：
 *          输入：nums = [3,30,34,5,9]
 *          输出："9534330"
 *      示例 3：
 *          输入：nums = [1]
 *          输出："1"
 *      示例 4：
 *          输入：nums = [10]
 *          输出："10"
 * 【提示】
 *      1、1 <= nums.length <= 100
 *      2、0 <= nums[i] <= 10^9
 */
public class LargestNumber {

    public String largestNumber(int[] nums) {

        int n = nums.length;
        // 转换成包装类型，以便传入 Comparator 对象（此处为 lambda 表达式）
        Integer[] numsArr = new Integer[n];
        for (int i = 0; i < n; i++) {
            numsArr[i] = nums[i];
        }

        Arrays.sort(numsArr, (x, y) -> {
            long sx = 10, sy = 10;
            while (sx <= x) {
                sx *= 10;
            }
            while (sy <= y) {
                sy *= 10;
            }
            return (int) (-sy * x - y + sx * y + x);
        });

        if (numsArr[0] == 0) {
            return "0";
        }
        StringBuilder ret = new StringBuilder();
        for (int num : numsArr) {
            ret.append(num);
        }
        return ret.toString();

    }
}
