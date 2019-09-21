package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/21 18:38
 * @desc :268.缺失数字
 * 【题目】
 *      给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 * 【示例】
 *      输入: [3,0,1]
 *      输出: 2
 */
public class MissingNumber {

    /**
     * 【想法】
     *      求和之后和本应该的结果做差
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        int s = 0;
        int length = nums.length;
        for (int num : nums) {
            s += num;
        }
        return length *(length + 1) / 2 - s;
    }

    /**
     * 【想法】
     *      由于异或运算（XOR）满足结合律，并且对一个数进行两次完全相同的异或运算会得到原来的数，因此我们可以通过异或运算找到缺失的数字。
     * 【算法】
     *      我们知道数组中有 nn 个数，并且缺失的数在 [0..n][0..n] 中。因此我们可以先得到 [0..n][0..n] 的异或值，再将结果对数组中的每一个数进行一次异或运算。未缺失的数在 [0..n][0..n] 和数组中各出现一次，因此异或后得到 0。而缺失的数字只在 [0..n][0..n] 中出现了一次，在数组中没有出现，因此最终的异或结果即为这个缺失的数字
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(n)O(n)。这里假设异或运算的时间复杂度是常数的，总共会进行 O(n)O(n) 次异或运算，因此总的时间复杂度为 O(n)O(n)。
     *      空间复杂度：O(1)O(1)。算法中只用到了 O(1)O(1) 的额外空间，用来存储答案。
     */
    public int missingNumber1(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public static void main(String[] args) {
        MissingNumber number = new MissingNumber();
        int[] arr = new int[]{3,1,5,7,2,6,0};
        long start = System.nanoTime();
        int result = number.missingNumber(arr);
        System.out.println(result);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = number.missingNumber1(arr);
        System.out.println(result);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
    }

}
