package explore.recursion_i;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :DengSiYuan
 * @date :2019/9/14 14:45
 * @desc : 118、杨辉三角
 * 【题目】
 *      给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 * 【示例】
 *      示例:
 *          输入: 5
 *          输出:
 *          [
 *              [1],
 *             [1,1],
 *            [1,2,1],
 *           [1,3,3,1],
 *          [1,4,6,4,1]
 *          ]
 */
public class PascalsTriangle {

    /**
     * 【想法】
     *      （1）第一行的数组直接赋值1
     *      （2）从第二开始遍历。首先记录下上一行的数组
     *      （3）先赋值第一个数值为0
     *      （4）从第二元素（即索引为1的位置）开始，每一个元素为上一行的i-1和第i的元素之和
     *      （5）赋值最后一个元素为0
     * @param numRows
     * @return
     * 【复杂度分析】
     *      时间复杂度：O(numRows^2)
     *      空间复杂度：O(numRows^2)
     *  )
     */
    public List<List<Integer>> generate1(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        if (numRows == 0) {
            return triangle;
        }
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> prevRow = triangle.get(rowNum-1);
            row.add(1);
            for (int j = 1; j < rowNum; j++) {
                row.add(prevRow.get(j-1) + prevRow.get(j));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }

    /**
     * 【解法二】
     *      递归
     *      首先判断是否是有0行或者1行，直接返回或者赋值1返回
     *      之后使用递归，从第一行向下进行一一计算赋值
     *
     */
    public List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        } else if (numRows == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            result.add(list);
            return result;
        } else {
            result = generate2(numRows-1);
            List<Integer> lastList = result.get(result.size()-1);
            List<Integer> list = new ArrayList<>();
            list.add(1);
            for (int i = 0; i < lastList.size()-1; i++) {
                list.add(lastList.get(i) + lastList.get(i+1));
            }
            list.add(1);
            result.add(list);
            return result;
        }
    }

    public static void main(String[] args) {
        PascalsTriangle triangle = new PascalsTriangle();
        long start = System.nanoTime();
        List<List<Integer>> lists = triangle.generate1(10);
        long end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.print("]");
            System.out.println();
        }
        start = System.nanoTime();
        lists = triangle.generate2(10);
        end = System.nanoTime();
        System.out.println("运行时间：" + (end - start) / 1000000.0 + "ms");
        for (List<Integer> list : lists) {
            System.out.print("[");
            for (Integer integer : list) {
                System.out.print(integer + ",");
            }
            System.out.print("]");
            System.out.println();
        }
    }

}
