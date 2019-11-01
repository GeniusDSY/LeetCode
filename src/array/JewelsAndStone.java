package array;

/**
 * @author :DengSiYuan
 * @date :2019/10/31 20:57
 * @desc : 771.宝石与石头
 * 【题目】
 *       给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 *      J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 【示例】
 *      示例 1:
 *          输入: J = "aA", S = "aAAbbbb"
 *          输出: 3
 *      示例 2:
 *          输入: J = "z", S = "ZZ"
 *          输出: 0
 * 【注意】
 *      S 和 J 最多含有50个字母。
 *      J 中的字符不重复。
 */
public class JewelsAndStone {

    public int numJewelsInStones1(String J, String S) {
        int result = 0;
        int[] letter = new int[58];
        char[] chars = S.toCharArray();
        char[] target = J.toCharArray();
        for (char a : target) {
            letter[a - 'A']++;
        }
        for (char c : chars) {
            if (letter[c - 'A'] >= 1){
                result++;
            }
        }
        return result;
    }

    public int numJewelsInStones2(String J, String S) {
        if (J.length() == 0 || S.length() == 0) {
            return 0;
        }
        int res = 0;
        for (char c : S.toCharArray()) {
            if (J.indexOf(c) != -1) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        JewelsAndStone stone = new JewelsAndStone();
        long start = System.nanoTime();
        int result = stone.numJewelsInStones1("z","ZZ");
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = stone.numJewelsInStones2("z","ZZ");
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
    }

}
