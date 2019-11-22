package explore.recursion_i;

/**
 * @author :DengSiYuan
 * @date :2019/11/22 20:02
 * @desc : 344.反转字符串
 * 【题目】
 *      编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 *      不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *      你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * 【示例】
 *      输入：["h","e","l","l","o"]
 *      输出：["o","l","l","e","h"]
 *
 *      输入：["H","a","n","n","a","h"]
 *      输出：["h","a","n","n","a","H"]
 */
public class ReverseString {

    /**
     * 【解法一】
     *      不适用递归，使用while函数进行首尾对称交换，直到前索引>=后索引
     */
    public void reverseString1(char[] s) {
        if(s.length!=0){
            int i=0;
            int j=s.length-1;
            char temp=s[0];
            while(i<j) {
                s[i]=s[j];
                s[j]=temp;
                i++;
                j--;
                temp=s[i];
            }
        }
    }

    /**
     * 【解法二】
     *      使用递归，将首尾在遍历中进行交换，直到前索引<=后索引
     */
    public void reverseString2(char[] s) {
        swap(0, s.length-1, s);
    }

    public void swap(int start, int end, char[] s) {
        if(start >= end){
            return;
        }
        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;
        swap(start+1, end-1, s);
    }

}
