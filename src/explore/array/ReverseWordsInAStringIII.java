package explore.array;

import java.util.ArrayList;

/**
 * @author :DengSiYuan
 * @date :2019/12/20 11:54
 * @desc : 557.反转字符串中的单词
 */
public class ReverseWordsInAStringIII {

    /**
     * 【解法一】    最简单解法
     *      1、按照空格拆分
     *      2、遍历，对其中的每个元素进行反转
     * 【时间复杂度】
     *      时间复杂度： O(n)。其中n是字符串的长度。
     *      空间复杂度： O(n)。使用了大小为n的res。
     */
    public String reverseWords1(String s) {
        String words[] = s.split(" ");
        StringBuilder res=new StringBuilder();
        for (String word: words) {
            res.append(new StringBuffer(word).reverse().toString() + " ");
        }
        return res.toString().trim();
    }

    /**
     * 【解法二】    不用自带函数split()和reverse()
     * 【时间复杂度】
     *      时间复杂度：O(n)。其中 n 是字符串的长度。
     *      空间复杂度：O(n)。使用了大小为 n 的 res 。
     */
    public String reverseWords2(String s) {
        String words[] = split(s);
        StringBuilder res=new StringBuilder();
        for (String word: words) {
            res.append(reverse(word) + " ");
        }
        return res.toString().trim();
    }
    public String[] split(String s) {
        ArrayList<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                words.add(word.toString());
                word = new StringBuilder();
            } else {
                word.append(s.charAt(i));
            }
        }
        words.add(word.toString());
        return words.toArray(new String[words.size()]);
    }
    public String reverse(String s) {
        StringBuilder res=new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            res.insert(0, s.charAt(i));
        }
        return res.toString();
    }

}
