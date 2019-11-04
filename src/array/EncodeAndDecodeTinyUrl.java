package array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :DengSiYuan
 * @date :2019/11/2 13:49
 * @desc : 535.TinyURL的加密与解密
 * 【题目】
 *      TinyURL是一种URL简化服务， 比如：当你输入一个URL https://leetcode.com/problems/design-tinyurl 时，它将返回一个简化的URL http://tinyurl.com/4e9iAk.
 *
 * 【要求】
 *      设计一个 TinyURL 的加密 encode 和解密 decode 的方法。你的加密和解密算法如何设计和运作是没有限制的，你只需要保证一个URL可以被加密成一个TinyURL，并且这个TinyURL可以用解密方法恢复成原本的URL。
 */
public class EncodeAndDecodeTinyUrl {

    Map<Integer, String> map1 = new HashMap<>();
    int i = 0;

    public String encode1(String longUrl) {
        map1.put(i, longUrl);
        return "http://tinyurl.com/" + i++;
    }

    public String decode1(String shortUrl) {
        return map1.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

    String chars = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    HashMap<String, String> map2 = new HashMap<>();
    int count = 1;

    public String getString() {
        int c = count;
        StringBuilder sb = new StringBuilder();
        while (c > 0) {
            c--;
            sb.append(chars.charAt(c % 62));
            c /= 62;
        }
        return sb.toString();
    }

    public String encode2(String longUrl) {
        String key = getString();
        map2.put(key, longUrl);
        count++;
        return "http://tinyurl.com/" + key;
    }

    public String decode2(String shortUrl) {
        return map2.get(shortUrl.replace("http://tinyurl.com/", ""));
    }

    Map<Integer, String> map3 = new HashMap<>();

    public String encode3(String longUrl) {
        map3.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    public String decode3(String shortUrl) {
        return map3.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }

    public static void main(String[] args) {
        EncodeAndDecodeTinyUrl url = new EncodeAndDecodeTinyUrl();
        String originUrl = "https://leetcode.com/problems/design-tinyurl";
        System.out.println(url.encode1(originUrl));
        System.out.println(url.decode1(url.encode1(originUrl)));
        System.out.println(url.encode2(originUrl));
        System.out.println(url.decode2(url.encode2(originUrl)));
        System.out.println(url.encode3(originUrl));
        System.out.println(url.decode3(url.encode3(originUrl)));
    }


}
