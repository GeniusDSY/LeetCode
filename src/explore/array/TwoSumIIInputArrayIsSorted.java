package explore.array;

/**
 * @author :DengSiYuan
 * @date :2019/9/22 9:33
 * @desc : 167. 两数之和 II - 输入有序数组
 * 【题目】
 *      给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *      函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 【说明】
 *      返回的下标值（index1 和 index2）不是从零开始的。
 *      你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 【示例】
 *      输入: numbers = [2, 7, 11, 15], target = 9
 *      输出: [1,2]
 *      解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSumIIInputArrayIsSorted {

    /**
     * 【想法】 暴力解法
     *      遍历两遍数组，逐个进行判断相加若等于目标值，则对索引进行返回
     * @param numbers
     * @param target
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N^2)
     */
    public int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target){
                    result[0] = i+1;
                    result[1] = j+1;
                }
            }
        }
        return result;
    }

    /**
     * 【想法】 双指针法
     *      (1)找到数组的首尾位置的索引（因为数组有序）
     *      (2)若首尾求和后小于目标值，进行low++
     *      (3)若首尾求和后大于目标值，进行high--
     *      (4)当low < high 一直进行循环判断
     * @param numbers
     * @param target
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)
     */
    public int[] twoSum1(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0){return null;}
        int low = 0;int high = numbers.length - 1;
        while (low < high){
            int sum = numbers[low] + numbers[high];
            if (sum == target){
                return new int[]{low+1,high+1};
            }else if (sum < target){
                ++low;
            }else {
                --high;
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        TwoSumIIInputArrayIsSorted arrayIsSorted = new TwoSumIIInputArrayIsSorted();
        int[] numbers = new int[]{-1,0};
        long start = System.nanoTime();
        int[] result = arrayIsSorted.twoSum(numbers,-1);
        long end = System.nanoTime();
        System.out.println("暴力解法运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int i : result) {
            System.out.print(i);
            System.out.print(",");
        }
        System.out.println();
        start = System.nanoTime();
        result = arrayIsSorted.twoSum(numbers,-1);
        end = System.nanoTime();
        System.out.println("双指针运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int i : result) {
            System.out.print(i);
            System.out.print(",");
        }
    }

}
