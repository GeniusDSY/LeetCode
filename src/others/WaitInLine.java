package others;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author :DengSiYuan
 * @date :2020/4/14 18:04
 * @desc :
 * 【题目】     排队最大满意度
 *      有一个n人的队列，每个人都有自己的满意度，位于第i个人的满意度计算公式 s = ai * i + (n - i) * bi
 * 【示例】
 *      输入:[8,9,7][5, 8, 3]
 *      输出：[3,1,2]
 */
public class WaitInLine {

    public static int[] waitInLine (int[] a, int[] b) {
        // write code here
        int[] weights = new int[a.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            weights[i] = Math.abs(a[i] - b[i]);
            map.put(weights[i],i+1);
        }
        Arrays.sort(weights);
        int[] result = new int[a.length];
        for (int i = 0; i < result.length; i++) {
            result[result.length - 1 - i] = map.get(weights[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        waitInLine(new int[]{8,9,7},new int[]{5, 8, 3});
    }

}
