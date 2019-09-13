package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/10 18:51
 * @desc : 1051、高度检查器
 * 【题目】
 *      学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
 *
 *【示例】
 *      输入：[1,1,4,2,1,3]
 *      输出：3
 *      解释：
 *      高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
 *
 * 【提示】
 *      ① 1 <= heights.length <= 100
 *      ② 1 <= heights[i] <= 100
 */
public class HeightChecker {

    /**
     * 【想法】
     *    本来是想将该数组进行从头遍历，进行前后比对
     *    但发现存在某生虽然比前一个的数字小，但是后面存在一个比这俩数都小的数字例如：
     *    4，2，1这里并不是三个都站错了位置，而只有4，2站错了，应当互换。计数错误
     * 改进想法：
     *    1、我们可以创建一个数组（看到题目要求的范围是100，我们创建一个容量为100的即可），
     *    逐一遍历传入数组的值，使新数组在索引为该值的地方++，进行元素顺序计数（例如有三个1，则计数数组索引为1的位置为3）
     *    2、遍历计数数组，从小到大遍历，遇到有值的索引与原数组进行对比，若不同则进行人数+1
     * @param heights
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(n)，计数过程为 O(n)，比较过程外层循环次数固定为 100，里层循环一共也只会执行 n 次，O(100+n)，即 O(n)
     *      空间复杂度：O(1) ，其中一个固定长度的计数数组与一个统计变量，与输入 N 的大小无关
     */
    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        //遍历进行计数，将原数组的值当作计数数组的索引进行++操作
        for (int height : heights) {
            arr[height]++;
        }
        int count = 0;
        //遍历计数数组
        for (int i = 1, j = 0; i < arr.length; i++) {
            //判断原数组是否存在值为计数数组的索引（即计数数组的值>0）
            while (arr[i]-- > 0) {
                //匹配计数数组索引（按非递减顺序排列的），若不匹配，则没有在正确位置，进行++
                if (heights[j++] != i){
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] a = {1,1,4,2,1,3};
        HeightChecker heightChecker = new HeightChecker();
        System.out.println(heightChecker.heightChecker(a));
    }

}
