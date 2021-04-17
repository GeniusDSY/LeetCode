package solutions;

import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author :DengSiYuan
 * @date :2021/4/17 9:52
 * @desc : 220.存在重复元素III
 * 【题目】
 * 给你一个整数数组 nums 和两个整数 k 和 t 。请你判断是否存在 两个不同下标 i 和 j，
 * 使得 abs(nums[i] - nums[j]) <= t ，同时又满足 abs(i - j) <= k 。如果存在则返回 true，不存在返回 false。
 * 【示例】
 * 示例 1：
 * 输入：nums = [1,2,3,1], k = 3, t = 0
 * 输出：true
 * 示例 2：
 * 输入：nums = [1,0,1,1], k = 1, t = 2
 * 输出：true
 * 示例 3：
 * 输入：nums = [1,5,9,1,5,9], k = 2, t = 3
 * 输出：false
 * 【提示】
 * 1、0 <= nums.length <= 2 * 104
 * 2、-231 <= nums[i] <= 231 - 1
 * 3、0 <= k <= 104
 * 4、0 <= t <= 231 - 1
 */
public class ContainsDuplicateIII {

    /**
     * 暴力解法，运行时间较长，可能会超出时间限制。
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int i = 0;
        for (; i < nums.length; i++) {
            for (int j = i + 1; j <= ((i + k) < nums.length ? (i + k) : nums.length - 1); j++) {
                // -2^31 - 2^31会超出int
                if (Math.abs((long) nums[i] - (long) nums[j]) <= t) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 滑动窗口 + 有序集合
     * 【时间复杂度】
     *      O(nlog(min(n,k)))，其中 n 是给定数组的长度。每个元素至多被插入有序集合和从有序集合中删除一次，
     *      每次操作时间复杂度均为 O(log(min(n,k))。
     * 【空间复杂度】
     *      O(min(n,k))，其中 n 是给定数组的长度。有序集合中至多包含 min(n,k+1) 个元素。
     */
    public boolean containsNearbyAlmostDuplicate1(int[] nums, int k, int t) {

        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    /**
     * 桶排序
     *
     * 【时间复杂度】
     *      O(n)，其中n是给定数组的长度。每个元素至多被插入哈希表和从哈希表中删除一次，
     *      每次操作的时间复杂度均为 O(1)。
     * 【空间复杂度】
     *      O(min(n,k))，其中 n 是给定数组的长度。哈希表中至多包含min(n,k+1)个元素。
     *
     */
    private long w;

    public boolean containsNearbyAlmostDuplicate2(int[] nums, int k, int t) {
        /*
            k --- index     1
            t ---- value    2147483647
        */
        if (nums.length == 0 || t < 0) {
            return false;
        }

        //long ---id    long value
        HashMap<Long, Long> map = new HashMap<>(16);
        w = (long) t + 1;

        for (int i = 0; i < nums.length; i++) {
            if (i - k - 1 >= 0 && map.containsKey(getId(nums[i - k - 1]))) {
                map.remove(getId(nums[i - k - 1]));
            }
            if (map.containsKey(getId(nums[i]))) {
                return true;
            }
            if (map.containsKey(getId(nums[i]) - 1)
                    && Math.abs(map.get(getId(nums[i]) - 1) - (long) nums[i]) <= t) {
                return true;
            }
            if (map.containsKey(getId(nums[i]) + 1)
                    && Math.abs(map.get(getId(nums[i]) + 1) - (long) nums[i]) <= t) {
                return true;
            }
            map.put(getId(nums[i]), (long) nums[i]);
        }
        return false;
    }

    private long getId(long num) {
        if (num >= 0) {
            return num / w;
        } else {
            return (num - 1) / w - 1;
        }
    }

}
