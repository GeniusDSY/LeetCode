package others;

/**
 * @author :DengSiYuan
 * @date :2020/3/29 16:42
 * @desc :
 */
public class ReverseString {
    /**
     * 反转字符串，输入Douyu，输出uyuoD
     * @param str string字符串 任意字符串
     * @return string字符串
     */
    public String reverse (String str) {
        // write code here
        char[] s = str.toCharArray();
        swap(0, s.length-1, s);
        return new String(s);
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
