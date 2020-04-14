package others;

import java.util.Scanner;

/**
 * @author :DengSiYuan
 * @date :2020/4/14 11:30
 * @desc :
 * 【题目】     贴墙纸
 *      你是一位装修工，根据设计师的要求给客户的客厅背景墙铁墙纸。
 *      假设背景墙面积为 n x m，装修风格为现代极简风格，需要使用尽可能少的 不同颜色的 正方形 墙纸包 来铺满墙面。
 *      假设正方形墙纸包块的规格不限，边长都是整数。
 *      请你帮设计师计算一下，最少需要用到多少块方形墙纸包？
 * 【示例】
 *      示例 1：
 *          输入：n = 2, m = 3
 *          输出：3
 *          解释：3 块墙纸包就可以铺满墙面。
 *               2 块 1x1 墙纸包
 *               1 块 2x2 墙纸包
 *      示例 2：
 *          输入：n = 5, m = 8
 *          输出：5
 *      示例 3：
 *          输入：n = 11, m = 13
 *          输出：6
 * 【提示】
 *      1 <= n <= 13
 *      1 <= m <= 13
 */
public class WallPapering {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        System.out.println(tilingRectangle(n, m));

    }

    public static int tilingRectangle(int n, int m) {
        int[][] dp=new int[14][14];
        for(int i=1;i<=n;i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = i == j ? 1 : i * j;
                for (int p = 1; p < i; p++) {
                    dp[i][j] = Math.min(dp[i][j], dp[p][j] + dp[i - p][j]);
                }
                for (int x = 2; x < i; x++) {
                    for (int y = 2; y < j; y++) {
                        dp[i][j] = Math.min(dp[i][j], dp[x - 1][y] + dp[x][j - y] + dp[i - x + 1][y - 1] + dp[i - x][j - y + 1] + 1);
                    }
                }
            }
        }
        return dp[n][m];
    }
}
