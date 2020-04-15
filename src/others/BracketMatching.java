package others;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author :DengSiYuan
 * @date :2020/4/15 10:28
 * @desc :
 * 【题目】     括号匹配
 *      输入：()))(((
 *      输出： 1 3 2
 *      解释：匹配的括号数为1，不匹配的左括号数3，不匹配的右括号数2
 */
public class BracketMatching {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int matchNum = 0, left = 0, right = 0;
        if (input == null || input.length() == 0){
            System.out.printf("%d %d %d",matchNum,left,right);
        }else {
            Stack<Character> stack = new Stack<>();
            char[] chars = input.toCharArray();
            for (char c : chars) {
                if ('(' == c){
                    stack.push(c);
                }else if (')' == c){
                    if (stack.size() != 0){
                        stack.pop();
                        matchNum++;
                    }else{
                        right++;
                    }
                }
            }
            left = left + stack.size();
        }
        System.out.printf("%d %d %d",matchNum,left,right);
    }

}
