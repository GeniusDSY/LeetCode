package explore.array;

import java.util.Arrays;

/**
 * @author :DengSiYuan
 * @date :2019/9/12 15:51
 * @desc :561. 数组拆分 I
 * 【题目】
 *      给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。、
 * 【示例】
 *      输入: [1,4,3,2]
 *      输出: 4
 *      解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 * 【提示】
 *      n是正整数,范围在 [1, 10000].
 *      数组中的元素范围在 [-10000, 10000].
 */
public class ArrayPartitionI {

    /**
     * 【个人想法】
     *      为了得到两两之间的最小值进行求和，即就是从小排到大，从第一个开始，每两个取一个，也就是取奇数个元素求和即可
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(nlog(n))。排序需要 O(nlog(n)) 的时间。另外会有一次数组的遍历。
     *      空间复杂度：O(1)。仅仅需要常数级的空间.
     * 【说明】
     *      比较稳定，时间复杂度不会产生级数级增长
     */
    public int arrayPairSum(int[] nums) {
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i+=2) {
            result += nums[i];
        }
        return result;
    }



    /**
     * 【LeetCode官方解法 1暴力求解 [超过时间限制]】
     *      简单来说：排列组合遍历所有排序情况，找出最小的
     *      最简单的解决方案是考虑 nums 数组的元素每个可能的配对集。
     *  为了生成所有可能的配对，我们使用函数 permute（nums，current_index）。
     *  此函数创建给定数组元素的所有可能排列。
     *
     *  为此，permute将当前元素 current_index的索引作为参数之一，
     *  然后，它将当前元素与数组中的每个其他元素交换，向右移动，以便生成数组元素的新排序。
     *  在完成交换之后，它再次调用 permute，但这次使用数组中下一个元素的索引。返回时，我们反转当前函数调用中的交换。
     *
     * 因此，当到达数组的末尾时，会生成数组元素的新排序。考虑配对的元素，使得每对的第一个元素来自新数组的前半部分，第二个元素来自数组的后半部分。
     * 因此，我们总结了所有这些可能配对中的最小元素，并找出它们的最大总和。
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(n!)。对于数组中的 n 元素，总共可以 n 排列。
     *      空间复杂度：O(1)。仅需使用常数级的额外空间。
     * 【说明】
     *      在数据量小的情况下，比较快速
     *      在数据量大的情况下，容易超时
     */
    int max_sum = Integer.MIN_VALUE;
    public int arrayPairSum1(int[] nums) {
        permute(nums, 0);
        return max_sum;
    }
    public void permute(int[] nums, int l) {
        if (l == nums.length - 1) {
            int sum = 0;
            for (int i = 0; i < nums.length / 2; i++) {
                sum += Math.min(nums[i], nums[nums.length / 2 + i]);
            }
            max_sum = Math.max(max_sum, sum);
        }
        for (int i = l; i < nums.length; i++) {
            swap(nums, i, l);
            permute(nums, l + 1);
            swap(nums, i, l);
        }
    }
    public void swap(int[] nums, int x, int y) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }

    /**
     * 【LeetCode官方解法 3 使用额外的空间】 没理解
     *      这种方法在某种程度上与排序方法有关。由于给定数组中的元素范围有限 [-10000, 10000]，
     *  我们可以使用 arrarr 的哈希表，这样 arr [i]arr[i] 存储 （i-10000）^ {th}元素的出现频率。
     *  这个减法操作可以保证这个哈希表可以能够存下范围内的所有数字。
     *      因此，现在我们可以直接以递增的顺序遍历哈希表，而不是对数组的元素进行排序。但是，任何元素也可能在给定数组中多次出现。我们需要考虑这个因素。
     *      为此，考虑一个例子：nums：[a，b，a，b，b，a]。这个数组的排序顺序是 nums_sorted：[a，a，a，b，b，b]。
     *（我们实际上并没有在这种方法中对数组进行排序，但是排序的数组仅用于演示）。
     * 从前面的方法，我们知道所需的配对集是 （a，a），（a，b），（b，b）（a，a），（a，b），（b，b）。
     * 现在，我们可以看到，在选择最小元素时，aa 将被选择两次，bb 将仅被选择一次。
     * 发生这种情况是因为要选择的 aa 的数量已经由 aa 的频率确定，其余的地方将由 bb 填补。
     * 这是因为，为了得到正确的结果，我们需要按升序考虑元素。因此，较低的数字总是优先被添加到最终结果。
     *      但是，如果排序的元素采用以下形式：nums_sorted：[a，a，b，b，b，b]，正确的配对将是 （a，a），（b，b），（b，b） ）（a，a），（b，b），（b，b））。
     *      同样，在这种情况下，所选择的aa的数量已经预先确定，但由于 aa 的数量是奇数，因此它不会影响最终总和中 bb 的选择。
     *      因此，基于上面的讨论，我们遍历哈希表 arr。如果当前元素出现 req_i次，并且其中一个元素与右边区域中的其他元素配对（考虑虚拟排序数组），我们考虑当前元素 [freq_i/2]次数以及数组中出现的下一个元素 [freq_i/2]最终总和的次数。
     * 为了传播这个左边对所选数字的影响，我们使用了一个标志 d。如果当前集合中有剩余元素将被再次考虑，则此标志设置为 1。在从下一组中选择元素时，会考虑已考虑的相同额外元素。
     *
     * 在遍历哈希表时，我们确定需要考虑每个元素的正确次数，如上所述。请注意，如果数组中不存在哈希表的当前元素，则标志 d 和 sum保持不变。
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(n)。需要遍历一次哈希表 arr。
     *      空间复杂度：O(n)。存储一个大小为nn哈希表 arr 所需要的空间。。
     */
    public int arrayPairSum2(int[] nums) {
        int[] arr = new int[20001];
        int lim = 10000;
        for (int num: nums) {
            arr[num + lim]++;
        }
        int d = 0, sum = 0;
        for (int i = -10000; i <= 10000; i++) {
            sum += (arr[i + lim] + 1 - d) / 2 * i;
            d = (2 + arr[i + lim] - d) % 2;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,1,1,2,2,2};
        int[] la = new int[]{123,342,54,76,243,-213,-342,-43,126};
        ArrayPartitionI array = new ArrayPartitionI();
        System.out.println("---------短数组测试案例----------");
        long start = System.nanoTime();
        int result=array.arrayPairSum(a);
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("个人想法运行时间：" + (end-start)/ 1000000.0 + "mm");
        long start1 = System.nanoTime();
        int result1=array.arrayPairSum1(a);
        long end1 = System.nanoTime();
        System.out.println(result1);
        System.out.println("暴力解法运行时间：" + (end1-start1)/ 1000000.0 + "mm");
        long start2 = System.nanoTime();
        int result2=array.arrayPairSum2(a);
        long end2 = System.nanoTime();
        System.out.println(result2);
        System.out.println("使用额外的空间解法运行时间：" + (end2-start2)/ 1000000.0 + "mm");
        System.out.println("---------长数组测试案例----------");
        start = System.nanoTime();
        result=array.arrayPairSum(la);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("个人想法运行时间：" + (end-start)/ 1000000.0 + "mm");
        start1 = System.nanoTime();
        result1=array.arrayPairSum1(la);
        end1 = System.nanoTime();
        System.out.println(result1);
        System.out.println("暴力解法运行时间：" + (end1-start1)/ 1000000.0 + "mm");
        start2 = System.nanoTime();
        result2=array.arrayPairSum2(la);
        end2 = System.nanoTime();
        System.out.println(result2);
        System.out.println("使用额外的空间解法运行时间：" + (end2-start2)/ 1000000.0 + "mm");
    }

}
