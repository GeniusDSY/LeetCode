package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/28 9:58
 * @desc : 5.最长回文子串
 * 【题目】
 *      给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 * 【示例】
 *      输入: "babad"
 *      输出: "bab"
 *      注意: "aba" 也是一个有效答案。
 *
 *      输入: "cbbd"
 *      输出: "bb"
 */
public class LongestPalindromicSubstring {

    /**
     * 【想法】 暴力解法
     * 列举所有的子串，判断是否为回文串，保存最长的回文串。
     *
     * @param s
     * @return 【复杂度分析】
     * 时间复杂度：两层 for 循环 O（n²），for 循环里边判断是否为回文，O（n），所以时间复杂度为 O（n³）。
     * 空间复杂度：O（1），常数个变量。
     */
    public String longestPalindrome(String s) {
        String ans = "";
        int max = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j <= len; j++) {
                String test = s.substring(i, j);
                if (isPalindromic(test) && test.length() > max) {
                    ans = test;
                    max = Math.max(max, ans.length());
                }
            }
        }
        return ans;
    }

    public boolean isPalindromic(String s) {
        int len = s.length();
        for (int i = 0; i < len / 2; i++) {
            if (s.charAt(i) != s.charAt(len - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public String longestPalindrome1(String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString(); //字符串倒置
        int length = s.length();
        int[][] arr = new int[length][length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[i][j] = 1;
                    } else {
                        arr[i][j] = arr[i - 1][j - 1] + 1;
                    }
                }
                if (arr[i][j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (beforeRev + arr[i][j] - 1 == i) { //判断下标是否对应
                        maxLen = arr[i][j];
                        maxEnd = i;
                    }

                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    /**
     * 【想法】
     *      使用数组进行记录回文子串的起点索引和末尾索引。
     *      （1）从字符串数组从头进行遍历
     *      （2）因为单个字母的重复就符合回文子串的标准，首先判断当前元素是否和后一元素相等，如果相等，则对末尾记录索引进行+1操作
     *      （3）当判断完重复字母后，我们对称判断前后两个字母是否相等，若相等，则对首记录索引进行--，末尾记录索引进行++
     *      （4）判断首尾记录索引的差值是否大于原纪录值，若大于进行替换
     * @param s
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(n^2)，由于围绕中心来扩展回文会耗去 O(n)O(n) 的时间，所以总的复杂度为 O(n^2)
     *      空间复杂度：O(1)O(1)。
     */
    public String longestPalindrome2(String s) {
        if(s == null ||s.length() == 0){
            return "";
        }
        char[] c = s.toCharArray();
        int[] r = new int[2];
        for(int i=0; i < c.length; i++){
            i = longest(i, r, c);
        }
        return s.substring(r[0], r[1] + 1);
    }
    public int longest(int low, int[] r, char[] c){
        int high = low;
        //判断连续重复的字母个数
        while(high < c.length - 1 && c[low] == c[high + 1]){
            ++high;
        }
        int ans = high;
        //从中心向两侧进行扩散
        while(low > 0 && high < c.length - 1 && c[low - 1] == c[high + 1]){
            --low;
            ++high;
        }
        //若长度大于原纪录长度，则进行替换
        if(high - low > r[1] - r[0]){
            r[0] = low;
            r[1] = high;
        }
        return ans;
    }

        public static void main (String[]args){
            LongestPalindromicSubstring substring = new LongestPalindromicSubstring();
            String a = "abababccba";
            long start = System.nanoTime();
            String result = substring.longestPalindrome(a);
            long end = System.nanoTime();
            System.out.println(result);
            System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
            start = System.nanoTime();
            result = substring.longestPalindrome1(a);
            end = System.nanoTime();
            System.out.println(result);
            System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
            start = System.nanoTime();
            result = substring.longestPalindrome2(a);
            end = System.nanoTime();
            System.out.println(result);
            System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        }
}