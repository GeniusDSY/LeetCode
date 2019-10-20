package array;

/**
 * @author :DengSiYuan
 * @date :2019/10/20 9:18
 * @desc : 9.回文数
 * 【题目】
 *      判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 【示例】
 *      示例 1:
 *          输入: 121
 *          输出: true
 *      示例 2:
 *          输入: -121
 *          输出: false
 *          解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *      示例 3:
 *          输入: 10
 *          输出: false
 *          解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
public class PalindromeNumber {

    /**
     * 【想法】
     *      1、负数坑定不是回文数
     *      2、将数字转换为字符串数组
     *      3、首尾判断，到中间停止，遇到一个不一样的就返回
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)){
            return false;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int length = chars.length;
        int min = 0;
        int max = length - 1;
        while (min < max){
            if (chars[min] != chars[max]){
                return false;
            }else {
                min++;
                max--;
            }
        }
        return true;
    }

    /**
     * 【想法】
     *      1、负数和末尾为0的数字不为回文数
     *      2、反向取数字的后半部分，直到取出来的部分>=剩下的部分
     *      3、若原数字是偶数位，那么两值相等即可；若为奇数，则剩下部分的数字=反向去除的后半部分的数字除以10（因为包含中间一个单独的数字）
     * @param x
     * @return
     */
    public boolean isPalindrome2(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main(String[] args) {
        PalindromeNumber number = new PalindromeNumber();
        long start = System.nanoTime();
        boolean result = number.isPalindrome1(12121);
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = number.isPalindrome2(12121);
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
    }

}
