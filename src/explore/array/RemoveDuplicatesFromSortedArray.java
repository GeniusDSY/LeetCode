package explore.array;

/**
 * @author :DengSiYuan
 * @date :2019/12/21 18:59
 * @desc : 26.删去排序数组中的重复项
 * 【题目】
 *      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 【示例】
 *      给定数组 nums = [1,1,2],
 *      函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 *      你不需要考虑数组中超出新长度后面的元素。
 *
 *      给定 nums = [0,0,1,1,1,2,2,3,3,4],
 *      函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
 *      你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveDuplicatesFromSortedArray {

    /**
     * 【解法一】    双指针
     *      数组完成排序后，我们可以放置两个指针i和j，其中 i是慢指针，而j是快指针。只要nums[i] = nums[j]，我们就增加j以跳过重复项。
     *      当我们遇到nums[j]!=nums[i] 时，跳过重复项的运行已经结束，因此我们必须把它（nums[j]）的值复制到 nums[i+1]。
     *      然后递增 i，接着我们将再次重复相同的过程，直到 j 到达数组的末尾为止。
     * 【复杂度分析】
     *      时间复杂度：O(n)，假设数组的长度是 n，那么i和j分别最多遍历n步。
     *      空间复杂度：O(1)。
     */
    public int removeDuplicates1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
