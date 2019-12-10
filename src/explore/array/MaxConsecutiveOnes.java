package explore.array;

/**
 * @author :DengSiYuan
 * @date :2019/9/20 20:21
 * @desc :485.最大连续1的个数
 * 【题目】
 *      给定一个二进制数组， 计算其中最大连续1的个数。
 * 【示例】
 *      输入: [1,1,0,1,1,1]
 *      输出: 3
 *      解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 【注意】
 *      输入的数组只包含 0 和1。
 *      输入数组的长度是正整数，且不超过 10,000。
 */
public class MaxConsecutiveOnes {

    /**
     * 【想法】
     *      （1）判断数组是否为空，为空直接返回0
     *      （2）遍历数组，遇到1就对临时变量temp进行++，遇到非0就行行判断当前记录的temp是否大于max，若大于就换max
     *      （3）到数组末尾仍为1，因此return的时候仍然要判断一下max和temp的大小关系
     * @param nums
     * @return
     */
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        if (nums.length < 1){
            return 0;
        }
        int temp = 0;
        for (int num : nums) {
            if (num == 1){
                temp++;
            }else {
                max = max > temp ? max : temp;
                temp = 0;
            }
        }
        return max > temp ? max : temp;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes ones = new MaxConsecutiveOnes();
        int[] arr = new int[]{1,1,0,1,1,1};
        long start = System.nanoTime();
        int result = ones.findMaxConsecutiveOnes(arr);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
    }

}
