package array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :DengSiYuan
 * @date :2019/9/22 9:04
 * @desc : 217.存在重复元素
 * 【题目】
 *      给定一个整数数组，判断是否存在重复元素。
 *      如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 【示例】
 *      输入: [1,2,3,1]
 *      输出: true
 */
public class ContainsDuplicat {

    /**
     * 【想法】 暴力解法
     *      直接两层遍历，判断后面的有没有和前面的一样的，有一样的就返回true
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N^2)
     *      空间复杂度 : O(1)。只使用了常数额外空间。
     */
    public boolean containsDuplicate(int[] nums) {
        boolean result = false;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    result = true;
                    break;
                }
            }
        }
        return result;
    }

    /**
     * 【想法】 排序
     *      排序后，我们就可以很快的通过一层循环判断前后两个数值是否相等
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度 : O(nlogn)。排序的复杂度是 O(nlogn)，扫描的复杂度是O(n)。整个算法主要由排序过程决定，因此是 O(nlogn)。
     *      空间复杂度 : O(1) 这取决于具体的排序算法实现，通常而言，使用 堆排序 的话，是 O(1)。
     * 【注意】
     *      此处的算法实现对原始数组进行排序，修改了原始数组。通常，除非调用方清楚输入数据将被修改，否则不应该随意修改输入数据。可以先复制 nums，然后对副本进行操作。
     */
    public boolean containsDuplicate1(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; ++i) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 【想法】 哈希表
     *      从方法一中我们知道，对无序数组的查找操作的时间复杂度为 O(n)O(n)，而我们会重复调用查找操作。因此，使用搜索时间更快的数据结构将加快整个算法的速度。
     *      有许多数据结构常用作动态集合,如二进制搜索树和哈希表。这里我们需要的操作是 search 和 insert。对于平衡二叉搜索树（Java 中的 TreeSet 或 TreeMap），search 和 insert 的时间复杂度均为O(logn)。对于哈希表（Java 中的 HashSet 或 HashMap），search 和 insert 的平均时间复杂度为 O(1)。因此，通过使用哈希表，我们可以达到在线性时间复杂度解决问题。
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度 : O(n)。search() 和 insert() 各自使用 n 次，每个操作耗费常数时间。
     *      空间复杂度 : O(n)。哈希表占用的空间与元素数量是线性关系。
     * 【注意】
     *      对于一些特定的 n 不太大的测试样例，本方法的运行速度可能会比方法二更慢。这是因为哈希表在维护其属性时有一些开销。要注意，程序的实际运行表现和 Big-O 符号表示可能有所不同。Big-O 只是告诉我们在 充分 大的输入下，算法的相对快慢。因此，在 n 不够大的情况下， O(n) 的算法也可以比 O(nlogn)的更慢。
     */
    public boolean containsDuplicate2(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int x: nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        ContainsDuplicat duplicat = new ContainsDuplicat();
        long start = System.nanoTime();
        boolean result = duplicat.containsDuplicate(arr);
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = duplicat.containsDuplicate1(arr);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = duplicat.containsDuplicate2(arr);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
    }

}
