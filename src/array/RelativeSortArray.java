package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/14 20:21
 * @desc :1122.数组的相对排序
 * 【题目】
 *      给你两个数组，arr1 和 arr2，
 *      - arr2 中的元素各不相同
 *      - arr2 中的每个元素都出现在 arr1 中
 *      对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末尾。
 * 【示例】
 *      输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 *      输出：[2,2,2,1,4,3,3,9,6,7,19]
 * 【提示】
 *      - arr1.length, arr2.length <= 1000
 *      - 0 <= arr1[i], arr2[i] <= 1000
 *      - arr2 中的元素 arr2[i] 各不相同
 *      - arr2 中的每个元素 arr2[i] 都出现在 arr1 中
 */
public class RelativeSortArray {

    /**
     * 【想法】
     *      （1）使用数组下标标记元素的数值，用数值标记相同元素的个数
     *      （2）遍历肯定有的数组arr2，通过数组arr2的值作为记录数组的下标进行-->0的判断，依次赋值给结果数组，索引进行++
     *      （3）遍历记录数组，将没有在arr2中的元素进行依次放入到结果数组中
     * @param arr1
     * @param arr2
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)
     */
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] temp = new int[1001];
        int[] result = new int[arr1.length];
        for (int i : arr1) {
            temp[i]++;
        }
        int j = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (temp[arr2[i]]-- > 0){
                result[j++] = arr2[i];
            }
        }
        for (int i = 0; i < temp.length; i++) {
            while (temp[i]-- > 0){
                result[j++] = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = new int[]{2,3,1,3,2,4,6,7,9,2,19};
        int[] arr2 = {2,1,4,3,9,6};
        RelativeSortArray array = new RelativeSortArray();
        long start = System.nanoTime();
        int[] result = array.relativeSortArray(arr1,arr2);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int i : result) {
            System.out.print(i);
        }
    }
}
