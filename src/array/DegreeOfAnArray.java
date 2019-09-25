package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :DengSiYuan
 * @date :2019/9/25 17:11
 * @desc : 697.数组的度
 * 【题目】
 *      给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 *      你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 【示例】
 *      输入: [1, 2, 2, 3, 1]
 *      输出: 2
 *      解释:
 *          输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 *          连续子数组里面拥有相同度的有如下所示:
 *          [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 *          最短连续子数组[2, 2]的长度为2，所以返回2.
 * 【注意】
 *      ① nums.length 在1到50,000区间范围内。
 *      ② nums[i] 是一个在0到49,999范围内的整数。
 */
public class DegreeOfAnArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, Integer> left = new HashMap<>(),
                right = new HashMap<>(), count = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (left.get(x) == null) {
                left.put(x, i);
            }
            right.put(x, i);
            count.put(x, count.getOrDefault(x, 0) + 1);
        }

        int ans = nums.length;
        int degree = Collections.max(count.values());
        for (int x: count.keySet()) {
            if (count.get(x) == degree) {
                ans = Math.min(ans, right.get(x) - left.get(x) + 1);
            }
        }
        return ans;
    }

    public int findShortestSubArray1(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int[] mapSize = new int[max + 1];
        int[] mapMin = new int[max + 1];
        int[] mapMax = new int[max + 1];
        int maxSize = 1;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (mapSize[num] == 0) {
                mapMin[num] = i;
                mapMax[num] = i;
            } else {
                mapMax[num] = i;
            }
            maxSize = Math.max(maxSize, ++mapSize[num]);
        }
        int ans = Integer.MAX_VALUE;
        for (int num = 0; num <= max; num++) {
            if (maxSize == mapSize[num]) {
                ans = Math.min(ans, mapMax[num] - mapMin[num] + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        DegreeOfAnArray anArray = new DegreeOfAnArray();
        int[] arr = new int[]{1, 2, 2, 3, 1};
        long start = System.nanoTime();
        int result = anArray.findShortestSubArray(arr);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
        start = System.nanoTime();
        result = anArray.findShortestSubArray1(arr);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
    }

}
