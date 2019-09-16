package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author :DengSiYuan
 * @date :2019/9/16 19:47
 * @desc : 169.求众数
 * 【题目】
 *      给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 *      你可以假设数组是非空的，并且给定的数组总是存在众数。
 * 【示例】
 *      输入: [3,2,3]
 *      输出: 3
 *      输入: [2,2,1,1,1,2,2]
 *      输出: 2
 */
public class MajorityElement {

    /**
     * 【想法】
     *      将元素放入到map中，key为元素值，value为元素个数，判断哪个超过了半数，进行返回
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N)N为数组长度
     *      空间复杂度：O(n)
     */
    public int majorityElement(int[] nums) {
        int result = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.get(num) == null){
                map.put(num,1);
            }else {
                map.put(num,map.get(num)+1);
            }
        }
        for (int num : nums) {
            if (map.get(num) > nums.length / 2){
                result = num;
            }
        }
        return result;
    }

    /**
     * 【想法】 Boyer-Moore 投票算法
     *      从第一个元素作为标准进行计数，遇到相同的就++，不同的就--，减到0了就重新赋值当前位置的元素，因为众数超过一半，所以最后至少会剩下1不会减到0，故返回值就是众数。
     * @param nums
     * @return
     * 【复杂度分析】
     *      空间复杂度：O(n)
     *      空间复杂度：O(1)
     */
    public int majorityElement1(int[] nums) {
        int count =0;
        int temp =0;
        for(int i =0;i<nums.length;i++) {
            if(count==0) {
                temp =nums[i];
            }
            if(nums[i]==temp) {
                count++;
            }
            else {
                count--;
            }

        }
        return temp;
    }

    /**
     * 【想法】
     *      排序后，因为超过了半数，那么最中间那个一定是众数
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(nlgn)
     *      空间复杂度：O(1)或者 O(n)
     *      我们将 nums 就地排序，如果不能就低排序，我们必须使用线性空间将 nums 数组拷贝，然后再排序。
     */
    public int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * 【思路】 分治算法
     *      如果我们知道数组左边一半和右边一半的众数，我们就可以用线性时间知道全局的众数是哪个。
     * 【算法】
     *      这里我们使用经典的分治算法递归求解，直到所有的子问题都是长度为 1 的数组。由于传输子数组需要额外的时间和空间，所以我们实际上只传输子区间的左右指针 lo 和 hi 表示相应区间的左右下标。长度为 1 的子数组中唯一的数显然是众数，直接返回即可。如果回溯后某区间的长度大于 1 ，我们必须将左右子区间的值合并。如果它们的众数相同，那么显然这一段区间的众数是它们相同的值。否则，我们需要比较两个众数在整个区间内出现的次数来决定该区间的众数。原问题的答案就是下标为 0 和 n 之间的众数这一子问题。
     * @param nums
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(nlgn)
     *      空间复杂度：O(lgn)
     */
    private int countInRange(int[] nums, int num, int lo, int hi) {
        int count = 0;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] == num) {
                count++;
            }
        }
        return count;
    }

    private int majorityElement3(int[] nums, int lo, int hi) {
        // base case; the only element in an array of size 1 is the majority
        // element.
        if (lo == hi) {
            return nums[lo];
        }

        // recurse on left and right halves of this slice.
        int mid = (hi-lo)/2 + lo;
        int left = majorityElement3(nums, lo, mid);
        int right = majorityElement3(nums, mid+1, hi);

        // if the two halves agree on the majority element, return it.
        if (left == right) {
            return left;
        }

        // otherwise, count each element and return the "winner".
        int leftCount = countInRange(nums, left, lo, hi);
        int rightCount = countInRange(nums, right, lo, hi);

        return leftCount > rightCount ? left : right;
    }

    public int majorityElement3(int[] nums) {
        return majorityElement3(nums, 0, nums.length-1);
    }

    public static void main(String[] args) {
        MajorityElement element = new MajorityElement();
        int[] arr = new int[]{-1,-1,1,1,1,1,2};
        long start = System.nanoTime();
        int result = element.majorityElement(arr);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
        start = System.nanoTime();
        result = element.majorityElement1(arr);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
        start = System.nanoTime();
        result = element.majorityElement2(arr);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
        start = System.nanoTime();
        result = element.majorityElement3(arr);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
    }

}
