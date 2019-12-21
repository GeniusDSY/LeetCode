package explore.array;

/**
 * @author :DengSiYuan
 * @date :2019/12/21 19:43
 * @desc : 80.删除排序数组中的重复项 II
 * 【题目】
 *      给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。
 *      不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 */
public class RemoveDuplicatesFromSortedArrayII {

    /**
     * 【解法】
     *      1、用一个标识curPos记录当前结尾的位置。
     *      2、如果遍历到的数nums[i]和nums[curPos-1]相等。说明nums[i]==nums[curPos]==nums[curPos-1]。
     *      3、因此已经连续三个数相等了。nums[i]直接忽略即可。
     *      4、如果nums[i]和nums[curPos-1]不相等。则应将其赋值到curPos+1的位置。
     *      5、遍历结束以后。curPos+1就是需要求的新长度。
     */
    public int removeDuplicates(int[] nums) {
        if(nums.length < 3){
            return nums.length;
        }
        int curPos = 1;
        for (int i = 2; i < nums.length ; i++) {
            if(nums[i] != nums[curPos-1]){
                nums[++curPos] = nums[i];
            }
        }
        return curPos+1;
    }
}
