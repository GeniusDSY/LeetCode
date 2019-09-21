package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author :DengSiYuan
 * @date :2019/9/20 21:23
 * @desc : 448.找到所有数组中消失的数字
 * 【题目】
 *      给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 *      找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 *      您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 【示例】
 *      输入:
 *          [4,3,2,7,8,2,3,1]
 *      输出:
 *          [5,6]
 */
public class FindAllNumbersDisappearedInAnArray {

    /**
     * 【想法】耗时好长，哭泣
     *      （1）将给定数组排序,例如[1,3,4,4] j
     *      （2）遍历应该存在的数字，例如[1,2,3,4] i
     *      （3）当前所要判断的数字i是否存在于j中，若 i > j，则对j进行++，判断下一个元素是否符合i
     *      （4）当所要判断i < j时，证明了i并不出现在j中，则将i添加到list中，j保持不变，防止下次遍历漏掉
     *      （5）若i==j，则进行j++维护到下一个元素，继续进行判断
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 1,j = 0; i <= nums.length; i++) {
            int temp = j;
            while (temp < nums.length && i > nums[temp]){
                ++temp;
            }
             if (temp >= nums.length || i < nums[temp]){
                list.add(i);
            }else {
                 j++;
             }
        }
        return list;
    }

    /**
     * 【想法】 最优解法
     *      （1）创建与原数组+1等长的boolean数组
     *      （2）遍历原数组，将索引为原数组元素值得元素置为true
     *      （3）遍历boolean数组，若不为true，则添加到list中
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> res=new ArrayList<>();
        boolean[] judge=new boolean[nums.length+1];
        for(int t:nums) {
            judge[t] = true;
        }
        for(int i=1;i<=nums.length;i++) {
            if (!judge[i]) {
                res.add(i);
            }
        }
        return res;
    }

    /**
     * 【想法】
     *     （1）遍历数组，将数值放在该放的位置上（即：a[i] = i+1）
     *      (2)遍历数组，判断各个位置上是否 a[i] = i+1,不相等则将i+1添加到数组中
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length ; i++) {
            while (nums[i] != nums[nums[i]-1]){
                swap(nums,i,nums[i]-1);
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                list.add(i+1);
            }
        }
        return list;
    }

    private void swap(int[] nums, int i, int j){
        nums[i] = nums[j] + nums[i];
        nums[j] = nums[i] - nums[j];
        nums[i] = nums[i] - nums[j];
    }

    public static void main(String[] args) {
        FindAllNumbersDisappearedInAnArray array = new FindAllNumbersDisappearedInAnArray();
        int[] arr = new int[]{10,2,5,10,9,1,1,4,3,7};
        int[] arr1 = new int[]{10,2,5,10,9,1,1,4,3,7};
        int[] arr2 = new int[]{10,2,5,10,9,1,1,4,3,7};
        long start = System.nanoTime();
        List<Integer> list = array.findDisappearedNumbers(arr);
        long end = System.nanoTime();
        System.out.println("数组下标记录方法运行时间：" + (end - start) / 1000000.0 + "ms");
        for (Integer o : list) {
            System.out.print(o);
        }
        System.out.println();
        start = System.nanoTime();
        list = array.findDisappearedNumbers1(arr1);
        end = System.nanoTime();
        System.out.println("数组下标记录方法运行时间：" + (end - start) / 1000000.0 + "ms");
        for (Integer o : list) {
            System.out.print(o);
        }
        System.out.println();
        start = System.nanoTime();
        list = array.findDisappearedNumbers2(arr2);
        end = System.nanoTime();
        System.out.println("数组下标记录方法运行时间：" + (end - start) / 1000000.0 + "ms");
        for (Integer o : list) {
            System.out.print(o);
        }
    }

}