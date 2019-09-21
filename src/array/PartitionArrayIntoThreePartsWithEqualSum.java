package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/21 10:07
 * @desc : 1013.将数组分成和相等的三部分
 * 【题目】
 *      给定一个整数数组 A，只有我们可以将其划分为三个和相等的非空部分时才返回 true，否则返回 false。
 *      形式上，如果我们可以找出索引 i+1 < j 且满足 (A[0] + A[1] + ... + A[i] == A[i+1] + A[i+2] + ... + A[j-1] == A[j] + A[j-1] + ... + A[A.length - 1]) 就可以将数组三等分。
 *【示例】
 *      输出：[0,2,1,-6,6,-7,9,1,2,0,1]
 *      输出：true
 *      解释：0 + 2 + 1 = -6 + 6 - 7 + 9 + 1 = 2 + 0 + 1
 *
 *      输入：[0,2,1,-6,6,7,9,-1,2,0,1]
 *      输出：false
 * 【提示】
 *      3 <= A.length <= 50000
 *      -10000 <= A[i] <= 10000
 */
public class PartitionArrayIntoThreePartsWithEqualSum {

    /**
     * 【想法】
     *      （1）将所有元素求和，对3取余，不可以整除则进行返回
     *      （2）遍历数组，当等于和的1/3时进行计数++
     *      （3）遍历完成后，判断计数器是否为3，true or false
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i : A) {
            sum += i;
        }
        if (sum % 3 != 0){
            return false;
        }
        int s=0;
        int cnt=0;
        for (int a : A) {
            s += a;
            if(s == sum/3){
                cnt++;
                s=0;
            }
        }
        return cnt == 3;
    }

    public static void main(String[] args) {
        PartitionArrayIntoThreePartsWithEqualSum sum = new PartitionArrayIntoThreePartsWithEqualSum();
        int[] arr = new int[]{3,3,6,5,-2,2,5,1,-9,4};
        long start = System.nanoTime();
        boolean result = sum.canThreePartsEqualSum(arr);
        long end = System.nanoTime();
        System.out.println("方法运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
    }

}
