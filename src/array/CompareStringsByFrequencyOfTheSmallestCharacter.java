package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/19 22:06
 * @desc : 1170.比较字符串最小字母出现频次
 * 【题意】
 *      我们来定义一个函数 f(s)，其中传入参数 s 是一个非空字符串；该函数的功能是统计 s  中（按字典序比较）最小字母的出现频次。
 *      例如，若 s = "dcce"，那么 f(s) = 2，因为最小的字母是 "c"，它出现了 2 次。
 *      现在，给你两个字符串数组待查表 queries 和词汇表 words，请你返回一个整数数组 answer 作为答案，其中每个 answer[i] 是满足 f(queries[i]) < f(W) 的词的数目，W 是词汇表 words 中的词。
 * 【示例】
 *      输入：queries = ["cbd"], words = ["zaaaz"]
 *      输出：[1]
 *      解释：查询 f("cbd") = 1，而 f("zaaaz") = 3 所以 f("cbd") < f("zaaaz")。
 * 【示例】
 *      输入：queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 *      输出：[1,2]
 *      解释：第一个查询 f("bbb") < f("aaaa")，第二个查询 f("aaa") 和 f("aaaa") 都 > f("cc")。
 * 【提示】
 *      ① 1 <= queries.length <= 2000
 *      ② 1 <= words.length <= 2000
 *      ③ 1 <= queries[i].length, words[i].length <= 10
 *      ④ queries[i][j], words[i][j] 都是小写英文字母
 */
public class CompareStringsByFrequencyOfTheSmallestCharacter {

    /**
     * 【想法】
     *      （1）遍历词汇表中的各个字符串的最小字母出现的频次（下标代表各个元素长度，数值表示该长度的元素个数）
     *      （2）累和求出长度为0~9任何长度时比他长的词汇表元素个数（求比他大的个数应该从后向前累加、求比他小的应该从前向后累加）
     *      （3）根据遍历待查表各个元素的长度 + 1作为累和数组的下标进行获取比待查元素长的元素个数
     * @param queries
     * @param words
     * @return
     */
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        // 统计词汇表中各个字符串的最小字母的出现频次
        int [] counter = new int[12];
        for (String word : words) {
            counter[fs(word)]++;
        }
        // 累和得到每个位置比他大的元素数（案例中["a","aa","aaa","aaaa"],长度分别为(1,2,3,4),那么计算后的counter为[4,4,3,2,1,0,0,0,0]）
        for (int i = 9; i >= 0; i--) {
            counter[i] += counter[i + 1];
        }
        // 拿值
        int[] ret = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ret[i] = counter[fs(queries[i]) + 1];
        }
        return ret;
    }

    /**
     * 返回字符串中最小元素的出现频次
     * @param str
     * @return
     */
    public int fs(String str) {
        if (str.length() < 2) {
            return str.length();
        }
        char temp = str.charAt(0);
        int max = 1;
        for (int i = 1; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == temp) {
                max += 1;
            }
            else if (ch < temp) {
                max = 1;
                temp = ch;
            } else {
                continue;
            }
        }
        return max;
    }

    public static void main(String[] args) {

        CompareStringsByFrequencyOfTheSmallestCharacter character = new CompareStringsByFrequencyOfTheSmallestCharacter();
        String[] queries = new String[]{"bbb","cc"};
        String[] words = new String[]{"a","aa","aaa","aaaa"};
        long start = System.nanoTime();
        int[] result = character.numSmallerByFrequency(queries,words);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (int i : result) {
            System.out.print(i + ",");
        }
    }

}
