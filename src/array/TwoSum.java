package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :DengSiYuan
 * @date :2019/9/25 21:44
 * @desc : 1.两数之和
 * 【题目】
 *      给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *      你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 * 【示例】
 *      给定 nums = [2, 7, 11, 15], target = 9
 *      因为 nums[0] + nums[1] = 2 + 7 = 9
 *      所以返回 [0, 1]
 */
public class TwoSum {

    /**
     * 【想法】 暴力解法
     *      两层循环，选定一个基准元素，向后遍历找可以满足条件的另一个元素
     * @param nums
     * @param target
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N^2)
     */
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    /**
     * 【想法】
     *      遍历数组，一个一个进行判断，对target - num进行 & 操作，若存在则进行返回
     * @param nums
     * @param target
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)
     */
    public int[] twoSum1(int[] nums,int target){
        int indexArrayMax = 2047;
        int[] indexArrays = new int[indexArrayMax + 1];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            int index = diff & indexArrayMax;
            if (indexArrays[index] != 0) {
                return new int[] { indexArrays[index] - 1 , i };
            }
            indexArrays[nums[i] & indexArrayMax] = i + 1;
        }
        return new int[]{};
    }

    /**
     * 【想法】
     *      遍历元素，对 target-num进行map的containkey判断，若存在，则进行返回 num的i和map的value
     *      若不存在，则将该元素按照(数值,索引)的格式存入map
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        TwoSum sum = new TwoSum();
        int[] arr = new int[]{2,7,11,15};
        long start = System.nanoTime();
        int[] result = sum.twoSum(arr,9);
        long end = System.nanoTime();
        for (int i : result) {
            System.out.print(i);
        }
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = sum.twoSum1(arr,9);
        end = System.nanoTime();
        for (int i : result) {
            System.out.print(i);
        }
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = sum.twoSum2(arr,9);
        end = System.nanoTime();
        for (int i : result) {
            System.out.print(i);
        }
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
    }

}
