package explore.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author :DengSiYuan
 * @date :2020/2/29 16:26
 * @desc :350. 两个数组的交集 II
 * 【题目】
 *      给定两个数组，编写一个函数来计算它们的交集。
 * 【示例】
 *      输入: nums1 = [1,2,2,1], nums2 = [2,2]
 *      输出: [2,2]
 *
 *      输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 *      输出: [4,9]
 * 【说明】
 *      输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *      我们可以不考虑输出结果的顺序。
 * 【进阶】
 *      如果给定的数组已经排好序呢？你将如何优化你的算法？
 *      如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 *      如果 nums2 的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 */
public class IntersectionOfTwoArraysII {

    /**
     * 【解法一】        哈希映射
     *      1、如果 nums1 元素个数大于 nums2，则交换数组元素。
     *      2、对于 nums1 的每个元素，添加到 HashMap m 中，如果元素已经存在则增加对应的计数。
     *      3、初始化 k = 0，记录当前交集元素个数。
     *      4、遍历数组 nums2：
     *      5、检查元素在 m 是否存在，若存在且计数为正：
     *      6、将元素拷贝到 nums1[k]，且 k++。
     *      7、减少 m 中对应元素的计数。
     *      8、返回 nums1 前 k 个元素。
     * 【复杂度分析】
     *      时间复杂度：O(n+m)。其中n，m分别代表了数组的大小。
     *      空间复杂度：O(min(n,m))，我们对较小的数组进行哈希映射使用的空间。
     */
    public int[] intersect1(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect1(nums2, nums1);
        }
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : nums1) {
            m.put(n, m.getOrDefault(n, 0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = m.getOrDefault(n, 0);
            if (cnt > 0) {
                nums1[k++] = n;
                m.put(n, cnt - 1);
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    /**
     * 【解法二】    排序
     *      1、对数组 nums1 和 nums2 排序。
     *      2、初始化指针 i，j 和 k 为 0。
     *      3、指针 i 指向 nums1，指针 j 指向 nums2：
     *      4、如果 nums1[i] < nums2[j]，则 i++。
     *      5、如果 nums1[i] > nums2[j]，则 j++。
     *      6、如果 nums1[i] == nums2[j]，将元素拷贝到 nums1[k]，且 i++，j++，k++。
     *      7、返回数组 nums1 前 k 个元素。
     * 【复杂度分析】
     *      时间复杂度：O(nlogn+mlogm)。其中n，m分别代表了数组的大小。我们对数组进行了排序然后进行了线性扫描。
     *      空间复杂度：O(1)，我们忽略存储答案所使用的空间，因为它对算法本身并不重要。
     */
    public int[] intersect2(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

}
