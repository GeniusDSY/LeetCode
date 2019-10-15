package array;

/**
 * @author :DengSiYuan
 * @date :2019/10/15 19:13
 * @desc : 7.整数反转
 * 【题目】
 *      给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 【示例】
 *      示例 1:
 *          输入: 123
 *          输出: 321
 *      示例 2:
 *          输入: -123
 *          输出: -321
 *      示例 3:
 *          输入: 120
 *          输出: 21
 * 【注意】
 *      假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class ReverseInteger {

    /**
     * 【想法】
     *      首先将所给数值若为负数，那么就变成正数，之后进行不断地取余除十，并将余数数值加到结果上
     *      判断结果是不是超过了最大值的范围
     * @param x
     * @return
     */
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = ~x+1;
        }
        long cur = 0;
        while (x > 0) {
            cur *= 10;
            cur += x % 10;
            x /= 10;
        }
        return Integer.MAX_VALUE < cur || Integer.MIN_VALUE > cur ? 0 : flag ? (int)~cur+1 : (int)cur;
    }
    public int reverse1(int x) {
        int ret = 0;
        while(x != 0){
            if(ret > Integer.MAX_VALUE/10 || (ret == Integer.MAX_VALUE / 10 && (x%10)> 7)){
                return 0;
            }
            if(ret < Integer.MIN_VALUE/10 || (ret == Integer.MIN_VALUE / 10 && (x%10)< -8)){
                return 0;
            }
            ret = ret * 10 + (x % 10);
            x = x /10;
        }

        return ret;
    }

    public static void main(String[] args) {
        ReverseInteger integer = new ReverseInteger();
        int num = 987654;
        long start = System.nanoTime();
        System.out.println(integer.reverse(num));
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end-start)/ 1000000.0 + "mm");
        start = System.nanoTime();
        System.out.println(integer.reverse1(num));
        end = System.nanoTime();
        System.out.println("运行时间：" + (end-start)/ 1000000.0 + "mm");
    }

}
