package sword_finger_offer;

/**
 * @author :DengSiYuan
 * @date :2020/2/20 14:20
 * @desc : 面试题17.打印从1到最大的n位数
 * 【题目】
 *      输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 【示例】
 *      输入: n = 1
 *      输出: [1,2,3,4,5,6,7,8,9]
 * 【说明】
 *      用返回一个整数列表来代替打印
 *      n 为正整数
 */
public class PrintNDigitsFrom1ToMax {

    public int[] printNumbers(int n) {
        int max = 9;
        for (int i = 0; i < n - 1; i++) {
            max = max * 10 + 9;
        }
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i+1;
        }
        return result;
    }

}
