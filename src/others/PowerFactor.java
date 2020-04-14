package others;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2020/4/14 17:37
 * @desc :
 * 【题目】     无重复幂因子的完美数
 *      输入两个数N,R，若N是由R的c次方和相加组成，并且幂均不重复，则N称为无重复幂因子的完美数
 * 【示例】
 *      输入:39,3
 *          39 = 3^1 + 3^2 + 3^3
 *      输出：[1,2,3]
 *
 *      输入：33,3
 *          33 = 3^1 + 3^1 + 3^3
 *      输出：[] 因为次幂重复了
 */
public class PowerFactor {

    /**
     * 返回无重复幂因子的 N进制完美数之和的所有幂因子
     * @param R int整型
     * @param N int整型 N进制
     * @return int整型一维数组
     * 想法：N是几就将R转换为N进制，若当前位置不是1，即有重复。
     */
    public static int[] getPowerFactor (int R, int N) {
        // write code here
        char[] baseNumber = new StringBuilder(Integer.toString(R, N)).reverse().toString().toCharArray();
        int[] result = new int[baseNumber.length];
        int j = 0;
        int index = 0;
        for (int i = 0; i < baseNumber.length; i++) {
            if (baseNumber[i] == '1'){
                result[j++] = i;
                index++;
            }else if (baseNumber[i] == '0'){
                continue;
            }else {
                return new int[]{};
            }
        }
        return Arrays.copyOfRange(result,0,index);
    }

    public static void main(String[] args) {
        for (int i : getPowerFactor(39, 3)) {
            System.out.println(i);
        }
    }

}
