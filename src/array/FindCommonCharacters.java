package array;

import java.util.*;

/**
 * @author :DengSiYuan
 * @date :2019/9/14 18:25
 * @desc :1002、查找常用字符
 * 【题目】
 *      给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 *
 * 你可以按任意顺序返回答案。
 * 【示例】
 *      输入：["bella","label","roller"]
 *      输出：["e","l","l"]
 * 【提示】
 *      1 <= A.length <= 100
 *      1 <= A[i].length <= 100
 *      A[i][j] 是小写字母
 */
public class FindCommonCharacters {

    /**
     * 【想法】
     *      （1）创建一个大小为26的数组（大小为26就知道我们要用下标来代表字母）
     *      （2）将数组中的第一个遍历与a作差，作为下标，进行++，就可以记录了有哪些字母和数量
     *      （3）从数组中第二个元素开始遍历，遍历各个字母，与（2）同样的方法进行记录
     *      （4）遍历记录字母数量的数组，取（2）（3）中记录的最小值存入res中
     *      （5）遍历结果数组进行字母还原，存入返回结果list中
     * @param A
     * @return
     */
    public List<String> commonChars(String[] A) {
        List<String> list = new ArrayList<>();
        int[] res = new int[26];
        for (char c : A[0].toCharArray()) {
            res[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] temp = new int[26];
            for (char c : A[i].toCharArray()) {
                temp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (temp[j] < res[j]) {
                    res[j] = temp[j];
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            if (res[i] > 0) {
                for (int j = 0; j < res[i]; j++) {
                    list.add((char)('a' + i) + "");
                }
            }
        }
        return list;
    }

    /**
     * 【想法】
     *      （1）首先判断数组长度是不是小于2，若小于2，直接返回空数组
     *      （2）使用Map统计每个字符串中字符出现的次数，并把Map结果放入到List中
     *      （3）获取所有Map中key的交集（相当于获取每个字符串中都出现的字符）
     *      （4）循环key的交集，并把获取到的次数最小的值为结果
     * @param A
     * @return
     */
    public List<String> commonChars1(String[] A) {
        List<String> result = new ArrayList<>();
        // 数组为空或者长度小于2，直接返回空结果
        if(A.length < 2){
            return result;
        }
        // 使用Map统计每个字符串中字符出现的次数，并把Map结果放入到List中
        List<Map<Character, Integer>> list = new ArrayList<>();
        for (String a : A) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : a.toCharArray()) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
            list.add(map);
        }

        // 获取所有Map中key的交集（相当于获取每个字符串中都出现的字符）
        Set<Character> retainSet = list.get(0).keySet();
        for (int i = 1; i < list.size(); i++) {
            retainSet.retainAll(list.get(i).keySet());
        }

        // 循环key的交集，并把获取到的次数最小的值为结果
        // 比如字符串1中a出现了3次，字符串2出现了3次，字符串3出现了1次，那么这3个集合中重复的a的个数就为1
        Iterator<Character> iterator = retainSet.iterator();
        while (iterator.hasNext()){
            Character current = iterator.next();
            int minCount = list.get(0).get(current);
            for (int i = 1; i < list.size(); i++) {
                Integer cnt = list.get(i).get(current);
                if(cnt < minCount){
                    minCount = cnt;
                }
            }
            for (int i = 0; i < minCount; i++) {
                result.add(current + "");
            }
        }
        return result;
    }

    /**
     *
     * @param A
     * @return
     */
    public List<String> commonChars2(String[] A) {

        // 入参检查
        if(A.length < 2) {
            return null;
        }
        // 记录每个字符出现的次数（字符的ASCII码-97的值做数组下标）
        int[] hash = new int[26];
        // 是否第一次维护hash数组
        boolean firstFlag = true;
        // 遍历字符串
        for (String word : A) {
            // 拆分成字符数组
            char[] wordChars = word.toCharArray();
            // 如果是第一次维护hash数组
            if (firstFlag) {
                // 直接记录每个字符出现的个数
                for (char wordChar : wordChars) {
                    hash[wordChar - 97]++;
                }
                // 标志置为否
                firstFlag = false;
                // 如果不是第一次维护，即hash数组中有值时
            }else {
                // 新建临时数组tmpHash来记录当前字符数组每个字符出现的次数
                int[] tmpHash = new int[26];
                for (char wordChar : wordChars) {
                    tmpHash[wordChar - 97]++;
                }

                // 维护hash数组
                for(int i = 0; i < hash.length; ++i) {
                    // 比较hash数组和tmpHash数组
                    // hash记录每次每个字符出现的最小次数
                    if(hash[i] > tmpHash[i]) {
                        hash[i] = tmpHash[i];
                    }
                }
            }
        }
        // 组装返回结果
        List<String> res = new ArrayList<>();
        for(int i = 0; i < hash.length; ++i) {
            if(hash[i] != 0) {
                String tmp = String.valueOf((char)(i + 97));
                for(int j = 0; j < hash[i]; ++j) {
                    res.add(tmp);
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        FindCommonCharacters characters = new FindCommonCharacters();
        String[] strings = new String[]{"bella","label","roller"};
        long start = System.nanoTime();
        List<String> list = characters.commonChars(strings);
        long end = System.nanoTime();
        System.out.println("数组下标记录方法运行时间：" + (end - start) / 1000000.0 + "ms");
        for (Object o : list) {
            System.out.print(o);
        }
        System.out.println();
        start = System.nanoTime();
        list = characters.commonChars1(strings);
        end = System.nanoTime();
        System.out.println("Map|Set记录方法运行时间：" + (end - start) / 1000000.0 + "ms");
        for (Object o : list) {
            System.out.print(o);
        }
        System.out.println();
        start = System.nanoTime();
        list = characters.commonChars2(strings);
        end = System.nanoTime();
        System.out.println("数组下标记录优化方法运行时间：" + (end - start) / 1000000.0 + "ms");
        for (Object o : list) {
            System.out.print(o);
        }
    }

}
