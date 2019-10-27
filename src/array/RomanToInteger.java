package array;

/**
 * @author :DengSiYuan
 * @date :2019/10/27 9:51
 * @desc : 13.罗马数字转整数
 * 【题目】
 *      罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *          字符          数值
 *          I             1
 *          V             5
 *          X             10
 *          L             50
 *          C             100
 *          D             500
 *          M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5
 * 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六
 * 种情况：
 *      · I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 *      · X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 *      · C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 * 【示例】
 *      示例 1:
 *          输入: "III"
 *          输出: 3
 *      示例 2:
 *          输入: "IV"
 *          输出: 4
 *      示例 3:
 *          输入: "IX"
 *          输出: 9
 *      示例 4:
 *          输入: "LVIII"
 *          输出: 58
 *          解释: L = 50, V= 5, III = 3.
 *      示例 5:
 *          输入: "MCMXCIV"
 *          输出: 1994
 *          解释: M = 1000, CM = 900, XC = 90, IV = 4.
 */
public class RomanToInteger {

    public int romanToInt(String s) {
        char[] ch = s.toCharArray();
        int num = 0;
        for (int i = 0; i < ch.length - 1; i++) {
            if(ch[i] == 'I' && (ch[i + 1] == 'V' || ch[i + 1] == 'X')) {
                num -= 2;
            }
            if(ch[i] == 'X' && (ch[i + 1] == 'L' || ch[i + 1] == 'C')) {
                num -= 20;
            }
            if(ch[i] == 'C' && (ch[i + 1] == 'D' || ch[i + 1] == 'M')) {
                num -= 200;
            }
        }
        for (int i = 0; i < ch.length; i++) {
            switch (ch[i]) {
                case 'M': {
                    num += 1000;
                    continue;
                }
                case 'D': {
                    num += 500;
                    continue;
                }
                case 'C': {
                    num += 100;
                    continue;
                }
                case 'L': {
                    num += 50;
                    continue;
                }
                case 'X': {
                    num += 10;
                    continue;
                }
                case 'V': {
                    num += 5;
                    continue;
                }
                default: {
                    num += 1;
                }
            }
        }
        return num;
    }

    public int romanToInt1(String s) {
        char[] chars = s.toCharArray();
        int[] nums = new int[100];
        int result = 0;
        for(int i = 0;i < chars.length; i++){
            switch (chars[i]){
                case 'I':
                    nums[i] = 1;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'M':
                    nums[i] = 1000;
                    break;
                default:
                    break;
            }
        }
        for (int i = 0;i < nums.length -1 ; i++){
            if(nums[i] < nums[i+1]){
                result = result - nums[i];
            }else {
                result = result + nums[i];
            }
        }
        return result + nums[nums.length-1];
    }

    public static void main(String[] args) {
        RomanToInteger integer = new RomanToInteger();
        long start = System.nanoTime();
        int result = integer.romanToInt("MCMXCIV");
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        start = System.nanoTime();
        result = integer.romanToInt1("MCMXCIV");
        end = System.nanoTime();
        System.out.println(result);
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
    }

}
