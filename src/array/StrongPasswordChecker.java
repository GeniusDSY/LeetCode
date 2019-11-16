package array;

import java.util.ArrayList;

/**
 * @author :DengSiYuan
 * @date :2019/11/14 19:22
 * @desc : 420. 强密码检验器
 * 【题目】
 *      一个强密码应满足以下所有条件：
 *          1、由至少6个，至多20个字符组成。
 *          2、至少包含一个小写字母，一个大写字母，和一个数字。
 *          3、同一字符不能连续出现三次 (比如 "...aaa..." 是不允许的, 但是 "...aa...a..." 是可以的)。
 * 编写函数 strongPasswordChecker(s)，s 代表输入字符串，如果 s 已经符合强密码条件，则返回0；否则返回要将 s 修改为满足强密码条件的字符串所需要进行修改的最小步数。
 * 插入、删除、替换任一字符都算作一次修改。
 */
public class StrongPasswordChecker {

    /**
     * 【问题答案】
     *      该解法存在问题！！
     * 【想法】
     *      （1）result：记录的该字符串中超过三个连续的（需要  改  或者  删除  操作）
     *      （2）lack：记录大写字母、小写字母、数字缺少的种类数（需要  增加  或者  更改  操作）
     *      （3）最后比较长度是否符合规范，计算出相差的（6 - length  或者  length - 20）
     *      因为考虑到result和lack可以在源字符串基础上进行变换，那么就谁大选谁，根据选择的大的。
     *      然后使用筛选出来的result和lack的较大的一个与长度差距进行比较，选择较大的一方
     *  【问题原因】
     *       因为在result中存在3个以上的连续字符，因此只能进行更改挥着全部删除，但是未进行此方面的考虑，因此会出现一些问题。
     * @param s
     * @return
     */
    public int strongPasswordChecker1(String s) {
        boolean low = false;
        boolean upper = false;
        boolean num = false;
        int result = 0;
        int lack = 0;
        int length = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < /*(*/length/* > 20 ? 20 : length)*/; i++) {
            int temp = 1;
            boolean tempFlag = false;
            if (chars[i] >= 'a' && chars[i] <= 'z'){
                low = true;
                tempFlag = true;
            }
            if (chars[i] >= 'A' && chars[i] <= 'Z'){
                upper = true;
                tempFlag = true;
            }
            if (chars[i] >= '0' && chars[i] <= '9'){
                num = true;
                tempFlag = true;
            }
            if (tempFlag){
                for (int j = i + 1;j < /*(*/length/* > 20 ? 20 : length)*/ && chars[i] == chars[j]; j++){
                    temp++;
                    if (temp == 3){
                        result++;
                        if (i + 2 < length) {
                            i = i + 2;
                            break;
                        }
                        temp = 0;
                    }
                }
            }
        }
        if (!low){
            lack++;
        }
        if (!upper){
            lack++;
        }
        if (!num){
            lack++;
        }
        if (length < 6){
            result += 6 - length;
        }
        if (result <= lack){
            result = lack;
            if (length > 20){
                result += length - 20;
            }
        }else {
            result = result > length - 20 ? result : length - 20 + result;
        }
        return result;
    }

    /**
     * 记录连续出现的字符 起始和终止坐标
     */
    class SameChar {
        int st;
        int en;
        char c;

        SameChar(int st, int en, char c) {
            this.st = st;
            this.en = en;
            this.c = c;
        }

    }

    /**
     *
     * @param str
     * @return
     */
    public int strongPasswordChecker2(String str) {
        // 统计小写字符
        int lowerCase = 0;
        // 统计大写字符
        int upwerCase = 0;
        // 统计数字
        int number = 0;
        // 统计连续字符出现的位置
        ArrayList<SameChar> sameChars = new ArrayList<SameChar>();
        char[] chars = str.toCharArray();
        if (chars.length == 0) {
            return 6;
        }
        // 记录连续出现的字符
        SameChar sameChar = new SameChar(0, 0, '\0');
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= 'a' && chars[i] <= 'z') {
                lowerCase++;
            } else if (chars[i] >= 'A' && chars[i] <= 'Z') {
                upwerCase++;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                number++;
            }
            if (sameChar.c != chars[i]) {
                if (sameChar.en - sameChar.st >= 2) {
                    sameChars.add(new SameChar(sameChar.st, sameChar.en, sameChar.c));
                }
                sameChar.c = chars[i];
                sameChar.st = i;
                sameChar.en = i;
            } else {
                sameChar.en = i;
            }
        }
        if (sameChar.en - sameChar.st >= 2) {
            sameChars.add(new SameChar(sameChar.st, sameChar.en, sameChar.c));
        }
        // 缺失的类型. 只可能是1 or 2
        int needType = count0(lowerCase, upwerCase, number);
        // 连续的字符出现的要消除的个数 连续值-2
        int[] chages = new int[sameChars.size()];
        for (int j = 0; j < sameChars.size(); j++) {
            chages[j] = sameChars.get(j).en - sameChars.get(j).st - 1;
        }
        int res = 0;
        // 如果长度小于6 , 很简单 要补的字符和缺失的类型择大
        if (str.length() < 6) {
            return Integer.max(6 - str.length(), needType);
        }
        // 删除的时候 要有优先概念
        if (str.length() > 20) {
            int index = -1;
            while (needType > 0 && (index = find(chages, 0)) > -1) {
                chages[index] = Integer.max(chages[index] - 3, 0);
                res++;
                needType--;
            }
            int d = str.length() - 20;
            while (d > 0 && (index = find(chages, 1)) > -1) {
                d--;
                res++;
                chages[index]--;
            }
            int n = 0;
            for (int l = 0; l < chages.length; l++) {
                n += chages[l] % 3 == 0 ? chages[l] / 3 : chages[l] / 3 + 1;
            }
            return res + d + needType + n;
        }
        int n = 0;
        for (int l = 0; l < chages.length; l++) {
            n += chages[l] % 3 == 0 ? chages[l] / 3 : chages[l] / 3 + 1;
        }
        return Integer.max(n, needType);
    }

    private int count0(int... array) {
        int n = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                n++;
            }
        }
        return n;
    }

    private int find(int[] array, int n) {
        int n0 = -1;
        int n1 = -1;
        int n2 = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0 && array[i] % 3 == 0) {
                n0 = i;
            }
            if (array[i] > 0 && array[i] % 3 == 1) {
                n1 = i;
            }
            if (array[i] > 0 && array[i] % 3 == 2) {
                n2 = i;
            }
        }
        if (n == 0) {
            return n0 > -1 ? n0 : (n2 > -1 ? n2 : n1);
        }
        if (n == 1) {
            return n1 > -1 ? n1 : (n2 > -1 ? n2 : n0);
        }
        return -1;
    }

    public static void main(String[] args) {
        StrongPasswordChecker checker = new StrongPasswordChecker();
        System.out.println(checker.strongPasswordChecker1("1010101010aaaB10101010"));
    }

}
