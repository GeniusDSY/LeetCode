package sword_finger_offer;

/**
 * @author :DengSiYuan
 * @date :2020/2/22 17:21
 * @desc : 面试题13. 机器人的运动范围
 * 【题目】
 *      地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 *      它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 *      例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 *      请问该机器人能够到达多少个格子？
 *【示例】
 *      输入：m = 2, n = 3, k = 1
 *      输出：3
 *      输入：m = 3, n = 1, k = 0
 *      输出：1
 *【提示】
 *      1 <= n,m <= 100
 *      0 <= k <= 20
 */
public class RobotSRangeOfMotion {

    private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private int cnt = 0;
    private int m;
    private int n;
    private int k;

    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        boolean[][] flag = new boolean[m][n];
        dfs(0,0,flag);
        return cnt;
    }
    private void dfs(int i, int j,boolean[][] flag ) {
        if (i < 0 || i >= m || j< 0 || j >= n || flag[i][j]) {
            return;
        }
        if(cal(i) + cal(j) > k) {
            return;
        }
        cnt++;
        flag[i][j] = true;
        for(int p = 0; p < 4; p++) {
            int newi= i + next[p][0];
            int newj= j + next[p][1];
            dfs(newi , newj , flag);
        }
    }
    private int cal(int num) {
        int ref = 0;
        while(num > 0) {
            ref += num % 10;
            num /= 10;
        }
        return ref;
    }

}
