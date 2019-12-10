package explore.array;

/**
 * @author :DengSiYuan
 * @date :2019/9/21 17:35
 * @desc :27.移除元素
 * 【题目】
 *      给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 *      元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * 【示例】
 *      给定 nums = [3,2,2,3], val = 3,
 *      函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。
 *      你不需要考虑数组中超出新长度后面的元素
 */
public class RemoveElement {

    /**
     * 【想法】 快慢指针
     *      遍历数组，当遇到数组中元素不等于指定元素的时候，就将他从原数组0的位置开始覆盖赋值
     * 【复杂度分析】
     *      时间复杂度：O(N)
     *      空间复杂度：O(1)
     */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{3,3,3,2,2,3,3,3};
        RemoveElement element = new RemoveElement();
        long start = System.nanoTime();
        int result = element.removeElement(arr,3);
        System.out.println(result);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int i = 0; i < result; i++) {
            System.out.print(arr[i]);
        }
    }

}
