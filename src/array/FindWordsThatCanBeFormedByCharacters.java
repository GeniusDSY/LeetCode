package array;

/**
 * @author :DengSiYuan
 * @date :2019/9/15 22:17
 * @desc : 1160.拼写单词
 * 【题目】
 *      给你一份『词汇表』（字符串数组） words 和一张『字母表』（字符串） chars。
 *      假如你可以用 chars 中的『字母』（字符）拼写出 words 中的某个『单词』（字符串），那么我们就认为你掌握了这个单词。
 *      注意：每次拼写时，chars 中的每个字母都只能用一次。
 *      返回词汇表 words 中你掌握的所有单词的 长度之和。
 * 【示例】
 *      输入：words = ["cat","bt","hat","tree"], chars = "atach"
 *      输出：6
 *      解释：
 *          可以形成字符串 "cat" 和 "hat"，所以答案是 3 + 3 = 6。
 * 【提示】
 *      ① 1 <= words.length <= 1000
 *      ② 1 <= words[i].length, chars.length <= 100
 *      ③ 所有字符串中都仅包含小写英文字母
 */
public class FindWordsThatCanBeFormedByCharacters {

    /**
     * 【想法】
     *      （1）将所给字符按照ASCII值 - a的ASCII为下标进行记录，数值作为数量的记录
     *      （2）遍历所需要计算的字符串数组，找到相关字母所对应的索引进行--并判断是否>0，进行计数
     *      （3）判断计数器是否与该字符串的长度相同，相同即为可以组成该单词，则进行最终计数器++操作
     * @param words
     * @param chars
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(M*N)
     */
    public int countCharacters(String[] words, String chars) {
        char[] target = chars.toCharArray();
        int[] temp = new int[26];
        int result = 0;
        for (char c : target) {
            temp[c - 'a']++;
        }
        for (String word : words) {
            char[] src = word.toCharArray();
            int one = 0;
            int[] t = temp.clone();
            for (char c : src) {
                if(t[c - 'a']-- > 0){
                    one++;
                }
            }
            if (one == word.length()){
                result += one;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FindWordsThatCanBeFormedByCharacters characters = new FindWordsThatCanBeFormedByCharacters();
        String[] words = new String[]{"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        long start = System.nanoTime();
        int result = characters.countCharacters(words,chars);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        System.out.println(result);
    }

}
