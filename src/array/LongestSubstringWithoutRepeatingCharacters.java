package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author :DengSiYuan
 * @date :2019/9/27 22:42
 * @desc : 3.无重复字符的最长子串
 * 【题目】
 *     给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 【示例】
 *      输入: "abcabcbb"
 *      输出: 3
 *      解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 *      输入: "bbbbb"
 *      输出: 1
 *      解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * 【想法】 Set去重
     *      （1）遍历字符串数组,将元素值装入set中
     *      （2）判断是否已经存在于Set中，若已存在，则进行下一次循环，否则计数器++
     * @param s
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(N^2)
     */
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int max = 1;
        if (len <= 1){
            return len;
        }else {
            for (int i = 0;i < len;i++){
                Set<Character> set = new HashSet<>();
                set.add(s.charAt(i));
                int temp = 1;
                for(int j = i + 1;j < len;j++){
                    if(set.contains(s.charAt(j))){
                        break;
                    }else{
                        set.add(s.charAt(j));
                        temp++;
                    }
                    max = max > temp ? max : temp;
                }
            }
        }
        return max;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length(), ans = 0;
        int[] index = new int[26]; // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            i = index[s.charAt(j) - 'a'] > i ? index[s.charAt(j) - 'a'] : i;
            ans = ans > j - i + 1 ? ans : j - i + 1;
            index[s.charAt(j) - 'a'] = j + 1;
        }
        return ans;
    }

    /**
     * 【想法】 优化的滑动窗口
     *      上述的方法最多需要执行 2n 个步骤。事实上，它可以被进一步优化为仅需要 n 个步骤。我们可以定义字符到索引的映射，而不是使用集合来判断一个字符是否存在。 当我们找到重复的字符时，我们可以立即跳过该窗口。
     *      也就是说，如果 s[j] 在 [i, j) 范围内有与 j重复的字符，我们不需要逐渐增加 ii 。 我们可以直接跳过 [i，j']范围内的所有元素，并将 i 变为 j' + 1
     * @param s
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(n)，索引 j 将会迭代 n 次。
     *      空间复杂度：O(min(m, n))
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        LongestSubstringWithoutRepeatingCharacters characters = new LongestSubstringWithoutRepeatingCharacters();
        long start = System.nanoTime();
        int result = characters.lengthOfLongestSubstring(s);
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = characters.lengthOfLongestSubstring1(s);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = characters.lengthOfLongestSubstring2(s);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");

    }

}
