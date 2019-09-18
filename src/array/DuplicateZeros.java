package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/18 13:09
 * @desc : 1089.复写零
 * 【题目】
 *      给你一个长度固定的整数数组 arr，请你将该数组中出现的每个零都复写一遍，并将其余的元素向右平移。
 *      注意：请不要在超过该数组长度的位置写入元素。
 *      要求：请对输入的数组 就地 进行上述修改，不要从函数返回任何东西。
 * 【示例】
 *      输入：[1,0,2,3,0,4,5,0]
 *      输出：null
 *      解释：调用函数后，输入的数组将被修改为：[1,0,0,2,3,0,0,4]
 * 【提示】
 *      1 <= arr.length <= 10000
 *      0 <= arr[i] <= 9
 */
public class DuplicateZeros {

    /**
     * 【想法】 快慢指针
     *      （1）使用两个指标i、j，
     *          i记录复写零之后最终可以存入到原数组的索引位置
     *          j是判断复写零到什么时候会填满整个数组，作为i是否继续++的判断依据
     *      （2）从后向前填充元素
     *          i > 0作为是否填满的标准
     *          将j位置的索引依次进行i位置的数值填充
     *          判断此次填充是否为0，如果为零，j继续--进行填充0
     *          将索引计数进行--前移
     * @param arr
     */
    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int i = 0, j = 0;
        while (j < n) {
            if (arr[i] == 0){ ++j;}
            ++i;
            ++j;
        }
        --i;    // i 回到最后一次合法的位置
        --j;    // j 同理，但 j 仍可能等于 n（例如输入 [0]）
        while (i >= 0) {
            if (j < n){ arr[j] = arr[i];}
            if (arr[i] == 0){ arr[--j] = arr[i];}
            --i;
            --j;
        }
    }

    public void duplicateZeros1(int[] arr) {
        for(int i = 0; i< arr.length; i++){
            if(arr[i] == 0){
                for(int j = arr.length - 1; j > i; j--){
                    arr[j] = arr[j-1];
                }
                i++;
            }
        }
    }


    public static void main(String[] args) {
        DuplicateZeros zeros = new DuplicateZeros();
        int[] arr = new int[]{1,0,2,3,0,4,5,0};
        int[] arr1 = new int[]{1,0,2,3,0,4,5,0};
        long start = System.nanoTime();
        zeros.duplicateZeros(arr);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        start = System.nanoTime();
        zeros.duplicateZeros1(arr1);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int i : arr) {
            System.out.print(i);
        }
    }

}
