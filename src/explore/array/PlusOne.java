package explore.array;

/**
 * @author :DengSiYuan
 * @date :2019/12/1 14:01
 * @desc : 66.加一
 * 【题目】
 *      给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 *      最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 *      你可以假设除了整数 0 之外，这个整数不会以零开头。
 * 【示例】
 *      输入: [1,2,3]
 *      输出: [1,2,4]
 *      解释: 输入数组表示数字 123。
 *
 *      输入: [4,3,2,1]
 *      输出: [4,3,2,2]
 *      解释: 输入数组表示数字 4321。
 */
public class PlusOne {

    /**
     * 【解法】
     *      从尾部开始进行遍历，进行++操作，若进行++后等于10（取余为0）产生进位，那么继续向前循环
     *      若取余不等于0，则未产生进位，直接返回数组即可。
     *      循环结束后仍未返回，那么最高位也产生了进位，即就是(999+1=1000),那么直接创建新数组（length+1）首位赋值1后返回。
     * 【复杂度分析】
     *      时间复杂度：O(N)
     *      空间复杂度：O(1)
     */
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            if (digits[i] != 0){
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

}
