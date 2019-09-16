package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :DengSiYuan
 * @date :2019/9/16 19:47
 * @desc : 169.求众数
 * 【题目】
 *      给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *      你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 【示例】
 *      输入: [3,2,3]
 *      输出: 3
 *      输入: [2,2,1,1,1,2,2]
 *      输出: 2
 */
public class MajorityElement {

    /**
     * 【想法】
     *      将元素放入到map中，key为元素值，value为元素个数，判断哪个超过了半数，进行返回
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)N为数组长度
     */
    public int majorityElement(int[] nums) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }
        }
        for (int num : nums) {
            if (map.get(num) > nums.length / 2){
                result = num;
            }
        }
        return result;
    }

    /**
     * 【想法】
     *      从第一个元素作为标准进行计数，遇到相同的就++，不同的就--，减到0了就重新赋值当前位置的元素，因为众数超过一半，所以最后至少会剩下1不会减到0，故返回值就是众数。
     * @param nums
     * @return
     */
    public int majorityElement1(int[] nums) {
        int count =0;
        int temp =0;
        for(int i =0;i<nums.length;i++) {
            if(count==0) {
                temp =nums[i];
            }
            if(nums[i]==temp) {
                count++;
            }
            else {
                count--;
            }

        }
        return temp;
    }

    /**
     * 【想法】
     *      排序后，因为超过了半数，那么最中间那个一定是众数
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        int[] arr = new int[]{-1,-1,1,1,1,1,2};
        long start = System.nanoTime();
        int result = element.majorityElement(arr);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
        start = System.nanoTime();
        result = element.majorityElement1(arr);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
        start = System.nanoTime();
        result = element.majorityElement2(arr);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
    }

}
