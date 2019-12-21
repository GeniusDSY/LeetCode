package explore.array;

/**
 * @author :DengSiYuan
 * @date :2019/9/17 16:49
 * @desc :283.移动零
 * 【题目】
 *      给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 【示例】
 *      输入: [0,1,0,3,12]
 *      输出: [1,3,12,0,0]
 * 【说明】
 *      ① 必须在原数组上操作，不能拷贝额外的数组。
 *      ② 尽量减少操作次数。
 */
public class MoveZeroes {

    /**
     * 【想法】
     *      （1）遍历目标数组，遇到非零数值进行依次覆盖，并进行计数
     *      （2）遍历完成后，从所记非零数值的个数作为遍历首索引进行零的赋值，直到结尾
     * @param nums
     * 【复杂度分析】
     *      时间复杂度：O(N+M)N为元素的数组元素的个数，M为0元素的个数
     */
    public void moveZeroes(int[] nums) {
        int count = 0;
        for (int i = 0,j = 0; i < nums.length; i++) {
            if (nums[i] != 0){
                nums[j++] = nums[i];
                count++;
            }
        }
        for (int i = count; i < nums.length; i++) {
            nums[i] = 0;
        }
        for (int num : nums) {
            System.out.print(num);
        }
    }

    public static void main(String[] args) {
        MoveZeroes zeroes = new MoveZeroes();
        int[] arr = new int[]{0,1,0,3,12};
        long start = System.nanoTime();
        zeroes.moveZeroes(arr);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
    }

}
